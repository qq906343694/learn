package com.phei.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {

	private Selector selector;

	private ServerSocketChannel serverSocketChannel;

	private volatile boolean stop;

	public MultiplexerTimeServer(int port) {
		try {

			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port : " + port);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = true;
	}

	@Override
	public void run() {

		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				SelectionKey key = null;
				while(iterator.hasNext()){
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			if(key.isAcceptable()){
				ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
				SocketChannel sChannel = serverSocketChannel.accept();
				sChannel.configureBlocking(false);
				sChannel.register(selector, SelectionKey.OP_READ);
			
				
			}
			if(key.isReadable()){
				SocketChannel sChannel = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sChannel.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bs = new byte[readBuffer.remaining()];
					readBuffer.get(bs);
					String body = new String(bs, "UTF-8");
					System.out.println("the time server receive order :"+body);
					String currentTime = "Query time order".equalsIgnoreCase(body) ?
							new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
					doWrite(sChannel, currentTime);
				}else if (readBytes < 0) {
					key.cancel();
					sChannel.close();
				}
			}
		}
	}
	
	
	private void doWrite(SocketChannel channel,String response) throws IOException{
		if(response != null && response.trim().length() > 0){
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}

}

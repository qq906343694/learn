package com.phei.netty.nio;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TimeClientHandle {
	
	public static void main(String[] args) {
		
	}

}



class TimeClient implements Runnable{

	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	
	
	@Override
	public void run() {
		
	}
	
}
package com.phei.netty.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.phei.netty.bio.TimeServerHandler;

public class TimeServer {

	public static void main(String[] args) {
		
		int port = 8080;
		

		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}
}

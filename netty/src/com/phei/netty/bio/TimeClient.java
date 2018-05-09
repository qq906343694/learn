package com.phei.netty.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.SSLException;

public class TimeClient {
	
	public static void main(String[] args) {
		
		int port = 8081;
		String message="";
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd : hh-mm-ss");
		try {
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			while (true)
			{
				out.println(message);
				System.out.println("Send order 2 server succeed.");
				String resp = in.readLine();
				System.out.println("Now is :"+resp);		
				Thread.sleep(30000L);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null){
				out.close();
				out = null;
			}
			if(in != null){
				try {
					in.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				in = null;
			}
			if(socket != null){
				try {
					socket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				socket = null;
			}
		}
		
	}

}

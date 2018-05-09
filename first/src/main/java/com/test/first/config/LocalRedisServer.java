
package com.test.first.config;

import java.io.IOException;
import java.util.ArrayList;

import redis.embedded.RedisServer;

/**
 * 本地Redis服务
 * 
 * @author
 */
public class LocalRedisServer extends RedisServer
{
	
	public LocalRedisServer () throws IOException
	{
		super();
		args = new ArrayList<String>(args);
		args.add("--maxheap");
		args.add("128M");
		
	}
	
}

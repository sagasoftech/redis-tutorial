package com.github.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

	public static void main(String[] args) throws Exception {
		Jedis jedis = null;
		try {
			jedis = new Jedis("http://localhost:6379");
			System.out.println("Connection Successful");
			System.out.println("Server Ping: " + jedis.ping());
			//System.out.println("Server Info: " + jedis.info());

			//String
			System.out.println("String push : " + jedis.set("one", "Apple"));
			System.out.println("String push : " + jedis.set("two", "Samsung"));
			System.out.println("String pop one: " + jedis.del("one"));
			System.out.println("String pop two: " + jedis.del("two"));
			
			//List
			System.out.println("List push apple: " + jedis.lpush("phone", "apple"));
			System.out.println("List push samsun mi: " + jedis.lpush("phone", "samsung", "mi"));
			System.out.println("List pop mi: " + jedis.lpop("phone"));
			System.out.println("List pop apple: " + jedis.rpop("phone"));
			System.out.println("List pop samsung: " + jedis.lpop("phone"));
			
			//Set
			System.out.println("Set push baleno sonata: " + jedis.sadd("cars", "baleno", "sonata"));
			System.out.println("Set pop baleno: " + jedis.spop("cars"));
			System.out.println("Set pop sonata: " + jedis.spop("cars"));

		}catch(Exception e) {
			e.printStackTrace();
			if(jedis != null) {
				jedis.close();
			}
		}
	}
}

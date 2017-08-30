package net.ggum2.ggum2blog.util;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import redis.embedded.RedisServer;

@Profile({"dev"})
@Component
public class EmbededRedis {

	@Value("${spring.redis.port}")
	private int port;

	private RedisServer redisServer;

	@PostConstruct
	public void start() throws IOException {
		redisServer = new RedisServer(this.port);
		redisServer.start();
	}

	@PreDestroy
	public void stop() {
		redisServer.stop();
	}
}

package com.swasthify.swasthifychat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.swasthify.swasthifychat.Handlers.ChatWebSocketHandler;
@EnableWebSocket
@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer{
	
	private final static String CHAT_ENDPOINT = "/chat";
	
@Override
public void registerWebSocketHandlers(WebSocketHandlerRegistry WebSocketHandlerRegistry) {
	WebSocketHandlerRegistry.addHandler(getChatWebSocketHandler(),CHAT_ENDPOINT)
	.setAllowedOrigins("*");
	
}

@Bean
public WebSocketHandler getChatWebSocketHandler() {
	return new ChatWebSocketHandler();
}
}

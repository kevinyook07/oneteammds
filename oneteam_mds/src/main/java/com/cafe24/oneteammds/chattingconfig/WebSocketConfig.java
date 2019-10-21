package com.cafe24.oneteammds.chattingconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration // 어노테이션기반 환경구성
@EnableWebSocketMessageBroker // 웹 소켓 서버를 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override //오버라이더 설정
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        //websocket 설정
    }

    @Override //오버라이더 설정
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 메세지 입력시 셋팅
    	registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");   

    }
}

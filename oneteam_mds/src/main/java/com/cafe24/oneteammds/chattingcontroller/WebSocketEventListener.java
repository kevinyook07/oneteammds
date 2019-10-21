package com.cafe24.oneteammds.chattingcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.cafe24.oneteammds.chattingvo.ChatMessage;


@Component  //사용된 클래스를 자동으로 빈에 등록
public class WebSocketEventListener {
    // 접근지정자 설정
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired //저장 후 사용
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener //메소드를 애플리케이션 이벤트의 리스너로 표시
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        // 새 웹 소켓 연결 수신 
    	logger.info("Received a new web socket connection");
    }

    @EventListener //메소드를 애플리케이션 이벤트의 리스너로 표시
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // 채팅방 사용자 접속
    	StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}

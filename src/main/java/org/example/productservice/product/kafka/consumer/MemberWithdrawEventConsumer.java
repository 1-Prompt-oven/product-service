package org.example.productservice.product.kafka.consumer;

import org.example.productservice.product.application.ProductService;
import org.example.productservice.product.dto.message.MemberWithdrawEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberWithdrawEventConsumer {

	private final ProductService productService;

	@KafkaListener(
		topics = "${member-withdraw-event}",
		containerFactory = "memberWithdrawListenerContainerFactory"
	)
	@Transactional
	public void consumeMemberWithdraw(MemberWithdrawEvent event) {
		log.info("Member withdraw event received: {}", event);

		// 여기에 멤버 탈퇴 시 필요한 비즈니스 로직 구현
		// 예: 멤버와 관련된 데이터 삭제 또는 상태 업데이트
		String memberUUID = event.getMemberUUID();
		productService.handleMemberWithdraw(memberUUID);
	}
}

package org.food.order.system.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.order.system.service.domain.dto.message.PaymentResponse;
import org.food.order.system.service.domain.ports.input.message.listener.payment.PaymentResponseMessageListenerInterface;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentResponseMessageListener implements PaymentResponseMessageListenerInterface {
    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {

    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {

    }
}

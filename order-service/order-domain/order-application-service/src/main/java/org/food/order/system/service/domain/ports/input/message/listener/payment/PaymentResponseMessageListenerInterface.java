package org.food.order.system.service.domain.ports.input.message.listener.payment;

import org.food.order.system.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListenerInterface {
    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);

}

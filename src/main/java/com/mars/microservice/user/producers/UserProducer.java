package com.mars.microservice.user.producers;

import com.mars.microservice.user.dtos.EmailDto;
import com.mars.microservice.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {

        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso !");
        emailDto.setText(userModel.getName() + ", Seja bem Vindo(a) !! \nAgradecemos sua inscrição");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}

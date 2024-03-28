package org.example.devdojorabbitmqstream.request;

import lombok.RequiredArgsConstructor;
import org.example.devdojorabbitmqstream.common.RabbitStreamTemplateSimpleFactory;
import org.example.devdojorabbitmqstream.common.StreamListener;
import org.example.devdojorabbitmqstream.common.StreamListenerContainerSimpleFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.config.SuperStream;
import org.springframework.rabbit.stream.listener.StreamListenerContainer;
import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;

@Configuration
@RequiredArgsConstructor
class DevDojoSuperStreamConfig {
  private static final String SUPER_STREAM = "devdojo.super";

  @Bean
  SuperStream devDojoSuperStream() {
    return new SuperStream(SUPER_STREAM, 3);
  }

  @Bean
  RabbitStreamTemplate devDojoRabbitStreamTemplate(RabbitStreamTemplateSimpleFactory factory) {
    return factory.apply(SUPER_STREAM);
  }

  @Bean
  <T> StreamListenerContainer devDojoContainer(StreamListenerContainerSimpleFactory<T> factory,
                                               StreamListener<T> devDojoSuperStreamConsumer) {
    return factory.apply(SUPER_STREAM, devDojoSuperStreamConsumer);
  }
}


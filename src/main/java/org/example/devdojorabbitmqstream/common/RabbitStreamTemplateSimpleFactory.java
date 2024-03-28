package org.example.devdojorabbitmqstream.common;

import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;

import java.util.function.Function;

public interface RabbitStreamTemplateSimpleFactory extends Function<String, RabbitStreamTemplate> {
}

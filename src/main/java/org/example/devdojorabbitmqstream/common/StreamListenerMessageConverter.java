package org.example.devdojorabbitmqstream.common;

import org.springframework.amqp.core.MessageListener;

import java.util.function.Function;

public interface StreamListenerMessageConverter<T> extends Function<StreamListener<T>, MessageListener> {
}

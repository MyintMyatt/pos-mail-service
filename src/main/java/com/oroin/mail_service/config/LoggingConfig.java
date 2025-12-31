package com.oroin.mail_service.config;

import ch.qos.logback.classic.LoggerContext;
import jakarta.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @Bean
    public GracefulShutdown logbackShutdown() {
        return new GracefulShutdown();
    }

    public static class GracefulShutdown {
        @PreDestroy
        public void shutdown() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            /*
            * this flushes AsyncAppender queue and closes Kafka producer
            * */
            context.stop();
        }
    }
}

package com.dekelbz.animals;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ByteArrayJsonMessageConverter byteArrayJsonMessageConverter() {
        return new ByteArrayJsonMessageConverter();
    }

}

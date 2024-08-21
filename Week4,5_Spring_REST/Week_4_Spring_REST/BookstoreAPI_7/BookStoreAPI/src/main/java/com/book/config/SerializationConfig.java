package com.book.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.book.dto.BookDTO;
import com.book.json.CustomDeserializer;
import com.book.json.CustomSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class SerializationConfig {

  @Bean
  @SuppressWarnings({"rawtypes", "unchecked"})
  public ObjectMapper getObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(BookDTO.class, new CustomSerializer());
    simpleModule.addDeserializer(BookDTO.class, new CustomDeserializer());
    mapper.registerModule(simpleModule);
    return mapper;
  }
}
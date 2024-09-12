package com.felipeam10.user_request_spring_batch.writer;

import com.felipeam10.user_request_spring_batch.dto.UserDTO;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertUserDataDBWriterConfig {

    @Bean
    public ItemWriter<UserDTO> insertUserDataDBWriter() {
        return users -> users.forEach(System.out::println);
    }
}

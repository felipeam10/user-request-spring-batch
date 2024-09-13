package com.felipeam10.user_request_spring_batch.writer;

import com.felipeam10.user_request_spring_batch.dto.UserDTO;
import com.felipeam10.user_request_spring_batch.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class InsertUserDataDBWriterConfig {

    private static Logger logger = LoggerFactory.getLogger(InsertUserDataDBWriterConfig.class);

    @Bean
    public ItemWriter<User> insertUserDataDBWriter(@Qualifier("appDB") DataSource dataSource) {
//        return users -> users.forEach(System.out::println);

        logger.info("[WRITER STEP] Inserting data...");
        return new JdbcBatchItemWriterBuilder<User>()
                .dataSource(dataSource)
                .sql("INSERT INTO tb_user (login, name, avatar_url) VALUES (:login, :name, :avatarUrl)")
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .build();
    }
}

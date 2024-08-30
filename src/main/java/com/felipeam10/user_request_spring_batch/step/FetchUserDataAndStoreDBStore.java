package com.felipeam10.user_request_spring_batch.step;

import com.felipeam10.user_request_spring_batch.dto.UserDTO;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

public class FetchUserDataAndStoreDBStore {
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Value("${chunckSize}")
    private int chunckSize;
    @Bean
    public Step fetchUserDataAndStoreDBStore(ItemReader<UserDTO> fetchUserDataReader, JobRepository jobRepository) {
        return new StepBuilder("fetchUserDataAndStoreDBStep", jobRepository)
                .<UserDTO, UserDTO>chunk(chunckSize, transactionManager)
                .reader(fetchUserDataReader)
                .build();
    }
}

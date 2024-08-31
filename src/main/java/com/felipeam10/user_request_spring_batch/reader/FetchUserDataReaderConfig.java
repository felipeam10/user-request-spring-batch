package com.felipeam10.user_request_spring_batch.reader;

import com.felipeam10.user_request_spring_batch.dto.UserDTO;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class FetchUserDataReaderConfig implements ItemReader<UserDTO> {

    private final String BASE_URL = "http://localhost:8089";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public UserDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }

    private List<UserDTO> fecthUserDataFromAPI(){
        String uri =  BASE_URL + "/clients/pagedData?page=%d&size=%d";
    }
}

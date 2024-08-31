package com.felipeam10.user_request_spring_batch.domain;

import com.felipeam10.user_request_spring_batch.dto.UserDTO;

import java.util.List;

public class ResponseUser {

    private List<UserDTO> content;

    public List<UserDTO> getContent() {
        return content;
    }

}

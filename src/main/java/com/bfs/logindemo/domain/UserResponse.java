package com.bfs.logindemo.domain;

import lombok.Data;

@Data
public class UserResponse {
    private int id;
    private String name;
    private String password;
}

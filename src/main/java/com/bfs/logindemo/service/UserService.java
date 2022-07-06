package com.bfs.logindemo.service;

import com.bfs.logindemo.domain.User;



public interface UserService {

    public User getUserByNameAndPwd(String name, String password);

}

package com.bfs.logindemo.service.impl;

import com.bfs.logindemo.dao.UserDAO;
import com.bfs.logindemo.domain.User;
import com.bfs.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByNameAndPwd(String name, String password) {
        return userDao.findUserByNameAndPwd(name,password);
    }
}

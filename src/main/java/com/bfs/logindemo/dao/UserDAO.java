package com.bfs.logindemo.dao;

import com.bfs.logindemo.domain.User;
import com.bfs.logindemo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate jt;

    public User findUserByNameAndPwd(String name, String password){
        User user = null;
        try {
            user = jt.queryForObject("SELECT * FROM User WHERE name=? AND password=?",
                    new BeanPropertyRowMapper<User>(User.class),
                    name, password);
        } catch (EmptyResultDataAccessException e){

        }

        return user;
    }
}

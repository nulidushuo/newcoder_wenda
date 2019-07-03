package com.nowcoder.mywenda.service;

import com.nowcoder.mywenda.dao.UserDAO;
import com.nowcoder.mywenda.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserDAO userDAO;

    public User getUser(int id){
        return userDAO.selectById(id);
    }
}

package com.xu.service;


import com.xu.DAO.UserRepository;
import com.xu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveAllUser(){
        ArrayList list = new <User>ArrayList();
        list.add(new User("u1","p1"));
        list.add(new User("u2","p2"));
        list.add(new User("u3","p3"));
        userRepository.saveAll(list);
    }
}

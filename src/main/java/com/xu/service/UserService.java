package com.xu.service;


import com.google.common.base.CaseFormat;
import com.xu.DAO.UserRepository;
import com.xu.domain.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HikariDataSource ds;

    public void saveAllUser() {
        ArrayList list = new <User>ArrayList();
        list.add(new User("u1", "p1"));
        list.add(new User("u2", "p2"));
        list.add(new User("u3", "p3"));
        userRepository.saveAll(list);
    }

    @Transactional
    public List<User> emSave() {
        ArrayList<User> list = new <User>ArrayList();
        list.add(new User("u1", "p1"));
        list.add(new User("u2", "p2"));
        list.add(new User("u3", "p3"));
        StringBuilder sql = new StringBuilder();
        sql.append("insert into test1 (id,username,password) values");
        int size = list.size();
        if (size > 0) {
            for (User u : list) {
                sql.append(getValue(u));
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            statement.execute(sql.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    private String getValue(User user) {
        //('u1','p4'),
        StringBuilder value = new StringBuilder();
        value.append("(").append("0,'").append(user.getUsername()).append("','").append(user.getPassword()).append("'),");
        return value.toString();
    }

    public String getValueByReflect(User user) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = User.class.getDeclaredFields();
        List<String> values = new LinkedList<>();
        List<String> columnNames = new LinkedList<>();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();  //获得对象的属性名称
            name = name.substring(0, 1).toUpperCase() + name.substring(1);  //构造get方法的名字
            Method m = User.class.getMethod("get" + name);
            values.add(m.invoke(user).toString());
            columnNames.add(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name));
        }
        for (String value : columnNames) {
            System.out.println(value+",");
        }
        for (String value : values) {
            System.out.println(value+",");
        }

        return null;
    }


    
}

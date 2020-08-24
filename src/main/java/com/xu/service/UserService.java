package com.xu.service;


import com.xu.DAO.UserRepository;
import com.xu.domain.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    public void saveAllUser(){
        ArrayList list = new <User>ArrayList();
        list.add(new User("u1","p1"));
        list.add(new User("u2","p2"));
        list.add(new User("u3","p3"));
        userRepository.saveAll(list);
    }

    @Transactional
    public List<User> emSave(){
        ArrayList<User> list = new <User>ArrayList();
        list.add(new User("u1","p1"));
        list.add(new User("u2","p2"));
        list.add(new User("u3","p3"));
        StringBuilder sql=new StringBuilder();
        sql.append("insert into test1 values");
        int size = list.size();
        if(size>0){
            for (User u : list) {
                sql.append(getValue(u));
            }
        }
        sql.deleteCharAt(sql.length()-1);
//        entityManager.getTransaction().begin();
        //创建原生查询的时候，将info.class类即第二个参数，写成要传回的bean，这样就可以直接用List<Bean>接收
//        Query query = entityManager.createQuery (sql.toString());
//        DataSource dataSource = entityManager.unwrap(DataSource.class);
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        session.createQuery(sql.toString()).executeUpdate();
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.execute(sql.toString());
        return null;
    }

    private String getValue(User user ){
        //('u1','p4'),
        StringBuilder value = new StringBuilder();
        value.append("('").append(user.getUsername()).append("','").append(user.getPassword()).append("'),");
        return value.toString();
    }
}

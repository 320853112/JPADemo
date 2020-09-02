package com.xu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.CaseFormat;
import com.xu.domain.User;
import com.xu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {

    @Autowired
    private UserService userService;

    @Test
    public void testConvert() throws Exception {
        User user = new User("u1", "p1");
        userService.getValueByReflect(user);
    }

    @Test
    public void testReflect() throws Exception {
        User user = new User("u1", "p1");
        Field[] fields = User.class.getDeclaredFields();
        String name=fields[0].getName();
        String type=fields[0].getGenericType().toString();
        System.out.println("属性的类型："+type);
        name=name.substring(0,1).toUpperCase()+name.substring(1);
        Method m=User.class.getMethod("get"+name);
        long start = System.currentTimeMillis();
        int i = 0;
        while(i<100000000){
            ++i;
            m.setAccessible(true);
            m.invoke(user);
        }
        long end = System.currentTimeMillis();
        System.out.println("无缓存反射创建对象耗时："+(end - start ) + "ms");
    }

    @Test
    public void testUnder()  {
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "contactAccountType"));
    }

//    @Test
//    public void testG
}

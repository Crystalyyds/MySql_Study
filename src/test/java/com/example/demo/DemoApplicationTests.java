package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
   public void contextLoads(){

    }

    @Test
    public void testQuery() {
        userRepository.findById(1).ifPresent(System.out::println);
    }

    @Test
    public void testAdd() {
        User user = new User();
        //user.setId(2);
        user.setUsername("葛某人");
        user.setPassword("wsnbb");

        User saveUser = userRepository.save(user); //新增 返回的实体中带着实体id
        System.out.println(saveUser);
    }


    @Test
    public void testPageable(){
        userRepository.findAll(PageRequest.of(0,2)).forEach(System.out::println);
    }

    @Test
    public void testFindAll(){
        userRepository.findAllByUsername("葛某人").forEach(System.out ::println);
    }

    @Test
    public void findlike(){
        //注意百分号
        userRepository.findAllByUsernameLike("葛%").forEach(System.out ::println );
    }
    @Test
    public void test5(){
        userRepository.findUsers().forEach(System.out ::println);
    }

    @Test
    public void test6(){
        userRepository.findUsers2().forEach(System.out ::println);
    }

    @Test
    public void test7(){
        userRepository.findUsers3().forEach(System.out ::println);
    }

    @Test
    public void test8(){
        //数量
        userRepository.findUsers4().forEach(System.out ::println);
    }

    @Test
    public void test9(){
        //数量
        int result = userRepository.updateByusernameAndPassword2("赵某人",8);
        System.out.println(result);
    }

    @Test
    public void test10(){
        //数量
        int result = userRepository.updateByusernameAndPassword3("赵某人",8);
        System.out.println(result);
    }



}

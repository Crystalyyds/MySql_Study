package com.example.demo.dao;


import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 20312
 * @author 2022/8/16 11:34
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 根据username查询
     * @return
     */
    List<User> findAllByUsername(String str);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    List<User> findAllByUsernameAndPassword(String username,String password);

    /**
     *
     * @param username
     * @return
     */
    List<User> findAllByUsernameLike(String username);
}

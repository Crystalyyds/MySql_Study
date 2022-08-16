package com.example.demo.dao;


import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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


    /**
     * sql原生
     */

    /**
     *
     * @return
     */
    @Query("select u from User u")//从实体类中查询，而不是表
    public List<User> findUsers();

    /**
     *
     * @return
     */
    @Query("select u from  User u where u.username='葛某人'")//从实体类中查询，而不是表where 不是列名，而是属性
    List<User> findAlluserByUsername();

    /**
     * 需要某一列
     */

    /**
     *
     * @return
     */
    @Query("select u.id,u.username from User u")//从实体类中查询，而不是表
    List<Integer> findUsers2();

    /**
     *
     * @return
     */
    @Query("select u.id,u.username from User u")//从实体类中查询，而不是表
    List<Object> findUsers3();

    /**
     *
     * @return
     */
    @Query("select count(u) from User u")//从实体类中查询，而不是表
    List<Integer> findUsers4();


    /**
     * 更新
     * 修改数据一定加上@Modifying
     *
     *
     * @param username
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query("update User set username=?1 where id=?2")
    int updateByusernameAndPassword2(String username ,Integer id );

    /**
     * 修改数据一定加上@Modifying
     * @param username
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update user u set u.username=?1 where u.id=?2",nativeQuery = true)
        //如果写的是User。会显示找不到这个实体类,用user同时加上nativeQuery = true
    int updateByusernameAndPassword3(String username ,Integer id );
}

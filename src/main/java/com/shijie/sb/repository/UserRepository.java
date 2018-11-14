package com.shijie.sb.repository;

import com.shijie.sb.domain.User;

import java.util.List;

/**
 * Created by ShiJie on 2018-11-13 21:50
 */
public interface UserRepository {

    /**
     * 创建或者修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> listUsers();
}

package com.detection.service;

import com.detection.entity.Login;
import com.detection.entity.User;

/**
 * @author ding
 * @date 2021/12/8
 */

public interface UserService {

    User queryUser(Login login);

    int insertUser(User user);

    int updateUser(User user);

    int removeUser(Long userId);


}

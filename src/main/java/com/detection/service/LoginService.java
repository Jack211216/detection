package com.detection.service;

import com.detection.entity.Login;
import com.detection.entity.SharedParam;
import com.detection.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * @author ding
 * @date 2021/12/8
 */

public interface LoginService {

    HashMap<String,Object> queryUser(Login login);

    int insertUser(User user);

    int updateUser(User user);

    int removeUser(Long userId);

    List<User> queryAllUser(SharedParam sharedParam);

    User  queryId(User user);

}

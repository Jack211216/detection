package com.detection.service.Impl;

import com.detection.entity.Login;
import com.detection.entity.User;
import com.detection.mapper.UserMapper;
import com.detection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ding
 * @date 2021/12/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User queryUser(Login login) {
        return userMapper.queryUser(login);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUser(Long userId) {
        return userMapper.removeUse(userId);
    }
}

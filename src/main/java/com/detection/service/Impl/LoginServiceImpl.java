package com.detection.service.Impl;

import com.alibaba.fastjson.JSON;
import com.detection.entity.College;
import com.detection.entity.Login;
import com.detection.entity.SharedParam;
import com.detection.entity.User;
import com.detection.interceptor.Interceptor;
import com.detection.mapper.LoginMapper;
import com.detection.service.LoginService;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author ding
 * @date 2021/12/8
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final static Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper userMapper;

    @Override
    public HashMap<String,Object> queryUser(Login login) {
        return userMapper.queryUser(login);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user) {
        logger.info("新增数据：{}", JSON.toJSONString(user));
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUser(Long userId) {
        return userMapper.removeUser(userId);
    }

    @Override
    public List<User> queryAllUser(SharedParam sharedParam) {
        return userMapper.queryAllUser(sharedParam);
    }

    @Override
    public User queryId(User user) {
        return userMapper.queryId(user);
    }


}

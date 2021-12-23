package com.detection.service.Impl;

import com.detection.entity.College;
import com.detection.entity.DBLog;
import com.detection.entity.SharedParam;
import com.detection.entity.User;
import com.detection.mapper.UserMapper;
import com.detection.service.UserService;
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
public class UserServiceImpl implements UserService {

    private final static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertCollege(SharedParam param) {
        return userMapper.insertCollege(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertListCollege(SharedParam param) {
        int i = 0;
        try {
            i = userMapper.insertListCollege(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;

    }



    @Override
    public int removeUser(List<Long> userIds) {
        return userMapper.removeUser(userIds);
    }

    @Override
    public List<HashMap<String, String>> queryCollege() {
        return userMapper.queryCollege();
    }

    @Override
    public int updateCollege(College college) {
        return userMapper.updateCollege(college);
    }

    @Override
    public int insertDBLog(DBLog log) {
        return userMapper.insertDBLog(log);
    }

    @Override
    public DBLog queryDBLog(DBLog log) {
        return userMapper.queryDBLog(log);
    }

    @Override
    public int updateDBLog(DBLog log) {
        return userMapper.updateDBLog(log);
    }

    @Override
    public List<DBLog> queryAllDBLog(DBLog log) {
        return userMapper.queryAllDBLog(log);
    }

    @Override
    public int deleteDBLog(List<Long> ids) {
        return userMapper.deleteDBLog(ids);
    }

    @Override
    public List<DBLog> queryListDBLog(List<Long> ids) {
        return userMapper.queryListDBLog(ids);
    }

}

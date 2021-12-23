package com.detection.mapper;


import com.detection.entity.College;
import com.detection.entity.Login;
import com.detection.entity.SharedParam;
import com.detection.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * @author ding
 * @date 2021/12/8
 */
@Service
public interface LoginMapper {

    HashMap<String,Object> queryUser(Login login);

    int insertUser(User user);

    int updateUser(User user);

    int removeUser(Long userId);

    List<User> queryAllUser(SharedParam sharedParam);

    User  queryId(User user);
}

package com.detection.mapper;


import com.detection.entity.Login;
import com.detection.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * @author ding
 * @date 2021/12/8
 */
@Service
public interface UserMapper {

    User queryUser(Login login);

    int insertUser(User user);

    int updateUser(User user);

    int removeUse(Long userId);
}

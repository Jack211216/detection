package com.detection.service;

import com.detection.entity.College;
import com.detection.entity.DBLog;
import com.detection.entity.SharedParam;
import com.detection.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Author ding
 * @Date 2021/12/17
 */
public interface UserService {


    int insertCollege(SharedParam param);

    int insertListCollege(@Param("param") SharedParam param);

    int removeUser(List<Long> userIds);

    List<HashMap<String, String>> queryCollege();

    int updateCollege(College college);

    int  insertDBLog(DBLog log);

    DBLog queryDBLog(DBLog log);

    int updateDBLog(DBLog log);

    List<DBLog> queryAllDBLog(DBLog log);

    int deleteDBLog (List<Long> ids);

    List<DBLog> queryListDBLog(List<Long> ids);
}

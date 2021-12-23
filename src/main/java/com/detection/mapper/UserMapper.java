package com.detection.mapper;


import com.detection.entity.College;
import com.detection.entity.DBLog;
import com.detection.entity.SharedParam;
import com.detection.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * @author ding
 * @date 2021/12/8
 */
@Service
public interface UserMapper {

    int insertCollege(SharedParam param);

    int insertListCollege(SharedParam param);

    int removeUser(List<Long> userIds);

    List<HashMap<String, String>> queryCollege();

    int updateCollege(College college);

    int  insertDBLog(DBLog log);

    DBLog queryDBLog(DBLog log);

    int updateDBLog(DBLog log);

    List<DBLog> queryAllDBLog(DBLog log);

    int deleteDBLog(@Param("ids") List<Long> ids);

    List<DBLog> queryListDBLog(@Param("ids") List<Long> ids);
}

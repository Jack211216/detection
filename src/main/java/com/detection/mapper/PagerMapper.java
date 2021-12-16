package com.detection.mapper;


import com.detection.entity.Pager;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.HashMap;


/**
 * @author ding
 * @date 2021/12/8
 */
@Service
public interface PagerMapper {

    Long count();

    HashMap<String,Object> findByPager(Pager pager);
}

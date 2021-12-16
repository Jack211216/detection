package com.detection.service;

import com.detection.entity.Pager;

import java.util.HashMap;

/**
 * @author ding
 * @date 2021/12/7
 */
public interface PagerService {

    Long count();

    HashMap<String,Object> findByPager(Pager pager);

}

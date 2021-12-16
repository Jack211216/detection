package com.detection.service.Impl;

import com.detection.mapper.PagerMapper;
import com.detection.service.PagerService;
import com.detection.entity.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author ding
 * @date 2021/12/7
 */
@Service
public class PagerServiceImpl implements PagerService {

    @Autowired(required = false)
    private PagerMapper pagerMapper;

    @Override
    public Long count() {
        return pagerMapper.count();
    }

    @Override
    public HashMap<String, Object> findByPager(Pager pager) {
        return pagerMapper.findByPager(pager);
    }
}

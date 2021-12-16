package com.detection.util;

import com.detection.util.entity.TableDataInfo;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ding
 * @date 2021/12/8
 */
public class PagerUtil {

    public static TableDataInfo getPager(List<?> list, int page, int size){

        if(StringUtils.isNull(page)){
            page=1;
        }
        if(StringUtils.isNull(size)){
            size=10;
        }

        TableDataInfo data = new TableDataInfo();
        data.setCode(HttpStatus.SUCCESS);
        data.setMsg("查询成功");
        data.setTotal(list.size());
        List<?> collect = null;
        if(page==0){
            collect=list.stream().skip(0).limit(size).collect(Collectors.toList());
        }
        collect=list.stream().skip((page - 1) * size).limit(size).collect(Collectors.toList());
        data.setRows(collect);
        return data;
    }
}

package com.detection.controller;

import com.detection.annotation.VerifyToken;
import com.detection.common.Result;
import com.detection.entity.College;
import com.detection.entity.SharedParam;
import com.detection.entity.User;
import com.detection.exception.entity.MyException;
import com.detection.service.LoginService;
import com.detection.service.UserService;
import com.detection.util.EncryUtil;
import com.detection.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Author ding
 * @Remark 管理员操作
 * @Date 2021/12/17
 */

@RestController
@RequestMapping("home")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;


    /**
     * 查询省所有份下的大学
     * */
    @VerifyToken
    @PostMapping("college")
    public Result College(){
        List<HashMap<String, String>> map = userService.queryCollege();
        return  Result.success(map);
    }

    /**
     * 获取所有用户
     * */
    @VerifyToken
    @PostMapping("user")
    public Result user(SharedParam sharedParam){
        List<User> list = loginService.queryAllUser(sharedParam);
        list.forEach(o->{
            o.setId(EncryUtil.EncryptLong(o.getId()));
        });
        return  Result.success(list);
    }

//    @GetMapping("file")
//    public Result file(@RequestParam String path){
//        Properties uerKey = PropertiesUtil.getUerKey(path);
//        return Result.success();
//    }


    /**
     * 修改用户
     * */
    @VerifyToken
    @PutMapping("up")
    public Result updateUser(@RequestBody User user){
        return  Result.success(loginService.updateUser(user));
    }


    /**
     * 删除用户
     * */
    @VerifyToken
    @DeleteMapping("del")
    public Result removeUser(@RequestParam("userIds") List<Long> userIds){
        return  Result.success(userService.removeUser(userIds));
    }



    /**
     * 导入excel转成实体
     * */
    @VerifyToken
    @PostMapping("import")
    public Result getExcel(@RequestParam("file") MultipartFile file){
        InputStream stream = null;
        try {
            stream=file.getInputStream();
            List<College> list = ExcelUtil.readExcelBean(stream, College.class,3);
            SharedParam param=new SharedParam();
            param.setColleges(list);
            userService.insertListCollege(param);
        } catch (IOException e) {
            throw new MyException("文件读取异常！");
        } catch (IllegalAccessException e) {
            throw new MyException(file.getName()+"文件没有访问权限！");
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stream!=null) stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  Result.success();
    }


}

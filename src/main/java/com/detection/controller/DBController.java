package com.detection.controller;

import com.detection.common.Result;
import com.detection.entity.DBLog;
import com.detection.exception.entity.MyException;
import com.detection.service.UserService;
import com.detection.util.EncryUtil;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author ding
 * @Date 2021/12/21
 */
@RestController
@RequestMapping("DB")
@Slf4j
public class DBController {

    @Value("${DB.COME_IP}")
    private  String COME_IP;

    @Value("${DB.GO_IP}")
    private  String GO_IP;

    @Value("${DB.USER_KEY}")
    private  String USER_KEY;

    @Value("${DB.USER_VALUE}")
    private  String USER_VALUE;

    @Value("${DB.DATA_BASE}")
    private  String DATA_BASE;

    @Autowired
    private UserService userService;




    @PostMapping("backup")
    public Result backup() {
        String flag="0";
        Runtime runtime = Runtime.getRuntime();  //获取Runtime实例

        String filepath = "E:"+File.separator+"sql"+File.separator+"" + System.currentTimeMillis() + ".sql"; // 备份的路径地址
        //执行命令（此处需要定位到mysqldump.exe路径，--default-character-set=gbk是为了解决中文乱码问题）
        String stmt = "D:"+File.separator+"ruanjian"+File.separator+"mysql"+File.separator+"mysql-8.0.25-winx64"+
                File.separator+"mysql-8.0.25-winx64"+File.separator+"bin"+File.separator+"mysqldump -h "+COME_IP+" -u"+
                USER_KEY+" -p"+USER_VALUE+" --default-character-set=gbk "+DATA_BASE+" > "+filepath;

        try {
            String[] command = { "cmd", "/c", stmt};
            Process process = runtime.exec(command);
            InputStream input = process.getInputStream();
            log.error(IOUtils.toString(input, "gbk"));
            //若有错误信息则输出
            InputStream errorStream = process.getErrorStream();
            log.error(IOUtils.toString(errorStream, "gbk"));

        } catch (IOException e) {
            throw new MyException("数据库备份失败");
        }

        //记录操作
        DBLog log=new DBLog();
        log.setFilePath(filepath);
        log.setOperPerson("张三");
        log.setOperAccount("admin");
        log.setOperTime(new Date());
        log.setState(flag);
        userService.insertDBLog(log);
        return Result.success("数据备份成功！");
    }


    /**
     * @remark 数据库复原
     */
    @PostMapping("recover")
    public  Result recover(String filePath) {
        DBLog DB1 = new DBLog();
        DB1.setOperAccount("admin");
        DBLog dbLog = userService.queryDBLog(DB1);
        Runtime runtime = Runtime.getRuntime();
        try {
            File file=new File(filePath);
            if(file.exists()) {
//                    String stmt1 = "mysqladmin -h " + GO_IP + " -u " + USER_KEY + " -p" + USER_VALUE + " create " + database;
                String stmt = "mysql -h " + GO_IP + " -u" + USER_KEY + " -p" + USER_VALUE + " " + DATA_BASE + "< " + filePath;
                String[] command = {"cmd", "/c", stmt};
                Process process = runtime.exec(command);
                InputStream errorStream = process.getErrorStream();
                log.error(IOUtils.toString(errorStream, "gbk"));
                //等待操作
                int processComplete = process.waitFor();
                if (processComplete == 0) {
                   log.info("还原成功");
                } else {
                    throw new MyException("还原数据库失败");
                }
            }else {
                throw new MyException("源文件不存在!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //记录操作
        DBLog log=new DBLog();
        log.setFilePath(dbLog.getFilePath());
        log.setOperPerson("张三");
        log.setOperAccount("admin");
        log.setOperTime(new Date());
        log.setState("1");
        userService.insertDBLog(log);
        return Result.success("数据库还原成功！");
    }


    /**
     * 删除备份文件
     * */
    @GetMapping("removeDB")
    public Result removeDB(@RequestParam("ids") List<Long> ids){
        List<Long> longs = EncryUtil.EncryptLong(ids);
        String[] filePath=new String[ids.size()];
        List<DBLog> log = userService.queryListDBLog(longs);
        int i=0;
        for(DBLog str:log){
            filePath[i]=str.getFilePath();
            i++;
        }

        for(String item:filePath) {
            File file = new File(item);
            if (file.isDirectory()) {
                return Result.error("该路径是目录");
            }
            if (file.exists()) {
                if(file.isFile()) {
                    boolean delete = file.delete();
                    if (!delete)
                        return Result.error("删除失败");
                }
            }
        }

        userService.deleteDBLog(longs);
        return Result.error("删除成功");
    }

    /**
     * 获取所有备份文件
     * */
    @PostMapping("AllDBLog")
    public Result queryAllDBLog(){
        List<DBLog> log = userService.queryAllDBLog(new DBLog());
        log.forEach(o->{
           o.setId(EncryUtil.DecryptLong(o.getId()));
           o.setState(String.valueOf(o.getState()));
        });

        return Result.success(log);
    }
}

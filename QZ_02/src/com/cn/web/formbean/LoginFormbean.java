package com.cn.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeguxin on 2016/9/18.
 */
public class LoginFormbean {
    /*
    * 封装用户表单提交的数据
    * 里面的数据与login.jsp中的表单项name一一对应
    * loginformbean负责接收数据，校验数据，防sql注入。
    * */
    //与login.jsp中的表单项一一对应
//    <input type="text" name="username">
    private String username;
//    <input type="password" name="password">
    private String password;
    //用map存储校验产生的错误信息
    private Map<String,String> errors=new HashMap<String,String>();
    public boolean isValid(){
        boolean isOk=true;
        return isOk;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

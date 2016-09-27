package com.cn.web.formbean;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by wan on 2016/9/16.
 */
public class RegisterFormbean {
    /*
    * 封装用户表单提交的数据
    * 里面的数据与register.jsp中的表单项name一一对应
    * registerformbean负责接收数据，校验数据
    * */
    //与register.jsp中的表单项一一对应
//    <input type="text" name="username">
    private String username;
//    <input type="text" name="nickname">
    private String nickname;
//    <input type="password" name="password1" id="pwd1">
    private String password1;
//    <input type="password" name="password2" id="pwd2">
    private String password2;
//    <input type="text" name="email">
    private String email;
    /*
    * 用map存储校验产生的错误信息*/
    private Map<String,String> errors=new HashMap<String,String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    /*
    * isvalid方法开始校验是否正确，返回boolean值*/
    public boolean isvalid() {
        boolean isOK = true;
        /*
         * isvalid方法负责校验表单输入项
         * 表单输入项校验规则：
         *         private String userName; 用户名不能为空，并且要是6-18的字符 abcdABcd
         *         private String nickname; 昵称不能为空
         *         private String password1; 密码不能为空，并且要是3-8的数字
         *         private String password2; 两次密码要一致
         *         private String email; 可以为空，不为空要是一个合法的邮箱
         */
        if (this.username == null || this.username.trim().equals("")) {
            isOK = false;
            errors.put("username", "用户名不能为空！！");
        } else {
            if (!this.username.matches("^[a-zA-z][a-zA-Z0-9_]{5,17}$")) {
                isOK = false;
                errors.put("username", "用户名必须是6-18位的字符");
            }
        }
        if (this.nickname ==null|| this.nickname.trim().equals("")){
            isOK = false ;
            errors.put("nickname","昵称不能为空！！");
        }
        if (this.password1 == null || this.password1.trim().equals("")) {
            isOK = false;
            errors.put("password1", "密码不能为空！！");
        } else {
            if (!this.password1.matches("\\d{3,8}")) {
                isOK = false;
                errors.put("password1", "密码必须为3-8位的数字");
            } else {
                if (!this.password1.equals(this.password2)) {
                    isOK = false;
                    errors.put("password2", "两次密码不一致！！");
                }
            }
        }
        if (this.email != null && !this.email.trim().equals("")) {
            if (!this.email.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
                isOK = false;
                errors.put("email", "这不是一个合法邮箱！！");
            }

        }
        return isOK;
    }
/*
* setter和 getter方法*/


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

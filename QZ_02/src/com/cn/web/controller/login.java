package com.cn.web.controller;

import com.cn.dao.demo.LoginAndRegister_Dao;
import com.cn.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wan on 2016/9/15.
 */
@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user=new User();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        LoginAndRegister_Dao lar_dao=new LoginAndRegister_Dao();

        try {
            List<User> list=lar_dao.getEntryByName(username);

            for (User user1 : list) {

//                response.getWriter().write(user1.getUsername()+"  "+user1.getPassword()+"  "+password);
                if (user1.getPassword().equals(password)){




                    int flag=1;
                    request.getSession().setAttribute("flag",flag);
                    request.getSession().setAttribute("username",username);
                    String stat=username+",欢迎您访问本网站";
                    request.getSession().setAttribute("stat",stat);
                    request.getRequestDispatcher("/WEB-INF/pages/success/login_suc.jsp").forward(request,response);

                    return;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

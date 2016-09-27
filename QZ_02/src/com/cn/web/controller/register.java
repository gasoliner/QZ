package com.cn.web.controller;

import com.cn.dao.demo.LoginAndRegister_Dao;
import com.cn.domain.User;
import com.cn.util.webUtils;
import com.cn.web.formbean.RegisterFormbean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wan on 2016/9/15.
 */
@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RegisterFormbean registerFormbean= webUtils.request2bean(request,RegisterFormbean.class);
            if (!registerFormbean.isvalid()){
                request.setAttribute("formbean",registerFormbean);
                request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request,response);
                return;

            }else {


//                response.getWriter().write("else");


                User user=new User();
                String username=request.getParameter("username");
                String password=request.getParameter("password1");
                user.setUsername(username);
                user.setPassword(password);
                LoginAndRegister_Dao lar_dao=new LoginAndRegister_Dao();
                try {
                    lar_dao.addEntry(user);
//                    response.sendRedirect("/UI_Login");
                } catch (Exception e) {
//                    response.sendRedirect("/WEB-INF/pages/error/Regis_Fail.jsp");
                    e.printStackTrace();
                }
                response.sendRedirect("/UI_login");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

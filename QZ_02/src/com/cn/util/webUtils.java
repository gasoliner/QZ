package com.cn.util;


import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
//import java.util.StringJoiner;

/**
 * Created by wan on 2016/9/17.
 */
public class webUtils {
    /*
    * 把request中的参数封装到Formbean中*/
    public static <T> T request2bean(HttpServletRequest httpServletRequest, Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T bean=clazz.newInstance();
        Enumeration<String> enumeration=httpServletRequest.getParameterNames();
        while (enumeration.hasMoreElements()){
            String name=(String)enumeration.nextElement();
            String value=httpServletRequest.getParameter(name);
            BeanUtils.setProperty(bean,name,value);
        }
        return bean;
    }
}

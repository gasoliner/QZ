package com.cn.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by yeguxin on 2016/9/23.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory=null;
    static{

        Configuration configuration=new Configuration();
        try {
            configuration.configure("hibernate.cfg.xml");
            sessionFactory=configuration.buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }


    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }
}

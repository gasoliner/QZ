package com.cn;


import com.cn.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by yeguxin on 2016/9/22.
 */
public class test {
    @Test
    public void test() {
        SessionFactory sf = null;
        Configuration cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        User user = session.get(User.class, 1);
        System.out.println(user.getId());
    }
}

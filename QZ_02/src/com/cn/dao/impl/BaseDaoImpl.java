package com.cn.dao.impl;

import com.cn.dao.IBaseDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jgroups.tests.perf.UPerf;


/**
 * Created by yeguxin on 2016/9/22.
 */
public class BaseDaoImpl<T> implements IBaseDao {

    private static SessionFactory sessionFactory ;

    public BaseDaoImpl() {
        Configuration configuration=new Configuration();

        configuration.configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
    }

    @Override
    public void addEntry(Object o) throws Exception {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(o);
        transaction.commit();
        session.close();

    }

    @Override
    public void moveEntry(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public Object getEntryById(Integer id) {
        return null;
    }

    @Override
    public Object getEntryByName(String name) {
        return null;
    }
}

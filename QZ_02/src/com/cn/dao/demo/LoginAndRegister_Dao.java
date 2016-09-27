package com.cn.dao.demo;

//import com.cn.dao.IBaseDao;
import com.cn.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.omg.CORBA.Object;
import com.cn.domain.User;

import java.util.List;

/**
 * Created by yeguxin on 2016/9/23.
 */
public class LoginAndRegister_Dao {

    public void addEntry(User user) throws Exception {

        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Transaction transaction=session.beginTransaction();//开始事务
            session.save(user);//保存
            transaction.commit();//提交事务
        }catch (RuntimeException e){
            session.beginTransaction().rollback();//回滚事务
            throw e;
        }finally {
            session.close();
        }

        return;
    }

    public void moveEntry(Object o) {

    }

    public void update(Object o) {

    }

    public User getEntryById(Integer id) {
        Session session=HibernateUtils.openSession();
        User user;
        try {
            Transaction transaction=session.beginTransaction();
            user=session.get(User.class,id);
            transaction.commit();
        }catch (RuntimeException e){
            session.beginTransaction().rollback();
            throw e;
        }finally {
            session.close();
        }

        return user;
    }

    public List<User> getEntryByName(String name) {
        Session session=HibernateUtils.openSession();
        String hql="FROM User WHERE user_name = ?";
        Query query = session.createQuery(hql);
        List<User> list= (List<User>) query.setString(0,name).list();
        return list;
    }
}

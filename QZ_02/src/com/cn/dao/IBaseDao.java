package com.cn.dao;
import org.hibernate.exception.*;
/**
 * Created by yeguxin on 2016/9/22.
 */
public interface IBaseDao<T> {
    /*
    *封装了DAO的基本的增删改查操作*/

    /*
    * 查询一张表的总的记录数*/
//    int getCount()
//    增加
    void addEntry (T t) throws Exception;
//    删除
    void moveEntry (T t);
//    更新
    void update (T t);
//    查询-根据ID
    T getEntryById(Integer id);
//    查询-根据用户名
    T getEntryByName(String name);
}

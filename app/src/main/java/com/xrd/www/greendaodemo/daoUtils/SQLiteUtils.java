package com.xrd.www.greendaodemo.daoUtils;

import com.xrd.www.greendaodemo.app.MyApp;
import com.xrd.www.greendaodemo.bean.Person;
import com.xrd.www.greendaodemo.bean.User;
import com.xrd.www.greendaodemo.dao.DaoSession;
import com.xrd.www.greendaodemo.dao.PersonDao;
import com.xrd.www.greendaodemo.dao.UserDao;

import java.util.List;

/**
 * Created by user on 2018/8/14.
 */

public class SQLiteUtils {
    private static SQLiteUtils instance;
    private final DaoSession daoSession;
    private final UserDao userDao;
    private final PersonDao personDao;

    private SQLiteUtils(){
        daoSession = MyApp.getInstances().getDaoSession();
        userDao = daoSession.getUserDao();
        personDao = daoSession.getPersonDao();
    }
    public static SQLiteUtils getInstance(){
        if(instance==null){
            synchronized (SQLiteUtils.class){
                if(instance==null){
                    instance=new SQLiteUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 添加user
     * @param user
     * @return
     */
    public long addUser(User user){
        long insert = userDao.insert(user);
        return insert;
    }
    /**
     * 删除指定user
     * @param user
     * @return
     */
    public void deleteUser(User user){
        userDao.delete(user);
    }
    /**
     * 更新指定user
     * @param user
     * @return
     */
    public void updataUser(User user){
        userDao.update(user);
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> findAll(){
        List<User> userList = userDao.queryBuilder().list();
        return userList;
    }

    /**
     * 按照name进行指定查询
     * @param name
     * @return
     */
    public List<User> selectName(String name){
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().list();
        return list;
    }
    /**
     * 按照age进行查询
     */
    /*public List<User> selectAge(int age){
        userDao.queryBuilder().where(UserDao.Properties.Age==age).build().list();
    }*/

    /**
     * 删除所有
     */
    public void deleteAll(){
        userDao.deleteAll();
    }

    public Long insertData(Person person){
        long insert = personDao.insert(person);
        return insert;
    }
    public List<Person> findAllPerson(){
        List<Person> list = personDao.queryBuilder().list();
        return list;
    }
}

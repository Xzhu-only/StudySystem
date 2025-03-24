package Dao.abst;

import javaBean.UserBean;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {//接口类提供访问数据库的接口
    public ResultSet login(String Uname) throws Exception;//登录
    public boolean register(String Uname,String Upassword,String Major,String Classname,String commits,String safeanwser);//注册
    public ResultSet find(String Uname) throws Exception;//找回
    public List<UserBean> getAll() throws Exception;//获取对象组
    public UserBean getOne(String Uname) throws Exception;//获取单个对象
    public int delete(String Uname) throws Exception;//删除
    public int update(UserBean ub) throws Exception;//修改
    int modifyPass(String name, String password) throws Exception;
}

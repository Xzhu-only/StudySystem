package service.abst;

import javaBean.UserBean;

import java.sql.ResultSet;
import java.util.List;
public interface UserService {//抽象服务类，提供操作的接口
    public ResultSet login(String Uname) throws Exception;
    public boolean register(String Uname, String Upassword,String Major,String Classname, String commits, String safeanwser);//注册
    public ResultSet find(String Uname) throws Exception;//登录
    public int delete(String Uname)throws Exception;
    public List<UserBean> getAll() throws Exception;
    UserBean getOne(String Uname) throws Exception;
    public int update(UserBean ub) throws Exception;
    public int modifyPass(String name,String password) throws Exception;
}

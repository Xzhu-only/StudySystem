package service.Impl;

import Dao.abst.UserDao;
import Dao.impl.UserDaoImpl;
import javaBean.UserBean;
import service.abst.UserService;

import java.sql.ResultSet;
import java.util.List;

public class UserServiceImpl implements UserService {//具体操作的实现类，调用daoImpl，实现封装（外界访问数据库操作的统一接口）
    private UserDao ud=new UserDaoImpl();
    @Override
    public ResultSet login(String Uname) throws Exception {return ud.login(Uname);}
    @Override
    public int delete(String Uname) throws Exception {return ud.delete(Uname);}
    @Override
    public boolean register(String Uname, String Upassword,String Major,String Classname, String commits, String safeanwser) {
        return ud.register(Uname,Upassword,Major,Classname,commits,safeanwser);
    }
    @Override
    public ResultSet find(String Uname) throws Exception {return ud.find(Uname);}
    @Override
    public List<UserBean> getAll() throws Exception {return ud.getAll();}
    @Override
    public UserBean getOne(String Uname) throws Exception {return ud.getOne(Uname);}
    @Override
    public int update(UserBean ub) throws Exception {return ud.update(ub);}
    @Override
    public int modifyPass(String name, String password) throws Exception {return ud.modifyPass(name,password);}
}

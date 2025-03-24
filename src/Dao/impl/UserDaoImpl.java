package Dao.impl;

import Dao.BaseDao;
import Dao.DatabaseAccessObject;
import Dao.abst.UserDao;
import javaBean.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    Connection conn = DatabaseAccessObject.getConn();
    @Override
    public int delete(String Uname) {
        String sql = "delete from users where Uname=?";
        Object[] obj = {Uname};
        int rt;
        try {
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }
    @Override
    public ResultSet login(String Uname) {
        String sql = "select*from users where Uname=?";
        Object[] obj = {Uname};
        boolean temp = false;
        ResultSet rt;
        try {
            rt = this.query(conn,sql, obj);
        } catch (Exception a) {
            throw new RuntimeException(a);
        }
        return rt;
    }
    @Override
    public boolean register(String Uname, String Upassword,String Major,String Classname,String commits, String safeanwser) {
        String sql ="insert into users(Uname,Upassword,Major,Classname,commits,safeanwser) values(?,?,?,?,?,?)";
        Object [] obj={Uname,Upassword,Major,Classname,commits,safeanwser};
        boolean temp=false;
        try {
            int rt = this.insert(conn,sql, obj);
            if(rt!=0){
                temp=true;
            }
        } catch (Exception a) {
            throw new RuntimeException(a);
        }
        return temp;
    }
    @Override
    public ResultSet find(String Uname) {
        String sql = "select*from users where Uname=?";
        Object[] obj = {Uname};
        boolean temp = false;
        ResultSet rt;
        try {
            rt = this.query(conn,sql, obj);
        } catch (Exception a) {
            throw new RuntimeException(a);
        }
        return rt;
    }
    @Override
    public List<UserBean> getAll() throws Exception {
        String sql = "select*from users";
        ResultSet rt=this.query(conn,sql,new Object[] {});
        List<UserBean> list=new ArrayList<UserBean>();
        while (rt.next()){
            UserBean ub=new UserBean();
            ub.setUid(rt.getInt(1));
            ub.setUname(rt.getString(2));
            ub.setMajor(rt.getString(3));
            ub.setClassname(rt.getString(4));
            ub.setUpassword(rt.getString(5));
            ub.setCommits(rt.getString(6));
            ub.setSafeanwser(rt.getString(7));
            ub.setIsdelete(rt.getString(8));
            list.add(ub);
        }
        return list;
    }
    @Override
    public UserBean getOne(String Uname) throws Exception {
        String sql = "select*from users where Uname=?";
        Object[] obj = {Uname};
        ResultSet rt=this.query(conn,sql,obj);
        UserBean ub=new UserBean();
        while (rt.next()){
            ub.setUid(rt.getInt(1));
            ub.setUname(rt.getString(2));
            ub.setMajor(rt.getString(3));
            ub.setClassname(rt.getString(4));
            ub.setUpassword(rt.getString(5));
            ub.setCommits(rt.getString(6));
            ub.setSafeanwser(rt.getString(7));
            ub.setIsdelete(rt.getString(8));
        }
        return ub;
    }
    @Override
    public int update(UserBean ub) throws Exception {
        String sql = "update users set Uname=?,Upassword=?,Major=?,Classname=?,commits=?,safeanwser=?,isdelete=? where Uid=?";
        return this.modify(conn,sql,new Object[]{ub.getUname(),ub.getUpassword(),ub.getMajor(),ub.getClassname(),ub.getCommits(),ub.getSafeanwser(),
                ub.getIsdelete(),ub.getUid()});
    }
    @Override
    public int modifyPass(String name,String password) throws Exception {
        String sql = "update users set Upassword=?where Uname=?";
        Object[] obj = {password,name};
        return this.modify(conn,sql,obj);
    }
}

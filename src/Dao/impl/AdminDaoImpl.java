package Dao.impl;

import Dao.BaseDao;
import Dao.DatabaseAccessObject;
import Dao.abst.AdminDao;
import javaBean.AdminBean;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    Connection conn = DatabaseAccessObject.getConn();
    @Override
    public ResultSet login(String Aname) throws Exception {
        String sql = "select*from admins where Aname=?";
        Object[] obj = {Aname};
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
    public boolean add(String Aname, String Apassword) {
        String sql ="insert into admins(Aname,Apassword) values(?,?)";
        Object [] obj={Aname,Apassword};
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
    public List<AdminBean> getAll() throws Exception {
        String sql = "select*from admins";
        ResultSet rt=this.query(conn,sql);
        List<AdminBean> list=new ArrayList<AdminBean>();
        while (rt.next()){
            AdminBean ab=new AdminBean();
            ab.setAid(rt.getInt(1));
            ab.setAname(rt.getString(2));
            ab.setApassword(rt.getString(3));
            list.add(ab);
        }
        return list;
    }

    @Override
    public AdminBean getOne(String Aname) throws Exception {
        String sql = "select*from admins where Aname=?";
        Object[] obj = {Aname};
        ResultSet rt=this.query(conn,sql,obj);
        AdminBean ab =new AdminBean();
        while (rt.next()){
            ab.setAid(rt.getInt(1));
            ab.setAname(rt.getString(2));
            ab.setApassword(rt.getString(3));
        }
        return ab;
    }

    @Override
    public int delete(String Aname) throws Exception {
        String sql = "delete from admins where Aname=?";
        Object[] obj = {Aname};
        int rt;
        try {
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }

    @Override
    public int update(AdminBean ab) throws Exception {
        String sql = "update admins set Aname=?,Apassword=? where Aid=?";
        return this.modify(conn,sql, ab.getAname(),ab.getApassword(),ab.getAid());
    }
}

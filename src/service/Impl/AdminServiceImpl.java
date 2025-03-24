package service.Impl;

import Dao.abst.AdminDao;
import Dao.impl.AdminDaoImpl;
import javaBean.AdminBean;
import service.abst.AdminService;

import java.sql.ResultSet;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao ad =new AdminDaoImpl();
    @Override
    public ResultSet login(String Aname) throws Exception {
        return ad.login(Aname);
    }

    @Override
    public boolean add(String Aname, String Apassword) {
        return ad.add(Aname,Apassword);
    }

    @Override
    public List<AdminBean> getAll() throws Exception {
        return ad.getAll();
    }

    @Override
    public AdminBean getOne(String Aname) throws Exception {
        return ad.getOne(Aname);
    }

    @Override
    public int delete(String Aname) throws Exception {
        return ad.delete(Aname);
    }

    @Override
    public int update(AdminBean ab) throws Exception {
        return ad.update(ab);

    }


}

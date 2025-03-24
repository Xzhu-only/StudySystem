package service.abst;

import javaBean.AdminBean;

import java.sql.ResultSet;
import java.util.List;

public interface AdminService {
    public ResultSet login(String Aname) throws Exception;


    public boolean add(String Aname,String Apassword);//添加

    public List<AdminBean> getAll() throws Exception;//获取对象组

    public AdminBean getOne(String Aname) throws Exception;//获取单个对象

    public int delete(String Aname) throws Exception;//删除

    public int update(AdminBean ab) throws Exception;//修改
}

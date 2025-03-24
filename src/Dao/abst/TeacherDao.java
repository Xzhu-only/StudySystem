package Dao.abst;

import javaBean.TeacherBean;
import javaBean.UserBean;

import java.sql.ResultSet;
import java.util.List;

public interface TeacherDao {
    //登录
    public TeacherBean login(String Tname) throws Exception; //登录
    public boolean register(String Tname,String Tpassword,String prone,String introduce);//注册

    public List<TeacherBean> getAll() throws Exception;//获取对象组

    public TeacherBean getOne(String Tname) throws Exception;//获取单个对象

    public boolean add(String Tname,String Tpassword,String prone,String introduce);//添加

    public int delete(String Tname) throws Exception;//删除

    public int update(TeacherBean tb) throws Exception;//修改

}

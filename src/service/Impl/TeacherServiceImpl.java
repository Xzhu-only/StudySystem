package service.Impl;

import Dao.abst.TeacherDao;
import Dao.impl.TeacherDaoImpl;
import javaBean.TeacherBean;
import service.abst.TeacherService;

import java.sql.ResultSet;
import java.util.List;

    public class TeacherServiceImpl implements TeacherService {
        TeacherDao td = new TeacherDaoImpl();

        @Override
        public TeacherBean login(String Tname) throws Exception {

            String sql = "SELECT tpassword, isdelete FROM teacher WHERE tname = ?";
            System.out.println("SQL Query: " + sql);
            System.out.println("Parameter: " + Tname);

            return td.login(Tname);
            // 确保查询语句和数据库字段一致
        }
    @Override
    public boolean register(String Tname, String Tpassword, String prone, String introduce) {
        return td.register(Tname,Tpassword,prone,introduce);
    }

    @Override
    public List<TeacherBean> getAll() throws Exception {
        return td.getAll();
    }

    @Override
    public TeacherBean getOne(String Tname) throws Exception {
        return td.getOne(Tname);
    }

    @Override
    public boolean add(String Tname, String Tpassword, String prone, String introduce) {
        return td.add(Tname,Tpassword,prone,introduce);
    }

    @Override
    public int delete(String Tname) throws Exception {
        return td.delete(Tname);
    }

    @Override
    public int update(TeacherBean tb) throws Exception {
        return td.update(tb);
    }
}

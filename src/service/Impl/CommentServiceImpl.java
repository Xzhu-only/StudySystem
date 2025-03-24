package service.Impl;

import Dao.abst.CommentDao;
import Dao.impl.CommentDaoImpl;
import javaBean.CommentBean;
import service.abst.CommentService;

import java.sql.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    CommentDao cd=new CommentDaoImpl();

    @Override
    public List<CommentBean> getAll() throws Exception {
        return cd.getAll();
    }

    @Override
    public int delete(int Cid) throws Exception {
        return cd.delete(Cid);
    }

    @Override
    public int deleteByUid(int Uid) throws Exception {
        return cd.deleteByUid(Uid);
    }

    @Override
    public int deleteByVid(int Vid) throws Exception {
        return cd.deleteByVid(Vid);
    }

    @Override
    public List<CommentBean> getByUid(int Uid) throws Exception {
        return cd.getByUid(Uid);
    }
    @Override
    public List<CommentBean> getByVid(int Vid) throws Exception{
        return cd.getByVid(Vid);
    }

    @Override
    public boolean add(int Uid, int Vid, String create_time, String comments) {
        return cd.add(Uid,Vid,create_time,comments);
    }
}

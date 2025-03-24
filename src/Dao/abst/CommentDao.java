package Dao.abst;

import javaBean.CommentBean;

import java.sql.Date;
import java.util.List;

public interface CommentDao {

    public List<CommentBean> getAll() throws Exception;//获取对象组

    public int delete(int Cid) throws Exception;//删除单挑评论

    public int deleteByUid(int Uid) throws Exception;//级联删除用户

    public int deleteByVid(int Vid) throws Exception;//级联删除视频

    List<CommentBean> getByUid(int Uid) throws Exception;

    List<CommentBean> getByVid(int Vid) throws Exception;
    boolean add(int Uid, int Vid, String create_time, String comments);
}

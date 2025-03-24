package test;

import Dao.abst.CommentDao;
import Dao.impl.CommentDaoImpl;

public class DateTest {
    public static void main(String[] args) throws Exception {
        CommentDao commentDao =new CommentDaoImpl();
        commentDao.getAll();
    }
}

package service.abst;

import javaBean.VideoBean;

import java.util.List;

public interface VideoService {
    public boolean add(int Tid ,String Vname,String category,String grade,String introduce,String img,String path);//添加
    public List<VideoBean> getAll() throws Exception;//获取对象组
    public VideoBean getOne(String Vname) throws Exception;//获取单个对象

    public int delete(String Vname) throws Exception;//删除

    public int deleteByTid(int Tid) throws Exception;//级联删除教师
    public int update(VideoBean vb) throws Exception;//修改
    public int update1(VideoBean vb1) throws Exception;//修改
    public VideoBean getOneByVid(int Vid) throws Exception;
    public List<VideoBean>  getOneByTid(int Tid) throws Exception;

    public List<VideoBean> getByKeyword(String keyword) throws Exception;//获取对象组

    public List<VideoBean> getByCategory(String instrumentType,String hardType) throws Exception;

}

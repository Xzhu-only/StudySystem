package service.Impl;

import Dao.abst.VideoDao;
import Dao.impl.VideoDaoImpl;
import javaBean.VideoBean;
import service.abst.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    VideoDao vd=new VideoDaoImpl();
    @Override
    public boolean add(int Tid, String Vname, String category, String grade, String introduce, String img, String path) {
        return vd.add(Tid,Vname,category,grade,introduce,img,path);
    }
    @Override
    public List<VideoBean> getAll() throws Exception {
        return vd.getAll();
    }
    @Override
    public VideoBean getOne(String Vname) throws Exception {
        return vd.getOne(Vname);
    }
    @Override
    public int delete(String Vname) throws Exception {
        return vd.delete(Vname);
    }
    @Override
    public int deleteByTid(int Tid) throws Exception {
        return vd.deleteByTid(Tid);
    }
    @Override
    public int update(VideoBean vb) throws Exception {
        return vd.update(vb);
    }
    @Override
    public int update1(VideoBean vb1) throws Exception {
        return vd.update1(vb1);
    }
    @Override
    public VideoBean getOneByVid(int Vid) throws Exception {
        return vd.getOneByVid(Vid);
    }
   @Override
   public List<VideoBean> getOneByTid(int Tid) throws Exception {
       return vd.getOneByTid(Tid);
   }
    @Override
    public List<VideoBean> getByKeyword(String keyword) throws Exception {
        return vd.getByKeyword(keyword);
    }

    @Override
    public List<VideoBean> getByCategory(String instrumentType, String hardType) throws Exception {
        return vd.getByCategory(instrumentType,hardType);
    }
}

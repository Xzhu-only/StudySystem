package service.Impl;


import Dao.impl.CourseDaoimpl;
import service.abst.CourseService;
import javaBean.CourseBean;

public class CourseServiceImpl implements CourseService {

    private CourseDaoimpl courseDao;

    public CourseServiceImpl() {
        this.courseDao = new CourseDaoimpl();
    }

    @Override
    public boolean addCourse(CourseBean course,int tid) {
        return courseDao.addCourse(course,tid);
    }
}

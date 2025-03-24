package service.abst;

import javaBean.CourseBean;

public interface CourseService {
    boolean addCourse(CourseBean course,int teacher_id);
}


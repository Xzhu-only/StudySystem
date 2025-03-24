package Dao.abst;

import javaBean.CourseBean;

import java.util.List;

public interface CourseDao {
    // 获取教师的所有课程（改为实例方法）
    List<CourseBean> getCoursesByTeacherId(int teacherId);

    // 添加课程
    boolean addCourse(CourseBean course,int teacherId);

    // 删除课程
    boolean deleteCourse(int courseId);

    // 更新课程信息
    boolean updateCourse(CourseBean course);
}

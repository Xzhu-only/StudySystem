package javaBean;

public class CourseBean {
    private int courseId;          // 课程 ID
    private int teacherId;         // 教师 ID
    private String courseName;     // 课程名称
    private String category;       // 课程类别
    private String grade;          // 适用年级
    private String introduce;      // 课程介绍
    private String isDelete;       // 是否删除（逻辑删除）

    // 默认构造方法
    public CourseBean() {}

    // 带参数构造方法
    public CourseBean(int courseId, int teacherId, String courseName, String category, String grade, String introduce, String isDelete) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.courseName = courseName;
        this.category = category;
        this.grade = grade;
        this.introduce = introduce;
        this.isDelete = isDelete;
    }

    // Getter 和 Setter 方法

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTid() {
        return teacherId;
    }

    public void setTid(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourname(String courseName) {
        this.courseName = courseName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CourseBean{" +
                "courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", courseName='" + courseName + '\'' +
                ", category='" + category + '\'' +
                ", grade='" + grade + '\'' +
                ", introduce='" + introduce + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }

}


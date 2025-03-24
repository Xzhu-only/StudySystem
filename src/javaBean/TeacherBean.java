package javaBean;

public class TeacherBean {
    private int tid;
    private String tname;
    private String Tpassword;
    private String prone;
    private String introduce;
    private String isdelete;

    public TeacherBean(int tid, String tname, String tpassword, String prone, String introduce, String isdelete) {
        this.tid = tid;
        this.tname = tname;
        this.Tpassword = tpassword;
        this.prone = prone;
        this.introduce = introduce;
        this.isdelete = isdelete;
    }
    public TeacherBean(int tid, String tname, String tpassword, String prone, String introduce) {
        this.tid = tid;
        this.tname = tname;
        this.Tpassword = tpassword;
        this.prone = prone;
        this.introduce = introduce;
    }

    public TeacherBean() {
    }

    public TeacherBean(int tid, String tname, String tpassword, String isdelete) {
        this.tid = tid;
        this.tname = tname;
        this.Tpassword = tpassword;
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "TeacherBean{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", introduce='" + introduce + '\'' +
                ", isdelete=" + isdelete +
                ", prone='" + prone + '\'' +
                '}';
    }

    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }
    public String getTpassword() {
        return Tpassword;
    }
    public void setTpassword(String tpassword) {
        this.Tpassword = tpassword;
    }
    public String getProne() {
        return prone;
    }
    public void setProne(String prone) {
        this.prone = prone;
    }
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getIsdelete() {
        return isdelete;
    }
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }
}

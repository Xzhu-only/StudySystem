package javaBean;

public class UserBean {
    private int Uid;
    private String Uname;
    private String Major;
    private String Classname;
    private String Upassword;
    private String commits;
    private String safeanwser;
    private String isdelete;
    public UserBean(int uid, String uname,String major,String classname, String upassword, String commits, String safeanwser, String isdelete) {
        Uid = uid;
        Uname = uname;
        Major = major;
        Classname = classname;
        Upassword = upassword;
        this.commits = commits;
        this.safeanwser = safeanwser;
        this.isdelete = isdelete;
    }

    public UserBean() {

    }

    public int getUid() {
        return Uid;
    }
    public void setUid(int Uid) {
        this.Uid = Uid;
    }
    public String getUname() {
        return Uname;
    }
    public void setMajor(String Major) {
        this.Major=Major;
    }
    public String getMajor() {return Major;}

    public void setClassname(String Classname) {
        this.Classname = Classname;
    }
    public String getClassname() {return Classname;}
    public void setUname(String Uname) {
        this.Uname = Uname;
    }
    public String getUpassword() {
        return Upassword;
    }
    public void setUpassword(String Upassword) {
        this.Upassword = Upassword;
    }
    public String getCommits() {
        return commits;
    }
    public void setCommits(String commits) {
        this.commits = commits;
    }
    public String getSafeanwser() {
        return safeanwser;
    }
    public void setSafeanwser(String safeanwser) {
        this.safeanwser = safeanwser;
    }
    public String getIsdelete() {
        return isdelete;
    }
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }
}

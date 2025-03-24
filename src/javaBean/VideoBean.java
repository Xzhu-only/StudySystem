package javaBean;

public class VideoBean {
    private int Vid;
    private int Tid;//教师号，外键参照教师表
    private String Vname;
    private String category;
    private String grade;
    private String introduce;
    private String img;
    private String path;
    public VideoBean(int vid, int tid, String vname, String category, String grade, String introduce,String img,String path) {
        Vid = vid;
        Tid = tid;
        Vname = vname;
        this.category = category;
        this.grade = grade;
        this.introduce = introduce;
        this.img=img;
        this.path=path;
    }
    public VideoBean(int vid,String vname, String category, String grade, String introduce) {
        Vid = vid;
        Vname = vname;
        this.category = category;
        this.grade = grade;
        this.introduce = introduce;
    }

    public VideoBean() {

    }

    public int getVid() {
        return Vid;
    }
    public void setVid(int Vid) {
        this.Vid = Vid;
    }
    public int getTid() {
        return Tid;
    }
    public void setTid(int Tid) {
        this.Tid = Tid;
    }
    public String getVname() {
        return Vname;
    }
    public void setVname(String Vname) {
        this.Vname = Vname;
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
    public String getImg() {return img;}
    public void setImg(String img) {this.img = img;}
    public String getPath() {return path;}
    public void setPath(String path) {this.path = path;}
}

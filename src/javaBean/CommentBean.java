package javaBean;

import java.sql.Date;

public class CommentBean {
    private int Cid;
    private int Uid;
    private int Vid;//视频号，外键参照视频表
    private String create_time;
    private String comment;
    public CommentBean(int cid, int uid, int vid, String create_time, String comment) {
        Cid = cid;
        Uid = uid;
        Vid = vid;
        this.create_time = create_time;
        this.comment = comment;
    }

    public CommentBean() {

    }

    public int getCid() {return Cid;}
    public void setCid(int Cid) {this.Cid = Cid;}
    public int getUid() {return Uid;}
    public void setUid(int Uid) {this.Uid = Uid;}
    public int getVid() {return Vid;}
    public void setVid(int Vid) {this.Vid = Vid;}
    public String getCreate_time() {return create_time;}
    //返回当前时间
    public void setCreate_time(String create_time) {this.create_time = create_time;}
    public String getComment() {return comment;}
    public void setComment(String comment) {this.comment = comment;}
}

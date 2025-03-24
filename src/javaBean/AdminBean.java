package javaBean;

public class AdminBean {
    private int Aid;
    private String Apassword;
    private String Aname;
    public AdminBean() {
    }
    public AdminBean(int aid, String aname, String apassword) {
        Aid = aid;
        Aname = aname;
        Apassword = apassword;
    }
    public int getAid() {
        return Aid;
    }
    public void setAid(int Aid) {this.Aid = Aid;}
    public String getApassword() {return Apassword;}
    public void setApassword(String Apassword) {this.Apassword = Apassword;}
    public String getAname() {return Aname;}
    public void setAname(String Aname) {this.Aname = Aname;}
}

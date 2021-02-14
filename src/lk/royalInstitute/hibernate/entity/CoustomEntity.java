package lk.royalInstitute.hibernate.entity;

public class CoustomEntity implements SuperEntity{
    private String Student_ID;
    private String Student_Name;
    private String Course_ID;
    private String Course_Name;
    private int Reg_No;
    private String Reg_Date;
    private double Reg_Fee;

    public CoustomEntity() {
    }

    public CoustomEntity(String student_ID, String student_Name, String course_ID, String course_Name, int reg_No, String reg_Date, double reg_Fee) {
        Student_ID = student_ID;
        Student_Name = student_Name;
        Course_ID = course_ID;
        Course_Name = course_Name;
        Reg_No = reg_No;
        Reg_Date = reg_Date;
        Reg_Fee = reg_Fee;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String course_ID) {
        Course_ID = course_ID;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    public int getReg_No() {
        return Reg_No;
    }

    public void setReg_No(int reg_No) {
        Reg_No = reg_No;
    }

    public String getReg_Date() {
        return Reg_Date;
    }

    public void setReg_Date(String reg_Date) {
        Reg_Date = reg_Date;
    }

    public Double getReg_Fee() {
        return Reg_Fee;
    }

    public void setReg_Fee(Double reg_Fee) {
        Reg_Fee = reg_Fee;
    }

    @Override
    public String toString() {
        return "CoustomEntity{" +
                "Student_ID='" + Student_ID + '\'' +
                ", Student_Name='" + Student_Name + '\'' +
                ", Course_ID='" + Course_ID + '\'' +
                ", Course_Name='" + Course_Name + '\'' +
                ", Reg_No=" + Reg_No +
                ", Reg_Date='" + Reg_Date + '\'' +
                ", Reg_Fee=" + Reg_Fee +
                '}';
    }

}

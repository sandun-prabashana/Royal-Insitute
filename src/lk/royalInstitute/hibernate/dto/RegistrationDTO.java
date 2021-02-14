package lk.royalInstitute.hibernate.dto;

import javafx.scene.control.Button;

public class RegistrationDTO {
    private int Reg_No;
    private String Reg_Date;
    private Double Reg_Fee;
    private String Student_ID;
    private String Course_ID;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int reg_No, String reg_Date, Double reg_Fee, String student_ID, String course_ID) {
        Reg_No = reg_No;
        Reg_Date = reg_Date;
        Reg_Fee = reg_Fee;
        Student_ID = student_ID;
        Course_ID = course_ID;
    }

    public RegistrationDTO(int reg_no) {
        this.Reg_No=reg_no;
    }

    public RegistrationDTO(String course_id, String student_id, int reg_no, String reg_date, Double reg_fee) {
        this.Course_ID=course_id;
        this.Student_ID=student_id;
        this.Reg_No=reg_no;
        this.Reg_Date=reg_date;
        this.Reg_Fee=reg_fee;
    }
//
//    public RegistrationDTO(int reg_No, String reg_Date, Double reg_Fee, String student_ID, String course_ID) {
//        Reg_No = reg_No;
//        Reg_Date = reg_Date;
//        Reg_Fee = reg_Fee;
//        Student_ID = student_ID;
//        Course_ID = course_ID;
//    }

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

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String course_ID) {
        Course_ID = course_ID;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "Reg_No=" + Reg_No +
                ", Reg_Date='" + Reg_Date + '\'' +
                ", Reg_Fee=" + Reg_Fee +
                ", Student_ID='" + Student_ID + '\'' +
                ", Course_ID='" + Course_ID + '\'' +
                '}';
    }
}

package lk.royalInstitute.hibernate.dto;

import javafx.scene.control.Button;

public class CoustomDTO {
    private int Reg_No;
    private String date;
    private Double fee;
    private String SId;
    private String CId;
    private Button button;
    private String Student_ID;
    private String Student_Name;
    private String Course_ID;
    private String Course_Name;
    private String Reg_Date;
    private Double Reg_Fee;

    public CoustomDTO(String student_ID, String student_Name, String course_ID, String course_Name,int reg_No, String reg_Date, Double reg_Fee) {
        this.Student_ID=student_ID;
        this.Student_Name=student_Name;
        this.Course_ID=course_ID;
        this.Course_Name=course_Name;
        this.Reg_No=reg_No;
        this.Reg_Date=reg_Date;
        this.Reg_Fee=reg_Fee;
    }

    public CoustomDTO() {
    }

    public CoustomDTO(int reg_No, String date, Double fee, String SId, String CId, Button button) {
        Reg_No = reg_No;
        this.date = date;
        this.fee = fee;
        this.SId = SId;
        this.CId = CId;
        this.button = button;
    }

    public int getReg_No() {
        return Reg_No;
    }

    public void setReg_No(int reg_No) {
        Reg_No = reg_No;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
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
}

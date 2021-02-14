package lk.royalInstitute.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Registration implements SuperEntity{
    @Id
    private int Reg_No;
    private String Reg_Date;
    private Double Reg_Fee;

    @EmbeddedId
    private RegistrationPK registrationPK;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Student_ID", referencedColumnName = "Student_ID" , insertable = false , updatable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID" , insertable = false , updatable = false)
    private Course course;

    public Registration(int reg_no, String reg_date, Double reg_fee, String student_id, String course_id) {
        this.Reg_No=reg_no;
        this.Reg_Date=reg_date;
        this.Reg_Fee=reg_fee;
        this.registrationPK=new RegistrationPK(student_id,course_id);
    }

    public Registration(int reg_No, String reg_Date, Double reg_Fee, RegistrationPK registrationPK, Student student, Course course) {
        Reg_No = reg_No;
        Reg_Date = reg_Date;
        Reg_Fee = reg_Fee;
        this.registrationPK = registrationPK;
        this.student = student;
        this.course = course;
    }

    public Registration() {
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

    public RegistrationPK getRegistrationPK() {
        return registrationPK;
    }

    public void setRegistrationPK(RegistrationPK registrationPK) {
        this.registrationPK = registrationPK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Reg_No == that.Reg_No &&
                Objects.equals(Reg_Date, that.Reg_Date) &&
                Objects.equals(Reg_Fee, that.Reg_Fee) &&
                Objects.equals(registrationPK, that.registrationPK) &&
                Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Reg_No, Reg_Date, Reg_Fee, registrationPK, student, course);
    }
}

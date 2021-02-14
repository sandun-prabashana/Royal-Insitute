package lk.royalInstitute.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Course implements SuperEntity{
    @Id
    private String Course_ID;
    private String Course_Name;
    private Double Fee;
    private String Duration;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Registration> registrationDetailList;

    public Course() {
    }

    public Course(String course_ID, String course_Name, Double fee, String duration) {
        Course_ID = course_ID;
        Course_Name = course_Name;
        Fee = fee;
        Duration = duration;
    }

    public Course(String course_ID, String course_Name, Double fee, String duration, List<Registration> registrationDetailList) {
        Course_ID = course_ID;
        Course_Name = course_Name;
        Fee = fee;
        Duration = duration;
        this.registrationDetailList = registrationDetailList;
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

    public Double getFee() {
        return Fee;
    }

    public void setFee(Double fee) {
        Fee = fee;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public List<Registration> getRegistrationDetailList() {
        return registrationDetailList;
    }

    public void setRegistrationDetailList(List<Registration> registrationDetailList) {
        this.registrationDetailList = registrationDetailList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Course_ID='" + Course_ID + '\'' +
                ", Course_Name='" + Course_Name + '\'' +
                ", Fee=" + Fee +
                ", Duration='" + Duration + '\'' +
                ", registrationDetailList=" + registrationDetailList +
                '}';
    }
}

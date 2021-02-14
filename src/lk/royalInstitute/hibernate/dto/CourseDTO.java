package lk.royalInstitute.hibernate.dto;

import java.math.BigDecimal;

public class CourseDTO {
    private String Course_ID;
    private String Course_Name;
    private Double Fee;
    private String Duration;

    public CourseDTO(String course_id) {
        this.Course_ID=course_id;
    }

    public CourseDTO(String course_ID, String course_Name, Double fee, String duration) {
        Course_ID = course_ID;
        Course_Name = course_Name;
        Fee = fee;
        Duration = duration;
    }

    public CourseDTO(Double fee) {
        this.Fee=fee;
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

    @Override
    public String toString() {
        return "Course{" +
                "Course_ID='" + Course_ID + '\'' +
                ", Course_Name='" + Course_Name + '\'' +
                ", Fee=" + Fee +
                ", Duration='" + Duration + '\'' +
                '}';
    }
}

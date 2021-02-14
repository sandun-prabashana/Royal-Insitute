package lk.royalInstitute.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;

@Entity
public class Student implements SuperEntity{
    @Id
    private String Student_ID;
    private String Student_Name;
    private String Address;
    private String Contact;
    private String DOB;
    private String Gender;

    public Student() {
    }

    public Student(String student_ID, String student_Name, String address, String contact, String DOB, String gender) {
        Student_ID = student_ID;
        Student_Name = student_Name;
        Address = address;
        Contact = contact;
        this.DOB = DOB;
        Gender = gender;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Student_ID='" + Student_ID + '\'' +
                ", Student_Name='" + Student_Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", DOB=" + DOB +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}

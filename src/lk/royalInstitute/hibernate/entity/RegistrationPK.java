package lk.royalInstitute.hibernate.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegistrationPK implements Serializable {
    private String Student_ID;
    private String Course_ID;

    public RegistrationPK() {
    }

    public RegistrationPK(String student_ID, String course_ID) {
        Student_ID = student_ID;
        Course_ID = course_ID;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationPK)) return false;
        RegistrationPK that = (RegistrationPK) o;
        return Objects.equals(getStudent_ID(), that.getStudent_ID()) &&
                Objects.equals(getCourse_ID(), that.getCourse_ID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudent_ID(), getCourse_ID());
    }
}

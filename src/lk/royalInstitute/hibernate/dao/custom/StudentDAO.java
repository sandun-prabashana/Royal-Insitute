package lk.royalInstitute.hibernate.dao.custom;


import lk.royalInstitute.hibernate.dao.SuperDAO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDAO<Student, String> {
    String getLastCustomerID();

    List<Student> findAll();

    List<Student> getAllStudent();
}

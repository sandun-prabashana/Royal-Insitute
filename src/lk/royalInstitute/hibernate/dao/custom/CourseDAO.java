package lk.royalInstitute.hibernate.dao.custom;


import lk.royalInstitute.hibernate.dao.SuperDAO;
import lk.royalInstitute.hibernate.entity.Course;

import java.util.List;

public interface CourseDAO extends SuperDAO<Course, String> {
    List<Course> getAllCourse();
}

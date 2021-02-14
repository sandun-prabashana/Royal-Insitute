package lk.royalInstitute.hibernate.bo.custom.impl;



import lk.royalInstitute.hibernate.bo.custom.CourseBO;
import lk.royalInstitute.hibernate.dao.DAOFactry;
import lk.royalInstitute.hibernate.dao.custom.CourseDAO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;


public class CourseBOImpl implements CourseBO {

    static CourseDAO courseDAO= (CourseDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.COURSE);


    @Override
    public boolean addCourse(CourseDTO course) throws Exception {
        return courseDAO.add(new Course(course.getCourse_ID(),
                course.getCourse_Name(),
                course.getFee(),course.getDuration()));
    }

    @Override
    public List<CourseDTO> getCourse() throws Exception {
        List<Course> all = courseDAO.getAll();
        List<CourseDTO> list = new ArrayList<>();
        for (Course c : all) {
            list.add(new CourseDTO(c.getCourse_ID(), c.getCourse_Name(),c.getFee(), c.getDuration()
                    ));
        }
        return list;
    }

    @Override
    public boolean deleteCourse(CourseDTO course) throws Exception {
        return courseDAO.delete(new Course(course.getCourse_ID(),
                course.getCourse_Name(),
                course.getFee(),course.getDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO course) throws Exception {
        return courseDAO.update(new Course(course.getCourse_ID(),
                course.getCourse_Name(),
                course.getFee(),course.getDuration()));
    }

    @Override
    public List<CourseDTO> getCourseCombobox() throws Exception {
        List<Course> all = courseDAO.getAllCourse();
        List<CourseDTO> list = new ArrayList<>();
        for (Course c : all) {
            list.add(new CourseDTO(c.getCourse_ID()));
        }
        return list;
    }

    @Override
    public CourseDTO searchFee(String couId) throws Exception {
        Course c = courseDAO.search(couId);
        return new CourseDTO(c.getFee());
    }


}

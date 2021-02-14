package lk.royalInstitute.hibernate.bo.custom;



import lk.royalInstitute.hibernate.bo.SuperBO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.CoustomDTO;

import java.util.List;


public interface CourseBO extends SuperBO {
    public boolean addCourse(CourseDTO course)throws Exception;


    List<CourseDTO> getCourse()throws Exception;


    boolean deleteCourse(CourseDTO course)throws Exception;

    boolean updateCourse(CourseDTO course)throws Exception;

    List<CourseDTO> getCourseCombobox()throws Exception;

    CourseDTO searchFee(String couId)throws Exception;
}

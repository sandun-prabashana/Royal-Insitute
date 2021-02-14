package lk.royalInstitute.hibernate.bo.custom;

import lk.royalInstitute.hibernate.bo.SuperBO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    boolean addStudent(StudentDTO student) throws Exception;

    boolean updateStudent(StudentDTO student)throws Exception;

    List<StudentDTO> getStudent()throws Exception;

    String newStudentID()throws Exception;

    boolean deleteStudent(StudentDTO student)throws Exception;

    public List<StudentDTO>  getAllStudent();

    public List<StudentDTO> getallstudent()throws Exception;

    List<StudentDTO> getStudentCombobox()throws Exception;
}

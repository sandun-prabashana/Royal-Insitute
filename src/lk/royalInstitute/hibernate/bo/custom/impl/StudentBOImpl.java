package lk.royalInstitute.hibernate.bo.custom.impl;

import lk.royalInstitute.hibernate.bo.custom.StudentBO;
import lk.royalInstitute.hibernate.dao.DAOFactry;
import lk.royalInstitute.hibernate.dao.custom.StudentDAO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.Student;
import lk.royalInstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    static StudentDAO studentDAO= (StudentDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.STUDENT);

    @Override
    public boolean addStudent(StudentDTO student) throws Exception {
        return studentDAO.add(new Student(student.getStudent_ID(),student.getStudent_Name(),student.getAddress(),student.getContact(),
                student.getDOB(),student.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws Exception {
        return studentDAO.update(new Student(student.getStudent_ID(),student.getStudent_Name(),student.getAddress(),student.getContact(),
                student.getDOB(),student.getGender()));
    }

    @Override
    public List<StudentDTO> getStudent() throws Exception {
        List<Student> all = studentDAO.getAll();
        List<StudentDTO> list = new ArrayList<>();
        for (Student s : all) {
            list.add(new StudentDTO(s.getStudent_ID(),s.getStudent_Name(),s.getAddress(),s.getContact(),
                    s.getDOB(),s.getGender()));
        }
        return list;
    }

    @Override
    public String newStudentID() throws Exception {
        String lastID = studentDAO.getLastCustomerID();

//        int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;
//
//         if(newID < 10){
//            return "S00"+newID;
//        }else if(newID < 100){
//            return "S0"+newID;
//        }else{
//            return "S"+newID;
//        }
        return lastID;
    }

    @Override
    public boolean deleteStudent(StudentDTO student) throws Exception {
        return studentDAO.delete(new Student(student.getStudent_ID(),student.getStudent_Name(),student.getAddress(),student.getContact(),
                student.getDOB(),student.getGender()));
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        return null;
    }

    @Override
    public List<StudentDTO> getallstudent() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();
        studentDAO.setSession(session);
        Transaction tx = null;
        List<Student> all;
        try{
            tx = session.beginTransaction();
            all= studentDAO.findAll();
            tx.commit();
        }catch (Throwable t){
            tx.rollback();
            throw t;
        }finally {
            session.close();
        }

        List<StudentDTO> list = new ArrayList<>();
        for (Student s : all) {
            list.add(new StudentDTO(s.getStudent_ID(),s.getStudent_Name(),s.getAddress(),s.getContact(),
                    s.getDOB(),s.getGender()));
        }
        return list;
    }

    @Override
    public List<StudentDTO> getStudentCombobox() throws Exception {
        List<Student> all = studentDAO.getAllStudent();
        List<StudentDTO> list = new ArrayList<>();
        for (Student s : all) {
            list.add(new StudentDTO(s.getStudent_ID()));
        }
        return list;
    }
}

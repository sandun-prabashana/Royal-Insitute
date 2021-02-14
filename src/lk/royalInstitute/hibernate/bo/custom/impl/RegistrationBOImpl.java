package lk.royalInstitute.hibernate.bo.custom.impl;

import lk.royalInstitute.hibernate.bo.custom.RegistrationBO;
import lk.royalInstitute.hibernate.bo.custom.StudentBO;
import lk.royalInstitute.hibernate.dao.DAOFactry;
import lk.royalInstitute.hibernate.dao.custom.CourseDAO;
import lk.royalInstitute.hibernate.dao.custom.RegistrationDAO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.RegistrationDTO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.CoustomEntity;
import lk.royalInstitute.hibernate.entity.Registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    static RegistrationDAO registrationDAO= (RegistrationDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.REGISTRATION);

    @Override
    public boolean add(RegistrationDTO registration) throws Exception {
        return registrationDAO.add(new Registration(registration.getReg_No(),registration.getReg_Date()
        ,registration.getReg_Fee(),registration.getStudent_ID(),registration.getCourse_ID()));
    }

    @Override
    public void placeRegistration(List<RegistrationDTO> registationLIst) throws Exception {
        for (RegistrationDTO r : registationLIst) {
            registrationDAO.add(new Registration(r.getReg_No(),r.getReg_Date(),r.getReg_Fee(),r.getStudent_ID(),r.getCourse_ID()));
        }
    }

    @Override
    public String newRegID() throws Exception {
        String lastID = registrationDAO.getLastCustomerID();

        int newID = Integer.parseInt(lastID.substring(0,1)) + 1;

        return String.valueOf(newID);
    }

    @Override
    public RegistrationDTO searchRegNo(String stuId) throws Exception {
        Registration r = registrationDAO.searchRegNo(stuId);
        return new RegistrationDTO(r.getReg_No());
    }

    @Override
    public String newRegNo(String stuId) throws Exception {
        String lastID = registrationDAO.getLastReg(stuId);

        int newID = Integer.parseInt(lastID);

        return String.valueOf(newID);
    }

    @Override
    public List<RegistrationDTO> getReg(String id) throws Exception {
        List<CoustomEntity> all = registrationDAO.getAllREG(id);
        List<RegistrationDTO> list = new ArrayList<>();
        for (CoustomEntity c : all) {
            list.add(new RegistrationDTO(c.getCourse_ID(),c.getStudent_ID(),c.getReg_No(),c.getReg_Date(),c.getReg_Fee()));
        }
        return list;
    }
}

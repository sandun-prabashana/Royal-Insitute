package lk.royalInstitute.hibernate.dao.custom;

import lk.royalInstitute.hibernate.dao.SuperDAO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.CoustomEntity;
import lk.royalInstitute.hibernate.entity.Registration;

import java.util.List;

public interface RegistrationDAO extends SuperDAO<Registration, Integer> {
    String getLastCustomerID();

    Registration searchRegNo(String stuId);

    String getLastReg(String stuId);

    List<CoustomEntity> getAllREG(String id);
}

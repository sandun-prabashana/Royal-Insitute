package lk.royalInstitute.hibernate.dao.custom.impl;

import lk.royalInstitute.hibernate.dao.custom.RegistrationDAO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.CoustomEntity;
import lk.royalInstitute.hibernate.entity.Registration;
import lk.royalInstitute.hibernate.entity.SuperEntity;
import lk.royalInstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean add(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(Registration entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return false;
    }

    @Override
    public Registration search(Integer integer) throws Exception {
        return null;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        return null;
    }

    @Override
    public String getLastCustomerID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select Reg_No from Registration order by Reg_No desc limit 1");
        String id = String.valueOf((Integer) sqlQuery.uniqueResult());
        transaction.commit();

        session.close();
        return id;
    }

    @Override
    public Registration searchRegNo(String stuId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select r.Reg_No from Registration r,Student s WHERE s.Student_ID =?1");
        query.setParameter(1, stuId);
        Registration registration = (Registration) query.uniqueResult();
        transaction.commit();
        session.close();
        return registration;
    }

    @Override
    public String getLastReg(String stuId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select Reg_No from Registration where Student_ID = ?1 limit 1");
        sqlQuery.setParameter(1, stuId);
        String id = String.valueOf((Integer) sqlQuery.uniqueResult());
        transaction.commit();

        session.close();
        return id;
    }

    @Override
    public List<CoustomEntity> getAllREG(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select * from Registration where Course_ID = ?1 ");
        sqlQuery.setParameter(1, id);
        List<CoustomEntity> list = sqlQuery.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean deleteReg(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(session.get(Registration.class, id));

        transaction.commit();

        session.close();
        return true;
    }

}

package lk.royalInstitute.hibernate.dao.custom.impl;

import lk.royalInstitute.hibernate.dao.custom.CourseDAO;
import lk.royalInstitute.hibernate.dao.custom.CourseDAO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.Student;
import lk.royalInstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private Class<Course> entity;

    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean add(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();

        session.close();
        return true;
    }


    @Override
    public boolean update(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public Course search(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course WHERE Course_ID = ?1");
        query.setParameter(1, s);
        Course customer = (Course) query.uniqueResult();
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public List<Course> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course");
        List<Course> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<Course> getAllCourse() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course");
        List<Course> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}

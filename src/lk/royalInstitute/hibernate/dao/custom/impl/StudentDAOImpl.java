package lk.royalInstitute.hibernate.dao.custom.impl;

import lk.royalInstitute.hibernate.dao.custom.StudentDAO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.Student;
import lk.royalInstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    protected Session session;
    private Class<Student> entity;
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Student> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Student ");
        List<Student> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getLastCustomerID() {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select Student_ID from Student order by Student_ID desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        transaction.commit();

        session.close();
        return id;
    }

    @Override
    public List<Student> findAll() {
        return session.createQuery("select s.Student_ID from Student s").list();
    }

    @Override
    public List<Student> getAllStudent() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Student");
        List<Student> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

}

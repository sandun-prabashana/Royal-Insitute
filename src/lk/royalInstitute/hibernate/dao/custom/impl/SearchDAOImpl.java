package lk.royalInstitute.hibernate.dao.custom.impl;

import lk.royalInstitute.hibernate.dao.custom.SearchDAO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.CoustomEntity;
import lk.royalInstitute.hibernate.entity.Student;
import lk.royalInstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class SearchDAOImpl implements SearchDAO {
    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean add(CoustomEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(CoustomEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(CoustomEntity entity) throws Exception {
        return false;
    }

    @Override
    public CoustomEntity search(String s) throws Exception {
        return null;
    }

    @Override
    public List<CoustomEntity> getAll() throws Exception {
        return null;
    }

}

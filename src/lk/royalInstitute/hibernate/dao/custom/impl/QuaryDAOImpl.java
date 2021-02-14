package lk.royalInstitute.hibernate.dao.custom.impl;

import lk.royalInstitute.hibernate.dao.custom.QuaryDAO;
import lk.royalInstitute.hibernate.entity.CoustomEntity;
import lk.royalInstitute.hibernate.entity.Student;
import lk.royalInstitute.hibernate.entity.SuperEntity;
import lk.royalInstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuaryDAOImpl implements QuaryDAO {
    @Override
    public List<CoustomEntity> getDeatil(String stuId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT s.Student_ID,s.Student_Name,c.Course_ID,c.Course_Name,r.Reg_No,r.Reg_Date,r.Reg_Fee FROM Registration r " +
                "INNER JOIN r.student s INNER JOIN r.course c WHERE s.Student_ID = ?1");
        query.setParameter(1, stuId);
        List<Object[]> list = query.list();
        List<CoustomEntity> all = new ArrayList<>();
        for (Object[] objects : list) {
            all.add(new CoustomEntity(objects[0].toString(), objects[1].toString(), objects[2].toString(), objects[3].toString(), Integer.parseInt(objects[4].toString()),
                    objects[5].toString(), Double.parseDouble(objects[6].toString())));
        };
//        session.delete(session.get(Student.class, "S001"));
        transaction.commit();
        session.close();
        return all;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean add(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public SuperEntity search(Serializable serializable) throws Exception {
        return null;
    }

    @Override
    public List getAll() throws Exception {
        return null;
    }
}

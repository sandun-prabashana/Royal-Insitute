package lk.royalInstitute.hibernate.util;

import lk.royalInstitute.hibernate.entity.Registration;
import lk.royalInstitute.hibernate.entity.RegistrationPK;
import lk.royalInstitute.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import lk.royalInstitute.hibernate.entity.Course;


public class FactoryConfiguration {
    private static lk.royalInstitute.hibernate.util.FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Registration.class)
                .addAnnotatedClass(RegistrationPK.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static lk.royalInstitute.hibernate.util.FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new lk.royalInstitute.hibernate.util.FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}

package lk.royalInstitute.hibernate.dao;

import lk.royalInstitute.hibernate.dao.custom.impl.*;

public class DAOFactry {
    private static DAOFactry daoFactry;

    private DAOFactry(){}

    public static DAOFactry getInstance(){
        if(daoFactry==null){
            daoFactry=new DAOFactry();
        }
        return daoFactry;
    }

    public enum DAOType{
        COURSE,STUDENT,REGISTRATION,SEARCH,QUEARY
    }

    public SuperDAO getDAO (DAOType daoType){
        switch (daoType){
            case COURSE:
                return new CourseDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case SEARCH:
                return new SearchDAOImpl();
            case QUEARY:
                return new QuaryDAOImpl();
            default:
                return null;
        }
    }
}

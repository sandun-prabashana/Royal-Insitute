package lk.royalInstitute.hibernate.bo;


import lk.royalInstitute.hibernate.bo.custom.impl.CourseBOImpl;
import lk.royalInstitute.hibernate.bo.custom.impl.RegistrationBOImpl;
import lk.royalInstitute.hibernate.bo.custom.impl.SearchBOImpl;
import lk.royalInstitute.hibernate.bo.custom.impl.StudentBOImpl;

public class BOFactry {

    private static BOFactry boFactry;

    private BOFactry(){

    }

    public static BOFactry getInstance(){
        if(boFactry==null){
            boFactry=new BOFactry();
        }
        return boFactry;
    }

    public enum BOTypes{
        COURSE,STUDENT,REGISTRATION,SEARCH
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case COURSE:
                return new CourseBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            case SEARCH:
                return new SearchBOImpl();
            default:
                return null;
        }
    }
}

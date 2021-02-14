package lk.royalInstitute.hibernate.bo.custom;

import lk.royalInstitute.hibernate.bo.SuperBO;
import lk.royalInstitute.hibernate.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    boolean add(RegistrationDTO registrationDTO) throws Exception;

    void placeRegistration(List<RegistrationDTO> registationLIst)throws Exception;

    String newRegID()throws Exception;

    RegistrationDTO searchRegNo(String stuId)throws Exception;

    String newRegNo(String stuId)throws Exception;

    List<RegistrationDTO> getReg(String id)throws Exception;
}

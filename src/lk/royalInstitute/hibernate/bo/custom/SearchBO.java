package lk.royalInstitute.hibernate.bo.custom;

import lk.royalInstitute.hibernate.bo.SuperBO;
import lk.royalInstitute.hibernate.dto.CoustomDTO;

import java.util.List;

public interface SearchBO extends SuperBO {
    List<CoustomDTO> getDeatil(String stuId)throws Exception;
}

package lk.royalInstitute.hibernate.dao.custom;

import lk.royalInstitute.hibernate.dao.SuperDAO;
import lk.royalInstitute.hibernate.entity.CoustomEntity;

import java.util.List;

public interface QuaryDAO extends SuperDAO {
    List<CoustomEntity> getDeatil(String stuId);
}

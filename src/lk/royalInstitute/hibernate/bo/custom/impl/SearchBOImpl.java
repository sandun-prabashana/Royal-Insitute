package lk.royalInstitute.hibernate.bo.custom.impl;

import lk.royalInstitute.hibernate.bo.custom.SearchBO;
import lk.royalInstitute.hibernate.dao.DAOFactry;
import lk.royalInstitute.hibernate.dao.custom.CourseDAO;
import lk.royalInstitute.hibernate.dao.custom.QuaryDAO;
import lk.royalInstitute.hibernate.dao.custom.SearchDAO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.CoustomDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;
import lk.royalInstitute.hibernate.entity.Course;
import lk.royalInstitute.hibernate.entity.CoustomEntity;
import lk.royalInstitute.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class SearchBOImpl implements SearchBO {
    static SearchDAO searchDAO= (SearchDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.SEARCH);
    static QuaryDAO quaryDAO= (QuaryDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.QUEARY);
    @Override

    public List<CoustomDTO> getDeatil(String stuId) throws Exception {
        List<CoustomEntity> all = quaryDAO.getDeatil(stuId);
        List<CoustomDTO> list = new ArrayList<>();
        for (CoustomEntity s : all) {
            list.add(new CoustomDTO(s.getStudent_ID(),s.getStudent_Name(),s.getCourse_ID(),
                    s.getCourse_Name(),s.getReg_No(),s.getReg_Date(),s.getReg_Fee()));
        }
        return list;
    }
}

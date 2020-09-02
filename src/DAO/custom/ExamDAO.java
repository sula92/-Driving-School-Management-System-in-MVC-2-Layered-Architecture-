package DAO.custom;

import DAO.CrudDAO;
import entity.Exam;

public interface ExamDAO extends CrudDAO<Exam, String> {

    public String getStatusCount(String exid,String status) throws Exception;

    public String getLastExamID() throws Exception;


}

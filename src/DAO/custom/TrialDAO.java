package DAO.custom;

import DAO.CrudDAO;
import entity.Exam;
import entity.Trial;

public interface TrialDAO extends CrudDAO<Trial, String> {

    public String getStatusCount(String tid,String status) throws Exception;

}

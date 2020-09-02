package DAO.custom;

import DAO.CrudDAO;
import DAO.SuperDAO;
import entity.Student;

public interface StudentDAO extends CrudDAO<Student, String> {

    public String getLastStudentID() throws Exception;

}

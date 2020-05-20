package DAO.custom;

import entity.CustomEmployeeEntity;
import entity.CustomExamEntity;
import entity.CustomStudentEntity;
import entity.CustomTrialEntity;

public interface QueryDAO {

    public abstract CustomExamEntity getExamInfo(int ExamId) throws Exception;

    public abstract CustomTrialEntity getTrialInfo(int TrialId) throws Exception;

    public abstract CustomEmployeeEntity getEmployeeInfo(int empId) throws Exception;

    public abstract CustomStudentEntity getStudentInfo(int stdId) throws Exception;


}

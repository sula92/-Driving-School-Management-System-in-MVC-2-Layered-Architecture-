package DAO;

import DAO.custom.EmployeeDAO;
import DAO.custom.impl.*;
import entity.Person;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DAOFactory()) : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case EXAM:
                return (T) new ExamDAOImpl();
            case BRANCH:
                return (T) new BranchDAOImpl();
            case LECTURE:
                return (T) new LectureDAOImpl();
            case TRIAL:
                return (T) new TrialDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case PERSON:
                return (T) new PersonDAOImpl();
            case PERSON_CONTACT:
                return (T) new Person_ContactDAOImpl();

            default:
                return null;
        }
    }


}

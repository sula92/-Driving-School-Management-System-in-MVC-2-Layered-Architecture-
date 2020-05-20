package business;

import business.custom.TrialBO;
import business.custom.impl.*;
import entity.Employee;
import entity.Student;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null)? (boFactory = new BOFactory()): boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case EXAM:
                return (T) new ExamBOImpl();

            case BRANCH:
                return (T) new BranchBOImpl();

            case LECTURE:
                return (T) new LectureBOImpl();
            case TRIAL:
                return (T) new TrialBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();



            default:
                return null;
        }
    }


}

package business.custom.impl;

import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.EmployeeDAO;
import DAO.custom.PersonDAO;
import DAO.custom.Person_ContactDAO;
import business.custom.EmployeeBO;
import dto.EmployeeDTO;
import entity.Employee;
import entity.Person;
import entity.Person_Contact;

import java.util.ArrayList;
import java.util.List;



public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO= DAOFactory.getInstance().getDAO(DAOTypes.EMPLOYEE);
    private PersonDAO personDAO=DAOFactory.getInstance().getDAO(DAOTypes.PERSON);
    private Person_ContactDAO person_contactDAO=DAOFactory.getInstance().getDAO(DAOTypes.PERSON_CONTACT);

    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception {
        System.out.println("BO_"+employeeDTO.toString());


            boolean x = personDAO.save(new Person(employeeDTO.getNic(), "002", employeeDTO.getNm(), employeeDTO.getDob(), employeeDTO.getAge(), employeeDTO.getGender()));



           if (x) {
               System.out.println(x);
                    boolean y=employeeDAO.save(new Employee(employeeDTO.getEmployeeId(), employeeDTO.getNic(), employeeDTO.getPos(), employeeDTO.getMonthly_sal(), employeeDTO.getBranch(), employeeDTO.getDorec().toString(), employeeDTO.getGrade()));

                if (y) {

                    boolean z = person_contactDAO.save(new Person_Contact(employeeDTO.getNic(), "002", employeeDTO.getAddress(), employeeDTO.getMobile(), employeeDTO.getPhone(), employeeDTO.getEmail()));

                    System.out.println(y);
                    System.out.println(z);
                }

           }
          return x;
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) throws Exception {
        return false;
    }

    @Override
    public boolean deleteEmployee(String EmpId) throws Exception {
        return false;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() throws Exception {
        return null;
    }

    @Override
    public String getLastEmployeeID() throws Exception {
        return null;
    }

    @Override
    public EmployeeDTO findEmployee(String EmpId) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllEmployeeIDs() throws Exception {
       return null;
    }
}

package business.custom;

import business.SuperBO;
import dto.EmployeeDTO;

import java.util.List;

public interface EmployeeBO extends SuperBO {

    boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception;

    boolean updateEmployee(EmployeeDTO employee) throws Exception;

    boolean deleteEmployee(String EmpId) throws Exception;

    List<EmployeeDTO> findAllEmployees() throws Exception;

    String getLastEmployeeID() throws Exception;

    EmployeeDTO findEmployee(String EmpId) throws Exception;

    List<String> getAllEmployeeIDs() throws Exception;



}

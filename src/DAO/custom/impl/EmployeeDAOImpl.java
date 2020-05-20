package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.EmployeeDAO;
import entity.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() throws Exception {
        return null;
    }

    @Override
    public Employee find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Employee employee) throws Exception {
        System.out.println(employee.toString());
        return CrudUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?,?)", employee.getEmp_ID(), employee.getNIC(), employee.getPosition(), employee.getMonthly_Sal(),employee.getBranch(),employee.getDate_of_Recruited(),employee.getGrade());
    }

    @Override
    public boolean update(Employee entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}

package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.PersonDAO;
import entity.Person;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public List<Person> findAll() throws Exception {
        return null;
    }

    @Override
    public Person find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Person emp) throws Exception {
        return false;//CrudUtil.execute("INSERT INTO person VALUES (?,?,?,?,?,?)", emp.getNIC(),emp.getType_ID(), emp.getName(), emp.getDOB(), emp.getAge(),emp.getGender());
    }

    @Override
    public boolean update(Person entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}

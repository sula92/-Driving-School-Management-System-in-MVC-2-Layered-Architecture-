package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.PersonDAO;
import DAO.custom.Person_ContactDAO;
import entity.Person;
import entity.Person_Contact;

import java.util.List;

public class Person_ContactDAOImpl implements Person_ContactDAO {

    @Override
    public List<Person_Contact> findAll() throws Exception {
        return null;
    }

    @Override
    public Person_Contact find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Person_Contact person_contact) throws Exception {
        return CrudUtil.execute("INSERT INTO Person_Contact VALUES (?,?,?,?,?,?)", person_contact.getNIC(), person_contact.getType_ID(), person_contact.getAddress(), person_contact.getMobile(),person_contact.getPhone(),person_contact.getEmail());
    }

    @Override
    public boolean update(Person_Contact entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}

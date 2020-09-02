package DAO.custom;

import DAO.CrudDAO;
import entity.Branch;

public interface BranchDAO extends CrudDAO<Branch, String> {


    String getLastBranchId();
}

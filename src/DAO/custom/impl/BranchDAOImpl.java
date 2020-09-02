package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.BranchDAO;
import entity.Branch;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BranchDAOImpl implements BranchDAO {
    @Override
    public List<Branch> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM branch");
        List<Branch> branches = new ArrayList<>();
        while (rst.next()) {

            branches.add(new Branch(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getString(6).toString()));

        }
        return branches;
    }

    @Override
    public Branch find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Branch branch) throws Exception {

        LocalDate DOE= LocalDate.parse(branch.getEstablished_Date());
        return CrudUtil.execute("INSERT INTO branch VALUES (?,?,?,?,?,?)", branch.getBranch_ID(), branch.getBranch_Name(), branch.getAddress(), branch.getContact_Number(),branch.getEmail(),DOE);
    }

    @Override
    public boolean update(Branch branch) throws Exception {
        return CrudUtil.execute("update branch set branch_name=?, address=?, contact_number, email, established_date=? where branch_id=?",branch.getBranch_Name(),branch.getAddress(),branch.getContact_Number(),branch.getEmail(),branch.getEstablished_Date(),branch.getBranch_ID());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from branch where branch_id=?",s);
    }


    @Override
    public String getLastBranchId() {
        try {
            ResultSet r= CrudUtil.execute("select Branch_ID from branch");
            r.last();
            return r.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

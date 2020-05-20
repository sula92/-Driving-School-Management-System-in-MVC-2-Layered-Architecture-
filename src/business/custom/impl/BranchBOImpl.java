package business.custom.impl;

import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.BranchDAO;
import business.custom.BranchBO;
import business.exception.AlreadyExistsInOrderException;
import dto.BranchDTO;
import entity.Branch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class BranchBOImpl implements BranchBO {

    private BranchDAO branchDAO = DAOFactory.getInstance().getDAO(DAOTypes.BRANCH);


    @Override
    public boolean saveBranch(BranchDTO branchDTO) throws Exception {

        System.out.println(branchDTO);
        return branchDAO.save(new Branch(branchDTO.getBranchId(),
                branchDTO.getBranchNm(), branchDTO.getBranchAdd(), branchDTO.getContact(),branchDTO.getEmail(),branchDTO.getDOE()));
    }

    @Override
    public boolean updateBranch(BranchDTO branchDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteBranch(String brachId) throws Exception {

        return false;
    }

    @Override
    public List<BranchDTO> findAllBranch() throws Exception {
        List<Branch> allBranches = branchDAO.findAll();
        List<BranchDTO> dtos = new ArrayList<>();
        for (Branch branch : allBranches) {
            dtos.add(new BranchDTO(branch.getBranch_ID(),branch.getBranch_Name(),branch.getAddress(),branch.getContact_Number(),branch.getEmail(),branch.getEstablished_Date().toString()));
        }
        return dtos;
    }

    @Override
    public String getLastBranchId() throws Exception {
        return null;
    }

    @Override
    public BranchDTO findBranch(String branchId) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllbranchId() throws Exception {
        return null;
    }
}

package business.custom;

import business.SuperBO;
import dto.BranchDTO;
import entity.Branch;

import java.util.List;

public interface BranchBO extends SuperBO {

    boolean saveBranch(BranchDTO branchDTO) throws Exception;

    boolean updateBranch(BranchDTO branchDTO) throws Exception;

    boolean deleteBranch(String brachId) throws Exception;

    List<BranchDTO> findAllBranch() throws Exception;

    String getLastBranchId() throws Exception;

    BranchDTO findBranch(String branchId) throws Exception;

    List<String> getAllbranchId() throws Exception;

}

package business.custom;

import business.SuperBO;
import dto.ExamDTO;
import dto.TrialDTO;
import entity.Trial;

import java.util.List;

public interface TrialBO extends SuperBO {

    boolean saveTrial(TrialDTO trialDTO) throws Exception;

    boolean updateTrial(TrialDTO trial) throws Exception;

    boolean deleteTrial(String id) throws Exception;

    List<TrialDTO> findAllTrials() throws Exception;

    String getLastTrialid() throws Exception;

    ExamDTO findTrial(String itemCode) throws Exception;

    List<String> getAllTrialids() throws Exception;

    public String getStatusCount(String x,String y) throws Exception;

}

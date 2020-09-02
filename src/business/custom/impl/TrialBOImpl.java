package business.custom.impl;

import DAO.CrudUtil;
import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.TrialDAO;
import business.custom.TrialBO;
import dto.ExamDTO;
import dto.TrialDTO;
import entity.Trial;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class TrialBOImpl implements TrialBO {

    private TrialDAO trialDAO= DAOFactory.getInstance().getDAO(DAOTypes.TRIAL);

    @Override
    public boolean saveTrial(TrialDTO trialDTO) throws Exception {
        return trialDAO.save(new Trial(trialDTO.getTrial_id(),
                trialDTO.getDate(), trialDTO.getTime(), trialDTO.getVenue()));
    }

    @Override
    public boolean updateTrial(TrialDTO trial) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTrial(String id) throws Exception {
        return false;
    }

    @Override
    public List<TrialDTO> findAllTrials() throws Exception {
        List<Trial> allTrials = trialDAO.findAll();
        List<TrialDTO> dtos = new ArrayList<>();
        for (Trial trial : allTrials) {
            dtos.add(new TrialDTO(trial.getTrial_ID(),trial.getDate(),trial.getTime(),trial.getVenue()));
        }
        return dtos;
    }

    @Override
    public String getLastTrialid() throws Exception {
        ResultSet r=CrudUtil.execute("select Trial_ID from trial");
        r.last();
        return r.getString(1);

    }

    @Override
    public ExamDTO findTrial(String itemCode) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllTrialids() throws Exception {
        return null;
    }

    public String getStatusCount(String tid,String status) throws Exception {

        System.out.println(tid);

        String count=trialDAO.getStatusCount(tid,status);

        System.out.println(count);

        return count;

    }
}

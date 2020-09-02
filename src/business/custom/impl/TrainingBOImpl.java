package business.custom.impl;

import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.TrainingDAO;
import business.custom.TrainingBO;
import business.custom.TrialBO;
import dto.ExamDTO;
import dto.TrainingDTO;
import dto.TrialDTO;
import entity.Training;

import java.util.ArrayList;
import java.util.List;


public class TrainingBOImpl implements TrainingBO {

    TrainingDAO trainingDAO= DAOFactory.getInstance().getDAO(DAOTypes.TRAINING);

    @Override
    public boolean saveStudent(TrainingDTO trainingDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(TrainingDTO trainingDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public List<TrainingDTO> findAllTrainings() throws Exception {
        List<Training> trainings= trainingDAO.findAll();
        ArrayList<TrainingDTO> trainingDTOS=new ArrayList<>();
        trainings.stream().forEach(training -> {
            trainingDTOS.add(new TrainingDTO(training.getTraining_ID(),training.getDate(),training.getTime(),training.getVenue()));
        });

        return trainingDTOS;
    }

    @Override
    public String getLastTrainingID() throws Exception {
        return null;
    }

    @Override
    public TrainingDTO findTraining(String id) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllTrainingIds() throws Exception {
        return null;
    }
}

package business.custom;

import business.SuperBO;
import dto.TrainingDTO;

import java.util.List;

public interface TrainingBO extends SuperBO {

    boolean saveStudent(TrainingDTO trainingDTO) throws Exception;

    boolean updateStudent(TrainingDTO trainingDTO) throws Exception;

    boolean deleteStudent(String id) throws Exception;

    List<TrainingDTO> findAllTrainings() throws Exception;

    String getLastTrainingID() throws Exception;

    TrainingDTO findTraining(String id) throws Exception;

    List<String> getAllTrainingIds() throws Exception;

}

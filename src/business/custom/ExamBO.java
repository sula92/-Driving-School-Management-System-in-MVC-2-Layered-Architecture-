package business.custom;

import business.SuperBO;
import dto.ExamDTO;

import java.util.List;

public interface ExamBO extends SuperBO {

    boolean saveExam(ExamDTO examDTO) throws Exception;

    boolean updateExam(ExamDTO item) throws Exception;

    boolean deleteExam(String itemCode) throws Exception;

    List<ExamDTO> findAllExams() throws Exception;

    String getLastExamID() throws Exception;

    ExamDTO findItem(String itemCode) throws Exception;

    List<String> getAllItemCodes() throws Exception;

    public String getStatusCount(String x,String y) throws Exception;


}

package business.custom.impl;

import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.ExamDAO;
import business.custom.ExamBO;
import dto.ExamDTO;
import entity.Exam;

import java.util.ArrayList;
import java.util.List;

public class ExamBOImpl implements ExamBO {


    private ExamDAO examDAO = DAOFactory.getInstance().getDAO(DAOTypes.EXAM);

    @Override
    public boolean saveExam(ExamDTO examDTO) throws Exception {
        return examDAO.save(new Exam(examDTO.getExam_ID(),
                examDTO.getDate().toString(), examDTO.getTime().toString(), examDTO.getVenue()));
    }



    @Override
    public boolean updateItem(ExamDTO item) throws Exception {
        return false;
    }

    @Override
    public boolean deleteExam(String itemCode) throws Exception {
        return false;
    }

    @Override
    public List<ExamDTO> findAllExams() throws Exception {
        List<Exam> allExams = examDAO.findAll();
        List<ExamDTO> dtos = new ArrayList<>();
        for (Exam exam : allExams) {
            dtos.add(new ExamDTO(   exam.getExam_ID(),exam.getDate(),exam.getTime(),exam.getVenue()));
        }
        return dtos;
    }


    @Override
    public String getLastItemCode() throws Exception {
        return null;
    }

    @Override
    public ExamDTO findItem(String itemCode) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllItemCodes() throws Exception {
        return null;
    }

    public String getStatusCount(String exid,String status) throws Exception {

       String count=examDAO.getStatusCount(exid,status);

        return count;

    }

}

package business.custom.impl;

import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.LectureDAO;
import business.custom.LectureBO;
import dto.LectureDTO;
import entity.Lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectureBOImpl implements LectureBO {

    private LectureDAO lectureDAO = DAOFactory.getInstance().getDAO(DAOTypes.LECTURE);


    @Override
    public boolean saveLecture(LectureDTO lectureDTO) throws Exception {
        return lectureDAO.save(new Lecture(lectureDTO.getLecture_id(),
                lectureDTO.getLecture_name(), lectureDTO.getDate(), lectureDTO.getTime(),lectureDTO.getVenue()));
    }

    @Override
    public boolean updateLectures(LectureDTO lecture) throws Exception {
        return false;
    }

    @Override
    public boolean deleteLectures(String lectureid) throws Exception {
        return lectureDAO.delete(lectureid);
    }

    @Override
    public List<LectureDTO> findAllLectures() throws Exception {
        List<Lecture> allLectures = lectureDAO.findAll();
        List<LectureDTO> dtos = new ArrayList<>();
        for (Lecture lecture : allLectures) {
            dtos.add(new LectureDTO(
                    lecture.getLecture_ID(),
                    lecture.getLecture_Name(),
                    lecture.getDate(),
                    lecture.getTime(),
                    lecture.getVenue()
            ));
        }
        System.out.println("BOArr"+ Arrays.toString(new List[]{dtos}));
        return dtos;
    }

    @Override
    public String getLastLecturesId() throws Exception {
        return null;
    }

    @Override
    public LectureBO findLectures(String itemCode) throws Exception {
        return null;
    }

    @Override
    public List<String> getAllLecturesId() throws Exception {
        return null;
    }
}

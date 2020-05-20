package business.custom;

import business.SuperBO;
import dto.LectureDTO;

import java.util.List;

public interface LectureBO extends SuperBO {

    boolean saveLecture(LectureDTO lectureDTO) throws Exception;

    boolean updateLectures(LectureDTO lecture) throws Exception;

    boolean deleteLectures(String lectureid) throws Exception;

    List<LectureDTO> findAllLectures() throws Exception;

    String getLastLecturesId() throws Exception;

    LectureBO findLectures(String itemCode) throws Exception;

    List<String> getAllLecturesId() throws Exception;



}

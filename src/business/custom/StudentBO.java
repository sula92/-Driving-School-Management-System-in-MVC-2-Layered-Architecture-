package business.custom;

import business.SuperBO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {

    boolean saveStudent(StudentDTO studentDTO) throws Exception;

    boolean updateStudent(StudentDTO studentDTO) throws Exception;

    boolean deleteStudent(String id) throws Exception;

    List<StudentDTO> findAllStudents() throws Exception;

    String getLastStudentID() throws Exception;

    StudentDTO findStudent(String itemCode) throws Exception;

    List<String> getAllStudentIds() throws Exception;


}

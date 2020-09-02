package business.custom.impl;

import DAO.DAOFactory;
import DAO.DAOTypes;
import DAO.custom.StudentDAO;
import business.custom.StudentBO;
import dto.StudentDTO;
import entity.Person;
import entity.Person_Contact;
import entity.Student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO= DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO s) throws Exception {
        Date date= (Date) s.getDateOfJoined();
        return studentDAO.update(new Student(s.getStdId(), s.getNic(), s.getBranchId(), s.getCourseId(), date, s.getExamId(), s.getTrialId(), s.getTrainingId(), s.getLecId()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> findAllStudents() throws Exception {
        ArrayList<StudentDTO> studentDTOS=new ArrayList<>();
        List<Student> students=studentDAO.findAll();
        students.stream().forEach(student -> {
            Person_Contact person_contact=new Person_Contact(student.getPerson_contact().getNIC(),student.getPerson_contact().getAddress(),student.getPerson_contact().getMobile(),student.getPerson_contact().getPhone(),student.getPerson_contact().getEmail());
            StudentDTO studentDTO=new StudentDTO(student.getNic(),student.getName(),student.getDOB(),student.getAge(),student.getGender(),person_contact,student.getStdId(),student.getNic(),student.getBranchId(),student.getCourseId(),student.getDateOfJoined(),student.getExamId(),student.getTrialId(),student.getTrainingId(),student.getLecId());

            studentDTOS.add(studentDTO);
        });
        return studentDTOS;
    }

    @Override
    public String getLastStudentID() throws Exception {
        return studentDAO.getLastStudentID();
    }

    @Override
    public StudentDTO findStudent(String id) throws Exception {
        Student student=studentDAO.find(id);
        Person_Contact person_contact=new Person_Contact(student.getPerson_contact().getNIC(),student.getPerson_contact().getAddress(),student.getPerson_contact().getMobile(),student.getPerson_contact().getPhone(),student.getPerson_contact().getEmail());
        StudentDTO studentDTO=new StudentDTO(student.getNic(),student.getName(),student.getDOB(),student.getAge(),student.getGender(),person_contact,student.getStdId(),student.getNic(),student.getBranchId(),student.getCourseId(),student.getDateOfJoined(),student.getExamId(),student.getTrialId(),student.getTrainingId(),student.getLecId());
        return studentDTO;
    }

    @Override
    public List<String> getAllStudentIds() throws Exception {
        return null;
    }
}

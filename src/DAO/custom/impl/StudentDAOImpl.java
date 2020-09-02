package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.StudentDAO;
import entity.Person_Contact;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> findAll() throws Exception {
        ArrayList<Student> students=new ArrayList<>();
        ResultSet rs=CrudUtil.execute("select * from student s inner join person p on s.NIC=p.NIC inner join person_contact pc on p.NIC=pc.NIC");
        while (rs.next()){
            Person_Contact person_contact=new Person_Contact(rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19));
           Student student=new Student(rs.getString(2),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),person_contact,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
           students.add(student);
        }
        return students;
    }

    @Override
    public Student find(String s) throws Exception {
        ResultSet rs=CrudUtil.execute("select * from student s inner join person p on s.NIC=p.NIC inner join person_contact pc on p.NIC=pc.NIC where s.NIC=?",s);
        rs.next();
            Person_Contact person_contact=new Person_Contact(rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19));
            Student student=new Student(rs.getString(2),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),person_contact,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            return student;

    }

    @Override
    public boolean save(Student s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student s) throws Exception {
        return CrudUtil.execute("update student set NIC=?, Branch_ID=?, Course_ID=?, Date_of_Joined=?, Exam_ID=?, Trial_ID=?, Next_Training_ID=?, Next_Lecture_ID=? where Std_ID=?",s.getNic(),s.getBranchId(),s.getCourseId(),s.getDateOfJoined(),s.getTrialId(),s.getTrainingId(),s.getLecId(),s.getLecId(),s.getStdId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from student where std_id=?",s);
    }

    @Override
    public String getLastStudentID() throws Exception {
        ResultSet rs=CrudUtil.execute("select Std_ID from student");
        rs.last();
        return rs.getString(1);
    }
}

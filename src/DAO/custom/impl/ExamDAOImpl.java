package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.SuperDAO;
import DAO.custom.ExamDAO;
import entity.Exam;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {

    @Override
    public List<Exam> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM exam");
        List<Exam> exams = new ArrayList<>();
        while (rst.next()) {
           /* String p=getStatusCount(rst.getString(1),"passed");
            String f=getStatusCount(rst.getString(1),"failed");
            String a=getStatusCount(rst.getString(1),"absent");

            int pass= Integer.parseInt(p);
            int fail= Integer.parseInt(f);
            int ab= Integer.parseInt(a);
            String tota= String.valueOf(pass+fail+ab);*/


            String date = String.valueOf(rst.getDate(2));
            String time = String.valueOf(rst.getTime(3));

            exams.add(new Exam(rst.getString(1), date, time, rst.getString(4)));

        }
        return exams;
    }

    @Override
    public Exam find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Exam exam) throws Exception {
        return CrudUtil.execute("INSERT INTO exam VALUES (?,?,?,?)", exam.getExam_ID(), exam.getDate(), exam.getTime(), exam.getVenue());
    }

    @Override
    public boolean update(Exam entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    public String getStatusCount(String exid,String status) throws Exception {

        System.out.println(exid);

        //String sqla = "SELECT count(*) FROM student_status where Exam_ID = ? AND Exam_Status = 'passed' ORDER BY Exam_ID ASC", x;
        ResultSet rst = CrudUtil.execute( "SELECT count(*) FROM student_status where Exam_ID = ? AND Exam_Status = ? ORDER BY Exam_ID ASC", exid,status);


        rst.absolute(1);
        String c = rst.getString(1);
        System.out.println("pcount" + c);

        return c;

    }

}

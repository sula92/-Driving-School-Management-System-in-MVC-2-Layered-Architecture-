package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.TrialDAO;
import entity.Exam;
import entity.Trial;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrialDAOImpl implements TrialDAO {

    @Override
    public List<Trial> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM trial");
        List<Trial> trials = new ArrayList<>();
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

            trials.add(new Trial(rst.getString(1), date, time, rst.getString(4)));

        }
        return trials;
    }

    @Override
    public Trial find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Trial trial) throws Exception {
        return CrudUtil.execute("INSERT INTO trial VALUES (?,?,?,?)", trial.getTrial_ID(), trial.getDate(), trial.getTime(), trial.getVenue());
    }

    @Override
    public boolean update(Trial entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    public String getStatusCount(String tid,String status) throws Exception {

        System.out.println(tid);

        //String sqla = "SELECT count(*) FROM student_status where Exam_ID = ? AND Exam_Status = 'passed' ORDER BY Exam_ID ASC", x;
        ResultSet rst = CrudUtil.execute( "SELECT count(*) FROM student_status where Trial_ID = ? AND Trial_Status = ? ORDER BY Trial_ID ASC", tid,status);


        rst.absolute(1);
        String c = rst.getString(1);
        System.out.println("pcount" + c);

        return c;

    }

}

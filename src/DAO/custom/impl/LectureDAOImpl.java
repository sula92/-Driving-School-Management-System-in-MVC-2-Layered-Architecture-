package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.LectureDAO;
import entity.Exam;
import entity.Lecture;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectureDAOImpl implements LectureDAO {

    @Override
    public ArrayList<Lecture> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM lecture");
        ArrayList<Lecture> lectures = new ArrayList<Lecture>();
        while (rst.next()) {

            Date date=rst.getDate(3);
            Time time=rst.getTime(4);

           // System.out.println(date+"&"+time);

            Lecture lec=new Lecture(

                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getTime(4),
                    rst.getString(5));

            lectures.add(lec);
            System.out.println( lectures.get(0).toString());
            System.out.println(rst.getString(1)+""+rst.getString(2)+""+rst.getDate(3));

        }
        System.out.println("LECTURE IS:"+Arrays.toString(new ArrayList[]{lectures}));
        return lectures;
    }

    @Override
    public Lecture find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Lecture lecture) throws Exception {
        return CrudUtil.execute("INSERT INTO lecture VALUES (?,?,?,?,?)", lecture.getLecture_ID(), lecture.getLecture_Name(), lecture.getDate(), lecture.getTime(),lecture.getVenue());
    }

    @Override
    public boolean update(Lecture entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM lecture WHERE Lecture_ID=?",s);
    }
}

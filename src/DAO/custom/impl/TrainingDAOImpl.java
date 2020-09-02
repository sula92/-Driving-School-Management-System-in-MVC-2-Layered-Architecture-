package DAO.custom.impl;

import DAO.CrudUtil;
import DAO.custom.TrainingDAO;
import entity.Training;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {
    @Override
    public List<Training> findAll() throws Exception {
        ArrayList<Training> trainings=new ArrayList<>();
        ResultSet rs=CrudUtil.execute("select * from training");
        while (rs.next()){
            trainings.add(new Training(rs.getString(1),rs.getDate(2),rs.getTime(3),rs.getString(4)));
        }
        return trainings;
    }

    @Override
    public Training find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(Training entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Training entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}

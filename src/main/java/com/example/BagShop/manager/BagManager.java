package com.example.BagShop.manager;

import com.example.BagShop.db.DBConnectionProvider;
import com.example.BagShop.enums.UserType;
import com.example.BagShop.model.Bag;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BagManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager=new UserManager();

    public List<Bag> getBags() {
        String sql = "SELECT * FROM bag";
        List<Bag> bags = new ArrayList<>();
        try {
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bag bag = Bag.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .price(resultSet.getDouble(4))
                        .count(resultSet.getInt(5))
                        .picUrl(resultSet.getString(6))
                        .build();
                bags.add(bag);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bags;
    }


    public void removeBagById(int id) {
        String sql = "DELETE from bag where id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Bag> getAllBagsByUserId(int userId)  {
        String sql = "SELECT * FROM bag where id=" + userId;
        List<Bag> bags = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bag bag = new Bag();
                bag.setId(resultSet.getInt(1));
                bag.setName(resultSet.getString(2));
                bag.setDescription(resultSet.getString(3));
                bag.setPrice(resultSet.getDouble(4));
                bag.setCount(resultSet.getInt(5));
                bag.setPicUrl(resultSet.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }return bags;
    }
    public void addBag(Bag bag) {
        String sql = "INSERT INTO bag (name,description,price,count,pic_url) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, bag.getName());
            statement.setString(2, bag.getDescription());
            statement.setDouble(3, bag.getPrice());
            statement.setInt(4,bag.getCount());
            statement.setString(5,bag.getPicUrl());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                bag.setId(rs.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}

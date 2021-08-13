package com.example.BagShop.manager;

import com.example.BagShop.db.DBConnectionProvider;
import com.example.BagShop.enums.BagType;
import com.example.BagShop.enums.UserType;
import com.example.BagShop.model.Bag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BagManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();

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
                        .type(BagType.valueOf(resultSet.getString(7)))
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

    public List<Bag> getAllBagsByUserId(int userId) {
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
                bag.setType(BagType.valueOf(resultSet.getString(7)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return bags;
    }

    public void addBag(Bag bag) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO bag(name,description,price,count,pic_url,type) VALUES('%s','%s','%s','%s','%s','%s');",
                    bag.getName(), bag.getDescription(), bag.getPrice(), bag.getCount(),bag.getPicUrl(),bag.getType());
            System.out.println(query);

            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                bag.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public Bag getBagsById(int id) {
        String sql = "SELECT * FROM bag where id=" + id;
        List<Bag> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Bag.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .price(Double.parseDouble(resultSet.getString(4)))
                        .count(resultSet.getInt(5))
                        .picUrl(resultSet.getString(6))
                        .type(BagType.valueOf(resultSet.getString(7)))
                        .build();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public void updateBag(Bag bag) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE  user SET name='%s', description='%s',price='%s',count='%s',pic_url='%s' ,type='%s'  where id=" + bag.getId(),
                    bag.getName(), bag.getDescription(), bag.getPrice(), bag.getCount(), bag.getPicUrl(),bag.getType());
            System.out.println(query);

            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

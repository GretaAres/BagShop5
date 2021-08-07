package com.example.BagShop.manager;

import com.example.BagShop.db.DBConnectionProvider;
import com.example.BagShop.enums.UserType;
import com.example.BagShop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void addUser(User user) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO user(name,surname,email,password,type) VALUES('%s','%s','%s','%s','%s');",
                    user.getName(), user.getSurname(), user.getEmail(), user.getPassword() ,user.getUserType());
            System.out.println(query);

            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                user.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .userType(UserType.valueOf(resultSet.getString(6)))
                        .build();
                result.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void removeUserById(int id) {
        String sql = "DELETE from user where id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getUsersById(int id) {
        String sql = "SELECT * FROM user where id=" + id;
        List<User> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .userType(UserType.valueOf(resultSet.getString(6)))
                        .build();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }
    public User getUsersByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM user where email='" + email +"' and password ='"+password+"'";
        List<User> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .userType(UserType.valueOf(resultSet.getString(6)))
                        .build();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }


}

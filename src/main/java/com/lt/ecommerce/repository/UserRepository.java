package com.lt.ecommerce.repository;

import com.lt.ecommerce.model.User;
import com.lt.ecommerce.service.ConnectionService;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<Integer, User> userMap = new HashMap<Integer, User>();

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        System.out.println("connection: " + connection);
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
            System.out.println("connection created: " + connection);
        }
    }

    public boolean addUser(User user) throws SQLException {
//        userMap.put(user.getId(), user);
        this.initConnection();
        String query = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getMobileNo());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getUserType());
            preparedStatement.setString(7, String.valueOf(LocalDateTime.now()));

            System.out.println("inserting user data to table: " + user);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(int userId) {
        return userMap.get(userId);
    }

    public User removeUser(int userId) {
        return userMap.remove(userId);
    }

    public Map<Integer, User> getAllUsers() {
        return userMap;
    }

    public void removeAllUsers() {
        userMap.clear();
    }

    public int getUsersSize() {
        return userMap.size();
    }

    public boolean containsUser(int userId) {
        return userMap.containsKey(userId);
    }

}

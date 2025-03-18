package com.lt.ecommerce.service;
import com.lt.ecommerce.model.User;
import com.lt.ecommerce.repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private final int userType;
    private final Scanner scanner = new Scanner(System.in);
    private static final UserRepository userRepository = new UserRepository();

    public UserService(int userType) {
        this.userType = userType;
    }

    public void createUser() throws SQLException {
        User user = new User();
        user.setUserType(this.userType);
        String userByType = this.getUserType(this.userType);
        user.setId(1);
        user.setFirstName("Jay");
        user.setLastName("Kumar");
        user.setMobileNo(991199001);
        user.setAddress("Pune");
        boolean isUserAdded = userRepository.addUser(user);
        System.out.println(userByType.toUpperCase() + (isUserAdded ? " created!!!" : "Failed to create"));
    }

    private String getUserType(int userType) {
        return switch (userType) {
            case 1 -> "customer";
            case 2 -> "seller";
            case 3 -> "delivery agent";
            default -> "";
        };
    }

    public void displayAllUsers() throws SQLException {
        ArrayList<User> users = (ArrayList<User>) userRepository.getAllUsers();
        if (users != null && users.size() > 0) {
            users.stream().forEach(user -> {
                System.out.println("User details = " + user.toString());
            });
        } else {
           System.out.println("User's not found to display !!!");
        }
    }

    public void getUser(int userId) throws SQLException {
        User user = userRepository.getUser(userId);
        if (user != null && user.getId() != 0) {
            System.out.println("User details = " + user.toString());
        } else {
            System.out.println("User id : " + userId + " does not exits!!!");
        }
    }

    public void removeUser(int userId) throws SQLException {
        boolean isUserDeleted = userRepository.removeUser(userId);
        if(isUserDeleted) {
            System.out.println("Removed  details = " + isUserDeleted);
        } else {
            System.out.println("User not found !!!");
        }
    }

    public void removeAllUsers() throws SQLException {
        boolean isUserDeleted = userRepository.removeAllUsers();
        if(isUserDeleted) {
            System.out.println("Removed  details = " + isUserDeleted);
        } else {
            System.out.println("User's not found !!!");
        }
    }

}

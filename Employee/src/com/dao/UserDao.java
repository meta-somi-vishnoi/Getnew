package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enums.Status;
import com.models.UserDetails;
import com.mysql.jdbc.Connection;

public class UserDao {

    private static UserDao userDao = new UserDao();

    public static UserDao getInstance() {
        return userDao;
    }

    public List<UserDetails> selectUserDetails() {
        UserDetails userDetails;
        List<UserDetails> userList = new ArrayList<UserDetails>();
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getSelectUserquery();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userDetails = new UserDetails();
                userDetails.setFirstName(resultSet.getString("first_name"));
                userDetails.setLastName(resultSet.getString("last_name"));
                userDetails.setAge(resultSet.getInt("age"));
                userDetails.setDob(resultSet.getDate("dob"));
                userDetails.setContactNo(resultSet.getString("contact_no"));
                userDetails.setEmail(resultSet.getString("email"));
                userDetails.setPassword(resultSet.getString("password"));
                userDetails
                        .setOrganization(resultSet.getString("organization"));
                userList.add(userDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return userList;
    }

    public Status insertUserDetails(UserDetails userDetails) {
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getAddUserQuery();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setString(1, userDetails.getFirstName());
            preparedStatement.setString(2, userDetails.getLastName());
            preparedStatement.setString(3, userDetails.getEmail());
            preparedStatement.setInt(4, userDetails.getAge());
            preparedStatement.setDate(5, userDetails.getDob());
            preparedStatement.setString(6, userDetails.getPassword());
            preparedStatement.setString(7, userDetails.getContactNo());
            preparedStatement.setString(8, userDetails.getOrganization());
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                return Status.NOT_INSERTED;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return Status.INSERTED;
    }

    public UserDetails selectUserDetailsByEmail(String email) {
        UserDetails userDetails = new UserDetails();
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getSelectUserByEmailQuery();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            userDetails.setFirstName(resultSet.getString("first_name"));
            userDetails.setLastName(resultSet.getString("last_name"));
            userDetails.setAge(resultSet.getInt("age"));
            userDetails.setDob(resultSet.getDate("dob"));
            userDetails.setContactNo(resultSet.getString("contact_no"));
            userDetails.setEmail(resultSet.getString("email"));
            userDetails.setPassword(resultSet.getString("password"));
            userDetails.setOrganization(resultSet.getString("organization"));
            userDetails.setImage(resultSet.getString("image"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return userDetails;
    }

    public Status updateUserDetails(UserDetails userDetails) {
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getUpdateUserDetailsQuery();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setString(1, userDetails.getFirstName());
            preparedStatement.setString(2, userDetails.getLastName());
            preparedStatement.setDate(3, userDetails.getDob());
            preparedStatement.setString(4, userDetails.getContactNo());
            preparedStatement.setString(5, userDetails.getEmail());
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                return Status.NOT_UPDATED;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return Status.UPDATED;
    }

    public List<UserDetails> selectListOfFriends(String email) {
        UserDetails userDetails = new UserDetails();
        List<UserDetails> userList = new ArrayList<UserDetails>();
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getFriendListQuery();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userDetails = new UserDetails();
                userDetails.setFirstName(resultSet.getString("first_name"));
                userDetails.setLastName(resultSet.getString("last_name"));
                userDetails.setImage(resultSet.getString("image"));
                userDetails.setEmail(resultSet.getString("email"));
                userList.add(userDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return userList;
    }

    public Status uploadImage(UserDetails userDetails) {
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getImageUploadQuery();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setString(1, userDetails.getImage());
            preparedStatement.setString(2, userDetails.getEmail());
            int result = preparedStatement.executeUpdate();
            if (result == 0) {
                return Status.NOT_UPDATED;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return Status.UPDATED;
    }
}

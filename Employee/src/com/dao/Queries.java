package com.dao;

public class Queries {
    private static final String addUserQuery = "INSERT INTO user(first_name,last_name,email,age,dob,password,contact_no,organization) VALUES(?,?,?,?,?,?,?,?)";
    private static final String selectUserQuery = "SELECT * FROM user";
    private static final String selectUserByEmailQuery = "SELECT * FROM user WHERE email = ?";
    private static final String updateUserDetailsQuery = "UPDATE user SET first_name = ? , last_name = ? , dob = ? , contact_no = ? WHERE email = ?";
    private static final String friendListQuery = "SELECT first_name ,last_name ,image ,email FROM user WHERE organization IN ("
            + " SELECT organization FROM user WHERE email = ? "
            + ") AND email <> ?";
    private static final String imageUploadQuery = "UPDATE user SET image = ? WHERE email = ?";

    public static String getAddUserQuery() {
        return addUserQuery;
    }

    public static String getSelectUserquery() {
        return selectUserQuery;
    }

    public static String getSelectUserByEmailQuery() {
        return selectUserByEmailQuery;
    }

    public static String getUpdateUserDetailsQuery() {
        return updateUserDetailsQuery;
    }

    public static String getFriendListQuery() {
        return friendListQuery;
    }

    public static String getImageUploadQuery() {
        return imageUploadQuery;
    }
}

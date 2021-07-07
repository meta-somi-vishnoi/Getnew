package com.facade;

import java.util.List;

import com.dao.UserDao;
import com.enums.Status;
import com.models.UserDetails;

public class UserFacade {

    private static UserFacade userFacade = new UserFacade();
    private UserDao userDao = UserDao.getInstance();

    public static UserFacade getInstance() {
        return userFacade;
    }

    public Status insertUserDetails(UserDetails userDetails) {
        List<UserDetails> userDetailsList = userDao.selectUserDetails();
        for (UserDetails user : userDetailsList) {
            if (user.getEmail().equalsIgnoreCase(userDetails.getEmail())) {
                return Status.DUPLICATE;
            }
        }
        Status status = userDao.insertUserDetails(userDetails);
        if (!Status.INSERTED.equals(status)) {
            return Status.NOT_INSERTED;
        }
        return Status.INSERTED;
    }

    public Status validateUserDetails(UserDetails userDetails) {
        List<UserDetails> userDetailsList = userDao.selectUserDetails();
        for (UserDetails user : userDetailsList) {
            if (userDetails.getEmail().equalsIgnoreCase(user.getEmail())
                    && userDetails.getPassword().equals(user.getPassword())) {
                return Status.FOUND;
            }
        }
        return Status.NOT_FOUND;
    }

    public UserDetails selectUserDetailsByEmail(String email) {
        UserDetails userDetails = new UserDetails();
        userDetails = userDao.selectUserDetailsByEmail(email);
        return userDetails;
    }

    public Status updateUserDetails(UserDetails userDetails) {
        Status status = userDao.updateUserDetails(userDetails);
        if (Status.UPDATED.equals(status)) {
            return Status.UPDATED;
        }
        return Status.NOT_UPDATED;
    }

    public List<UserDetails> selectListOfFriends(String email) {
        List<UserDetails> userDetailsList = userDao.selectListOfFriends(email);
        return userDetailsList;
    }

    public Status uploadImage(UserDetails userDetails) {
        Status status = userDao.uploadImage(userDetails);
        if (Status.UPDATED.equals(status)) {
            return Status.UPDATED;
        }
        return Status.NOT_UPDATED;
    }
}
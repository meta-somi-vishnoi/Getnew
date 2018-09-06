package com.metacube.advertisementwebservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertisementwebservices.Properties.Query;
import com.metacube.advertisementwebservices.connection.ConnectionManager;
import com.metacube.advertisementwebservices.enums.Status;
import com.metacube.advertisementwebservices.model.Advertisement;

public class AdvertisementDao {
    private static AdvertisementDao mysqlAdvertisementDao = new AdvertisementDao();

    public static AdvertisementDao getInstance() {
        return mysqlAdvertisementDao;
    }

    public Status insert(Advertisement advertisement) {
        String query = Query.INSERT_NEW_ADVERTISEMENT;
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setString(1, advertisement.getAdvertisementTitle());
            preparedStatement.setString(2, advertisement.getAdvertisementDescription());
            preparedStatement.setInt(3, advertisement.getCategoryId());
            if (preparedStatement.executeUpdate() == 1) {
                return Status.INSERTED;
            }
        } catch (SQLException | AssertionError e) {
            e.printStackTrace();
        }
        return Status.NOT_INSERTED;
    }

    public List<Advertisement> getAll() {
        List<Advertisement> advertisementList = new ArrayList<Advertisement>();
        String query = Query.SELECT_ALL_ADVERTISMENT;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setAdvertisementId(resultSet.getInt("advertisement_id"));
                advertisement.setAdvertisementTitle(resultSet.getString("advertisement_title"));
                advertisement.setAdvertisementDescription(resultSet.getString("advertisement_desc"));
                advertisement.setCategoryId(resultSet.getInt("category_id"));
                advertisementList.add(advertisement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertisementList;
    }

    public List<Advertisement> getAllById(int categoryId) {
        List<Advertisement> advertisementList = new ArrayList<Advertisement>();
        String query = Query.SELECT_ALL_ADVERTISMENT_BY_ID;
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setAdvertisementId(resultSet.getInt("advertisement_id"));
                advertisement.setAdvertisementTitle(resultSet.getString("advertisement_title"));
                advertisement.setAdvertisementDescription(resultSet.getString("advertisement_desc"));
                advertisement.setCategoryId(resultSet.getInt("category_id"));
                advertisementList.add(advertisement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertisementList;
    }

    public Status updateName(String name, int id) {
        String query = Query.UPDATE_NAME;
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            if (preparedStatement.executeUpdate() == 1) {
                return Status.UPDATED;
            }
        } catch (SQLException | AssertionError e) {
            e.printStackTrace();
        }
        return Status.NOT_UPDATED;
    }

    public Status deleteAdvertisement(int id) {
        String query = Query.DELETE_ADVERTISEMENT;
        try (Connection conn = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 1) {
                return Status.DELETED;
            }
        } catch (SQLException | AssertionError e) {
            e.printStackTrace();
        }
        return Status.NOT_FOUND;
    }
}

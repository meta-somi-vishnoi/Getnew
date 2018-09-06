package com.metacube.advertisementwebservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metacube.advertisementwebservices.connection.ConnectionManager;
import com.metacube.advertisementwebservices.enums.Status;
import com.metacube.advertisementwebservices.Properties.Query;
import com.metacube.advertisementwebservices.model.Category;

public class CategoryDao {

	private static CategoryDao mysqlCategoryDao = new CategoryDao();

	public static CategoryDao getInstance() {
		return mysqlCategoryDao;
	}

	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		String query = Query.SELECT_ALL_CATEGORIES;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn
						.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	public Status insert(String name) {
		String query = Query.INSERT_NEW_CATEGORY;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			if (preparedStatement.executeUpdate() == 1) {
				return Status.INSERTED;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return Status.NOT_INSERTED;
	}

	public Status updateCategory(String category, int id) {
		String query = Query.UPDATE_CATEGORY;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, id);
			if (preparedStatement.executeUpdate() == 1) {
				return Status.UPDATED;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return Status.NOT_UPDATED;
	}

	public Category getCategoryByName(String name) {
		Category category = null;
		String query = Query.SELECT_CATEGORY_BY_NAME;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));
				return category;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public Category getCategoryById(int id){
		Category category = null;
		String query = Query.SELECT_CATEGORY_BY_ID;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));
				return category;
			}
		} catch (SQLException | AssertionError e) {
			e.printStackTrace();
		}
		return category;
	}
}

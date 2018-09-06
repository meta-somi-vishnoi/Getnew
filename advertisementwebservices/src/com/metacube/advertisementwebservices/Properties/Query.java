package com.metacube.advertisementwebservices.Properties;

public class Query {
	public static final String INSERT_NEW_CATEGORY = "INSERT INTO category (category_name) VALUES (?)";
	public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category";
	public static final String SELECT_CATEGORY_BY_NAME = "SELECT * FROM category WHERE category_name=? ";
	public static final String SELECT_ALL_ADVERTISMENT = "SELECT * FROM advertisement";
	public static final String SELECT_ALL_ADVERTISMENT_BY_ID = "SELECT * FROM advertisement WHERE category_id=?";
	public static final String UPDATE_NAME = "UPDATE advertisement SET advertisement_title=? WHERE advertisement_id=?";
	public static final String INSERT_NEW_ADVERTISEMENT = "INSERT INTO advertisement (advertisement_title, advertisement_desc , category_id) VALUES (?,?,?)";
	public static final String UPDATE_CATEGORY = "UPDATE category SET category_name = ? WHERE category_id = ? ";
	public static final String DELETE_ADVERTISEMENT = "DELETE FROM advertisement WHERE advertisement_id = ? ";
	public static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE category_id=? ";
}

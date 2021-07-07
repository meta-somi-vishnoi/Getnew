package com.metacube.advertisementwebservices.facade;

import java.util.List;

import com.metacube.advertisementwebservices.enums.Status;
import com.metacube.advertisementwebservices.dao.CategoryDao;
import com.metacube.advertisementwebservices.model.Category;

public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	CategoryDao categoryDao = (CategoryDao) CategoryDao.getInstance();

	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	public Status insertCategory(String name) {
		if(name=="" || name == null){
			return Status.NO_DATA_TO_INSERT;
		}
		if(categoryDao.getCategoryByName(name)!=null){
			return Status.DUPLICATE;
		}
		return categoryDao.insert(name);
	}

	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	public Status updateCategory(String categoryName, int id) {
		if(id<=0 || categoryName =="" || categoryName==null){
			return Status.INVALID;
		}
		if(categoryDao.getCategoryById(id)==null){
			return Status.NOT_FOUND;
		}
		if(categoryDao.getCategoryByName(categoryName)!=null){
			return Status.DUPLICATE;
		}
		return categoryDao.updateCategory(categoryName, id);		
	}
}

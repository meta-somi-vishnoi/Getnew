package com.metacube.advertisementwebservices.facade;

import java.util.List;

import com.metacube.advertisementwebservices.enums.Status;
import com.metacube.advertisementwebservices.dao.AdvertisementDao;
import com.metacube.advertisementwebservices.dao.CategoryDao;
import com.metacube.advertisementwebservices.model.Advertisement;

public class AdvertisementFacade {
    private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();

    AdvertisementDao advertisementDao = (AdvertisementDao) AdvertisementDao.getInstance();
    CategoryDao categoryDao = (CategoryDao) CategoryDao.getInstance();

    public static AdvertisementFacade getInstance() {
        return advertisementFacade;
    }

    public Status insertAdvertisement(Advertisement advertisement) {
        int categoryId = advertisement.getCategoryId();
        String title = advertisement.getAdvertisementTitle();
        String description = advertisement.getAdvertisementDescription();

        if (categoryId <= 0 || title == "" || description == "" || title == null || description == null) {
            return Status.INVALID;
        }

        if (categoryDao.getCategoryById(categoryId) == null) {
            return Status.NOT_FOUND;
        }
        List<Advertisement> advertisementList = advertisementDao.getAllById(categoryId);
        for (Advertisement advertisementTemp : advertisementList) {
            if (advertisementTemp.getAdvertisementTitle().equalsIgnoreCase(title)) {
                return Status.DUPLICATE;
            }
        }
        return advertisementDao.insert(advertisement);
    }

    public List<Advertisement> getAll() {
        return advertisementDao.getAll();
    }

    public List<Advertisement> getAllById(int id) {
        return advertisementDao.getAllById(id);
    }

    public Status updateName(String name, int id) {
        if (name == "" || id <= 0) {
            return Status.INVALID;
        }
        return advertisementDao.updateName(name, id);
    }

    public Status deleteAdvertisement(int id) {
        return advertisementDao.deleteAdvertisement(id);
    }
}

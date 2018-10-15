package com.showCars.services.daoImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.showCars.dao.IAdDao;
import com.showCars.pojos.Ad;
import com.showCars.pojos.User;
import com.showCars.services.IAdService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Service
public class AdService implements IAdService {

    private Logger logger = Logger.getLogger(AdService.class);


    @Autowired
    IAdDao adDao;

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "hxqjawdta",
            "api_key", "178688611992431",
            "api_secret", "B925PaAvSXrlqsD1VXcgf1nfrKA"));

    @Override
    public void saveOrUpdate(User user, String make, String model,
                             String price, String year, String description, MultipartFile photo) throws Exception {

        String urlPhoto = null;
        Map uploadResult = null;

        if (!photo.isEmpty()) {
            try {

                File f = Files.createTempFile("temp", photo.getOriginalFilename()).toFile();
                photo.transferTo(f);

                uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
                urlPhoto = (String) uploadResult.get("url");
            } catch (IOException e) {
                logger.error("error with upload photo to cloudinary");
            }

        }

        Ad ad = new Ad();
        ad.setMake(make);
        ad.setModel(model);
        if (!year.isEmpty())ad.setYear(Integer.parseInt(year));
        if (!price.isEmpty())ad.setPrice(Integer.parseInt(price));
        ad.setDescription(description);
        ad.setPhoto(urlPhoto);
        ad.setUser(user);

        try {
            adDao.saveOrUpdate(ad);
            logger.info("ad created");

        } catch (Exception e) {
            logger.error("Error saveOrUpdate in AdService: " + e);
            throw new Exception(e);
        }
    }

    @Override
    public List getAllWithFilters(String minYear, String maxYear, String minPrice, String maxPrice) throws Exception {
        return adDao.getAllWithFilters(minYear, maxYear, minPrice, maxPrice);
    }

    @Override
    public List getAll() throws Exception {
        return adDao.getAll();
    }

    @Override
    public List getMyAd(int id) throws Exception {
        return adDao.getMyAd(id);
    }


    @Override
    public void saveOrUpdate(Object o) throws Exception {

    }

    @Override
    public void delete(Object o) throws Exception {

    }

    @Override
    public Object get(Serializable id) throws Exception {
        return null;
    }
}

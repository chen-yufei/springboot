package com.chenyuhui.springboot.admin.service.impl;

import com.chenyuhui.springboot.admin.bean.City;
import com.chenyuhui.springboot.admin.mapper.CityMapper;
import com.chenyuhui.springboot.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {


    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public void saveCity(City city) {

    }
}

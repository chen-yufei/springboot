package com.chenyuhui.springboot.admin.service;

import com.chenyuhui.springboot.admin.bean.City;
import com.chenyuhui.springboot.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CityService {

     City getById(Long id);

     void saveCity(City city);

}

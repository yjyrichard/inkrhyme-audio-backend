package com.yangjiayu.audio.album.service.impl;

import com.yangjiayu.audio.album.config.VodConstantProperties;
import com.yangjiayu.audio.album.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VodServiceImpl implements VodService {

    @Autowired
    private VodConstantProperties vodConstantProperties;

}

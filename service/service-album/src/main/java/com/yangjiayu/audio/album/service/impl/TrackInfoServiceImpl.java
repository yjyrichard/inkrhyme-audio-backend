package com.yangjiayu.audio.album.service.impl;

import com.yangjiayu.audio.album.mapper.TrackInfoMapper;
import com.yangjiayu.audio.album.service.TrackInfoService;
import com.yangjiayu.audio.model.album.TrackInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"all"})
public class TrackInfoServiceImpl extends ServiceImpl<TrackInfoMapper, TrackInfo> implements TrackInfoService {

	@Autowired
	private TrackInfoMapper trackInfoMapper;

}

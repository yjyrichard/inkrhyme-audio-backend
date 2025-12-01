package com.yangjiayu.audio.album.service.impl;

import com.yangjiayu.audio.album.mapper.AlbumInfoMapper;
import com.yangjiayu.audio.album.service.AlbumInfoService;
import com.yangjiayu.audio.model.album.AlbumInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"all"})
public class AlbumInfoServiceImpl extends ServiceImpl<AlbumInfoMapper, AlbumInfo> implements AlbumInfoService {

	@Autowired
	private AlbumInfoMapper albumInfoMapper;
}

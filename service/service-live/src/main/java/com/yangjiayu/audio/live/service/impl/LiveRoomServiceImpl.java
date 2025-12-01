package com.yangjiayu.audio.live.service.impl;

import com.yangjiayu.audio.live.mapper.LiveRoomMapper;
import com.yangjiayu.audio.live.service.LiveRoomService;
import com.yangjiayu.audio.model.live.LiveRoom;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"all"})
public class LiveRoomServiceImpl extends ServiceImpl<LiveRoomMapper, LiveRoom> implements LiveRoomService {

	@Autowired
	private LiveRoomMapper liveRoomMapper;

}

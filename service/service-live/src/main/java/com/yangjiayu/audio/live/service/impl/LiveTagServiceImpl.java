package com.yangjiayu.audio.live.service.impl;

import com.yangjiayu.audio.live.mapper.LiveTagMapper;
import com.yangjiayu.audio.live.service.LiveTagService;
import com.yangjiayu.audio.model.live.LiveTag;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"all"})
public class LiveTagServiceImpl extends ServiceImpl<LiveTagMapper, LiveTag> implements LiveTagService {

	@Autowired
	private LiveTagMapper liveTagMapper;

}

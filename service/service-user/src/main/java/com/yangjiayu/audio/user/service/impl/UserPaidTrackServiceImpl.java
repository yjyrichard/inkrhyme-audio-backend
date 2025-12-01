package com.yangjiayu.audio.user.service.impl;

import com.yangjiayu.audio.model.user.UserPaidTrack;
import com.yangjiayu.audio.user.mapper.UserPaidAlbumMapper;
import com.yangjiayu.audio.user.mapper.UserPaidTrackMapper;
import com.yangjiayu.audio.user.service.UserPaidTrackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"all"})
public class UserPaidTrackServiceImpl extends ServiceImpl<UserPaidTrackMapper, UserPaidTrack> implements UserPaidTrackService {

	@Autowired
	private UserPaidAlbumMapper userPaidAlbumMapper;

}

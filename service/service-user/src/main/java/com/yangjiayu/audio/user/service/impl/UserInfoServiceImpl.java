package com.yangjiayu.audio.user.service.impl;

import com.yangjiayu.audio.model.user.UserInfo;
import com.yangjiayu.audio.user.mapper.UserInfoMapper;
import com.yangjiayu.audio.user.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"all"})
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

}

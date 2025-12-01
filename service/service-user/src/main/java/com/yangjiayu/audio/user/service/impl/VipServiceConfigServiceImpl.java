package com.yangjiayu.audio.user.service.impl;

import com.yangjiayu.audio.model.user.VipServiceConfig;
import com.yangjiayu.audio.user.mapper.VipServiceConfigMapper;
import com.yangjiayu.audio.user.service.VipServiceConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"all"})
public class VipServiceConfigServiceImpl extends ServiceImpl<VipServiceConfigMapper, VipServiceConfig> implements VipServiceConfigService {

	@Autowired
	private VipServiceConfigMapper vipServiceConfigMapper;


}

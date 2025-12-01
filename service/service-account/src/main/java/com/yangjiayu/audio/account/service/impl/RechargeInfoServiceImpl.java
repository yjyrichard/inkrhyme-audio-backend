package com.yangjiayu.audio.account.service.impl;

import com.yangjiayu.audio.account.mapper.RechargeInfoMapper;
import com.yangjiayu.audio.account.service.RechargeInfoService;
import com.yangjiayu.audio.model.account.RechargeInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"all"})
public class RechargeInfoServiceImpl extends ServiceImpl<RechargeInfoMapper, RechargeInfo> implements RechargeInfoService {

	@Autowired
	private RechargeInfoMapper rechargeInfoMapper;

}

package com.yangjiayu.audio.account.service.impl;

import com.yangjiayu.audio.account.mapper.UserAccountMapper;
import com.yangjiayu.audio.account.service.UserAccountService;
import com.yangjiayu.audio.model.account.UserAccount;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"all"})
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

	@Autowired
	private UserAccountMapper userAccountMapper;

}

package com.yangjiayu.audio.payment.service.impl;

import com.yangjiayu.audio.model.payment.PaymentInfo;
import com.yangjiayu.audio.payment.mapper.PaymentInfoMapper;
import com.yangjiayu.audio.payment.service.PaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"all"})
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

}

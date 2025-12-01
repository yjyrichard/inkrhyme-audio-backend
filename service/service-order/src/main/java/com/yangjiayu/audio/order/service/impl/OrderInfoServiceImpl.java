package com.yangjiayu.audio.order.service.impl;

import com.yangjiayu.audio.model.order.OrderInfo;
import com.yangjiayu.audio.order.mapper.OrderInfoMapper;
import com.yangjiayu.audio.order.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"all"})
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


}

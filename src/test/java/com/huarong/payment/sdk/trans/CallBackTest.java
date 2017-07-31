package com.huarong.payment.sdk.trans;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huarong.payment.sdk.dto.NotifyDto;
import com.huarong.payment.sdk.enums.ResponseEnum;
import com.huarong.payment.sdk.notify.CallBack;
import com.huarong.payment.sdk.uitls.HttpRequestSimple;


public class CallBackTest implements CallBack {
    public static final Logger logger = LoggerFactory.getLogger(HttpRequestSimple.class);
    public boolean businessCallBack(NotifyDto dto) {
        if (dto.getRespCode().equals(ResponseEnum.API_ERROE_CODE_0000.getRespCode())) {
            logger.info("交易成功了，请修改订单状态");
            return true;
        }else if(dto.getRespCode().equals(ResponseEnum.API_ERROE_CODE_P000.getRespCode()) || dto.getRespCode().equals(ResponseEnum.API_ERROE_CODE_9997.getRespCode())){
            logger.info("还在处理中...");
            return false;
        }else{
            logger.info("交易失败...");
            return true;
        }
    }

}

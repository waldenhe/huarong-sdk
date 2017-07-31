package com.huarong.payment.sdk.notify;

import java.util.Map;

import com.huarong.payment.sdk.dto.NotifyDto;
import com.huarong.payment.sdk.enums.ResponseEnum;
import com.huarong.payment.sdk.uitls.BeanToMapUtil;
import com.huarong.payment.sdk.uitls.SignUtils;

/**
 * 订单通知实现
 * @author hjh
 *
 */
public class OrderNotifyImpl implements IOrderNotify {
    
    @Override
    public boolean asynchronousNotify(Map<String, String> reqMap, CallBack callBack) {
        NotifyDto dto = new NotifyDto();
        if(SignUtils.verferSignData(reqMap)){
            BeanToMapUtil.transMap2Bean3(reqMap, dto);
        }else{
            dto.setRespCode(ResponseEnum.API_ERROE_CODE_0012.getRespCode());
            dto.setRespDesc(ResponseEnum.API_ERROE_CODE_0012.getRespMsg());
        }
        return callBack.businessCallBack(dto);
    }

    @Override
    public boolean synchronizationNotify(Map<String, String> reqMap, CallBack callBack) {
        return synchronizationNotify(reqMap, callBack);
    }

}

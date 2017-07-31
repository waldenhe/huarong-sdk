package com.huarong.payment.sdk.notify;

import com.huarong.payment.sdk.dto.NotifyDto;
public interface CallBack {
    
    /**
     * 异步通知回调
     * @param dto
     * @return
     */
    public boolean businessCallBack(NotifyDto dto);
    
}

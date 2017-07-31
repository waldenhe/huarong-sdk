package com.huarong.payment.sdk.notify;

import java.util.Map;

/**
 * 订单通知接口
 * @author hjh
 *
 */
public interface IOrderNotify {
    
    /**
     * 异步通知
     * @param callBack
     */
    public boolean asynchronousNotify(Map<String, String> reqMap,CallBack callBack);
    
    /**
     * 同步通知
     * @param callBack
     */
    public boolean synchronizationNotify(Map<String, String> reqMap,CallBack callBack);
    
}

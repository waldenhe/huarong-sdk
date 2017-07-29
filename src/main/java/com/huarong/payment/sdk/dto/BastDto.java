package com.huarong.payment.sdk.dto;

import java.io.Serializable;

/**
 * 基类模型
 * 
 * @author hjh
 *
 */
public class BastDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 请求流水
     */
    private String requestNo;

    /**
     * 接口版本
     */
    private String version;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 加签数据
     */
    private String signature;

    /**
     * 响应结果
     */
    private String responseCode;

    /**
     * 响应消息
     */
    private String responseMsg;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 交易金额（单位分）
     */
    private long transAmt;

    /**
     * 商品描述
     */
    private String commodityName;

    /**
     * 产品类型
     */
    private String productId;

    /**
     * 交易类型
     */
    private String transId;

    /**
     * 交易时间
     */
    private String orderDate;

    /**
     * 异步通知地址
     */
    private String notifyUrl;

    /**
     * 同步通知地址
     */
    private String returnUrl;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public long getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(long transAmt) {
        this.transAmt = transAmt;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    @Override
    public String toString() {
        return "BastDto [requestNo=" + requestNo + ", version=" + version + ", merNo=" + merNo + ", signature=" + signature
                + ", responseCode=" + responseCode + ", responseMsg=" + responseMsg + ", orderNo=" + orderNo + ", transAmt="
                + transAmt + ", commodityName=" + commodityName + ", productId=" + productId + ", transId=" + transId
                + ", orderDate=" + orderDate + ", notifyUrl=" + notifyUrl + ", returnUrl=" + returnUrl + "]";
    }

}

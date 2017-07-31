package com.huarong.payment.sdk.dto;

import java.io.Serializable;

/**
 * 异步通知业务模型
 * 
 * @author Administrator
 *
 */
public class NotifyDto implements Serializable {

    private static final long serialVersionUID = -8917610829079566323L;
    private String productId;// 产品类型 详见各交易类接口
    private String transId;// 交易类型 详见各交易类接口
    private String merNo;// 商户号
    private String orderNo;// 商户订单号
    private String transAmt;// 交易金额
    private String orderDate;// 商品订单支付日期yyyyMMdd
    private String respCode;// 应答码
    private String respDesc;// 应答码描述
    private String acctNo;// 卡号
    private String Token;// 持卡人信息
    private String signature;// 验签字段

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

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "NotifyDto [productId=" + productId + ", transId=" + transId + ", merNo=" + merNo + ", orderNo=" + orderNo
                + ", transAmt=" + transAmt + ", orderDate=" + orderDate + ", respCode=" + respCode + ", respDesc=" + respDesc
                + ", acctNo=" + acctNo + ", Token=" + Token + ", signature=" + signature + "]";
    }

}

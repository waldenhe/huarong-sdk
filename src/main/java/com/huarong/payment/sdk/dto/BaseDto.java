package com.huarong.payment.sdk.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.huarong.payment.sdk.uitls.BeanToMapUtil;
import com.huarong.payment.sdk.uitls.ConfigUtils;

/**
 * 基类模型
 * 
 * @author hjh
 *
 */
public class BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 交易地址
	 */
	private String trans_url;

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
	private String respCode;

	/**
	 * 响应消息
	 */
	private String respDesc;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 交易金额（单位分）
	 */
	private String transAmt;

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

	public BaseDto() {
		this.setRequestNo(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		this.setVersion("V1.0");
		this.setMerNo(ConfigUtils.getProperty("merchant_no"));
		this.setOrderDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		this.setTrans_url(ConfigUtils.getProperty("trans_url"));
		this.setNotifyUrl(ConfigUtils.getProperty("notifyUrl"));
		this.setReturnUrl(ConfigUtils.getProperty("returnUrl"));
	}

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

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
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

	public String getTrans_url() {
		return trans_url;
	}

	public void setTrans_url(String trans_url) {
		this.trans_url = trans_url;
	}

	@Override
	public String toString() {
		return "BaseDto [trans_url=" + trans_url + ", requestNo=" + requestNo + ", version=" + version + ", merNo="
				+ merNo + ", signature=" + signature + ", respCode=" + respCode + ", respDesc=" + respDesc
				+ ", orderNo=" + orderNo + ", transAmt=" + transAmt + ", commodityName=" + commodityName
				+ ", productId=" + productId + ", transId=" + transId + ", orderDate=" + orderDate + ", notifyUrl="
				+ notifyUrl + ", returnUrl=" + returnUrl + "]";
	}

	public Map<String, Object> toMap() {
		return BeanToMapUtil.transBean2Map(this);
	}
}

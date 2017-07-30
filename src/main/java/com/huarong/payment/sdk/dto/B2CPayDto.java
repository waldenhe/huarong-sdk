package com.huarong.payment.sdk.dto;

/**
 * 网银业务模型
 * 
 * @author hjh
 *
 */
public class B2CPayDto extends BaseDto {
	private static final long serialVersionUID = 4968099733057726820L;
	/**
	 * 银行因为简称
	 */
	private String bankCode;
	
	/**
	 * 表单数据
	 */
	private String htmlData;

	public String getHtmlData() {
		return htmlData;
	}

	public void setHtmlData(String htmlData) {
		this.htmlData = htmlData;
	}

	public B2CPayDto() {
		super();
		this.setTransId("12");
		this.setProductId("0208");
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Override
	public String toString() {
		return "B2CPayDto [bankCode=" + bankCode + ", htmlData=" + htmlData + "]";
	}

}

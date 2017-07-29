package com.huarong.payment.sdk.dto;

/**
 * 工行代付业务模型
 * 
 * @author hjh
 *
 */
public class ProxyPayDto extends BaseDto {

	private static final long serialVersionUID = 680590141802648074L;

	/** 卡号 */
	private String acctNo;

	/** 姓名 */
	private String customerName;

	/** 账户类型 0-对私,1-对公 */
	private String isCompay;

	/** 备注 */
	private String note;
	
	public ProxyPayDto() {
		this.setTransId("07");
		this.setProductId("0201");
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIsCompay() {
		return isCompay;
	}
	/** 账户类型 0-对私,1-对公 */
	public void setIsCompay(String isCompay) {
		this.isCompay = isCompay;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ProxyPayDto [acctNo=" + acctNo + ", customerName=" + customerName + ", isCompay=" + isCompay + ", note="
				+ note + "]";
	}
}

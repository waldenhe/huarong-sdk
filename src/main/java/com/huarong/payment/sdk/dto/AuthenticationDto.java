package com.huarong.payment.sdk.dto;

/**
 * 实名认证DTO
 * 
 * @ClassName: AuthenticationDto
 * @author hejiahua
 * @date 2017年11月6日 下午3:58:58
 *
 */
public class AuthenticationDto extends BaseDto {

    private static final long serialVersionUID = -107224253560112490L;

    /** 卡号 */
    private String acctNo;
    /** 姓名 */
    private String customerName;
    /** 银行预留手机号 */
    private String phoneNo;
    /** 证件类型 */
    private String cerdType;
    /** 证件号 */
    private String cerdId;

    
    
    public AuthenticationDto() {
        super();
        this.setProductId("03012");//默认2要素
        this.setTransId("21");//短信签约
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCerdType() {
        return cerdType;
    }

    public void setCerdType(String cerdType) {
        this.cerdType = cerdType;
    }

    public String getCerdId() {
        return cerdId;
    }

    public void setCerdId(String cerdId) {
        this.cerdId = cerdId;
    }

    @Override
    public String toString() {
        return "AuthenticationDto [acctNo=" + acctNo + ", customerName=" + customerName + ", phoneNo=" + phoneNo + ", cerdType="
                + cerdType + ", cerdId=" + cerdId + "]";
    }

}

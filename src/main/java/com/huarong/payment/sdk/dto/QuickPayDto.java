package com.huarong.payment.sdk.dto;

/**
 * 快捷支付业务模型
 * 
 * @author hjh
 *
 */
public class QuickPayDto extends BastDto {
    private static final long serialVersionUID = -6614118198471236729L;
    /** 卡号 */
    private String cardNo;
    /** 持卡人姓名 */
    private String cardName;
    /** 银行预留手机号 */
    private String phoneNo;
    /** 证件类型 */
    private String cardIdcardType;
    /** 卡类型 */
    private String cardType;
    /** 证件号 */
    private String cardIdcardNo;
    /** (信用)卡有效期 */
    private String expDate;
    /** (信用)卡安全码 */
    private String cvn2;
    /** 短信验证码 */
    private String veriCode;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCardIdcardType() {
        return cardIdcardType;
    }

    public void setCardIdcardType(String cardIdcardType) {
        this.cardIdcardType = cardIdcardType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardIdcardNo() {
        return cardIdcardNo;
    }

    public void setCardIdcardNo(String cardIdcardNo) {
        this.cardIdcardNo = cardIdcardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvn2() {
        return cvn2;
    }

    public void setCvn2(String cvn2) {
        this.cvn2 = cvn2;
    }

    public String getVeriCode() {
        return veriCode;
    }

    public void setVeriCode(String veriCode) {
        this.veriCode = veriCode;
    }

    @Override
    public String toString() {
        return "QuickPayDto [cardNo=" + cardNo + ", cardName=" + cardName + ", phoneNo=" + phoneNo + ", cardIdcardType="
                + cardIdcardType + ", cardType=" + cardType + ", cardIdcardNo=" + cardIdcardNo + ", expDate=" + expDate
                + ", cvn2=" + cvn2 + ", veriCode=" + veriCode + "]";
    }

}

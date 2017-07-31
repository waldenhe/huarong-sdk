package com.huarong.payment.sdk.dto;

/**
 * 报备业务模型
 * @author hjh
 *
 */
public class ReportDto extends BaseDto {

    private static final long serialVersionUID = 8627985461558850046L;
    
    private String agentId;
    private String payWay;
    private String subMechantName;
    private String business;
    private String contactInfo;
    private String addressInfo;
    private String subMerchantShortname;
    private String contact;
    private String contactPhone;
    private String contactEmail;
    private String merchantRemark;
    private String servicePhone;
    
    /**
     * 报备成功得到此字段
     */
    private String subMchId;
    
    public ReportDto() {
        this.setTransId("33");
        this.setVersion("V1.1");
    }
    
    public String getSubMchId() {
        return subMchId;
    }


    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getAgentId() {
        return agentId;
    }
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    public String getPayWay() {
        return payWay;
    }
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
    public String getSubMechantName() {
        return subMechantName;
    }
    public void setSubMechantName(String subMechantName) {
        this.subMechantName = subMechantName;
    }
    public String getBusiness() {
        return business;
    }
    public void setBusiness(String business) {
        this.business = business;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public String getAddressInfo() {
        return addressInfo;
    }
    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }
    public String getSubMerchantShortname() {
        return subMerchantShortname;
    }
    public void setSubMerchantShortname(String subMerchantShortname) {
        this.subMerchantShortname = subMerchantShortname;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getMerchantRemark() {
        return merchantRemark;
    }
    public void setMerchantRemark(String merchantRemark) {
        this.merchantRemark = merchantRemark;
    }
    public String getServicePhone() {
        return servicePhone;
    }
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }
    @Override
    public String toString() {
        return "ReportDto [agentId=" + agentId + ", payWay=" + payWay + ", subMechantName=" + subMechantName + ", business="
                + business + ", contactInfo=" + contactInfo + ", addressInfo=" + addressInfo + ", subMerchantShortname="
                + subMerchantShortname + ", contact=" + contact + ", contactPhone=" + contactPhone + ", contactEmail="
                + contactEmail + ", merchantRemark=" + merchantRemark + ", servicePhone=" + servicePhone + ", subMchId="
                + subMchId + "]";
    }
    
    
    
}

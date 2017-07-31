package com.huarong.payment.sdk.dto;

/**
 * 交易查询业务模型
 * @author hjh
 *
 */
public class TransQueryDto extends BaseDto{

    private static final long serialVersionUID = -8303070177778704739L;
    private String origRespCode;//    原交易应答码 交易成功：0000 
    private String origRespDesc;//    原交易应答码描述
    private String refundAmt;//   已退金额 单位为分
    /**
    *失败返回failed 
    *成功返回paied  
    *处理中/待支付返回(推荐通过查询产品类型识别处理中还是待支付)  ready  
     */
    private String payStatus;//  交易状态码 
    
    
    
    public TransQueryDto() {
        this.setTransId("04");
    }
    
    
    public String getOrigRespCode() {
        return origRespCode;
    }
    public void setOrigRespCode(String origRespCode) {
        this.origRespCode = origRespCode;
    }
    public String getOrigRespDesc() {
        return origRespDesc;
    }
    public void setOrigRespDesc(String origRespDesc) {
        this.origRespDesc = origRespDesc;
    }
    public String getRefundAmt() {
        return refundAmt;
    }
    public void setRefundAmt(String refundAmt) {
        this.refundAmt = refundAmt;
    }
    public String getPayStatus() {
        return payStatus;
    }
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    @Override
    public String toString() {
        return "TransQueryDto [origRespCode=" + origRespCode + ", origRespDesc=" + origRespDesc + ", refundAmt=" + refundAmt
                + ", payStatus=" + payStatus + "]";
    }
    
    
}

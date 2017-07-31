package com.huarong.payment.sdk.dto;

/**
 * 配置置微信公众号
 * @author hjh
 *
 */
public class SettingWxPublicNoDto extends BaseDto{

    private static final long serialVersionUID = -2209318790883548180L;
    
    private String agentId;
    private String subMchId;
    private String payWay;
    private String jsApiPath;
    private String subAppId;
    private String subScribeAppid;
    
    public SettingWxPublicNoDto() {
        this.setTransId("34");
        this.setVersion("V1.1");
    }
    
    
    
    public String getAgentId() {
        return agentId;
    }
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    public String getSubMchId() {
        return subMchId;
    }
    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }
    public String getPayWay() {
        return payWay;
    }
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
    public String getJsApiPath() {
        return jsApiPath;
    }
    public void setJsApiPath(String jsApiPath) {
        this.jsApiPath = jsApiPath;
    }
    public String getSubAppId() {
        return subAppId;
    }
    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }
    public String getSubScribeAppid() {
        return subScribeAppid;
    }
    public void setSubScribeAppid(String subScribeAppid) {
        this.subScribeAppid = subScribeAppid;
    }
    @Override
    public String toString() {
        return "SettingWxPublicNoDto [agentId=" + agentId + ", subMchId=" + subMchId + ", payWay=" + payWay + ", jsApiPath="
                + jsApiPath + ", subAppId=" + subAppId + ", subScribeAppid=" + subScribeAppid + "]";
    }
    
    
    
}

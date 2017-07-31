package com.huarong.payment.sdk.dto;

/**
 * 微信或支付宝业务模型
 * 
 * @author hjh
 *
 */
public class WxOrAlipayDto extends BaseDto {
    private static final long serialVersionUID = -4652493162558777454L;
    private String storeId;// 门店号 当产品为0107时，可输
    private String terminalId;// 终端号 当产品为0107时，可输
    private String openid;// 微信openid当产品为0106时，可输
    private String subMchId;// 二级商户编号(由报备商户接口获取)
    
    /**
     * 交易成功返回参数
     */
    private String codeUrl;// 二维码链接      扫码支付时返回 
    private String imgUrl;//  二维码图片      扫码支付时返回 
    private String payUrl;//  支付链接       公众号支付时返回，支付链接，在微信客户端上打开 
    private String params;//  公众号支付信息    公众号支付时返回，公众号原生支付所需参数组成的json串

    public WxOrAlipayDto() {
        this.setTransId("17");
    }
    
    
    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    @Override
    public String toString() {
        return "WxOrAlipayDto [storeId=" + storeId + ", terminalId=" + terminalId + ", openid=" + openid + ", subMchId="
                + subMchId + ", codeUrl=" + codeUrl + ", imgUrl=" + imgUrl + ", payUrl=" + payUrl + ", params=" + params + "]";
    }

}

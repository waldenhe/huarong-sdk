package com.huarong.payment.sdk.trans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.huarong.payment.sdk.dto.B2CPayDto;
import com.huarong.payment.sdk.dto.ProxyPayDto;
import com.huarong.payment.sdk.dto.QuickPayDto;
import com.huarong.payment.sdk.dto.ReportDto;
import com.huarong.payment.sdk.dto.SettingWxPublicNoDto;
import com.huarong.payment.sdk.dto.TransQueryDto;
import com.huarong.payment.sdk.dto.WxOrAlipayDto;
import com.huarong.payment.sdk.enums.ResponseEnum;
import com.huarong.payment.sdk.exception.PayException;
import com.huarong.payment.sdk.uitls.BrowseUtil;
import com.huarong.payment.sdk.uitls.ConfigUtils;

public class DefaultTransApiTest {

    /**
     * 快捷支付
     * 
     * @throws Exception
     */
    @Test
    public void testQuickTrans() throws Exception {
        TransApi<QuickPayDto> transApi = new DefaultTransApi<>();
        QuickPayDto quickPayDto = new QuickPayDto();
        quickPayDto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        quickPayDto.setTransAmt("1");
        quickPayDto.setCardName("张三");
        quickPayDto.setCardNo("6217003170000000000");
        quickPayDto.setPhoneNo("13600000000");
        quickPayDto.setCardIdcardType("01");
        quickPayDto.setCardType("01");
        quickPayDto.setCardIdcardNo("512501197203035172");
        quickPayDto.setExpDate("");
        quickPayDto.setCvn2("");
        quickPayDto.setCommodityName("测试商品");
        // 第一步签约
        transApi.trans(quickPayDto);
        // 第二步支付
        quickPayDto.setVeriCode("666666");
        transApi.trans(quickPayDto);
    }

    /**
     * 代付
     * 
     * @throws Exception
     */
    @Test
    public void testProxyPay() throws Exception {
        TransApi<ProxyPayDto> transApi = new DefaultTransApi<ProxyPayDto>();
        ProxyPayDto payDto = new ProxyPayDto();
        payDto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        payDto.setTransAmt("1");
        payDto.setAcctNo("6223095840010507868");
        payDto.setIsCompay("0");
        payDto.setCustomerName("李四");
        payDto.setNote("测试商品");
        transApi.trans(payDto);
    }

    @Test
    public void testB2C() throws Exception {
        /**
         * 注意此处是为了演示跳转效果，切勿使用到生产环境
         **/
        B2CPayDto dto = new B2CPayDto();
        dto.setMerNo(ConfigUtils.getProperty("merchant_no"));
        dto.setBankCode("ICBC");
        dto.setOrderNo(System.currentTimeMillis() + "");
        dto.setTransAmt("1");
        dto.setCommodityName("测试商品");
        B2CTransApi.openUrl(dto);

        // 生产环境使用response输出流输出outHtml
        dto = B2CTransApi.getInstance().trans(dto);
        System.out.println(dto.getHtmlData());
    }

    /**
     * 交易查询
     * 
     * @throws Exception
     */
    @Test
    public void testTransQuery() throws Exception {
        TransApi<TransQueryDto> transApi = new DefaultTransApi<TransQueryDto>();
        TransQueryDto dto = new TransQueryDto();
        dto.setOrderNo("20170731111134");
        transApi.trans(dto);
    }

    /**
     * 报备
     * 
     * @throws Exception
     * @throws PayException
     */
    @Test
    public void testReport() throws PayException, Exception {
        TransApi<ReportDto> api = new DefaultTransApi<>();
        ReportDto dto = new ReportDto();
        /** 公共字段 */
        dto.setAgentId("");
        dto.setSubMechantName("深圳市华融电子支付科技有限公司");
        dto.setSubMerchantShortname("华融支付");// 微信界面显示的收款方
        dto.setContact("贺家华");
        dto.setContactPhone("13192466906");
        dto.setContactEmail("940417907@qq.com");
        dto.setMerchantRemark("备注信息");
        dto.setServicePhone("400-6000583");

        /** 微信报备 */
        dto.setPayWay("WX");
        dto.setBusiness("203");// 参考字典文件中的类目（微信跟支付宝分别不一样）
        api.trans(dto);

        /** 支付宝报备 */
        dto.setPayWay("ALIPAY");
        dto.setBusiness("2015062600002758");// 参考字典文件中的类目（微信跟支付宝分别不一样）
        dto.setContactInfo("{\"name\":\"贺家华\",\"type\":\"OTHER\"}");
        // 商户地址信息(json信息体)信息中要求的地区编码
        dto.setAddressInfo(
                "{\"province_code\":\"440000\",\"city_code\":\"440300\",\"district_code\":\"440304\",\"address\":\"联合广场A座302\"}");
        api.trans(dto);
    }

    /**
     * 配置微信公众号
     * 
     * @throws Exception
     * @throws PayException
     */
    @Test
    public void testSettingWxPublicNo() throws PayException, Exception {
        TransApi<SettingWxPublicNoDto> api = new DefaultTransApi<>();
        SettingWxPublicNoDto dto = new SettingWxPublicNoDto();
        dto.setAgentId("");
        dto.setSubMchId("40091673");

        /** 一次只能配置一个 */

        // JS授权目录(一个商户号不能超过五个)
        dto.setJsApiPath("https://www.lt66my.cn/demo1/");
        api.trans(dto);
        // 关联公众号APPID
        // dto.setSubAppId("wx8f7c2a61b8e914ac");
        // api.trans(dto);
        // 推荐关注公众号APPID
        /*
         * dto.setSubScribeAppid("wx8f7c2a61b8e914ac"); api.trans(dto);
         */

    }

    /**
     * 微信公众号支付
     * 
     * @throws Exception
     * @throws PayException
     */
    @Test
    public void testWxOrAlipay106() throws PayException, Exception {
        TransApi<WxOrAlipayDto> api = new DefaultTransApi<>();
        WxOrAlipayDto dto = new WxOrAlipayDto();
        /***** 请仔细阅读一下内容避免测试过程出现各种问题 *****/

        // 微信公众号支付步骤：
        // 第一步报备 ，注意点：商户名称必须跟公众号主体名称一致，否则公众号会配置不了。
        // 第二步
        // 2.1配置关联的公众号 2.2 配置微信公众号jsApi授权目录：自己系统的网站唤起jsapi支付的目录
        // 第三步开始测试公众号支付

        // 微信公众号支付方式
        // 第一种通过支付链接跳转去支付：需要配置微信公众号授权目录为：http://spdbweb.chinacardpos.com/payment-gate-web/gateway/
        // 第二种通过返回的原生支付数据去支付：需要配置微信公众号授权目录为自己网站的jsapi支付的目录。

        dto.setProductId("0106");
        dto.setSubMchId("40091673");
        dto.setTransAmt("100");
        dto.setCommodityName("测试商品");
        dto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

        // 如果要测试(部分测试环境因为没有ICP报备不便测试)的话：可以登录微信公众号在用户管理里面随意点击一个用户然后跳转到如下一个地址：
        // https://mp.weixin.qq.com/cgi-bin/singlesendpage?t=message/send&action=index&tofakeid=oZA6OwokWko0fNr1X5DrvTM1bV8c&token=1965779734&lang=zh_CN
        // 复制地址中的tofakeid就是openId
        // 生产环境openId获取方式。参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
        dto.setOpenid("oZA6OwokWko0fNr1X5DrvTM1bV8c");

        // 如果传了OpenId就会返回dto.getParams()和dto.getPayUrl(),否则返回dto.getPayUrl()
        if (ResponseEnum.API_ERROE_CODE_P000.getRespCode().equals(dto.getRespCode())) {
            BrowseUtil.openUrl(dto.getPayUrl());
        }
        // 微信jsapi唤醒支付方式：https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=7_7&index=6
        dto.getParams();

        api.trans(dto);
    }

    /**
     * 支付宝扫码支付
     * 
     * @throws Exception
     * @throws PayException
     */
    @Test
    public void testWxOrAlipay107() throws PayException, Exception {
        TransApi<WxOrAlipayDto> api = new DefaultTransApi<>();
        WxOrAlipayDto dto = new WxOrAlipayDto();
        // 支付宝扫码支付,注意：支付宝使用沙箱环境测试，需要安装测试沙箱测试版本的支付宝去支付。推荐直接使用生产环境测试即可。
        dto.setProductId("0107");
        dto.setSubMchId("2088621879773594");
        dto.setTransAmt("100");
        dto.setCommodityName("测试商品");
        dto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        api.trans(dto);
        if (ResponseEnum.API_ERROE_CODE_P000.getRespCode().equals(dto.getRespCode())) {
            BrowseUtil.openUrl(dto.getImgUrl());
        }
    }

    /**
     * 微信扫码支付
     * 
     * @throws Exception
     * @throws PayException
     */
    @Test
    public void testWxOrAlipay108() throws PayException, Exception {
        TransApi<WxOrAlipayDto> api = new DefaultTransApi<>();
        WxOrAlipayDto dto = new WxOrAlipayDto();
        // 微信扫码支付
        dto.setProductId("0108");
        dto.setSubMchId("40091673");
        dto.setTransAmt("100");
        dto.setCommodityName("测试商品");
        dto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        api.trans(dto);
        if (ResponseEnum.API_ERROE_CODE_P000.getRespCode().equals(dto.getRespCode())) {
            BrowseUtil.openUrl(dto.getImgUrl());
        }
    }
}

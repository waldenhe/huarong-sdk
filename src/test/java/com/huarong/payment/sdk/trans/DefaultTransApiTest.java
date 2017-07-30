package com.huarong.payment.sdk.trans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.huarong.payment.sdk.dto.ProxyPayDto;
import com.huarong.payment.sdk.dto.QuickPayDto;
import com.huarong.payment.sdk.uitls.ConfigUtils;

public class DefaultTransApiTest {
	
	
	@Test
	public void testQuickTrans() throws Exception {
		TransApi<QuickPayDto> transApi = new DefaultTransApi<>();
		QuickPayDto quickPayDto = new QuickPayDto();
		quickPayDto.setRequestNo(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		quickPayDto.setVersion("V1.0");
		quickPayDto.setMerNo(ConfigUtils.getProperty("merchant_no"));
		quickPayDto.setOrderDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
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
		//第一步签约
		transApi.trans(quickPayDto);
		//第二步支付
		quickPayDto.setVeriCode("666666");
		transApi.trans(quickPayDto);
	}
	@Test
	public void testProxyPay() throws Exception {
		TransApi<ProxyPayDto> transApi = new DefaultTransApi<ProxyPayDto>();
		ProxyPayDto payDto = new ProxyPayDto();
		payDto.setRequestNo(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		payDto.setVersion("V1.0");
		payDto.setMerNo(ConfigUtils.getProperty("merchant_no"));
		payDto.setOrderDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		payDto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		payDto.setTransAmt("1");
		payDto.setAcctNo("6223095840010507868");
		payDto.setIsCompay("0");
		payDto.setCustomerName("李四");
		payDto.setNote("测试商品");
		transApi.trans(payDto);
	}
}

package com.huarong.payment.sdk.trans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.huarong.payment.sdk.dto.ProxyPayDto;
import com.huarong.payment.sdk.dto.QuickPayDto;
import com.huarong.payment.sdk.dto.TransQueryDto;
/**
 * 交易查询测试类
 * @author hjh
 *
 */
public class TransQueryApiTest {
	
	
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
		payDto.setOrderNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		payDto.setTransAmt("1");
		payDto.setAcctNo("6223095840010507868");
		payDto.setIsCompay("0");
		payDto.setCustomerName("李四");
		payDto.setNote("测试商品");
		transApi.trans(payDto);
	}
	@Test
	public void testTransQuery() throws Exception{
	    TransApi<TransQueryDto> transApi = new DefaultTransApi<TransQueryDto>();
	    TransQueryDto dto = new TransQueryDto();
	    dto.setOrderNo("20170731111134");
        transApi.trans(dto);
	}
}

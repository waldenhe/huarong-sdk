package com.huarong.payment.sdk.trans;

import org.junit.Test;

import com.huarong.payment.sdk.dto.B2CPayDto;
import com.huarong.payment.sdk.uitls.ConfigUtils;

public class B2CTransApiTest {
	@Test
	public void testOpen() throws Exception {
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
}

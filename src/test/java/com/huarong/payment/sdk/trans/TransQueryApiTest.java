package com.huarong.payment.sdk.trans;

import org.junit.Test;

import com.huarong.payment.sdk.dto.TransQueryDto;
/**
 * 交易查询测试类
 * @author hjh
 *
 */
public class TransQueryApiTest {
	@Test
	public void testTransQuery() throws Exception{
	    TransApi<TransQueryDto> transApi = new DefaultTransApi<TransQueryDto>();
	    TransQueryDto dto = new TransQueryDto();
	    dto.setOrderNo("20170731111134");
	    dto.setOrderDate("20170731");
        transApi.trans(dto);
	}
}

package com.huarong.payment.sdk.trans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import com.huarong.payment.sdk.dto.BaseDto;
import com.huarong.payment.sdk.enums.ResponseEnum;
import com.huarong.payment.sdk.exception.PayException;
import com.huarong.payment.sdk.uitls.BeanToMapUtil;
import com.huarong.payment.sdk.uitls.ConfigUtils;
import com.huarong.payment.sdk.uitls.HttpRequestSimple;
import com.huarong.payment.sdk.uitls.SignUtils;

public  class DefaultTransApi<T extends BaseDto> implements TransApi<T>{
	
	/**
	 * 通用接口调用方法
	 * @param t
	 * @return 
	 * @throws Exception
	 */
	public T trans(T t) throws Exception{
		try {
			Map<String, Object> map = t.toMap();
			List<BasicNameValuePair> list = new ArrayList<>();
			for (String key : map.keySet()) {
				Object value = map.get(key);
				if (value != null && StringUtils.isNotEmpty(value.toString())) {
					list.add(new BasicNameValuePair(key, value.toString()));
				}
			}
			//加签
			list.add(new BasicNameValuePair("signature", SignUtils.signData(list)));
			
			String result = HttpRequestSimple.getInstance().postPramaList(list, ConfigUtils.getProperty("trans_url"));
			if (null == result) {
				return null;
			}else {
				if (SignUtils.verferSignData(result)) {
					map = BeanToMapUtil.strToMap(result);
					BeanToMapUtil.transMap2Bean(map, t);
					return t;
				}else {
					throw new PayException(ResponseEnum.API_ERROE_CODE_0012);
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

}

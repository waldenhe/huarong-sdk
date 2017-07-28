package com.huarong.payment.sdk.uitls;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xiaoleilu.hutool.io.FileUtil;

public class SignUtils {
	public static final Logger logger = LoggerFactory.getLogger(SignUtils.class);
	private static String preivateKeyStr = FileUtil
			.readString(FileUtil.file(ConfigUtils.getProperty("private_key_path")), "UTF-8");
	private static String publicKeyStr = FileUtil.readString(FileUtil.file(ConfigUtils.getProperty("public_key_path")),
			"UTF-8");

	public static String signData(Map<String, String> nvps) throws Exception {

		StringBuffer buf = new StringBuffer();
		for (String key : nvps.keySet()) {
			buf.append(key).append("=").append((String) nvps.get(key)).append("&");
		}
		String signatureStr = buf.substring(0, buf.length() - 1);
		String signData = RSAUtil.signByPrivate(signatureStr, preivateKeyStr, "UTF-8");
		logger.info("请求数据:{},签名数据:{}", signatureStr, signData);
		return signData;
	}
	
	public static String signDataObject(Map<String, Object> nvps) throws Exception {

		StringBuffer buf = new StringBuffer();
		for (String key : nvps.keySet()) {
			Object value = nvps.get(key);
			if (value != null && StringUtils.isNotEmpty(String.valueOf(value))) {
				buf.append(key).append("=").append(value).append("&");
			}
		}
		String signatureStr = buf.substring(0, buf.length() - 1);
		String signData = RSAUtil.signByPrivate(signatureStr, preivateKeyStr, "UTF-8");
		logger.info("请求数据:{},签名数据:{}", signatureStr, signData);
		return signData;
	}

	public static String signData(List<BasicNameValuePair> nvps) throws Exception {
		TreeMap<String, String> tempMap = new TreeMap<String, String>();
		for (BasicNameValuePair pair : nvps) {
			if (StringUtils.isNotBlank(pair.getValue())) {
				tempMap.put(pair.getName(), pair.getValue());
			}
		}
		StringBuffer buf = new StringBuffer();
		for (String key : tempMap.keySet()) {
			buf.append(key).append("=").append((String) tempMap.get(key)).append("&");
		}
		String signatureStr = buf.substring(0, buf.length() - 1);
		String signData = RSAUtil.signByPrivate(signatureStr,
				RSAUtil.readFile(ConfigUtils.getProperty("private_key_path"), "UTF-8"), "UTF-8");
		logger.info("请求数据:{},签名数据:{}", signatureStr, signData);
		return signData;
	}

	public static boolean verferSignData(String str) {
		logger.info("响应数据：{}", str);
		String data[] = str.split("&");
		StringBuffer buf = new StringBuffer();
		String signature = "";
		for (int i = 0; i < data.length; i++) {
			String tmp[] = data[i].split("=", 2);
			if ("signature".equals(tmp[0])) {
				signature = tmp[1];
			} else {
				buf.append(tmp[0]).append("=").append(tmp[1]).append("&");
			}
		}
		String signatureStr = buf.substring(0, buf.length() - 1);
		logger.info("验签数据：{}", signatureStr);
		return RSAUtil.verifyByKeyPath(signatureStr, signature, publicKeyStr, "UTF-8");
	}

}

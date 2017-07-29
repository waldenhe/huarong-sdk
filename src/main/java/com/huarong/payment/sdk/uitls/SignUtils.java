package com.huarong.payment.sdk.uitls;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import com.huarong.payment.sdk.uitls.RSAUtil.KeyInfo;


public class SignUtils {
	
	public static void main(String[] args) throws Exception {
		Map<String, String> notifyMap = new TreeMap<String, String>();
		notifyMap.put("merNo", "850440060123923");
		notifyMap.put("orderNo","201702271846_41324_19580");
		notifyMap.put("transAmt","500");
		notifyMap.put("respCode", "0000");
		notifyMap.put("orderDate", "20170227");
		notifyMap.put("productId","0208");
		notifyMap.put("respDesc","11");
		notifyMap.put("transId", "01");
		//merNo=850440060123923&orderDate=20170227&orderNo=201702271608_41318_19580&productId=0208&respCode=null&respDesc=null&transAmt=500000&transId=01
		//merNo=850440060123923&orderDate=20170227&orderNo=201702271846_41324_19580&productId=0208&respCode=null&respDesc=null&transAmt=500&transId=01
		StringBuffer buf = new StringBuffer();
        for (String key : notifyMap.keySet()) {
            buf.append(key).append("=").append((String) notifyMap.get(key)).append("&");
        }
        String signatureStr = buf.substring(0, buf.length() - 1);
        signatureStr="cardIdcardNo=421023198811248318&cardIdcardType=01&cardName=薛彦&cardNo=6222023602090704941&cardType=01&merNo=850440058121001&notifyUrl=http://weipan.wsyun.com/ashx/sanwingpaycallback.ashx&orderDate=20170417&orderNo=20170417152333830&phoneNo=13265997782&productId=0301&requestNo=20170417152333911&transAmt=1&transId=13&version=V1.0";
        KeyInfo keyInfo = RSAUtil.getPFXPrivateKey(ConfigUtils.getProperty("private_key_pfx_path"),
                                                   ConfigUtils.getProperty("private_key_pwd"));
        String signData = RSAUtil.signByPrivate(signatureStr, keyInfo.getPrivateKey(), "UTF-8");
        System.out.println("请求数据：" + signatureStr + "&signature=" + signData);
        System.out.println(RSAUtil.verify(signatureStr,signData,keyInfo.getPublicKey(), "UTF-8"));
        System.out.println(RSAUtil.signByPrivate("123abc"	, "-----BEGIN PRIVATE KEY-----MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANt7NLB8Emt0R9nQZqeg/EuDyk7I4/zdwjTUcSi1G0KbkPSGZxlSzjarL5yFUEUieILwZcgnidHcN7d1Bnj9sPmy4Ao0+6DoqKK+Mg7KsQSOPTugkDcOMlxeZSIGD4wKX5gsTsijthSQ4+QVEM5QsrYKbzAoXfH9gn+3wqEjFJyFAgMBAAECgYEAp41cAOsG6M9BVs/YvlmQoVl/5TtJiS4F52zS4j+4CtZWB8ZfCJ8FXAi9dSD00YJqO5OoL++3L+WNB1moUk9hfSP48LTc25QXb9lSDuPNJocAMifh+EirzzW9uDoLkSFZOgwPwQ+stuYP15uhZbla7ekQRVYiDYIRe4oJOd2Oa8ECQQDzy5fFnGQ+J9PQY47n1t7pt6AngEroNYcpbalzSTgcRmy9HzVNiP6gNCZv2Nh2jKjaNHfIpp7LvxKOBE7gceVRAkEA5ngDCu+gYL53ZYfYZyHVBWpijtqnyhbD+ckrQmAEF7d+Fb/02IdIPq8Bc3+UKwWZZ6TI7gyFoV3WxECbQ2BG9QJBAIjfUtRVG0pyHc8vNfoffoME3tuOgX+hHcM6mBnrj58AQuhi7xAay6mx3aqJue3Exr/LGT0Dnr+RBJ/K92W3TCECQBdQsM4ca9cdraqB0aytSYWgu5PEHxFcuDq+1TeDyyYzE/hTUQvOs8pTngv3LiAkEt7fVsxuS96FRcLY3lw0kzkCQQDeNeJK8PLxeSjYonMEmzoD8S6lzUn+K46Ij5OI76BbRJ12oxOrdGjrNZ7BcBwUPD78ndPRzwOhtQl1L3HAYJ2l-----END PRIVATE KEY-----", "UTF-8"));
        
	}
	
    public static String signData(Map<String, String> nvps) throws Exception {

        StringBuffer buf = new StringBuffer();
        for (String key : nvps.keySet()) {
            buf.append(key).append("=").append((String) nvps.get(key)).append("&");
        }
        String signatureStr = buf.substring(0, buf.length() - 1);
        /*KeyInfo keyInfo = RSAUtil.getPFXPrivateKey(ConfigUtils.getProperty("private_key_pfx_path"),
                                                   ConfigUtils.getProperty("private_key_pwd"));
        String signData = RSAUtil.signByPrivate(signatureStr, keyInfo.getPrivateKey(), "UTF-8");*/
        String signData = RSAUtil.signByPrivate(signatureStr, RSAUtil.readFile(ConfigUtils.getProperty("private_key_path"), "UTF-8"), "UTF-8");
        System.out.println("请求数据：" + signatureStr + "&signature=" + signData);
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
        /*KeyInfo keyInfo = RSAUtil.getPFXPrivateKey(ConfigUtils.getProperty("private_key_pfx_path"),
                                                   ConfigUtils.getProperty("private_key_pwd"));
        String signData = RSAUtil.signByPrivate(signatureStr, keyInfo.getPrivateKey(), "UTF-8");*/
        String signData = RSAUtil.signByPrivate(signatureStr, RSAUtil.readFile(ConfigUtils.getProperty("private_key_path"), "UTF-8"), "UTF-8");
        System.out.println("请求数据：" + signatureStr + "&signature=" + signData);
        return signData;
    }

    public static boolean verferSignData(String str) {
        System.out.println("响应数据：" + str);
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
        System.out.println("验签数据：" + signatureStr);
        return RSAUtil.verifyByKeyPath(signatureStr, signature, ConfigUtils.getProperty("public_key_path"), "UTF-8");
    }
    
}

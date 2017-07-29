package com.huarong.payment.sdk.trans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.colotnet.util.ConfigUtils;
import com.colotnet.util.SSLClient;
import com.colotnet.util.SignUtils;

/**
 * 快捷支付
 * 
 * @author hjh
 *
 */
public class QuickPayConsumeTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        // authentication2();
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        authentication2();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            }).start();
        }
        /*
         * new Thread(new Runnable() {
         * 
         * @Override public void run() { for (int i = 0; i < 10; i++) { try {
         * authentication2(); } catch (Exception e) { e.printStackTrace(); } } }
         * }).start(); new Thread(new Runnable() {
         * 
         * @Override public void run() { for (int i = 0; i < 10; i++) { try {
         * authentication2(); } catch (Exception e) { e.printStackTrace(); } } }
         * }).start();
         */

        System.out.println("请选择你要操作的功能：");
        System.out.println("支付请选择：1，签约请选择：2，鉴权请选择3");
        Scanner scanner = new Scanner(System.in);
        int change = scanner.nextInt();
        String verifyCode = "";
        String spOrderId = "";
        switch (change) {
        case 1:
            System.out.println("请输入验证码：");
            verifyCode = scanner.next();
            System.out.println("请输入商户签约订单号：");
            spOrderId = scanner.next();
            quickPay(verifyCode, spOrderId);
            break;
        case 2:
            authentication();
            break;
        case 3:
            authentication2();
            break;
        default:
            System.out.println("该功能不存在。。。a32ded82b5954a8b81b6111fd383fda1");
            break;
        }

    }

    /**
     * 鉴权
     * 
     * @throws Exception
     */
    public static String authentication() throws Exception {

        DefaultHttpClient httpClient = new SSLClient();
        HttpPost postMethod = new HttpPost(ConfigUtils.getProperty("trans_url"));
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("requestNo", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())));
        nvps.add(new BasicNameValuePair("version", "V1.0"));
        nvps.add(new BasicNameValuePair("productId", "0301"));
        nvps.add(new BasicNameValuePair("transId", "13"));
        nvps.add(new BasicNameValuePair("merNo", ConfigUtils.getProperty("merchant_no")));
        nvps.add(new BasicNameValuePair("orderDate", new SimpleDateFormat("yyyyMMdd").format(new Date())));
        String orderNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        nvps.add(new BasicNameValuePair("orderNo", orderNo));
        nvps.add(new BasicNameValuePair("transAmt", "1"));
        nvps.add(new BasicNameValuePair("notifyUrl", "http"));
        nvps.add(new BasicNameValuePair("cardName", "贺家华"));
        nvps.add(new BasicNameValuePair("phoneNo", "13192466906"));
        nvps.add(new BasicNameValuePair("cardIdcardType", "01"));
        nvps.add(new BasicNameValuePair("cardType", "01"));
        nvps.add(new BasicNameValuePair("cardIdcardNo", "430482199309185873"));
        nvps.add(new BasicNameValuePair("cardNo", "6217003170000105785"));
        nvps.add(new BasicNameValuePair("expDate", ""));
        nvps.add(new BasicNameValuePair("cvn2", ""));
        nvps.add(new BasicNameValuePair("commodityName", "测试商品"));
        nvps.add(new BasicNameValuePair("signature", SignUtils.signData(nvps)));

        try {
            postMethod.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse resp = httpClient.execute(postMethod);
            String str = EntityUtils.toString(resp.getEntity(), "UTF-8");
            int statusCode = resp.getStatusLine().getStatusCode();
            if (200 == statusCode) {
                boolean signFlag = SignUtils.verferSignData(str);
                if (!signFlag) {
                    System.out.println("验签失败");
                    return null;
                }
                System.out.println("验签成功");
                System.out.println("商户订单号：" + orderNo);
                return orderNo;
            }
            System.out.println("返回错误码:" + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void quickPay(String verifyCode, String spOrderId) throws Exception {
        DefaultHttpClient httpClient = new SSLClient();
        HttpPost postMethod = new HttpPost(ConfigUtils.getProperty("trans_url"));
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("requestNo", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())));
        nvps.add(new BasicNameValuePair("version", "V1.0"));
        nvps.add(new BasicNameValuePair("productId", "0302"));
        nvps.add(new BasicNameValuePair("transId", "15"));
        nvps.add(new BasicNameValuePair("merNo", ConfigUtils.getProperty("merchant_no")));
        nvps.add(new BasicNameValuePair("orderNo", spOrderId));
        /*
         * nvps.add(new BasicNameValuePair("orderDate", new
         * SimpleDateFormat("yyyyMMdd").format(new Date()))); nvps.add(new
         * BasicNameValuePair("notifyUrl", "http")); nvps.add(new
         * BasicNameValuePair("transAmt", "1")); nvps.add(new
         * BasicNameValuePair("commodityName", "test")); 个人信息 nvps.add(new
         * BasicNameValuePair("cardName", "贺家华")); nvps.add(new
         * BasicNameValuePair("phoneNo", "13192466906")); nvps.add(new
         * BasicNameValuePair("cardIdcardType", "01")); nvps.add(new
         * BasicNameValuePair("cardType", "01")); nvps.add(new
         * BasicNameValuePair("cardIdcardNo", "430482199309185873"));
         * nvps.add(new BasicNameValuePair("cardNo", "6214836552379527"));
         */
        // nvps.add(new BasicNameValuePair("expDate", "2012"));
        // nvps.add(new BasicNameValuePair("cvn2", "332"));

        nvps.add(new BasicNameValuePair("veriCode", verifyCode));

        nvps.add(new BasicNameValuePair("signature", SignUtils.signData(nvps)));

        try {
            postMethod.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse resp = httpClient.execute(postMethod);
            String str = EntityUtils.toString(resp.getEntity(), "UTF-8");
            int statusCode = resp.getStatusLine().getStatusCode();
            if (200 == statusCode) {
                boolean signFlag = SignUtils.verferSignData(str);
                if (!signFlag) {
                    System.out.println("验签失败");
                    return;
                }
                System.out.println("验签成功");
                return;
            }
            System.out.println("返回错误码:" + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String authentication2() throws Exception {

        DefaultHttpClient httpClient = new SSLClient();
        HttpPost postMethod = new HttpPost(ConfigUtils.getProperty("trans_url"));
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("requestNo", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())));
        nvps.add(new BasicNameValuePair("version", "V1.0"));
        nvps.add(new BasicNameValuePair("productId", "0301"));
        nvps.add(new BasicNameValuePair("transId", "21"));
        nvps.add(new BasicNameValuePair("merNo", ConfigUtils.getProperty("merchant_no")));
        nvps.add(new BasicNameValuePair("orderDate", new SimpleDateFormat("yyyyMMdd").format(new Date())));
        String orderNo = System.currentTimeMillis() + "";
        nvps.add(new BasicNameValuePair("orderNo", orderNo));
        nvps.add(new BasicNameValuePair("cardName", "张三1"));
        nvps.add(new BasicNameValuePair("cardNo", "6217582000023632670"));
        nvps.add(new BasicNameValuePair("phoneNo", "15899855585"));
        nvps.add(new BasicNameValuePair("cardIdcardType", "01"));
        nvps.add(new BasicNameValuePair("cardIdcardNo", "43122419871102001X"));
        nvps.add(new BasicNameValuePair("commodityName", "测试鉴权"));
        nvps.add(new BasicNameValuePair("signature", SignUtils.signData(nvps)));

        try {
            postMethod.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse resp = httpClient.execute(postMethod);
            String str = EntityUtils.toString(resp.getEntity(), "UTF-8");
            int statusCode = resp.getStatusLine().getStatusCode();
            if (200 == statusCode) {
                boolean signFlag = SignUtils.verferSignData(str);
                if (!signFlag) {
                    System.out.println("验签失败");
                    return null;
                }
                System.out.println("验签成功");
                System.out.println("商户订单号：" + orderNo);
                return orderNo;
            }
            System.out.println("返回错误码:" + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

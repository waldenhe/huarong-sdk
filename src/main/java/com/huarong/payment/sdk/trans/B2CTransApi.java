package com.huarong.payment.sdk.trans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huarong.payment.sdk.dto.B2CPayDto;
import com.huarong.payment.sdk.uitls.BrowseUtil;
import com.huarong.payment.sdk.uitls.SignUtils;

public class B2CTransApi implements TransApi<B2CPayDto> {

    public static final Logger logger = LoggerFactory.getLogger(B2CTransApi.class);

    private static TransApi<B2CPayDto> instance = new B2CTransApi();

    public static TransApi<B2CPayDto> getInstance() {
        if (instance == null) {
            instance = new B2CTransApi();
        }
        return instance;
    }

    private B2CTransApi() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 构造提交表单HTML数据
     * 
     * @param sParaTemp
     *            请求参数数组
     * @param gateway
     *            网关地址
     * @param strMethod
     *            提交方式。两个值可选：post、get
     * @param strButtonName
     *            确认按钮显示文字
     * @return 提交表单HTML文本
     */
    private static String buildForm(Map<String, String> sParaTemp, String gateway) {
        // 待请求参数数组
        Set<String> keys = sParaTemp.keySet();

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"editForm\" name=\"editForm\" action=\"");
        sbHtml.append(gateway);
        sbHtml.append("\" method=\"");
        sbHtml.append("POST");
        sbHtml.append("\">");
        for (String name : keys) {
            String value = sParaTemp.get(name);
            sbHtml.append("<input type=\"hidden\" name=\"");
            sbHtml.append(name == null ? name : name.trim());
            sbHtml.append("\" value=\"");
            sbHtml.append(value == null ? value : value.trim());
            sbHtml.append("\"/>");
            logger.info(name + "=============" + value);
        }
        // submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"充值\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['editForm'].submit();</script>");
        return sbHtml.toString();
    }

    private static String buildHtmlForm(Map<String, String> sParaTemp, String gateway) throws IOException {
        StringBuffer htmlBuf = new StringBuffer();
        htmlBuf.append("<html>");
        htmlBuf.append(" <head><title>sender</title></head>");
        htmlBuf.append(" <body>");
        htmlBuf.append(buildForm(sParaTemp, gateway));
        htmlBuf.append(" </body>");
        htmlBuf.append("</html>");
        String link = "d://test.html";
        File file = new File(link);
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write(htmlBuf.toString().getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;

    }

    private static Map<String, String> getMapValues(B2CPayDto dto) throws Exception {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("requestNo", dto.getRequestNo());
        map.put("version", dto.getVersion());
        map.put("productId", dto.getProductId());
        map.put("transId", dto.getTransId());
        map.put("merNo", dto.getMerNo());
        map.put("orderDate", dto.getOrderDate());
        map.put("orderNo", dto.getOrderNo());
        map.put("commodityName", dto.getCommodityName());
        map.put("transAmt", dto.getTransAmt());
        map.put("bankCode", dto.getBankCode());
        map.put("returnUrl", dto.getReturnUrl());// 修改对应地址
        map.put("notifyUrl", dto.getNotifyUrl());// 修改对应地址
        map.put("signature", SignUtils.signData(map));
        return map;
    }

    /**
     * 生产使用
     * 
     * @param dto
     *            网关业务模型
     * @return
     * @throws Exception
     */
    private String createxinfupayUrl(B2CPayDto dto) throws Exception {
        // 组装接口参数，并进行加密
        Map<String, String> map = getMapValues(dto);
        return buildForm(map, dto.getTrans_url());
    }

    /**
     * 该方法仅供测试使用
     * 
     * @param dto
     * @throws Exception
     */
    public static void openUrl(B2CPayDto dto) throws Exception {
        // 组装接口参数，并进行加密
        Map<String, String> map = getMapValues(dto);
        String link = buildHtmlForm(map, dto.getTrans_url());
        BrowseUtil.openUrl(link);
    }

    @Override
    public B2CPayDto trans(B2CPayDto t) throws Exception {
        t.setHtmlData(createxinfupayUrl(t));
        return t;
    }
}

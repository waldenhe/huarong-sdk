package com.huarong.payment.sdk.trans;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.huarong.payment.sdk.notify.CallBack;
import com.huarong.payment.sdk.notify.IOrderNotify;
import com.huarong.payment.sdk.notify.OrderNotifyImpl;

/**
 * 异步通知测试类
 * @author hjh
 *
 */
public class NotifyApiTest {

    @Test
    public void testNotify() throws UnsupportedEncodingException {
        CallBack callBackTest = new CallBackTest();
        //需要使用TreeMap,因为是通过Key默认排序验签
        Map<String, String> map = new TreeMap<>();
        
        //模拟数据
        String result = URLDecoder.decode(
                "respCode=0000&orderNo=20170731115540&acctNo=6214836552379527&transId=01&orderDate=20170731&respDesc=%E4%BA%A4%E6%98%93%E6%88%90%E5%8A%9F&transAmt=1&signature=GvadbH3v0%2BMwJ%2BJxduwj9Z%2BYrHjhi55IgIVuYxujiUTWwn706%2BzvW%2FYuC9YlNCLEN8v%2F1W0cbl6r4F6gAe%2BU2%2FGYpL7ZrVAfwIvG3ybjofcHXtDRIIM%2FMoDRphlmeXU6xZaXHTIiCbO4IRVHZ%2B8BY08FHrBWNgoibw%2FoP5yzkD8T%2Bk8CU%2FaPFXZyrifW3dkXyGCP8%2BDMNV5N0%2FM%2BsFq53MhhDcGKRzVl4Zp%2F1vYnscOq6EgdQOe1fBp3kK6xB0MJxCixwDZWtfJg8nGAR%2BeIegNTcz%2BZNtDIS1TUEwj790tM%2FdmmKxSLzQb9Z8hpYevubu8tpurEBdnioofz6ZuLsQ%3D%3D&merNo=850440058121001&productId=0302",
                "utf-8");

        String[] data = result.split("&");
        for (int i = 0; i < data.length; i++) {
            String[] params = data[i].split("=", 2);
            map.put(params[0], params[1]);
        }
        
        //生产环境数据获取方式：
        //BeanToMapUtil.initRequestMap(null, map);
        
        IOrderNotify orderNotify = new OrderNotifyImpl();
        
        //以异步通知结果为准（注意修改订单成功或失败后需要锁单，避免二次通知）,如果未收到商户返回的SUCCESS,总共会通知八次
        boolean notifyresult = orderNotify.asynchronousNotify(map, callBackTest);
        
        //异步通知处理成功/失败需要返回SUCCESS到华融平台
        System.out.println(notifyresult?"SUCCESS":"ERROR");
        
        //同步通知只处理图形化界面展示即可，不推荐处理业务逻辑
        orderNotify.synchronizationNotify(map, callBackTest);
    }

}

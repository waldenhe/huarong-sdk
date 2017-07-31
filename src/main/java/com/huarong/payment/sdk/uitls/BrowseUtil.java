package com.huarong.payment.sdk.uitls;

import java.io.File;

import com.xiaoleilu.hutool.io.FileUtil;

public class BrowseUtil {
    /**
     * 该方法仅供测试使用
     * 
     * @param dto
     * @throws Exception
     */
    public static void openUrl(String filePath) throws Exception {
        // 判断当前系统是否支持Java AWT Desktop扩展
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                // 获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                // 判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    // 获取系统默认浏览器打开链接
                    if (FileUtil.exist(filePath)) {
                        dp.open(new File(filePath));
                    }else{
                        //创建一个URI实例,注意不是URL
                        java.net.URI uri = java.net.URI.create(filePath);
                        dp.browse(uri);
                    }
                }
            } catch (java.lang.NullPointerException e) {
                // 此为uri为空时抛出异常
                System.out.println("无可用浏览器");
            } catch (java.io.IOException e) {
                // 此为无法获取系统默认浏览器
                System.out.println("无可用浏览器");
            }
        }
    }
}

package com.huarong.payment.sdk.trans;

import org.junit.Test;

import com.huarong.payment.sdk.dto.ReconciliationDto;
import com.huarong.payment.sdk.exception.PayException;
import com.huarong.payment.sdk.uitls.Base64;
import com.huarong.payment.sdk.uitls.Gzip;
import com.xiaoleilu.hutool.io.FileUtil;

/**
 * 对账文件下载测试类
 * 
 * @author hjh
 *
 */
public class ReconciliationApiTest {
    @Test
    public void testReconciliation() throws PayException, Exception {
        TransApi<ReconciliationDto> transApi = new DefaultTransApi<>();
        ReconciliationDto dto = new ReconciliationDto();
        dto.setStartDate("20170810");
        transApi.trans(dto);
        String datas = new String(Gzip.unzip(Base64.decode(dto.getFileContentDetail())), "UTF-8");
        System.out.println(datas);
        String path = "D://"+dto.getFileName();
        FileUtil.file(path);
        FileUtil.appendString(datas, path, "UTF-8");
        
    }
}

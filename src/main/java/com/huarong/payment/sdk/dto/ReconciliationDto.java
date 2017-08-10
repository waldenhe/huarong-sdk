package com.huarong.payment.sdk.dto;

/**
 * 对账业务模型
 * 
 * @author hjh
 *
 */
public class ReconciliationDto extends BaseDto {
    private static final long serialVersionUID = -5182577279336595368L;
    private String startDate;// 对账日期

    private String fileContentDetail;// 文件内容
    private String fileName;// 文件名

    public ReconciliationDto() {
        this.setTransId("14");
    }

    public String getFileContentDetail() {
        return fileContentDetail;
    }

    public void setFileContentDetail(String fileContentDetail) {
        this.fileContentDetail = fileContentDetail;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "ReconciliationDto [startDate=" + startDate + ", fileContentDetail=" + fileContentDetail + ", fileName=" + fileName
                + "]";
    }

}

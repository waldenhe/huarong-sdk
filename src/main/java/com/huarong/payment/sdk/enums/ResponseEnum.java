package com.huarong.payment.sdk.enums;


public enum ResponseEnum {
	/** 交易处理中 */
	API_ERROE_CODE_P000("P000", "交易处理中"),
	/** 待鉴权绑卡 */
	API_ERROE_CODE_T000("T000", "待鉴权绑卡"),
	/** 待短信验证 */
	API_ERROE_CODE_S000("S000", "待短信验证"),
	/** 交易成功 */
	API_ERROE_CODE_0000("0000", "交易成功"),
	/** 请求参数非法 */
	API_ERROE_CODE_0001("0001", "请求参数非法 "),
	/** 商户号不能为空 */
	API_ERROE_CODE_0002("0002", "商户号不能为空 "),
	/** 商户订单号不能为空 */
	API_ERROE_CODE_0003("0003", "商户订单号不能为空 "),
	/** 银行预留手机号不能为空 */
	API_ERROE_CODE_0004("0004", "银行预留手机号不能为空 "),
	/** 交易金额不能为空 */
	API_ERROE_CODE_0005("0005", "交易金额不能为空 "),
	/** 卡号不能为空 */
	API_ERROE_CODE_0006("0006", "卡号不能为空 "),
	/** CVN2不能为空 */
	API_ERROE_CODE_0007("0007", "CVN2不能为空 "),
	/** 信用卡有效期不能为空 */
	API_ERROE_CODE_0008("0008", "信用卡有效期不能为空 "),
	/** 验签字段不能为空 */
	API_ERROE_CODE_0009("0009", "验签字段不能为空 "),
	/** 商户信息不存在 */
	API_ERROE_CODE_0010("0010", "商户信息不存在 "),
	/** 商户状态异常 */
	API_ERROE_CODE_0011("0011", "商户状态异常 "),
	/** 校验签名失败 */
	API_ERROE_CODE_0012("0012", "校验签名失败 "),
	/** 商户密钥信息不存在 */
	API_ERROE_CODE_0013("0013", "商户密钥信息不存在"),
	/** 商户密钥已失效 */
	API_ERROE_CODE_0014("0014", "商户密钥已失效"),
	/** 获取商户密钥ID失败 */
	API_ERROE_CODE_0015("0015", "获取商户密钥ID失败"),
	/** 产品信息不存在 */
	API_ERROE_CODE_0016("0016", "产品信息不存在"),
	/** 产品信息状态异常 */
	API_ERROE_CODE_0017("0017", "产品信息状态异常"),
	/** 未授权的交易 */
	API_ERROE_CODE_0018("0018", "未授权的交易"),
	/** 渠道约束信息为空 */
	API_ERROE_CODE_0019("0019", "渠道约束信息为空"),
	/** 不支持的卡类型 */
	API_ERROE_CODE_0020("0020", "不支持的卡类型"),
	/** 不支持借记卡交易 */
	API_ERROE_CODE_0021("0021", "不支持借记卡交易"),
	/** 不支持贷记卡交易 */
	API_ERROE_CODE_0022("0022", "不支持贷记卡交易"),
	/** 订单号重复 */
	API_ERROE_CODE_0023("0023", "订单号重复"),
	/** 订单信息保存失败 */
	API_ERROE_CODE_0024("0024", "订单信息保存失败"),
	/** 验证银行结果签名失败 */
	API_ERROE_CODE_0025("0025", "验证银行结果签名失败"),
	/** 支付信息保存失败 */
	API_ERROE_CODE_0026("0026", "支付信息保存失败"),
	/** 未知交易类型 */
	API_ERROE_CODE_0027("0027", "未知交易类型"),
	/** 原交易不存在 */
	API_ERROE_CODE_0028("0028", "原交易不存在"),
	/** 原交易状态异常 */
	API_ERROE_CODE_0029("0029", "原交易状态异常"),
	/** 交易金额超限 */
	API_ERROE_CODE_0030("0030", "交易金额超限"),
	/** 路由筛选失败 */
	API_ERROE_CODE_0031("0031", "路由筛选失败"),
	/** 交易金额非法 */
	API_ERROE_CODE_0032("0032", "交易金额非法"),
	/** 银行卡信息保存失败 */
	API_ERROE_CODE_0033("0033", "银行卡信息保存失败"),
	/** 当天交易不支持退款 */
	API_ERROE_CODE_0034("0034", "当天交易不支持退款"),
	/** 原交易已撤销 */
	API_ERROE_CODE_0035("0035", "原交易已撤销"),
	/** 非当天交易不支持撤销 */
	API_ERROE_CODE_0036("0036", "非当天交易不支持撤销"),
	/** 原交易已发起撤销或退货 */
	API_ERROE_CODE_0037("0037", "原交易已发起撤销或退货"),
	/** 不支持的银行卡 */
	API_ERROE_CODE_0038("0038", "不支持的银行卡"),
	/** 原交易不支持撤销 */
	API_ERROE_CODE_0039("0039", "原交易不支持撤销"),
	/** 上一笔撤销交易正在处理中 */
	API_ERROE_CODE_0040("0040", "上一笔撤销交易正在处理中"),
	/** 上一笔退货交易正在处理中 */
	API_ERROE_CODE_0041("0041", "上一笔退货交易正在处理中"),
	/** 账户余额不足 */
	API_ERROE_CODE_0042("0042", "余额不足"),
	/** 生成代付单失败 */
	API_ERROE_CODE_0043("0043", "生成代付单失败"),
	/** 订单状态异常 */
	API_ERROE_CODE_0044("0044", "商品订单状态异常"),
	/** 支付订单状态异常 */
	API_ERROE_CODE_0045("0045", "支付订单状态异常"),
	/** 交易限额超限 */
	API_ERROE_CODE_0046("0046", "交易限额超限"),
	/** 交易金额与原交易不符 */
	API_ERROE_CODE_0047("0047", "交易金额与原交易不符"),
	/** 交易金额与原交易不符 */
	API_ERROE_CODE_0048("0048", "联行号不存在"),
	/** 交易时间点限制 */
	API_ERROE_CODE_0049("0049", "该时间段不允许交易"),
	/** 交易时间点限制 */
	API_ERROE_CODE_0050("0050", "订单日期无效。"),
	/** 短信验证码请求过于频繁,请稍后再试 */
	API_ERROE_CODE_0051("0051", "短信验证码请求过于频繁,请稍后再试"),
	/** 手机号非法 */
	API_ERROE_CODE_0052("0052", "手机号非法"),
	/** 短信验证码错误次数过多,请稍候再试 */
	API_ERROE_CODE_0053("0053", "短信验证码错误次数过多,请稍候再试"),
	/** 未获取短信验证码或短信验证码为空 */
	API_ERROE_CODE_0054("0054", "未获取短信验证码或短信验证码为空"),
	/** 短信验证码不能为空 */
	API_ERROE_CODE_0055("0055", "短信验证码不能为空"),
	/** 短信验证码错误 */
	API_ERROE_CODE_0056("0056", "短信验证码错误"),
	/** 交易日期格式错误 */
	API_ERROE_CODE_0057("0057", "文件获取日期格式错误"),
	/** 查询日期范围不能超过31天 */
	API_ERROE_CODE_0058("0058", "查询日期范围不能超过"),
	/** 获取卡号信息异常 */
	API_ERROE_CODE_0059("0059", "获取卡号信息异常"),
	/** 当前交易无需发送短信 */
	API_ERROE_CODE_0060("0060", "当前交易无需发送短信"),
	/** 交易不支持退款 */
	API_ERROE_CODE_0061("0061", "交易不支持退款"),
	/** 获取微信授权信息失败 */
	API_ERROE_CODE_0062("0062", "获取微信授权信息失败"),
	/** 获取微信授权信息失败 */
	API_ERROE_CODE_0063("0063", "获取微信配置信息失败"),
	/** 获取微信授权信息失败 */
	API_ERROE_CODE_0064("0064", "微信对账ftp创建文件失败"),
	/** 短信验证码超时,请重新获取 */
	API_ERROE_CODE_0065("0065", "短信验证码超时,请重新获取"),
	/** 卡类型不匹配 */
	API_ERROE_CODE_0066("0066", "卡类型不匹配"),
	/** 银行卡签约失败 */
	API_ERROE_CODE_0067("0067", "银行卡签约失败"),
	/** 交易数据不正确 */
	API_ERROE_CODE_0068("0068", "交易数据不正确"),
	/** 该笔交易存在风险不允许交易 **/
	API_ERROE_CODE_0070("0070", "该笔交易存在风险不允许交易"),
	/** 超过大额付款时间点，请您择日提交 **/
	API_ERROE_CODE_0071("0071", "超过大额付款时间点，请您择日提交"),
	/**对公商户收款信息不对*/
	API_ERROE_CODE_0072("0072", "对公商户收款信息不对"),
	/** 交易已退汇 */
	API_ERROE_CODE_9995("9995", "交易已退汇"),
	/** 交易已退货 */
	API_ERROE_CODE_9996("9996", "交易已退货"),
	/** 交易结果未知 */
	API_ERROE_CODE_9997("9997", "交易结果未知"),
	/** 交易失败 */
	API_ERROE_CODE_9998("9998", "交易失败"),
	/** 系统异常 */
	API_ERROE_CODE_9999("9999", "系统异常");

	private String respCode;
	private String respMsg;

	private ResponseEnum(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public static String getResponseEnumValue(String respCode) {
		for (ResponseEnum responseEnum : ResponseEnum.values()) {
			if (responseEnum.getRespCode().equals(respCode)) {
				return responseEnum.getRespMsg();
			}
		}
		return null;
	}

	public static ResponseEnum getResponseEnum(String respCode) {
		for (ResponseEnum responseEnum : ResponseEnum.values()) {
			if (respCode.equals(responseEnum.getRespCode())) {
				return responseEnum;
			}
		}
		return null;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

}

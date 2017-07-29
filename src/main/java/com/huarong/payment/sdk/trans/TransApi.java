package com.huarong.payment.sdk.trans;


public interface TransApi<T> {
	public T trans(T t) throws Exception;
}

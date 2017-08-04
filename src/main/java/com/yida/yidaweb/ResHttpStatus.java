package com.yida.yidaweb;

/**
 * 返回json数据
 * @author Administrator
 *
 */
public class ResHttpStatus {

	// 返回http状态码
	private String code;
	
	// 返回状态消息
	private String msg;
	
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}

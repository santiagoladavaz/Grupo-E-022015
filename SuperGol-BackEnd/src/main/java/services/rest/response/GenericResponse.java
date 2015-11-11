package services.rest.response;

import java.io.Serializable;

public class GenericResponse implements Serializable{

	
	private Object param;
	private String msg;
	
	
	public Object getParam() {
		return param;
	}
	public void setParam(Object param) {
		this.param = param;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}

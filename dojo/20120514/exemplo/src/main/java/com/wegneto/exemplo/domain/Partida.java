package com.wegneto.exemplo.domain;

import java.util.Date;

public class Partida {

	private Date data;

	private String time1;

	private String time2;
	
	public Partida(Date data, String time1, String time2) {
		super();
		this.data = data;
		this.time1 = time1;
		this.time2 = time2;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

}

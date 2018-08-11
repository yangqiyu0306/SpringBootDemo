package com.yqy.model;

import java.io.Serializable;

public class Menu implements Serializable{

	private String COpCde;//操作代码
	private String CParentCde;//上级代码
	private String COpNme;//操作代码简称
	private String COpAct;//操作行为
	private int NOpOrder;//显示顺序
	private String CIcon;//图标
	public String getCOpCde() {
		return COpCde;
	}
	public void setCOpCde(String cOpCde) {
		COpCde = cOpCde;
	}
	public String getCParentCde() {
		return CParentCde;
	}
	public void setCParentCde(String cParentCde) {
		CParentCde = cParentCde;
	}
	public String getCOpNme() {
		return COpNme;
	}
	public void setCOpNme(String cOpNme) {
		COpNme = cOpNme;
	}
	public String getCOpAct() {
		return COpAct;
	}
	public void setCOpAct(String cOpAct) {
		COpAct = cOpAct;
	}
	public int getNOpOrder() {
		return NOpOrder;
	}
	public void setNOpOrder(int nOpOrder) {
		NOpOrder = nOpOrder;
	}
	public String getCIcon() {
		return CIcon;
	}
	public void setCIcon(String cIcon) {
		CIcon = cIcon;
	}
} 

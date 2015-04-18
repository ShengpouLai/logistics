package com.lsp.logistics.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ToPage extends ActionSupport {
	
	public String costomerAddPage(){
		return "costomerAdd";
	}
	public String costomerFindPage(){
		return "costomerFind";
	}
	public String firstGoodsAddPage(){
		return "firstGoodsAdd";
	}
}

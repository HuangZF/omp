package com.ruyicai.omp.domain.tcash;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson
public class TcashDetail {

	private String id;

	private String userno;

	private String ttransactionid;

	private String name;

	private String provcode;

	private String areacode;

	private String provname;

	private String areaname;

	private BigDecimal amt;

	private BigDecimal fee;

	private Date plattime;

	private String bankname;

	private String bankaccount;

	private BigDecimal state;

	private String subbankname;
	
	private String rejectReason;
	
	private BigDecimal type;
	
	private String batchno;
	
	private Date modifytime;
	
	private Date checktime;
	
	private Date remittime;
	
	private Date estimatefinishtime;
	
	private Date finishtime;
	
	private String operator;
}

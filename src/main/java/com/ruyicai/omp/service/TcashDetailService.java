package com.ruyicai.omp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ruyicai.omp.domain.TcashDetail;

@Service
public class TcashDetailService {

	public List<TcashDetail> queryTcashDetailList()
	{
		List<TcashDetail> gridModel = new ArrayList<TcashDetail>();
		for(int i =0;i<100;i++)
		{
			TcashDetail td = new TcashDetail();
			td.setId(String.valueOf(i));
			td.setUserno(String.valueOf(i));
			td.setTtransactionid(String.valueOf(i));
			td.setName("tcashName" + String.valueOf(i));
			td.setProvcode(String.valueOf(i));
			td.setAreacode(String.valueOf(i));
			td.setProvname("tcashProvname" + String.valueOf(i));
			td.setProvname("tcashAreaname" + String.valueOf(i));
			td.setAmt(new BigDecimal(i));
			td.setFee(new BigDecimal(i));
			td.setPlattime(new Date());
			td.setBankname("bankname" + String.valueOf(i));
			td.setBankaccount(String.valueOf(i));
			td.setState(new BigDecimal(i));
			td.setSubbankname("subbankname" + String.valueOf(i));
			td.setRejectReason("rejectReason" + String.valueOf(i));
			td.setType(new BigDecimal(i));
			td.setBatchno(String.valueOf(i));
			td.setModifytime(new Date());
			td.setChecktime(new Date());
			td.setRemittime(new Date());
			td.setEstimatefinishtime(new Date());
			td.setFinishtime(new Date());
			td.setOperator("operator" + String.valueOf(i));
			
			gridModel.add(td);
		}
		return gridModel;
	}
}

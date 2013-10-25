package com.ruyicai.omp.service.tcash;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ruyicai.omp.domain.tcash.TcashDetail;
import com.ruyicai.omp.service.support.ManagerSupport;
import com.ruyicai.omp.util.JqGridSearchTo;
import com.ruyicai.omp.util.SearchOperationUtil;
import com.ruyicai.omp.util.StringBuilderUtil;

@Service
public class TcashDetailService extends ManagerSupport{

	// test data
	public List<TcashDetail> queryTcashDetailListTest()
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

	/**
	 * 获取提现信息
	 * @param jqGridSearchTo
	 * @param pageSize
	 * @param pageNum
	 * @param orderByColumn
	 * @param orderByType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TcashDetail> queryTcashDetailList(JqGridSearchTo jqGridSearchTo, int pageSize, int pageNum, String orderByColumn, String orderByType) throws Exception
	{
		String orderByString = StringBuilderUtil.getOrderByString(orderByColumn, orderByType);
		if(jqGridSearchTo!=null){
			Map<String,Object> conditions = SearchOperationUtil.getSqlConditionsMap(jqGridSearchTo);
			conditions.put("orderByString", orderByString);			
			if("AND".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
				return (List<TcashDetail>)dao.findObjectsByPage("getTcashDetailListWhereAnd", conditions, pageSize, pageNum);
			}else if("OR".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
				return (List<TcashDetail>)dao.findObjectsByPage("getTcashDetailListWhereOr", conditions, pageSize, pageNum);				
			}
		}

		return (List<TcashDetail>)dao.findObjectsByPage("getTcashDetailListNoWhere", orderByString, pageSize, pageNum);
	}

	/**
	 * 获取提现信息数量
	 * @param jqGridSearchTo
	 * @return
	 */
	public int countTcashDetail(JqGridSearchTo jqGridSearchTo) throws Exception
	{
		if(jqGridSearchTo != null){
			Map<String,Object> conditions = SearchOperationUtil.getSqlConditionsMap(jqGridSearchTo);
			if("AND".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
				return (Integer)dao.findObjectByProperties("countTcashDetailWhereAnd", conditions);
			}else if("OR".equalsIgnoreCase(jqGridSearchTo.getGroupOp())){
				return (Integer)dao.findObjectByProperties("countTcashDetailWhereOr", conditions);
			}
		}

		return (Integer)dao.findObjectByProperties("countTcashDetailNoWhere");

	}
}

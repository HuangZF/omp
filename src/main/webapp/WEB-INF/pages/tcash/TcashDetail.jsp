<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <sj:head jqueryui="true" jquerytheme="redmond" />
  </head>
  <body>
    <body>
    	<s:url var="remoteurl" action="tcash_queryTcashDetail"/>
	    <sjg:grid
	        id="gridtable"
	        caption="提现信息"
	        dataType="json"
	        href="%{remoteurl}"
	        pager="true"
	        gridModel="gridModel"
	        rowList="10,15,20"
	        rowNum="15"
	        rownumbers="true"
	        width="1000"
	    >
	        <sjg:gridColumn name="id" index="id" title="提现明细标识" width="20" formatter="integer" sortable="false"/>
	        <sjg:gridColumn name="userno" index="userno" title="账户标识" width="20" hidden="true" sortable="true"/>
	        <sjg:gridColumn name="ttransactionid" index="ttransactionid" width="20" title="交易标识" sortable="false"/>
	        <sjg:gridColumn name="name" index="name" title="姓名" width="20" sortable="false"/>
	        <sjg:gridColumn name="provcode" index="provcode" title="省代码" width="20" hidden="true" sortable="false"/>
	        <sjg:gridColumn name="areacode" index="areacode" title="地区代码" width="20" hidden="true" sortable="false"/>
	        <sjg:gridColumn name="provname" index="provname" title="省名称" width="20" hidden="true" sortable="false"/>
	        <sjg:gridColumn name="areaname" index="areaname" title="地市名称" width="20"  hidden="true" sortable="false"/>
	        <sjg:gridColumn name="amt" index="amt" title="提现金额(单位：分)"  width="20" sortable="false"/>
	        <sjg:gridColumn name="fee" index="fee" title="手续费(单位：分)"  width="20" sortable="false"/>
	        <sjg:gridColumn name="plattime" index="plattime" title="提现时间" width="30"  sortable="false"/>
	        <sjg:gridColumn name="bankname" index="bankname" title="开户行名称"  width="30" sortable="false"/>
	        <sjg:gridColumn name="bankaccount" index="bankaccount" title="银行账号" width="30"  sortable="false"/>
	        <sjg:gridColumn name="state" index="state" title="支付状态"  width="20" sortable="false"/>
	        <sjg:gridColumn name="subbankname" index="subbankname" title="银行渠道" width="20" hidden="true"  sortable="false"/>
	        <sjg:gridColumn name="rejectReason" index="rejectReason" title="驳回原因"  width="20" hidden="true" sortable="false"/>
	        <sjg:gridColumn name="type" index="type" title="提现类型"  width="20" sortable="false"/>
	        <sjg:gridColumn name="batchno" index="batchno" title="批次号" hidden="true" width="20" sortable="false"/>
	        <sjg:gridColumn name="modifytime" index="modifytime" title="最后修改时间" width="30" sortable="false"/>
	        <sjg:gridColumn name="checktime" index="checktime" title="审核时间" width="30" sortable="false"/>
	        <sjg:gridColumn name="remittime" index="remittime" title="银行汇款时间" width="30" sortable="false"/>
	        <sjg:gridColumn name="estimatefinishtime" index="estimatefinishtime" title="估计完成时间" width="30" hidden="true" sortable="false"/>
	        <sjg:gridColumn name="finishtime" index="finishtime" title="成功时间"  width="30" sortable="false"/>
	        <sjg:gridColumn name="operator" index="operator" title="操作员"  width="20" sortable="false"/>
	    </sjg:grid>
  </body>

  </body>
</html>
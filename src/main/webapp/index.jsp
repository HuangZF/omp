<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head jqueryui="true"/>
  </head>
  <body>
  		<s:url var="remoteurl" action="query_queryTcashDetail.action" />
		<sj:a href="%{remoteurl}" targets="main_content" cssStyle="font-style:bold;">查询提现信息</sj:a>
  </body>
</html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<sj:head jqueryui="true" jquerytheme="redmond" />
	<!--<sj:head locale="zh-CN" jqueryui="true" jquerytheme="%{theme}"
			customBasepath="templates/themes" loadAtOnce="true" compressed="false"
			loadFromGoogle="false" debug="true" />-->
</head>
<body>
	<div id="errMsg">
		<br />
	</div>
	<div>
		<img id="indicator" src="images/indicator.gif" alt="Loading..."
			style="display: none" />
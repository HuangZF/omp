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
    	<s:url var="remoteurl" action="jsontable/ssjdemo"/>
	    <sjg:grid
	        id="gridtable"
	        caption="SSJDemo"
	        dataType="json"
	        href="%{remoteurl}"
	        pager="true"
	        gridModel="gridModel"
	        rowList="10,15,20"
	        rowNum="15"
	        rownumbers="true"
	    >
	        <sjg:gridColumn name="id" index="id" title="ID" formatter="integer" sortable="false"/>
	        <sjg:gridColumn name="name" index="name" title="Name" sortable="true"/>
	        <sjg:gridColumn name="country" index="country" title="Country" sortable="false"/>
	        <sjg:gridColumn name="city" index="city" title="City" sortable="false"/>
	        <sjg:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" formatter="currency" sortable="false"/>
	    </sjg:grid>
  </body>

  </body>
</html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
  <head>
    <sj:head jqueryui="true" jquerytheme="redmond" />
  </head>
  <body>
    <body>
    	<s:url var="remoteurl" action="jsontable"/>
	    <sjg:grid
	        id="gridtable"
	        caption="Customer Examples"
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
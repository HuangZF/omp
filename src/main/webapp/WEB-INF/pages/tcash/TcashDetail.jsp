<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="../commonhead.jsp" %>
<body>
	<div id="errMsg">
		<br />
	</div>
	<div>
		<img id="indicator" src="images/indicator.gif" alt="Loading..."
			style="display: none" />
		<s:url var="remoteurl" action="tcash_queryTcashDetail" />
		<s:url var="editUrl" action="tcash_edit" />
		<sjg:grid 
			id="gridtable" 
			caption="提现信息列表" 
			dataType="json"
			href="%{remoteurl}" 
			pager="true"
			gridModel="gridModel"
			rowList="10,15,20" 
			rowNum="15"
			rownumbers="true"
			filter="true"
			filterOptions="{stringResult:true,searchOnEnter :true,enableClear: true}"
			viewrecords="true"
	    	navigator="true"
	    	navigatorEdit="true"
	    	navigatorView="true"
	    	navigatorDelete="true"
	    	navigatorSearch="true"
		    navigatorAdd="true"
		    navigatorRefresh="true"
		    altRows="true"
		    hidegrid="true"
		    multiselect="true"
		    editurl="%{editUrl}"
		    sortname="id" 
            sortorder="desc" 
            sortable="true"
		    resizable="true"
		    autowidth="true"
			onErrorTopics="getErrorMsg">
				<sjg:gridColumn name="id" index="id" title="提现明细标识" width="20" editable="true" search="true" searchoptions="{searchhidden:true,sopt:['cn']}"
					formatter="integer" sortable="true" />
				<sjg:gridColumn name="userno" index="userno" title="账户标识" width="20" editable="true" search="true" searchoptions="{searchhidden:true,sopt:['cn']}"
					hidden="true" sortable="true" />
				<sjg:gridColumn name="ttransactionid" index="ttransactionid" editable="true" search="true" searchoptions="{searchhidden:true,sopt:['cn']}"
					width="20" title="交易标识" sortable="true" />
				<sjg:gridColumn name="name" index="name" title="姓名" width="20" editable="true" search="true" searchoptions="{searchhidden:true,sopt:['cn']}"
					sortable="true" />
				<sjg:gridColumn name="provcode" index="provcode" title="省代码" editable="true"
					width="20" hidden="true" sortable="false" />
				<sjg:gridColumn name="areacode" index="areacode" title="地区代码" editable="false"
					width="20" hidden="true" sortable="false" />
				<sjg:gridColumn name="provname" index="provname" title="省名称" editable="false"
					width="20" hidden="true" sortable="false" />
				<sjg:gridColumn name="areaname" index="areaname" title="地市名称" editable="false"
					width="20" hidden="true" sortable="false" />
				<sjg:gridColumn name="amt" index="amt" title="提现金额(单位：分)" width="20" editable="false"
					sortable="false" />
				<sjg:gridColumn name="fee" index="fee" title="手续费(单位：分)" width="20" editable="false"
					sortable="false" />
				<sjg:gridColumn name="plattime" index="plattime" title="提现时间" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="bankname" index="bankname" title="开户行名称" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="bankaccount" index="bankaccount" title="银行账号" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="state" index="state" title="支付状态" width="20" editable="false"
					sortable="false" />
				<sjg:gridColumn name="subbankname" index="subbankname" title="银行渠道" editable="false"
					width="20" hidden="true" sortable="false" />
				<sjg:gridColumn name="rejectReason" index="rejectReason" title="驳回原因" editable="false"
					width="20" hidden="true" sortable="false" />
				<sjg:gridColumn name="type" index="type" title="提现类型" width="20" editable="false"
					sortable="false" />
				<sjg:gridColumn name="batchno" index="batchno" title="批次号" editable="false"
					hidden="true" width="20" sortable="false" />
				<sjg:gridColumn name="modifytime" index="modifytime" title="最后修改时间" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="checktime" index="checktime" title="审核时间" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="remittime" index="remittime" title="银行汇款时间" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="estimatefinishtime" index="estimatefinishtime" editable="false"
					title="估计完成时间" width="30" hidden="true" sortable="false" />
				<sjg:gridColumn name="finishtime" index="finishtime" title="成功时间" editable="false"
					width="30" sortable="false" />
				<sjg:gridColumn name="operator" index="operator" title="操作员" editable="false"
					width="20" sortable="false" />
		</sjg:grid>
	</div>
	
	<script type="javascript/text" src="js/grid.js"></script>
</body>
</html>
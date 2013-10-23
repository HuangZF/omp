$.subscribe('showcolumns', function(event, data) {
	//:not([id*='table'])代表id中不包括table字样的页面元素，subgrid自动生成的html标签为id="grid_user_127_table"
	//其中grid_user是父grid的名字,127是父grid中选中的行的id,我们不想让subgrid也可以修改和删除以及显示/隐藏列，所以要把subgrid过滤掉
	//$(":not([id*='table'])").jqGrid('setColumns', {top:100,left:200,width:300,colnameview:false,jqModal:true,modal:true});
	//$(":not([id*='table'])").jqGrid('columnChooser'); //3.1.1 new vision
	//$("table[id^='grid_']").jqGrid('columnChooser');
	if(data){
		$(data).jqGrid('columnChooser');
	}else{
		$("table[id^='grid_']").jqGrid('columnChooser');
	}
});

$.subscribe('rowadd', function(event,data) {
	//*代表所有页面元素,id^=grid代表所有以grid开头的id, 关于setColumns的参数详见：http://www.trirand.com/jqgridwiki/doku.php?id=wiki:show_hide_columns
	//$("*[id^=grid]").jqGrid('editGridRow',"new",{closeAfterAdd:true,reloadAfterSubmit:false}); 
	// $(":not([id*='table'])").jqGrid('editGridRow',"new",{closeAfterAdd:true,reloadAfterSubmit:true,modal:true,
	$("table[id^='grid_']").jqGrid('editGridRow',"new",{closeAfterAdd:true,reloadAfterSubmit:true,modal:true,
		errorTextFormat: function (data) {
			if (data.responseText.substr(0, 6) == "<html ") {
				return jQuery(data.responseText).html();
			}
			else {
				var responseJson = eval('('+data.responseText+')');
				return responseJson.errInfo;
				// or default display
				// return "Status: '" + data.statusText + "'. Error code: " +data.status;
			}
		}
	});         
});

$.subscribe('rowedit', function(event,data) {
	var id = $("table[id^='grid']").jqGrid('getGridParam', 'selrow');
	if(id == null){
		alert("请选择一条数据！");
	}else{
		//$(":not([id*='table'])").jqGrid('editGridRow',id,{closeAfterEdit:true,reloadAfterSubmit:true,modal:true,
		$("table[id^='grid_']").jqGrid('editGridRow',id,{closeAfterEdit:true,reloadAfterSubmit:true,modal:true,
			errorTextFormat: function (data) {
				if (data.responseText.substr(0, 6) == "<html ") {
					return jQuery(data.responseText).html();
				}
				else {
					var responseJson = eval('('+data.responseText+')');
					return responseJson.errInfo;
				}
			}});
	};
});
$.subscribe('rowdel', function(event, data) {
	//得到选择的id数组ids，selarrrow是内置属性，获取的是选择行的数据库中的id，不是当页的行数。
	var ids = $("table[id^=grid]").jqGrid('getGridParam', 'selarrrow');
	if(ids.length == 0){
		alert("请选择要删除的数据！");
	}else{
		$("table[id^='grid_']").jqGrid('delGridRow', ids, {
			height : 280,
			reloadAfterSubmit : true,
			modal:true,
			errorTextFormat: function (data) {
				if (data.responseText.substr(0, 6) == "<html ") {
					return jQuery(data.responseText).html();
				}
				else {
					var responseJson = eval('('+data.responseText+')');
					return responseJson.errInfo;
				}
			}
		});
	};
});	  	

$.subscribe('viewgrid', function(event,data) {
	var id = $("table[id^='grid']").jqGrid('getGridParam', 'selrow');
	if(id == null){
		alert("请选择一条数据！");
	}else{
		//$(":not([id*='table'])").jqGrid('editGridRow',id,{closeAfterEdit:true,reloadAfterSubmit:true,modal:true,
		$("table[id^='grid_']").jqGrid('viewGridRow',id,{closeAfterEdit:true,reloadAfterSubmit:true,modal:true,
			errorTextFormat: function (data) {
				if (data.responseText.substr(0, 6) == "<html ") {
					return jQuery(data.responseText).html();
				}
				else {
					var responseJson = eval('('+data.responseText+')');
					return responseJson.errInfo;
				}
			}});
	};
});

$.subscribe('searchgrid', function(event,data) {
	$("table[id^=grid_]").jqGrid('searchGrid', {sopt:['cn','eq','lt','gt']} );
});

//日期选择
$.subscribe('onDpChangeMonthAndYear', function(event,data) {
	alert('Change month to : '+event.originalEvent.month+' and year to '+event.originalEvent.year);
});
$.subscribe('onDpClose', function(event,data) {
	alert('Selected Date : '+event.originalEvent.dateText);
});         	

var for_confirm = function(str){
	var vaild = window.confirm(str);
	if(vaild)
	{
		return true;
	}
	return false;	
} 	

//错误处理
$.subscribe('getErrorMsg',function(event,data) {
	var errText = event.originalEvent.request.responseText;
	//alert(jQuery.parseJSON(errText).errInfo);
	// 2012-12-26 CHL UPDATE 【多处登录】列表操作显示错误消息  START
//	$.jgrid.info_dialog($.jgrid.errors.errcap,'<div class="ui-state-error">'+jQuery.parseJSON(errText).errInfo +'</div>', $.jgrid.edit.bClose,{buttonalign:'right'});
	if(!errText || errText == "")
	{
		return;
	}else if(errText.indexOf("This session has been expired") >= 0)
	{
//		window.location.href("login.jsp?message="+encodeURIComponent("您的账号已经在别处登录，请确认后重新登录！"));
		$.jgrid.info_dialog($.jgrid.errors.errcap,'<div class="ui-state-error">您的账号已经在别处登录，请确认后重新登录！</div>', $.jgrid.edit.bClose,{buttonalign:'right'});
	}else
	{
		$.jgrid.info_dialog($.jgrid.errors.errcap,'<div class="ui-state-error">'+jQuery.parseJSON(errText).errInfo +'</div>', $.jgrid.edit.bClose,{buttonalign:'right'});
	}
	// 2012-12-26 CHL UPDATE 【多处登录】列表操作显示错误消息  END
	//$("#assignButton").attr({"disabled":"disabled"});//将按钮禁用
	//$("#back").focus();
	//20120827 ouyang add 【错误提示被dialog遮挡】 start
	$('#info_dialog').css('z-index',10000);
	//20120827 ouyang add 【错误提示被dialog遮挡】 end
});

function isError(response,postdata){ 
	var text = response.responseText;

	if(text == '\r\n'){
		return [true,''];
	}else{
		return [false,getErrorText(response)];
	}
}

//获取错误内容
function getErrorText(response){
	// 错误内容定义
	var errText;

	// 编辑错误内容
	if(response.status == 403){
		errText = '你没有权限操作此功能！';
	}else{
		var errElm = $(response.responseText).find('li');
		if(errElm.length > 0){
			errText = $(response.responseText).find('li')[0].innerHTML;
		}else{
			errText = '系统错误，请联系技术人员！';
		}
	}
	// 返回错误内容
	return errText;
}

//返回父窗口
$.subscribe('goBack',function(){history.back(-1);});

/**   
 * 对Date的扩展，将 Date 转化为指定格式的 String   
 * 月 (M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符   
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
 * eg:   
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
 * (new Date()).pattern("yyyy-MM- dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04   
 * (new Date()).pattern("yyyy- MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04   
 * (new Date()).pattern("yyyy-MM- dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04   
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18   
 */    
Date.prototype.pattern=function(fmt) {     
	var o = {     
			"M+" : this.getMonth()+1, //月份     
			"d+" : this.getDate(), //日     
			"h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时     
					"H+" : this.getHours(), //小时     
					"m+" : this.getMinutes(), //分     
					"s+" : this.getSeconds(), //秒     
					"q+" : Math.floor((this.getMonth()+3)/3), //季度     
					"S" : this.getMilliseconds() //毫秒     
	};     
	var week = {     
			"0" : "\u65e5",     
			"1" : "\u4e00",     
			"2" : "\u4e8c",     
			"3" : "\u4e09",     
			"4" : "\u56db",     
			"5" : "\u4e94",     
			"6" : "\u516d"    
	};     
	if(/(y+)/.test(fmt)){     
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));     
	}     
	if(/(E+)/.test(fmt)){     
		fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);     
	}     
	for(var k in o){     
		if(new RegExp("("+ k +")").test(fmt)){     
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));     
		}     
	}     
	return fmt;     
}

/*
 * 页面可以复制
 document.oncontextmenu = function(e){return false;} 
 document.oncopy = function(e){return false;}
 document.oncut = function(e){return false;}
 document.onselectstart = function(e){return false;}
 */

/*
 * 获取画面显示宽度。
 * 根据浏览器宽度和预想宽度确定显示宽度；浏览器宽度*百分比小于预想宽度时按照浏览器宽度显示。
 * @param percent 显示宽度百分比
 * @param expWidth 预想宽度
 */
function getWidthByPercent(percent,expWidth){
	var dispWidth = parseInt(document.body.clientWidth * percent);
	if(dispWidth > expWidth){
		return expWidth;
	}else{
		return dispWidth;
	}
}

/**
 * 数据文字自动换行和列合并。
 * 支持数据文字自动换行；支持把第二列以后的单元格删除后合并到第二列。
 * @param str 需要合并列的行名称字符串(复数时用逗号分隔)
 */
function autoWorkBreak(str)
{
	// 设置数据文字换行
	$('.form-view-data').css('white-space','normal');
	$('.form-view-data').css('word-wrap','break-word');

	// 合并列
	if(str && str != "")
	{
		// 解析合并列
		var strArr = str.split(',');
		// 逐个合并
		for(var i=0; i<strArr.length;i=i+1)
		{
			if($("#trv_"+strArr[i]) && $("#trv_"+strArr[i]).find('td').length > 2)
			{
				$("#trv_"+strArr[i]).children('td').eq(1).attr('colspan','3');
				$("#trv_"+strArr[i]).children('td').eq(2).remove();
				$("#trv_"+strArr[i]).children('td:last').remove();
			}
		}
	}
}

/*
 * 文本框最大长度限制。
 * 由于IE不支持文本框的maxlength属性，通过本方法实现最大长度。
 * @param elm 文本框
 * @param maxlength 最大长度
 */
function doTextareaMaxlength(elm,maxlength){
	if(elm.value.length > maxlength){
		elm.value = elm.value.substr(0,maxlength);
	}
}

/* 列表显示完成事件 (显示小计与合计)*/
function showSumRow(gridName)
{
	// 显示合计行
	var trs = $("tr[id^="+gridName+"ghead_]");
	if(trs && trs.length > 0){
		// 最后合计行显示
		var trLast = $("#"+gridName).find("tr:last");
		if(trLast && trLast.length > 0){
			trLast.attr("id",gridName+"ghead_"+(2*trs.length-1));
			trLast.css("display","table-row");
		}
		// 其他合计行显示
		var prevElm;
		var j = 1;
		for(;j<trs.length;j=j+1){
			prevElm = $(trs[j]).prev();
			prevElm.attr("id",gridName+"ghead_"+(2*j-1));
			prevElm.css("display","table-row");
			$(trs[j]).attr("id",gridName+"ghead_"+(2*j));
			$(trs[j]).find("span.tree-wrap-ltr").attr("onClick","jQuery('#"+gridName+"').jqGrid('groupingToggle','"+gridName+"ghead_"+(2*j)+"');return false;");
		}
	}
}

// 通用trim()
String.prototype.trim=function() {  
	return this.replace(/(^\s*)|(\s*$)/g,'');  
};

// 编辑子列表参数
// 解决点开2个子表时，不能正常添加
function editSubAddData(params,posdata){
	for(var attr in posdata)
	{
		if(attr && attr.length > 9 && attr.substr(attr.length-9) == "_table_id"){
			var pid = attr.substring(0,attr.length-9);
			pid = pid.substr(pid.lastIndexOf("_")+1);
			return {"rowid":pid};
		}
	}
	return {};
}

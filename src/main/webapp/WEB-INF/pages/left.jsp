<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
  <head>
    <link rel="stylesheet" rev="stylesheet" href="styles/x3.css" type="text/css" id="css"/>
    <title>运营管理平台</title>
    <!-- 如果使用Tomcat6做服务器，页面不会有乱码。如果用weblogic9，则使用火狐时获取的grid.locale-zh-CN.js是以gb2312来解码的，而这个文件是utf-8编码的，所以会有乱码 -->
    <!-- 如果使用weblogic9则可能需要修改服务器字符集为utf-8 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <sj:head locale="zh-CN" jqueryui="true" jquerytheme="%{theme}"
        customBasepath="templates/themes" loadAtOnce="true"
        compressed="false" loadFromGoogle="false" debug="true" />
    <style>
        .commonFont {font-size: 14px; font-style: normal;}
    </style>
    <link rel="stylesheet" type="text/css" href="jat/style.css" />
</head>
<body>
  <div class="sidebarmenu">
                
                <a class="menuitem submenuheader" href="">系统管理</a>
                <div class="submenu">
	                <ul>
	                	<li><a href="###" target="mainFrame" >用户管理</a></li>
	                	<li><a href="###" target="mainFrame" >用户管理</a></li>
	                	<li><a href="###" target="mainFrame" >用户管理</a></li>
	                	<li><a href="###" target="mainFrame" >用户管理</a></li>
					</ul>
				</div>
                <a class="menuitem submenuheader" href="">提现管理</a>
                <div class="submenu">
	                <ul>
	                	<li><a href="tcash_showPage" target="mainFrame" >提现信息</a></li>
					</ul>
				</div>
                <a class="menuitem" href="">Blue button</a>
                <a class="menuitem_green" href="">Green button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                <a class="menuitem_red" href="">Red button</a>
                
   </div>
   
<script type="text/javascript" src="jat/ddaccordion.js"></script>
<script type="text/javascript">
  ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='jat/images/plus.gif' class='statusicon' />", "<img src='jat/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>
</body>
</html> 
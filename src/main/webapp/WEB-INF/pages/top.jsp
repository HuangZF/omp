<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
    <title>运营管理平台</title>
    <!-- 如果使用Tomcat6做服务器，页面不会有乱码。如果用weblogic9，则使用火狐时获取的grid.locale-zh-CN.js是以gb2312来解码的，而这个文件是utf-8编码的，所以会有乱码 -->
    <!-- 如果使用weblogic9则可能需要修改服务器字符集为utf-8 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <sj:head locale="zh-CN" jqueryui="true" jquerytheme="%{theme}" customBasepath="templates/themes" 
        loadAtOnce="true" compressed="false" loadFromGoogle="false" debug="true" />

    <link rel="stylesheet" rev="stylesheet" href="styles/x3.css" type="text/css" id="css"/>
    <style>
        .commonFont {font-size: 14px; font-style: normal;}
    </style>
</head>

<body>
    <div id="head-nav">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" >
            <tr>
                <th scope="col">
                    <div id="logo"></div>
                    <div id="welcome">
                        <table>
                            <tr>
<%
        String name = "ruyicai";
 %>
                                <td><h4><%=name %>, 欢迎使用!</h4></td>
                            </tr>
                        </table>
                    </div>
                    <div id="header-right">
                        <div id="zhux"><a href="<%=request.getContextPath()%>/j_spring_security_logout" target="_top">注销</a></div>
                        <div id="lun"><a href="changePsw.jsp" target="mainFrame">修改密码</a></div>
                    </div>
                </th>
            </tr>
            <tr>
                <td>
                    <div style="padding-left: 5px;">
                        <div id="color">
                            <div id="se">完美换肤：</div>
                            <select name="theme" id="selected_theme" onchange="changeTheme(this.value)">
                                <option value="redmond">淡雅幽兰</option>
                                <option value="smoothness">平淡人生</option>
                                <option value="sunny">阳光夏日</option>
                                <option value="ui-lightness" >明亮世界</option>
                                <option value="showcase" selected="selected" >经典海蓝</option>
                            </select>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>

    <script type="text/javascript" src="js/grid.js"></script>
    <script type="text/javascript" src="js/showMenu.js"></script>
    <script type="text/javascript">
    
	    // 皮肤切换
	    function changeTheme(theme){
	    	changeTopMenuCss(theme);
	    	changeLeftMenuCss(theme);
	    	changeMainPageCss(theme);
	    }
    </script>
</body>
</html> 
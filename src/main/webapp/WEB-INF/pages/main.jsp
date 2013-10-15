<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
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
    
<style>
	body {
	    background: none repeat scroll 0 0 #1B4783;
	    color: #333333;
	    font-family: 宋体,Arial Narrow,arial,serif;
	    font-size: 12px;
	    line-height: 1.8;
	    margin: 0 auto;
	    padding: 0;
	}
	.topbar-wrapper {
		background-color: #3F9FD9;
	}
	.site-nav{
	    z-index: 1999;
		position: fixed;
		_position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		background-position: 0 -361px;
		background-repeat: repeat-x;
	 }
	 .container {
	    background: none repeat scroll 0 0 #310B28;
	    margin: 0 auto;
	    padding: 0;
	    text-align: left;
	    width: 1250px;
	}
	.leftNav {
	    bottom: 0;
	    float: left;
	    position: relative;
	    top: 23px;
	    width: 190px;
	    background: none repeat scroll 0 0 #310B28;
	    margin-left: 0;
	    margin:30px 0;
	    z-index: 100;
	}
	.mainDiv {
	    margin: 20px 0 0 17%;
	    min-height: 800px;
	    padding-top: 55px;
	    position: relative;
	    top: 0;
	    width: 1010px;
	    z-index: 99;
	}
</style>

</head>
<body>
<div class="topbar-wrapper">
	<div id="navBar" class="site-nav">
	  <tr>
	      <td >
	        <iframe id="topFrame" title="topFrame" src="login_topMenu.action" name="topFrame" 
	            style="height: 68px; width: 100%; z-index: 1;"
	        	frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" allowtransparency="true">
	        </iframe>
	      </td>
	  </tr>
	 </div>
</div>
<div id="mainWrapper" class="container">
   <div id="leftNav" class="leftNav">
	   <tr>
	     <td id="left">
	 		<iframe id="leftFrame" title="leftFrame" src="login_leftMenu.action" name="leftFrame"
	 		    onload="setCwinHeight()" height="1" width="195px"
	 			frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" allowtransparency="true"
	 			>
	 		</iframe>
	 	 </td>
	   </tr>
	</div>
	<div id="rightInfo" class="mainDiv">
	  <tr>
	     <td id="main">
	       <iframe id="mainFrame" title="mainFrame" src="login_rigth.action" name="mainFrame" width="100%" height="500"
	          frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" allowtransparency="true">
	        </iframe>
	     </td>
	   </tr>
    </div>
</div>

<script type="text/javascript">
  function setCwinHeight(){
    var iframeid=document.getElementById("leftFrame"); //iframe id
    if (document.getElementById){
      if (iframeid && !window.opera){
        if (iframeid.contentDocument && iframeid.contentDocument.body.offsetHeight){
        iframeid.height = iframeid.contentDocument.body.offsetHeight;
        }else if(iframeid.Document && iframeid.Document.body.scrollHeight){
          iframeid.height = iframeid.Document.body.scrollHeight;
      }
     }
   }
  }
</script>
</body>
</html>
  
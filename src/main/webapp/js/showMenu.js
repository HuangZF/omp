/* 隐藏左菜单 */
function hideLeftBar(){
	$("#leftMenu").css("display","none");
	$("#controlHide").css("display","none");
	$("#controlShow").css("display","");
	$(parent.document).find("#leftFrame").attr("scrolling","no");
	$(parent.document).find("#leftFrame").attr("width","18");
	var idocumentElement = parent.document.getElementById("top");
	$(parent.document).find("#mainFrame").attr("width",idocumentElement.offsetWidth-26);
}

/* 显示左菜单 */
function showLeftBar(){
	var idocumentElement = parent.document.getElementById("top");
	$(parent.document).find("#mainFrame").attr("width",idocumentElement.offsetWidth-191);
	$(parent.document).find("#leftFrame").attr("scrolling","no");
	$("#controlShow").css("display","none");
	$("#leftMenu").css("display","");
	$("#controlHide").css("display","");
	$(parent.document).find("#leftFrame").attr("width","183");
}

/* 获取左菜单和主页面高度 */
function getWinHeight(){
    var winHeight = 700;
    if(parent.window.innerHeight){
        winHeight = parent.window.innerHeight;
    }else if((parent.document.documentElement) && (parent.document.documentElement.clientHeight)){
        winHeight = parent.document.documentElement.clientHeight;
    }
    return (winHeight - 122);
}

/* 设置页眉样式 */
function changeTopMenuCss(theme){
	// 获取当前样式
	var cuurTheme = theme;
	if(!cuurTheme)
	{
		cuurTheme = $(document).find('#selected_theme').val();
	}
	// 获取页面样式适用元素
	var css = document.getElementById("css");
	var rightMove = document.getElementById("moveRight");
	var leftMove = document.getElementById("moveLeft");
	// 切换样式
    if(cuurTheme == "ui-lightness")
    {
        css.setAttribute("href","styles/x4.css");
        rightMove.src = "images/jiantou10.jpg";
        leftMove.src = "images/jiantou9.jpg";
    }else if(cuurTheme == "showcase")
    {
        css.setAttribute("href","styles/x3.css");
        rightMove.src = "images/jiantou2.jpg";
        leftMove.src = "images/jiantou.jpg";
    }else if(cuurTheme == "smoothness")
    {
        css.setAttribute("href","styles/x1.css");
        rightMove.src = "images/jiantou3.jpg";
        leftMove.src = "images/jiantou4.jpg";
    }else if(cuurTheme == "sunny")
    {
        css.setAttribute("href","styles/x2.css");
        rightMove.src = "images/jiantou7.jpg";
        leftMove.src = "images/jiantou8.jpg";
    }else if(cuurTheme == "redmond")
    {
        css.setAttribute("href","styles/x5.css");
        rightMove.src = "images/jiantou6.jpg";
        leftMove.src = "images/jiantou5.jpg";
    }
}

/* 设置左菜单页面样式 */
function changeLeftMenuCss(theme){
	// 获取当前样式
	var cuurTheme = theme;
	if(!cuurTheme)
	{
		cuurTheme = $(parent.topFrame.document).find('#selected_theme').val();
	}
	// 获取左菜单页面样式适用元素
    var css = parent.leftFrame.document.getElementById("css");
    var leftUp = parent.leftFrame.document.getElementById("moveUp");
    var leftDown = parent.leftFrame.document.getElementById("moveDown");
	// 切换样式
    if(cuurTheme == "ui-lightness")
    {
        css.setAttribute("href","styles/x4.css");
        leftUp.src = "images/upC.jpg";
        leftDown.src = "images/downC.jpg";
    }else if(cuurTheme == "showcase")
    {
        css.setAttribute("href","styles/x3.css");
        leftUp.src = "images/shang.jpg";
        leftDown.src = "images/xia.jpg";
    }else if(cuurTheme == "smoothness")
    {
        css.setAttribute("href","styles/x1.css");
        leftUp.src = "images/upH.jpg";
        leftDown.src = "images/downH.jpg";
    }else if(cuurTheme == "sunny")
    {
        css.setAttribute("href","styles/x2.css");
        leftUp.src = "images/upZ.jpg";
        leftDown.src = "images/downZ.jpg";
    }else if(cuurTheme == "redmond")
    {
        css.setAttribute("href","styles/x5.css");
        leftUp.src = "images/upL.jpg";
        leftDown.src = "images/downL.jpg";
    }
}

/* 设置主页面样式 */
function changeMainPageCss(theme){
	// 获取当前样式
	var cuurTheme = theme;
	if(!cuurTheme && parent && parent.topFrame && parent.topFrame.document)
	{
		cuurTheme = $(parent.topFrame.document).find('#selected_theme').val();
	}
	// 针对单独弹出的框，不允许提交
	if(!cuurTheme || cuurTheme.length == 0)
	{
		// 输入框和按钮无效
		$("input").attr("disabled", true);
		$("select").attr("disabled", true);
		$("textarea").attr("disabled", true);
		// 链接无效
		$("a").attr("disabled", true);
		$("a").unbind('click');
		$("a").each(function(){
			this.onclick = function(){return false;};
		});
		// 日期选择无效
		$("button").attr("disabled", true);
		$("button").unbind('click');
		$("button").each(function(){
			this.onclick = function(){return false;};
		});
		// 列表无效
		$("[id^='lui_grid_']").css("display", "block");
		// 返回
		return;
	}
	// 获取主页面样式适用元素
    var areaStructureMgCss = parent.mainFrame.document.getElementById("areaStructureMg");
    var themeLink = parent.mainFrame.document.getElementById("jquery_theme_link");
	// 切换样式
    if(areaStructureMgCss)
    {
        if(cuurTheme == "ui-lightness")
        {
        	areaStructureMgCss.setAttribute("href","styles/area/areaStructureMg/04.css");
        }else if(cuurTheme == "showcase")
        {
        	areaStructureMgCss.setAttribute("href","styles/area/areaStructureMg/03.css");
        }else if(cuurTheme == "smoothness")
        {
        	areaStructureMgCss.setAttribute("href","styles/area/areaStructureMg/01.css");
        }else if(cuurTheme == "sunny")
        {
        	areaStructureMgCss.setAttribute("href","styles/area/areaStructureMg/02.css");
        }else if(cuurTheme == "redmond")
        {
        	areaStructureMgCss.setAttribute("href","styles/area/areaStructureMg/05.css");
        }
    }
    if(themeLink)
    {
    	themeLink.setAttribute('href','templates/themes/'+cuurTheme+'/jquery-ui.css');
    }
}

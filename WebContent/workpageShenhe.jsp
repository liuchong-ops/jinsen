<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>工单审核</title>
<!-- Custom CSS -->
<link rel="stylesheet" href="css/registe.css"/>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/PrintArea.css" />
<script src="js/excanvas.min.js"></script> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.flot.min.js"></script> 
<script src="js/jquery.flot.resize.min.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/fullcalendar.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.dashboard.js"></script> 
<script src="js/jquery.gritter.min.js"></script> 
<script src="js/matrix.interface.js"></script> 
<script src="js/matrix.chat.js"></script> 
<script src="js/jquery.validate.js"></script> 
<script src="js/matrix.form_validation.js"></script> 
<script src="js/jquery.wizard.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.popover.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.tables.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jQuery.print.js"></script>
<script src="js/jquery.PrintArea.js" type="text/JavaScript"></script>
    <style>
#h li{float: left; }
#h a{font-size:15px;width: 230px; height: 30px;padding: 10px 0;text-align: center;  background: #3c763d; display: block; text-decoration:none; color:white}
#h a:hover{color:white;background: green}
.p-tail {
    padding: 10px;
    font-size: 12px;
    color: #8a6d3b;
}
.i-tail {
    width: 14px;
    height: 11px;
    position: relative;
    display: inline-block;
    background-image: url(../img/listicon.jpg);
    top: 1px;
}
</style>    
<script type="text/javascript">
function mypass(workid)
{
	$.ajax({
        url:"workpageSevrlet",
        data:{
            "action":"mypass",
            "workid":workid,
        },
        type: "POST",
        dataType:"html",
        success: function (data) {
        	alert(data);
        }
    })
	}

function alldo()
{
    var mytype=document.getElementById("mytype").value;
    var group=[];
    if(mytype=="")
    	{
    	alert("请选择批量处理得方式");
    	}
    else
    {   
        if(mytype=="alldelete"){
        	var str=$("#table1").bootstrapTable('getSelections');
        	if(str.length<1)
        		{
        		alert("无选中记录");
        		}
        	else{
        	for(var i=0;i<str.length;i++)
        		{
        		var j=str[i];
        		group[i]=j.workid;
        		}
        	var mymap=JSON.stringify(group);
        	$.ajax({
                url:"workpageSevrlet?action=writepage&type="+mytype,
                data:{
                    "action":mytype,
                    "workid":mymap,
                },
                type: "POST",
                dataType:"html",
                success: function (data) {
                	alert(data);
                }
            })
        	}
        }
        else if(mytype=="notpass")
        {
        	var str=$("#table1").bootstrapTable('getSelections');
        	if(str.length<1)
        		{
        		alert("无选中记录");
        		}
        	else{
        	for(var i=0;i<str.length;i++)
        		{
        		var j=str[i];
        		group[i]=j.workid;
        		}
        	var mymap=JSON.stringify(group);
        	$.ajax({
                url:"workpageSevrlet?action=writepage&type="+mytype,
                data:{
                    "action":mytype,
                    "workid":mymap,
                },
                type: "POST",
                dataType:"html",
                success: function (data) {
                	alert(data);
                }
            })
        	}
        }
        else{
    	var param = { 
    	        url: "workpageSevrlet?action=writepage&type="+mytype, 
    	       }
    	$('#table1').bootstrapTable('refresh',param);
        }
	}
}
</script>
</head>
<body>
<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">产销部门平台</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">欢迎使用者</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> 我的个人资料 </a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i> 我的任务</a></li>
        <li class="divider"></li>
        <li><a href="login.jsp"><i class="icon-key"></i> 注销</a></li>
      </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">消息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> 系的消息</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> 收件箱</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> 发件箱</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> 垃圾箱</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
    <li class=""><a title="" href="login.jsp"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->

<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> 仪表盘</a>
  <ul>
    <li class="active"><a href="index.html"><i class="icon icon-home"></i> <span>生产数据查询</span></a> </li>
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>工单管理</span> <span class="label label-important">3</span></a>
       <ul>
        <li><a href="workorderAdd.jsp">发送工单通知</a></li>
        <li><a href="workpageAdd.jsp">输入工单</a></li>
        <li><a href="workpageShenhe.jsp">审核工单</a></li>
      </ul>
     </li>
    <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>异常处理</span></a> </li>
    <li><a href="tables.html"><i class="icon icon-th"></i> <span>生产结算</span></a></li>
    <li class="content"> <span>Monthly Bandwidth Transfer</span>
      <div class="progress progress-mini progress-danger active progress-striped">
        <div style="width: 77%;" class="bar"></div>
      </div>
      <span class="percent">77%</span>
      <div class="stat">21419.94 / 14000 MB</div>
    </li>
    <li class="content"> <span>Disk Space Usage</span>
      <div class="progress progress-mini active progress-striped">
        <div style="width: 87%;" class="bar"></div>
      </div>
      <span class="percent">87%</span>
      <div class="stat">604.44 / 4000 MB</div>
    </li>
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="hello2.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<main class="all">
    <article class="artlce">
    <div class="book_con01">
    <div class="find-top">
        <p class="p-tail"><i class="i-tail"></i> 请选择你要所要进行的操作。</p>
    </div>
    <div class="find-top">
        <select style="width: 100px" id="mytype">
            <option value="">---请选择---</option>
            <option value="notpass">未通过</option>
            <option value="didpass">已通过</option>
            <option value="notshenhe">未审核</option>
            <option value="alldelete">删除</option>
        </select>
        <button class="add-but" onclick="alldo()"><i class="glyphicon glyphicon-edit"></i>确定</button>
    </div>
    <div class="table-con">
        <table id="table1" class="table-style"></table>
    </div>
   </div> 
</article>
</main>
</div>
<script src="js/jquery.js"></script>
<script src="js/bstable/js/bootstrap.min.js"></script>
<script src="js/bstable/js/bootstrap-table.js"></script>
<script src="js/bstable/js/bootstrap-table-zh-CN.min.js"></script>
<script>
    $(function(){
        table1();
    })
    function table1(){
        $('#table1').bootstrapTable({
            method: "get",
            striped: true,
            singleSelect: false,
            url: "workpageSevrlet?action=writepage&type=all",
            data:{},
            dataType: "json",
            pagination: true, //分页
            pageSize: 8,
            pageNumber: 1,
            search: true, //显示搜索框
            contentType: "application/x-www-form-urlencoded",
            showRefresh: true,                      //是否显示刷新按钮
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            detailView: true,
            columns: [
            	{
                    checkbox: "true",
                    field: 'check',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: "工单号",
                    field: 'workid',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '采伐证号',
                    field: 'cutnum',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '采伐地点',
                    field: 'cutsite',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '检尺员',
                    field: 'surveyor',
                    align: 'center'
                },
                {
                    title: '操作',
                    field: 'opr',
                    width: 180,
                    align: 'center',
                    formatter: function (cellval, row) {
                        //var  d = '<a href="workpageSevrlet?action=single&workid=\''+ row.workid + '\'"><button  id="add" data-id="98" class="btn btn-xs btn-primary">查看</button></a>';
                        var  d = '<a href="workpageSevrlet?action=single&workid=\''+ row.workid + '\'"><button  id="add" data-id="98" class="btn btn-xs btn-primary">查看</button></a><button type="button" data-id="98"  class="btn btn-xs btn-primary" onclick="overtimedelete(\''+ row.workid + '\')">删除</button> ';
                        //var  d = '<a href="workpageSevrlet?action=alldelete&workid=\''+ row.workid + '\'"><button  id="id="delete" data-id="98" class="btn btn-xs btn-primary">删除</button></a>';
                        return  d;
                    }
                },
            ]
        });
    }
    /*function overtimedelete(workid)
    {
    	$.ajax({
    		 url:"workpageSevrlet",
    		 type:"POST",
    		 data:{"action":"alldelete","workid":workid},
    	     dataType:"text",
    	     success:function (data)
         	{
         		if(data=="true")
         		{
         			alert("修改成功！");	
         			window.location.reload();
         		}
         		else
         		{
         			alert("查看失败");	  
         		}
         	},
          error:function(e){
         	 alert("请联系管理员！");	  
         }
    	});
    }*/
    
    function overtimedelete(workid)
    {
		$.ajax({
            url:"workpageSevrlet",
            data:{
                "action":"alldelete1",
                "workid":workid,
            },
            type: "Post",
            dataType:"json",
            success: function (data) {
            	if(data)
            		{
            		alert("hh删除成功！");
            		$("#table1").bootstrapTable('refresh');
            		
            		}
            		
            	else
            		alert("hh删除失败！");
            }
        })
    }
    function goPage (newURL) {

        // if url is empty, skip the menu dividers and reset the menu selection to default
        if (newURL != "") {
        
            // if url is "-", it is this page -- reset the menu:
            if (newURL == "-" ) {
                resetMenu();            
            } 
            // else, send page to designated URL            
            else {  
              document.location.href = newURL;
            }
        }
    }

  // resets the menu selection upon entry to this page:
  function resetMenu() {
     document.gomenu.selector.selectedIndex = 2;
  }
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jinshen.bean.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工单录入</title>
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/jQueryCalendar/calendar.css">
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />

    <!-- font-awesome icons CSS -->
    <link href="css/font-awesome.css" rel="stylesheet">
    
    <link href="css/registe.css" rel="stylesheet">
    <!-- side nav css file -->
    <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
    <!-- //side nav css file -->
    <link rel="stylesheet" href="css/page/index.css">
    <!-- js-->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/modernizr.custom.js"></script>
    <!-- jQuery.print -->
	<script src="js/jQuery.print.js"></script>
    
    <style>
    body,td,th {font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 18px;color: #1d1007; line-height:24px}
    
    </style>
    <link href="css/registe.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .table_p{line-height: 28px;border-bottom: 1px #d0e6ec solid;position: relative;margin-bottom: 10px; 
            margin-top: 35px; margin-left:10px}
        .table_p span{border-bottom: 3px #42cdec solid;display: inline-block;position: absolute;bottom: -1px;font-weight: bold;font-size: 20px}
        .but_p button{width: 80px}
        #h li{float: left; }
        #h a{font-size:15px;width: 230px; height: 30px;padding: 10px 0;text-align: center;  background: #3c763d; display: block; text-decoration:none; color:white}
       #h a:hover{color:white;background: green}
         .table1{width:1000px; height:400px;margin-left:auto; margin-right:auto;padding:10px;border-collapse:collapse}
         td,th{text-align:center;vertical-align:middle}
         tr{text-align:center}

    </style>
    
<script type="text/javascript">
function inputNull(form){
	for(i=0;i<form.length;i++){
            //form属性的elements的首字母e要小写
		if(form.elements[i].value == ""){ 
			alert("" + form.elements[i].placeholder + "不能为空");
			form.elements[i].focus();	
			return false;
		}
	}
	}
</script>
<title>查看工单</title>
</head>
<body>
<% workpage c=(workpage)request.getAttribute("workpage"); 
%>
<main class="all">
    <article class="artlce">

        <div class="book_con01">
            <h1 class="book_h01">录入工单</h1>
            <form  onSubmit="return inputNull(this)" action="workpageSevrlet?action=addWorkpage" method="POST" >
                <div class="top">
                    <div>
                        <div class="top_out">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td>工单号<span></span></td>
                                    <td>
                                        <input type="text" name="workid" id="wworkid" value="<%=c.getWorkid() %>" placeholder="工单号">
                                    </td>
                                    <td>采伐证号<span></span></td>
                                    <td>
                                        <input type="text" name="cutnum" id="cccutnum" value="<%=c.getCutNum() %>" placeholder="采伐证号">
                                    </td>
                                    <td>采伐时间<span></span></td>
                                    <td>
                                        <input type="date" name="cutdate" value="<%=c.getCutdate() %>"  id="ccutdate" placeholder="采伐时间">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="table">
                                <tbody>
                                <tr>
                                   <td>采伐地点<span></span></td>
                                    <td>
                                        <input type="text" name="cutsite" id="ccutsite" value="<%=c.getCutSite() %>" placeholder="采伐地点">
                                    </td>
                                   <td>检验地点<span></span></td>
                                    <td>
                                        <input type="text" name="checksite" id="ccchecksite" value="<%=c.getCheckSite() %>" placeholder="检验地点">
                                    </td>
                                    
                                    <td>车牌号<span></span></td>
                                    <td>
                                        <input type="text" name="carnumber" id="ccarnumber" value="<%=c.getCarNumber() %>" placeholder="车牌号">
                                    </td>
                                </tbody>
                            </table>

                            <table class="table1">
                              <tr>
                                 <th scope="col">树    种</th>
                                  <th scope="col">检  尺  长</th>
                                  <th scope="col">检  尺  径</th>
                                  <th scope="col">根  数</th>
                                  <th scope="col">材  积</th>
                              </tr>
                              <tr>
                                 <td>&nbsp; </td>
                                 <td> &nbsp;</td>
                                 <td> &nbsp;</td>
                                 <td>&nbsp; </td>
                                 <td>&nbsp;</td>
                              </tr>
                              <tr>
                                 <td>&nbsp; </td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp; </td>
                                 <td>&nbsp;</td>
                              </tr>
                                <tr>
                                 <td>&nbsp; </td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp;</td>
                                 <td>&nbsp; </td>
                                 <td>&nbsp;</td>
                              </tr>
                            </table>
                            
                            <table class="table" >
                                <tbody>
                                <p class="table_p"><span>审核人员信息</span></p>
                                <tr style="font-size:20px">
                                   <td>检验员<span></span></td>
                                   <td><input type="text" name="surveyor" id="ssurveyor" value="<%=c.getSurveyor() %>" placeholder="检验员"></td>
                                    <td>林务员<span></span></td>
                                   <td><input type="text" name="forester " id="fforester " value="<%=c.getForester() %>" placeholder="林务员"></td>
                                    <td>楞厂管理员<span></span></td>
                                    <td><input type="text" name="woodmanage" id="wwoodmanage" value="<%=c.getWoodmanage() %>" placeholder="楞厂管理员"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class=" but_p" style="float:left;"><button class="but_save" type="submit" id="mybutton" value="更新工单">更新工单</button>
                <button class="but_save" type="button" value="返回" onclick="javascrtpt:window.location.href='workpageAdd.jsp'">返回添加</button></div>
                <div style="clear: both;padding-bottom: 40px"></div>
            </form>
        </div>
    </article>
</main>
</body>
</html>
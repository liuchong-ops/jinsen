package jinshen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import jinshen.bean.codejson;
import jinshen.bean.tree;
import jinshen.bean.volume;
import jinshen.bean.workpage;
import jinshen.dao.treeDao;
import jinshen.dao.volumeDao;
import jinshen.dao.workpageDao;
import jinshen.daoimpl.treeDaoImpl;
import jinshen.daoimpl.volumeDaoImpl;
import jinshen.daoimpl.workpageDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class workpageSevrlet
 */
@WebServlet("/workpageSevrlet")
public class workpageSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public workpageSevrlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String sql="";
        workpageDao wpd=new workpageDaoImpl();
        ObjectMapper mapper = new ObjectMapper();
        session.setAttribute("staff_id", "123");  //登录得员工id
        if("addWorkpage".equals(action)) {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	double cutNum = Double.parseDouble(request.getParameter("cutnum"));
        	String cutdate=request.getParameter("cutdate");
        	String cutSite=request.getParameter("cutsite");
        	String checkSite=request.getParameter("checksite");
        	String carNumber=request.getParameter("carnumber");
        	String surveyor=request.getParameter("surveyor");
        	String forester=request.getParameter("forester");
        	String woodmanage=request.getParameter("woodmanage");
        	//double batchNum=Double.parseDouble(request.getParameter("batchNum"));
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			try {
				d = format.parse(cutdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date cuttime = new java.sql.Date(d.getTime()); 
			workpage cp=new workpage();
			cp.setWorkid(workid);
			cp.setCutNum(cutNum);
			cp.setCutdate(cuttime);
			cp.setCutSite(cutSite);
			cp.setCheckSite(checkSite);
			cp.setCarNumber(carNumber);
			cp.setSurveyor(surveyor);
			cp.setForester(forester);
			cp.setWoodmanage(woodmanage);
			cp.setBatchNum(1);
		    sql = "select count(*) from workpage where workid="+cp.getWorkid()+"";
		    int flag=0;
		    double f=wpd.findcount(sql);
		    if(f==1) {
		    	flag=wpd.updateWorkPage(cp);
		    }
		    else {
		    	flag=wpd.addWorkPage(cp);
		    }
		    if(flag==1) {
	       		sql="select * from workpage where workid="+workid+"";
	       		workpage workpage=wpd.findCodeSingle(sql);
        		request.setAttribute("workpage", workpage);
    		    request.getRequestDispatcher("workpageUpdate.jsp").forward(request, response);
		    }
		    else
        	{
        		request.getRequestDispatcher("workpageAdd.jsp").forward(request, response);
        	}
			
        }
        else if("updateWorkpage".equals(action))
        {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	System.out.println("...." +workid + "...");
        	double cutNum = Double.parseDouble(request.getParameter("cutnum"));
        	String cutdate=request.getParameter("cutdate");
        	String cutSite=request.getParameter("cutsite");
        	String checkSite=request.getParameter("checksite");
        	String carNumber=request.getParameter("carnumber");
        	String surveyor=request.getParameter("surveyor");
        	String forester=request.getParameter("forester");
        	String woodmanage=request.getParameter("woodmanage");
        	//double batchNum=Double.parseDouble(request.getParameter("batchNum"));
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			try {
				d = format.parse(cutdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date cuttime = new java.sql.Date(d.getTime()); 
			workpage cp=new workpage();
			cp.setWorkid(workid);
			cp.setCutNum(cutNum);
			cp.setCutdate(cuttime);
			cp.setCutSite(cutSite);
			cp.setCheckSite(checkSite);
			cp.setCarNumber(carNumber);
			cp.setSurveyor(surveyor);
			cp.setForester(forester);
			cp.setWoodmanage(woodmanage);
			cp.setBatchNum(1);
		    sql = "select count(*) from workpage where workid="+cp.getWorkid()+"";
		    int flag=0;
		    double f=wpd.findcount(sql);
        	if(f==1) {
    		flag=wpd.updateWorkPage(cp);
    		sql="select count(*) from codestatus where workid="+workid+" and status='back'";
    		double ff=wpd.findcount(sql);
    		if(ff>0)
    		{
    		sql="update codestatus set status='again' where workid="+workid+"";
    		flag=wpd.updateWork(sql);
    		}
    	    }
    	   else
    	   {
    	      flag=wpd.addWorkPage(cp);
    	   }
    	   if(flag==1)
    	   {
    		  sql="select * from workpage where workid="+workid+"";
    		  workpage workpage=wpd.findCodeSingle(sql);
    		  request.setAttribute("workpage", workpage);
		      request.getRequestDispatcher("workpageUpdate.jsp").forward(request, response);
    	   }
    	   else {
    		   sql = "select * from workpage where workid="+workid+"";
    		   workpage workpage = wpd.findCodeSingle(sql);
    		   request.setAttribute("workpage",workpage);
    		   request.getRequestDispatcher("workpageUpdate.jsp").forward(request, response);
    	   }
        	
        }
        else if("mypass".equals(action))
        {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	double surveyor=Double.parseDouble((String)session.getAttribute("surveyor"));
        	//看这里，此处缺少用户权限得审核
        	sql="delete from codestatus where workid="+workid+"";
        	int i=wpd.delWorkPage(sql);
        	sql="update workpage set surveyor="+surveyor+" where workid="+workid+"";
        	i=wpd.updateWork(sql);
        	if(i==1)
        	{
        		out.print("审核成功！");
        	}
        	else
        	{
        		out.print("失败！");
        	}
        }
        else if("allpass".equals(action))
        {
        	double mygroup=Double.parseDouble(request.getParameter("workid"));
        	JSONArray json=JSONArray.fromObject(mygroup); 
        	double each=0;
        	for(int i=0;i<json.length();i++)
        	{
        		 each=Double.parseDouble(json.getString(i));
        		 double surveyor=Double.parseDouble((String)session.getAttribute("surveyor"));
        		 sql="update workpage set surveyor="+surveyor+" where workid="+each+"";
        		 int j=wpd.updateWork(sql);
        		 sql="delete from codestatus where workid="+each+"";
             	int k=wpd.delWorkPage(sql);
        		 if(j==0)
        		 {
        			 out.print("更新失败！");
        			 break;
        		 }
        	}
        	out.print("操作成功");
        }
        else if("allback".equals(action))
        {
        	double mygroup=Double.parseDouble(request.getParameter("workid"));
        	JSONArray json=JSONArray.fromObject(mygroup); 
        	double each=0;
        	int j=-1;
        	for(int i=0;i<json.length();i++)
        	{
        		 each=json.getDouble(i);
        		 sql="select count(*) from codestatus where workid="+each+" and status='again'";
         		double ff=wpd.findcount(sql);
         		if(ff>0)
         		{
         		sql="update codestatus set status='back' where workid="+each+"";
         		int flag=wpd.updateWork(sql);
         		}
         		else {
        		 sql="insert into codestatus values("+each+",'back')";
        		 j=wpd.addCodeStatus(sql);
         		}
        		if(j==0)
        		 {
        			 out.print("该码单已经被退回");
        			 break;
        		 }
        	}
        	out.print("退回成功");
        }
       /*else if("alldelete".equals(action))
        {
        	double mygroup=Double.parseDouble(request.getParameter("workid"));
        	JSONArray json=JSONArray.fromObject(mygroup); 
        	double each=0;
        	for(int i=0;i<json.length();i++)
        	{
        		 each=json.getDouble(i);
        		 sql="delete from workpage where workid="+each+"";
        		 int j=wpd.updateWork(sql);
        		 if(j==0)
        		 {
        			 out.print("删除失败！");
        			 break;
        		 }
        	}
        }*/
        else if("alldelete".equals(action))
    	{
    		sql="select workid,cutNum,cutSite,surveyor from workpage where surveyor like '0' or workid in (select workid from codestatus)";
        	List<codejson> work=wpd.findcodeJson(sql);
        	mapper.writeValue(response.getWriter(), work);
    	}
        else if("alldelete1".equals(action))
        {
        	String mygroup = request.getParameter("workid");
        	//workpage ac=new workpage();
        	sql="delete from workpage where workid="+mygroup+"";
        	int i=wpd.delWorkPage(sql);
        	//System.out.println("...." +i + "...");
        	ObjectMapper mapper1=new ObjectMapper();
    		mapper1.writeValue(response.getWriter(),i);
    		int flag=0;
    		if(i<0)
     		{
    		sql="update codestatus set status='delete' where workid="+mygroup+"";
        	flag=wpd.updateWork(sql);
     		}
     		else {
    		 sql="insert into codestatus values("+mygroup+",'delete')";
    		 flag=wpd.addCodeStatus(sql);
     		}
        }
        else if("writepage".equals(action))
        {
        	String mytype = request.getParameter("type");
        	if(mytype.equals("all"))
        	{
        		sql="select workid,cutNum,cutSite,surveyor from workpage";
            	List<codejson> work=wpd.findcodeJson(sql);
            	mapper.writeValue(response.getWriter(), work);
        	}
        	else if(mytype.equals("notpass"))
        	{
        		sql="select workid,cutNum,cutSite,surveyor from workpage where surveyor like '0' or workid in (select workid from codestatus)";
            	List<codejson> work=wpd.findcodeJson(sql);
            	mapper.writeValue(response.getWriter(), work);
        	}
        	else if(mytype.equals("didpass"))
        	{
        		sql="select workid,cutNum,cutSite,surveyor from workpage where surveyor like '0' and workid not in (select workid from codestatus)";
            	List<codejson> work=wpd.findcodeJson(sql);
            	mapper.writeValue(response.getWriter(), work);
        	}
        	else if(mytype.equals("notshenhe"))
        	{
        		sql="select workid,cutNum,cutSite,surveyor from workpage where surveyor like '0' and workid not in (select workid from codestatus)";
            	List<codejson> work=wpd.findcodeJson(sql);
            	mapper.writeValue(response.getWriter(), work);
        	}
        	else if(mytype.equals("alldelete"))
        	{
        		String mygroup = request.getParameter("workid");
            	JSONArray json=JSONArray.fromObject(mygroup); 
            	double each=0;
            	for(int i=0;i<json.length();i++)
            	{
            		each=Double.parseDouble(json.getString(i));
            		 sql="delete from workpage where workid="+each+"";
            		 int j=wpd.updateWork(sql);
            		 if(j==0)
            		 {
            			 out.print("删除失败！");
            			 break;
            		 }
            	}
        	}
        }
    	else if(action.equals("single"))
    	{
    		String str=request.getParameter("workid");
    		str=str.replace("'", "");
    		double workid=Double.parseDouble(str);
    		sql="select * from workpage where workid="+workid+"";
    		workpage workpage=wpd.findCodeSingle(sql);
    		request.setAttribute("workpage", workpage);
		    request.getRequestDispatcher("workpageUpdate.jsp").forward(request, response);
    	}
    	else if("searchstatus".equals(action))
        {
        	sql="select workid,cutNum,cutSite,surveyor from workpage where surveyor like '0'";
        	List<codejson> work=wpd.findcodeJson(sql);
        	mapper.writeValue(response.getWriter(), work);
        }
    	else if(action.equals("deletework"))
		 {
    		double workid=Double.parseDouble(request.getParameter("workid"));
				workpageDaoImpl ac=new workpageDaoImpl();
       		   boolean b=ac.delete_work(workid);
	    		mapper.writeValue(response.getWriter(),b);
		 }
	}

}

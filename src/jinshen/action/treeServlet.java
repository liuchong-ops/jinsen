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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import jinshen.bean.inyard;
import jinshen.bean.outyard;
import jinshen.bean.tree;
import jinshen.bean.volume;
import jinshen.dao.treeDao;
import jinshen.dao.volumeDao;
import jinshen.daoimpl.treeDaoImpl;
import jinshen.daoimpl.volumeDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class treeServlet
 */
@WebServlet("/treeServlet")
public class treeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public treeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String sql="";
        treeDao trd=new treeDaoImpl();
        volumeDao vl=new volumeDaoImpl();
        ObjectMapper mapper = new ObjectMapper();
        if("volume".equals(action))
        {
        	double td=Double.parseDouble(request.getParameter("td"));
        	double tr=Double.parseDouble(request.getParameter("tr"));
        	sql="select * from volume where tlong ="+td+" and tradius="+tr+"";
			volume vll=vl.findVolumeSingle(sql);
			if(vll!=null)
			{
				float volume=0.00f;
				volume=(float)vll.getMvolume();
				out.print(volume);
			   //out.print(vll.getMvolume());
			}
			else
			{
				out.print(" ");
			}
        }
        else if("treeAdd".equals(action)) {
        	String rebate = request.getParameter("newtree");
        	int id=Integer.parseInt(request.getParameter("id"));
        	JSONObject jb = JSONObject.fromObject(rebate);
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	sql="delete from tree where workid="+workid+"";
        	int ii=trd.delById(sql);
        	for(int i=0;i<id;i++)
        	{
        		JSONArray s=jb.getJSONArray(String.valueOf(i));
        		tree t=new tree();
        		t.setWorkid(workid);
        		t.setTreetype(s.getString(0));
            	t.setTlong(Double.parseDouble(s.getString(1)));
            	t.setTradius(Double.parseDouble(s.getString(2)));
            	t.setNum(Double.parseDouble(s.getString(3)));
            	sql="select * from volume where tlong ="+Double.parseDouble(s.getString(1))+" and tradius="+Double.parseDouble(s.getString(2));
            	volume vll=vl.findVolumeSingle(sql);
            	float tvolume = 0.00f; 
    			tvolume=(float)vll.getMvolume();
            	t.setTvolume(tvolume*t.getNum());
            	//材积单价还没有
            	t.setUnitprice(1);
            	t.setTotalnum(1);
            	int flag=trd.addTree(t);
            	out.print(flag);
        	}
        }
        else if("volumeout".equals(action)) {
        	double td=Double.parseDouble(request.getParameter("td"));
        	double tr=Double.parseDouble(request.getParameter("tr"));
        	sql="select * from volume where tlong ="+td+" and tradius="+tr+"";
			volume vll=vl.findVolumeSingle(sql);
			if(vll!=null)
			{
				float volume=0.00f;
				volume=(float)vll.getMvolume();
				out.print(volume);
			   //out.print(vll.getMvolume());
			}
			else
			{
				out.print(" ");
			}
        }
        else if("treeAddout".equals(action)) {
        	String rebate = request.getParameter("newtree");
        	int id=Integer.parseInt(request.getParameter("id"));
        	JSONObject jb = JSONObject.fromObject(rebate);
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	sql="delete from treeout where workid="+workid+"";
        	int ii=trd.delById(sql);
        	for(int i=0;i<id;i++)
        	{
        		JSONArray s=jb.getJSONArray(String.valueOf(i));
        		tree t=new tree();
        		t.setWorkid(workid);
        		t.setTreetype(s.getString(0));
            	t.setTlong(Double.parseDouble(s.getString(1)));
            	t.setTradius(Double.parseDouble(s.getString(2)));
            	t.setNum(Double.parseDouble(s.getString(3)));
            	sql="select * from volume where tlong ="+Double.parseDouble(s.getString(1))+" and tradius="+Double.parseDouble(s.getString(2));
            	volume vll=vl.findVolumeSingle(sql);
            	float tvolume = 0.00f; 
    			tvolume=(float)vll.getMvolume();
            	t.setTvolume(tvolume*t.getNum());
            	//材积单价还没有
            	t.setUnitprice(1);
            	t.setTotalnum(1);
            	int flag=trd.addTreeout(t);
            	out.print(flag);
        }
        
	}
        else if("inyard".equals(action)) {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	double cutNum = Double.parseDouble(request.getParameter("cutnum"));
        	String cutSite=request.getParameter("cutsite");
        	String yarddate=request.getParameter("yarddate");
        	String carNumber=request.getParameter("carnumber");
        	String yard=request.getParameter("yard");
        	double batchNum=Double.parseDouble(request.getParameter("batchnum"));        			
        	String surveyor=request.getParameter("surveyor");
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	Date d = null;
			try {
				d = format.parse(yarddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date yardtime = new java.sql.Date(d.getTime());
			inyard cp = new inyard();
			cp.setWorkid(workid);
			cp.setCutNum(cutNum);
			cp.setCutSite(cutSite);
			cp.setYarddate(yardtime);
			cp.setCarNumber(carNumber);
			cp.setYard(yard);
			cp.setBatchNum(batchNum);
			cp.setSurveyor(surveyor);
			sql = "select count(*) from inyard where workid="+cp.getWorkid()+"";
			int flag=0;
			double f=trd.findcount(sql);
			if(f==1) {
				flag=trd.updateInyard(cp);
			}
			else {
				flag=trd.addInyard(cp);
			}
			if(flag==1) {
				sql="select * from inyard where workid="+workid+"";
				inyard inyard=trd.findInSingle(sql);
				sql="select * from tree where workid="+workid+"";
				List<tree> tree=trd.findTree(sql);
				request.setAttribute("inyard", inyard);
				request.setAttribute("tree", tree);
				request.getRequestDispatcher("treeinUpdate.jsp").forward(request, response);
			}
			else {
			request.getRequestDispatcher("treein1.jsp").forward(request, response);	
			}
        }
        else if("updateTreein".equals(action)) {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	double cutNum = Double.parseDouble(request.getParameter("cutnum"));
        	String cutSite=request.getParameter("cutsite");
        	String yarddate=request.getParameter("yarddate");
        	String carNumber=request.getParameter("carnumber");
        	String yard=request.getParameter("yard");
        	double batchNum=Double.parseDouble(request.getParameter("batchnum"));        			
        	String surveyor=request.getParameter("surveyor");
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	Date d = null;
			try {
				d = format.parse(yarddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date yardtime = new java.sql.Date(d.getTime());
			inyard cp = new inyard();
			cp.setWorkid(workid);
			cp.setCutNum(cutNum);
			cp.setCutSite(cutSite);
			cp.setYarddate(yardtime);
			cp.setCarNumber(carNumber);
			cp.setYard(yard);
			cp.setBatchNum(batchNum);
			cp.setSurveyor(surveyor);
			sql = "select count(*) from inyard where workid="+cp.getWorkid()+"";
			int flag=0;
			double f=trd.findcount(sql);
			if(f==1) {
				flag = trd.updateInyard(cp);
				sql="select count(*) from codestatus where workid="+workid+" and status='back'";
				double ff=trd.findcount(sql);
				if(ff>0) {
					sql="update codestatus set status='again' where workid="+workid+"";
					flag = trd.updateWork(sql);
				}
			}
			else {
				flag=trd.addInyard(cp);
			}
			if(flag==1) {
				sql = "select * from inyard where workid="+workid+"";
				inyard inyard = trd.findInSingle(sql);
				sql="select * from tree where workid="+workid+"";
				List<tree> tree=trd.findTree(sql);
				request.setAttribute("inyard", inyard);
				request.setAttribute("tree", tree);
				request.getRequestDispatcher("treeinUpdate.jsp").forward(request, response);
			}
			else {
				sql = "select * from inyard where workid="+workid+"";
				inyard inyard = trd.findInSingle(sql);
				sql="select * from tree where workid="+workid+"";
        		List<tree> tree=trd.findTree(sql);
				request.setAttribute("inyard", inyard);
				request.setAttribute("tree", tree);
				request.getRequestDispatcher("treeinUpdate.jsp").forward(request, response);
			}
        }
        else if("outyard".equals(action)) {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	String yarddate=request.getParameter("yarddate");
        	String carNumber=request.getParameter("carnumber");
        	String yard=request.getParameter("yard");
        	double batchNum=Double.parseDouble(request.getParameter("batchnum"));        			
        	String surveyor=request.getParameter("surveyor");
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	Date d = null;
			try {
				d = format.parse(yarddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date yardtime = new java.sql.Date(d.getTime());
			outyard cp = new outyard();
			cp.setWorkid(workid);;
			cp.setYarddate(yardtime);
			cp.setCarNumber(carNumber);
			cp.setYard(yard);
			cp.setBatchNum(batchNum);
			cp.setSurveyor(surveyor);
			sql = "select count(*) from outyard where workid="+cp.getWorkid()+"";
			int flag=0;
			double f=trd.findcount(sql);
			if(f==1) {
				flag=trd.updateOutyard(cp);
			}
			else {
				flag=trd.addOutyard(cp);
			}
			if(flag==1) {
				sql="select *from outyard where workid="+workid+"";
				outyard outyard=trd.findOutSingle(sql);
				sql="select * from treeout where workid="+workid+"";
				List<tree> tree=trd.findTree(sql);
				request.setAttribute("outyard", outyard);
				request.setAttribute("tree", tree);
				request.getRequestDispatcher("treeoutUpdate.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("treeout1.jsp").forward(request, response);
			}
        }
        else if("updateTreeout".equals(action)) {
        	double workid=Double.parseDouble(request.getParameter("workid"));
        	String yarddate=request.getParameter("yarddate");
        	String carNumber=request.getParameter("carnumber");
        	String yard=request.getParameter("yard");
        	double batchNum=Double.parseDouble(request.getParameter("batchnum"));        			
        	String surveyor=request.getParameter("surveyor");
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	Date d = null;
			try {
				d = format.parse(yarddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date yardtime = new java.sql.Date(d.getTime());
			outyard cp = new outyard();
			cp.setWorkid(workid);
			cp.setYarddate(yardtime);
			cp.setCarNumber(carNumber);
			cp.setYard(yard);
			cp.setBatchNum(batchNum);
			cp.setSurveyor(surveyor);
			sql = "select count(*) from outyard where workid="+cp.getWorkid()+"";
			int flag=0;
			double f=trd.findcount(sql);
			if(f==1) {
				flag = trd.updateOutyard(cp);
				sql="select count(*) from codestatus where workid="+workid+" and status='back'";
				double ff=trd.findcount(sql);
				if(ff>0) {
					sql="update codestatus set status='again' where workid="+workid+"";
					flag = trd.updateWork(sql);
				}
			}
			else {
				flag=trd.addOutyard(cp);
			}
			if(flag==1) {
				sql = "select * from outyard where workid="+workid+"";
				outyard outyard = trd.findOutSingle(sql);
				sql="select * from treeout where workid="+workid+"";
				List<tree> tree=trd.findTree(sql);
				request.setAttribute("outyard", outyard);
				request.setAttribute("tree", tree);
				request.getRequestDispatcher("treeoutUpdate.jsp").forward(request, response);
			}
			else {
				sql = "select * from outyard where workid="+workid+"";
				outyard outyard = trd.findOutSingle(sql);
				sql="select * from treeout where workid="+workid+"";
				List<tree> tree=trd.findTree(sql);
				request.setAttribute("outyard", outyard);
				request.setAttribute("tree", tree);
				request.getRequestDispatcher("treeoutUpdate.jsp").forward(request, response);
			}
        }
        
	}

}

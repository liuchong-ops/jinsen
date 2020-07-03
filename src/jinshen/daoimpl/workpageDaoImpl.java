package jinshen.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import java.util.ArrayList;

import jinshen.bean.codejson;
import jinshen.bean.workpage;
import jinshen.dao.workpageDao;
import jinshen.db.DBcon;

public class workpageDaoImpl implements workpageDao {

	private DBcon dbc=new DBcon();
    Connection connection = null;
    PreparedStatement pStatement = null;
    
	@Override
	public int addWorkPage(workpage cp) {
		// TODO Auto-generated method stub
		String sql = "insert into workpage values(?,?,?,?,?,?,?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getCutNum(),cp.getCutdate(), cp.getCutSite(),
					cp.getCheckSite(), cp.getCarNumber(), cp.getSurveyor(), cp.getForester(), cp.getWoodmanage(),cp.getBatchNum()});
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public int updateWorkPage(workpage cp) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			String sql="update workpage set workid=?,cutNum=?,cutdate=?,cutSite=?,checkSite=?,carNumber=?,surveyor=?,forester=?,woodmanage=?,batchNum=?";
		    res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getCutNum(),cp.getCutdate(), cp.getCutSite(),
					cp.getCheckSite(), cp.getCarNumber(), cp.getSurveyor(), cp.getForester(), cp.getWoodmanage(), cp.getBatchNum()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public List<workpage> findWorkPage(String sql) {
		// TODO Auto-generated method stub
		List<workpage> addrList=new ArrayList<workpage>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()) {
				workpage addr=new workpage();
				addr.setWorkid(rs.getDouble(1));
				addr.setCutNum(rs.getDouble(2));
				addr.setCutdate(rs.getDate(3));
				addr.setCutSite(rs.getString(4));
				addr.setCheckSite(rs.getString(5));
				addr.setCarNumber(rs.getString(6));
				addr.setSurveyor(rs.getString(7));
				addr.setForester(rs.getString(8));
				addr.setWoodmanage(rs.getString(9));
				addr.setBatchNum(rs.getDouble(10));
				addrList.add(addr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return addrList;
	}

	@Override
	public int delWorkPage(String sql) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public workpage findCodeSingle(String sql) {
		// TODO Auto-generated method stub
		workpage addr = new workpage();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				addr.setWorkid(rs.getDouble(1));
				addr.setCutNum(rs.getDouble(2));
				addr.setCutdate(rs.getDate(3));
				addr.setCutSite(rs.getString(4));
				addr.setCheckSite(rs.getString(5));
				addr.setCarNumber(rs.getString(6));
				addr.setSurveyor(rs.getString(7));
				addr.setForester(rs.getString(8));
				addr.setWoodmanage(rs.getString(9));
				addr.setBatchNum(rs.getDouble(10));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return addr;
	}

	@Override
	public int updateWork(String sql) {
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public double findcount(String sql) {
		double num=1;
		try {
			ResultSet rs=dbc.doQuery(sql,new Object[]{});
			while(rs.next()) {
				num=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int addCodeStatus(String sql) {
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	
	@Override
	public List<codejson> findcodeJson(String sql) {
		List<codejson> work=new ArrayList<codejson>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()){
				codejson w=new codejson();
				w.setWorkid(rs.getDouble(1));
				w.setCutnum(rs.getDouble(2));
                w.setCutsite(rs.getString(3));
                w.setSurveyor(rs.getString(4));
				work.add(w);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return work;
	}

	@Override
	public boolean delete_work(double workid) {
		// TODO Auto-generated method stub
			String st="delete from workpage where workid=?";
			Connection con=DBcon.getConnection();
			try {
				PreparedStatement pst=con.prepareStatement(st);	
				pst.setDouble(1, workid);
				int i=pst.executeUpdate();
				if(i>0)
				  return true;
				else
					return false;
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
			finally
			{
				
			}
	}
}

package jinshen.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jinshen.bean.salemansql;
import jinshen.bean.salesman;
import jinshen.bean.work;
import jinshen.bean.worktree;
import jinshen.dao.salemanDao;
import jinshen.db.DBcon;

public class salemanDaoImpl implements salemanDao{
	private DBcon dbc=new DBcon();
	Connection connection = null;
    PreparedStatement pStatement = null;
	@Override
	public int findMaxid(String sql) {
		int num=0;
		try {
			ResultSet rs=dbc.doQuery(sql,new Object[]{});
			if(rs.next()) {
				num=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public List<salesman> findSaleList(String sql){
		List<salesman> salesman=new ArrayList<salesman>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				salesman addr = new salesman();
				//addr.setWorkid(rs.getDouble(1));
				addr.setYard(rs.getString(1));
				addr.setYarddate(rs.getDate(2));
				addr.setCarNumber(rs.getString(3));
				addr.setSurveyor(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			dbc.close();
		}
		return salesman;
	}
	
	@Override
	public List<worktree> findworktree(String sql)
	{
		List<worktree> work=new ArrayList<worktree>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()){
				worktree w=new worktree();
				w.setType(rs.getString(1));
				w.setTvolume(rs.getDouble(2));
				w.setUnitprice(rs.getDouble(3));
				w.setPrice(rs.getDouble(4));
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
	public salesman findsaleSingle(String sql) {
		salesman addr = new salesman();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				//addr.setWorkid(rs.getDouble(1));
				addr.setYard(rs.getString(1));
				addr.setYarddate(rs.getDate(2));
				addr.setCarNumber(rs.getString(3));
				addr.setSurveyor(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			dbc.close();
		}
		return addr;
	}
	
	@Override
	public int update(String sql)
	{
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
	public int addWork(salemansql cp) {
		String sql="insert into saleman values(?,?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getTreetype(),cp.getUnitprice(),cp.getPrice(),cp.getSaleman()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

}

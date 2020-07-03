package jinshen.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jinshen.bean.inyard;
import jinshen.bean.outyard;
import jinshen.bean.tree;
import jinshen.dao.treeDao;
import jinshen.db.DBcon;

public class treeDaoImpl implements treeDao {
	private DBcon dbc=new DBcon();
	
	@Override
	public List<tree> findTree(String sql) {
		List<tree> addrList=new ArrayList<tree>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()) {
				tree addr=new tree();
				addr.setWorkid(rs.getDouble(1));
				addr.setTreetype(rs.getString(2));
				addr.setTlong(rs.getDouble(3));
				addr.setTradius(rs.getDouble(4));
				addr.setNum(rs.getDouble(5));
				addr.setTvolume(rs.getDouble(6));
				addr.setUnitprice(rs.getDouble(7));
				addr.setTotalnum(rs.getDouble(8));
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
	public int addTree(tree c) {
		String sql="insert into tree values(?,?,?,?,?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {c.getWorkid(),c.getTreetype(),c.getTlong(),c.getTradius(),c.getNum(),c.getTvolume(),c.getUnitprice(),c.getTotalnum()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public tree findTreeSingle(String sql) {
		tree addr=new tree();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				addr.setWorkid(rs.getDouble(1));
				addr.setTreetype(rs.getString(2));
				addr.setTlong(rs.getDouble(3));
				addr.setTradius(rs.getDouble(4));
				addr.setNum(rs.getDouble(5));
				addr.setTvolume(rs.getDouble(6));
				addr.setUnitprice(rs.getDouble(7));
				addr.setTotalnum(rs.getDouble(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return addr;
	}

	@Override
	public int delById(String sql) {
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
	public int updateTree(tree c) {
		int res=0;
		try {
			String sql="update tree set treetype=?,tlong=?,tradius=?,num=?,tvolume=?,untiprice=?,totalnum=? where workid=?";
			res=dbc.doUpdate(sql, new Object[] {c.getTreetype(),c.getTlong(),c.getTradius(),c.getNum(),c.getTvolume(),c.getUnitprice(),c.getTotalnum(),c.getWorkid()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public int findMaxid() {
		String sql="select max(workid) from tree";
		int num=1;
		try {
			ResultSet rs=dbc.doQuery(sql,new Object[]{});
			while(rs.next()) {
				num=rs.getInt(1)+1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public int updateTree(String sql)
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
	public int addTreeout(tree c) {
		String sql="insert into treeout values(?,?,?,?,?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {c.getWorkid(),c.getTreetype(),c.getTlong(),c.getTradius(),c.getNum(),c.getTvolume(),c.getUnitprice(),c.getTotalnum()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	
	@Override
	public int updateTreeout(tree c) {
		int res=0;
		try {
			String sql="update treeout set treetype=?,tlong=?,tradius=?,num=?,tvolume=?,untiprice=?,totalnum=? where workid=?";
			res=dbc.doUpdate(sql, new Object[] {c.getTreetype(),c.getTlong(),c.getTradius(),c.getNum(),c.getTvolume(),c.getUnitprice(),c.getTotalnum(),c.getWorkid()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	
	@Override
	public int updateTreeout(String sql)
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
	public int addInyard(inyard cp) {
		String sql = "insert into inyard values(?,?,?,?,?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getCutNum(),cp.getYarddate(), cp.getCutSite(),
					cp.getCarNumber(),cp.getYard(), cp.getBatchNum(), cp.getSurveyor()});
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
	public int addOutyard(outyard cp) {
		String sql = "insert into outyard values(?,?,?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getYarddate(),
					cp.getCarNumber(),cp.getYard(), cp.getBatchNum(), cp.getSurveyor()});
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
	public int updateInyard(inyard cp) {
		int res=0;
		try {
			String sql="update inyard set workid=?,cutNum=?,yarddate=?,cutSite=?,carNumber=?,yard=?,batchNum=?,surveyor=?";
			res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getCutNum(),cp.getYarddate(), cp.getCutSite(),
					cp.getCarNumber(),cp.getYard(), cp.getBatchNum(), cp.getSurveyor()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	
	@Override
	public int updateOutyard(outyard cp) {
		int res=0;
		try {
			String sql="update outyard set workid=?,yarddate=?,carNumber=?,yard=?,batchNum=?,surveyor=?";
			res=dbc.doUpdate(sql, new Object[] {cp.getWorkid(),cp.getYarddate(),
					cp.getCarNumber(),cp.getYard(), cp.getBatchNum(), cp.getSurveyor()});
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
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
	public inyard findInSingle(String sql) {
		inyard addr=new inyard();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				addr.setWorkid(rs.getDouble(1));
				addr.setCutNum(rs.getDouble(2));
				addr.setYarddate(rs.getDate(3));
				addr.setCutSite(rs.getString(4));
				addr.setCarNumber(rs.getString(5));
				addr.setYard(rs.getString(6));
				addr.setBatchNum(rs.getDouble(7));
				addr.setSurveyor(rs.getString(8));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				dbc.close();
			}
			return addr;
		}
	@Override
	public outyard findOutSingle(String sql) {
		outyard addr = new outyard();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				addr.setWorkid(rs.getDouble(1));
				addr.setYarddate(rs.getDate(2));
				addr.setCarNumber(rs.getString(3));
				addr.setYard(rs.getString(4));
				addr.setBatchNum(rs.getDouble(5));
				addr.setSurveyor(rs.getString(6));
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

}

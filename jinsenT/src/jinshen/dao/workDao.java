package jinshen.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jinshen.bean.treeLaowu;
import jinshen.bean.treesalary;
import jinshen.bean.work;
import jinshen.bean.worktree;


public interface workDao {

	public int addWork(work cp);
	public int addWork(String sql);
	public int updateWork(work cp);
	public List<work> findWork(String sql);
	public int delWork(String sql);
	public int findMaxid(String sql);
	public work findWorkSingle(String sql);
	public int update(String sql);
	public List<worktree> findworktree(String sql);
	public List<work> findWorkList(String sql);
	//public List<CodePage> findByUser(String sql);
	
	//public HashMap<String,cat> findcarrr(String sql);
	public double findcount(String sql);
	public List<treeLaowu> findLaowu();//木材劳务结算单
	public treeLaowu printLaowu(double workid,double codeid);
}

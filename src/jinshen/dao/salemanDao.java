package jinshen.dao;
import java.util.List;

import jinshen.bean.*;

public interface salemanDao {
	public int findMaxid(String sql);
	public List<salesman> findSaleList(String sql);
	public List<worktree> findworktree(String sql);
	public salesman findsaleSingle(String sql);
	public int update(String sql);
	public int addWork(salemansql cp);
	

}

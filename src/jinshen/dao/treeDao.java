package jinshen.dao;

import java.util.List;

import jinshen.bean.inyard;
import jinshen.bean.outyard;
import jinshen.bean.tree;
import jinshen.bean.workpage;

public interface treeDao {

	public List<tree> findTree(String sql);
	public int addTree(tree c);
	public tree findTreeSingle(String sql);
	public int delById(String sql);
	public int updateTree(tree c);
	public int findMaxid();
	public int updateTree(String sql);
	//public List<cat> findByNameList(String sql);
	public int addTreeout(tree c);
	public int updateTreeout(tree c);
	public int updateTreeout(String sql);
	public int addInyard(inyard cp);
	public int updateInyard(inyard cp);
	public int addOutyard(outyard cp);
	public int updateOutyard(outyard cp);
	public double findcount(String sql);
	public inyard findInSingle(String sql);
	public outyard findOutSingle(String sql);
	public int updateWork(String sql);
	
}

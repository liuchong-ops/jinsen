package jinshen.dao;

import java.sql.Date;
import java.util.List;
import jinshen.bean.*;

public interface workpageDao {
	public int addWorkPage(workpage cp);
	public int updateWorkPage(workpage cp);
	public List<workpage> findWorkPage(String sql);
	public int delWorkPage(String sql);
	public workpage findCodeSingle(String sql);
	public int updateWork(String sql);
	public double findcount(String sql);
	public int addCodeStatus(String sql);
	public List<codejson> findcodeJson(String sql);
	public boolean delete_work(double workid);

}

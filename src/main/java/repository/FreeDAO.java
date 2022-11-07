package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDAO {

	private SqlSessionFactory factory;
	
	private static FreeDAO dao = new FreeDAO();
	private FreeDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FreeDAO getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.free.";
	
	public List<Free> selectAllFrees() {
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectAllFrees");
		ss.close();
		return frees;
	}
	
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public Free selectFreeByNo(Long freeNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectFreeByNo", freeNo);
		ss.close();
		return free;
	}
	
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteFree(Long freeNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteFree", freeNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
}

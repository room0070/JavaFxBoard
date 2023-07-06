package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MySession {
	private static final SqlSessionFactory sqlSessionFactory;
	
	static{
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream=null;
		try{
			inputStream = Resources.getResourceAsStream(resource);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("마이바티스 초기화 에러 :"+e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession getSession(){
		return sqlSessionFactory.openSession(true);
	}
}

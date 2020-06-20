package Util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaitsUtils {
	private static SqlSessionFactory sqlSessionFactory;
	public MybaitsUtils() {
		super();
	}

	/*
	 * SqlSessionFactory一旦被创建,应该在应用执行期间都存在.在应用运行期间不要重复创建多次
	 */
	static {
		String resourse = "mybaits-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resourse);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() {
		// 如果不设置参数或者参数为false就是手动提交事务，参数设置为true就是自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

}

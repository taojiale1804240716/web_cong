package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DAO.IphoneDAO;
import Service.JsoupIphone;
import Vo.Iphone;






public class test1 {
           public static void main(String[] args) throws IOException {
        
        		// 指定全局配置文件
       		String resource = "mybaits-config.xml";
       		// 读取配置文件
       		InputStream inputStream = Resources.getResourceAsStream(resource);
       		// 构建sqlSessionFactory
       		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

       		// 获取sqlSession
       		SqlSession sqlSession = sqlSessionFactory.openSession();
//       
//       		 执行方式1：执行命名空间为dao.IUserDAO的映射文件中的findByUserName操作，传递参数"admin"
//       		Iphone user1 = sqlSession.selectOne("dao.IphoneDAO.getByname", "苹果11");
//       		System.out.println(user1.toString());
//       		sqlSession.close();
//      
       		//执行方式2：自动获取相应的DAO实现代理对象
       		IphoneDAO dao = sqlSession.getMapper(IphoneDAO.class);
       	//https://list.tmall.com/search_product.htm?q=%BB%AA%CE%AA+%CA%D6%BB%FA&type=p&redirect=notRedirect
       		JsoupIphone j=new JsoupIphone();
       
       		
       		ArrayList<Iphone> list=new ArrayList<Iphone>();
       		list=dao.SelectAll();
       		
       		
//       		list=j.getIphone("https://list.tmall.com/search_product.htm?q=%BB%AA%CE%AA+%CA%D6%BB%FA&type=p&redirect=notRedirect");
       		for(Iphone iphone:list) {
       		     System.out.println(iphone.toString());
       		}
//       		sqlSession.commit();//提交事务
//       		sqlSession.close();


		}
}

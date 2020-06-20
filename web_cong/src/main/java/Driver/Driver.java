package Driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DAO.IphoneDAO;
import Service.JsoupIphone;
import Vo.Iphone;
public class Driver {
	public static void main(String[] args) throws IOException {
		// 指定全局配置文件
		String resource = "mybaits-config.xml";
		// 读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行方式2：自动获取相应的DAO实现代理对象
		IphoneDAO dao = sqlSession.getMapper(IphoneDAO.class);
		// https://list.tmall.com/search_product.htm?q=%BB%AA%CE%AA+%CA%D6%BB%FA&type=p&redirect=notRedirect
		JsoupIphone j = new JsoupIphone();       
		ArrayList<Iphone> list=new ArrayList<Iphone>();//存放网页中返回手机的信息
		int x;
		Scanner in = new Scanner(System.in);
		meau();
		System.out.print("请输入你的选择:");
		x = in.nextInt();
		while (x != 7) {
			Scanner in2 = new Scanner(System.in);
			switch (x) {
			case 1:
				System.out.println("请输入url:");
				String url=in2.nextLine();
                list=j.getIphone(url);
				break;
			case 2:
				
				for(Iphone iphone:list) {
					dao.insert(iphone);
				}
				System.out.println("成功插入");
				sqlSession.commit();//提交事务
				break;
			case 3:
				list=dao.SelectAll();
				for(Iphone iphone:list) {
	       		     System.out.println(iphone.toString());
	       		}
				System.out.println("成功输出");
				break;
			case 4:
				System.out.println("请输入你想想购买手机的价格例如大于1000的手机");
				String sprice=in2.nextLine();
				//将数据分隔开
				double price=Double.parseDouble(sprice);
				list=dao.Selectprice(price);
				for(Iphone iphone:list) {
	       		     System.out.println(iphone.toString());
	       		}
				System.out.println("成功输出");
				break;	
			
			case 5:
				System.out.println("请输入你想查询手机的品牌");
				String Brand=in2.nextLine();
				list=dao.SelectBrand(Brand);
				for(Iphone iphone:list) {
	       		     System.out.println(iphone.toString());
	       		}
				System.out.println("成功输出");
				break;
			case 6:
				System.out.println("请输入你想查询手机的型号");
				String moder=in2.nextLine();
				Iphone i= dao.Selectmoder(moder);
				if(i==null) {
					System.out.println("没有该型号的手机");
				}
				else {
					System.out.println(i.toString());
	                System.out.println("成功输出");
				}
                
                
			}
			meau();
			System.out.print("请输入你的选择:");
			x = in.nextInt();
		}
		System.out.println("退出程序");

	}
                   public  static void meau() {
                	   System.out.println("1.请输入你想爬虫的手机页面URL地址,将爬取网页:");
                	   System.out.println("2.将爬虫得到手机数据存入数据库");
                	   System.out.println("3.输出数据库中所有的手机信息");
                	   System.out.println("4.输出一个区间手机的价格");
                	   System.out.println("5.输出一个手机品牌的手机");
                	   System.out.println("6.输出指定型号的手机");
                	   System.out.println("7.退出程序");
                   }
}

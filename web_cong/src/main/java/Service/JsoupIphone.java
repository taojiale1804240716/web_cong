package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Vo.Iphone;


public class JsoupIphone {
	//返回值可以是手机的容器
             public  ArrayList<Iphone>  getIphone(String url) throws IOException {
            	
            	//https://list.tmall.com/search_product.htm?q=%BB%AA%CE%AA+%CA%D6%BB%FA&type=p&redirect=notRedirect
            	 Document doc = Jsoup.connect(url) .timeout(60000).get();
            	 System.out.println(doc.toString());
            	 Elements productPrice=doc.getElementsByClass("product-iWrap");
            	 int i=0;
            	  //创建一个容器
            	 ArrayList<Iphone> list=new ArrayList<Iphone>();
            	for(Element element:productPrice) {
            		//价格
            		String p_price = element.getElementsByClass("productPrice").first().getElementsByTag("p").first().text();
            		String p_tag=element.getElementsByClass("productPrice").first().getElementsByTag("b").first().text();
            		p_price=p_price.replace(p_tag,"");           		
            		double price=Double.parseDouble(p_price);  
            		//应该将手机的价格适当的过滤下
            		if(price>300) {
            		
            		String name=element.getElementsByClass("productTitle").first().getElementsByTag("a").first().text();
            		//手机的字符长度有限
            	    //手机名字           	
            		 //将第一个空格或者|的字符抓取
            		 String[] namelist=name.split(" |/");           		 
            		 //品牌
            		 String Brand=namelist[0];           	           		
            		 //型号
            		 String moder="";
            		 for(int j=1;j<namelist.length;j++) {
            			 moder=moder+namelist[j];
            		 }            		           			
            		          
            		//评论数
            		int numberofcomments=0;
            		String p_comments= element.getElementsByClass("productStatus").first().getElementsByTag("em").first().text();
            		//我们需要把评论数的万和笔改造一下
            		//将最后的笔去掉
            		p_comments=p_comments.replace("笔"," ");
            	  
            		//将万这个数字进行 改造
            		if(p_comments.indexOf("万")!=-1) {
            			//将万字去除
            			p_comments=p_comments.replace("万", "");
            			//我们需要将点去掉,相当于数字乘以10倍了
            			p_comments=p_comments.replace(".", "");         			
            			numberofcomments=(int)(Double.parseDouble(p_comments)*1000);
            			
            		}
            		else {
            			numberofcomments=(int)Double.parseDouble(p_comments);
            		}
            		//店铺名字		
            		String store= element.getElementsByClass("productShop-name").first().getElementsByTag("a").first().text();
            		//手机图片
            		String img=element.getElementsByClass("proThumb-wrap").first().getElementsByTag("img").first().attr("data-ks-lazyload");            		
//            		public Iphone(String name, double price, String img, String brand, String moder, int numberofcomments,
//        					String store) {
            		//接下来我们实例化手机
            		Iphone iphone=new Iphone(name,price,img,Brand,moder,numberofcomments,store);
            		list.add(iphone);    
            		}
            	}
            	return list;
          }
                            
}

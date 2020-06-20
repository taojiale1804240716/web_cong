package DAO;

import java.util.ArrayList;

import Vo.Iphone;

public interface IphoneDAO {
	 public Iphone getByname(String name);//得到手机的信息	
      public void insert(Iphone iphone);//像数据库中插入手机的信息
      public ArrayList<Iphone> SelectAll();//查找所有手机的信息
      public ArrayList<Iphone> Selectprice(double price);//根据价格区间找到手机信息
      public ArrayList<Iphone> SelectBrand(String Brand);//根据品牌找手机
      public Iphone Selectmoder(String moder);//根据手机型号查找
}

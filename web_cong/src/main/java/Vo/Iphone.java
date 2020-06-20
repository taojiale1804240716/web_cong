package Vo;

public class Iphone {
            private String name;//姓名
            private double price;//价格
            private String img;//图片
            private String Brand;//品牌
            private String moder;//型号
            private int numberofcomments;//评论数
            private String store;//店铺
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public String getImg() {
				return img;
			}
			public void setImg(String img) {
				this.img = img;
			}
			public String getBrand() {
				return Brand;
			}
			public void setBrand(String brand) {
				Brand = brand;
			}
			public String getModer() {
				return moder;
			}
			public void setModer(String moder) {
				this.moder = moder;
			}
			public int getNumberofcomments() {
				return numberofcomments;
			}
			public void setNumberofcomments(int numberofcomments) {
				this.numberofcomments = numberofcomments;
			}
			public String getStore() {
				return store;
			}
			public void setStore(String store) {
				this.store = store;
			}
			@Override
			public String toString() {
				return "Iphone [name=" + name + ", price=" + price + ", img=" + img + ", Brand=" + Brand + ", moder="
						+ moder + ", numberofcomments=" + numberofcomments + ", store=" + store + "]";
			}
			public Iphone(String name, double price, String img, String brand, String moder, int numberofcomments,
					String store) {
				super();
				this.name = name;
				this.price = price;
				this.img = img;
				Brand = brand;
				this.moder = moder;
				this.numberofcomments = numberofcomments;
				this.store = store;
			}
            
            
}

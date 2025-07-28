package oop.modifier1;

public class Keyboard {
	//멤버 필드는 외부에서 접근이 불가능하게 하고싶다.
	private String name;
	private String type;
	private int key;
	private int price;
	
	//아무런 접근 키워드를 사용하지않으면 이상태를 package 접근제한이라고 부른다
	//->외부 패키지에서 접근이 불가능하다.
	
	//외부의 접근까지 허용할려면 public키워드를 추가해야한다.
	void setName(String name) {
		this.name=name;
		
	}
	String getName() {
		return name;
	}
	String getType() {
		return type;
	}
	void setType(String type) {
		this.type = type;
	}
	int getKey() {
		return key;
	}
	void setKey(int key) {
		this.key = key;
	}
	int getPrice() {
		return price;
	}
	void setPrice(int price) {
		this.price = price;
	}
	
	Keyboard(String name,String type,int key,int price)
	{
		this.setName(name);
		this.setType(type);
		this.setKey(key);
		this.setPrice(price);
	}
	
	void info() {
		System.out.println("키보드 상품정보");
		System.out.println("제품명:"+this.name);
		System.out.println("제품유형:"+this.type);
		System.out.println("키 개수:"+this.key);
		System.out.println("판매가:"+this.price+"원");
		
		
	}
}

package dailyProject;

public class Goods {
	int reviewIdx = 0;
	Review[] review = new Review[50];
	String name;
	Type type;
	int idx, stock, price, sales;
	
	Goods(Type type){
		this.type = type;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getTypeNum() {
		return type.getType();
	}	
	public Type getType() {
		return this.type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock += stock;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String toString() {
		return idx+"번 "+type.toString()+" "+name+" "+price+"원 판매량 : "+sales;
	}
}

interface Type{
	String toString();
	int getType();
}
class Top implements Type{
	public int getType(){
		return 1;
	}
	public String toString() {
		return "상의";
	}
}
class Bottom implements Type{
	public int getType(){
		return 2;
	}
	public String toString() {
		return "하의";
	}
}
class Underwear implements Type{
	public int getType(){
		return 3;
	}
	public String toString() {
		return "속옷";
	}	
}
class Shoes implements Type{
	public int getType(){
		return 4;
	}
	public String toString() {
		return "신발";
	}	
}


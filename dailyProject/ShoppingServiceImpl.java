package dailyProject;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingServiceImpl implements ShoppingService {
	ShoppingServiceImpl(){
		item = new ItemList();
		check = true;
		Goods g1 = new Goods(top);
		
	}
	Scanner scanner = new Scanner(System.in);
	Goods goods;
	ItemList item;
	Page page;
	boolean check;

	Top top = new Top();
	Bottom bottom = new Bottom();
	Underwear underwear = new Underwear();
	Shoes shoes = new Shoes();

	
	@Override
	public void addItem() {
		System.out.print("추가 할 아이템 정보를 입력해주세요.");
		System.out.println("1:상의 2:하의 3:속옷 4:신발");
		while(check) {
			int input = scanner.nextInt();
			switch (input) {
			case 1: goods = new Goods(top); check=false; break;
			case 2: goods = new Goods(bottom); check=false; break;
			case 3: goods = new Goods(underwear); check=false; break;
			case 4: goods = new Goods(shoes); check=false; break;
			default:System.out.println("다시 입력해주세요.");break;
			}
		}
		check = true;
		System.out.println("이름과 가격, 판매량을 입력해주세요.");
		String name = scanner.next();
		int price = scanner.nextInt();
		goods.setName(name);
		goods.setPrice(price);
		int sales = scanner.nextInt();
		goods.setSales(sales);
		item.addItem(goods);
		System.out.printf("추가되었습니다.\n\n");
	}

	@Override
	public void eliminateItem() {
		if(item.goods.size()==0) {
			System.out.println("아이템 목록이 비어있습니다.");
			return;
		}
		int input = scanner.nextInt();
		item.deleteItem(item, input);
	}
	@Override
	public void addStock() {
		System.out.println("수량을 추가하고자 하는 상품 번호를 입력해주세요.");
		int input = scanner.nextInt();		
		try {
			item.goods.get(input);
		}catch(Exception e) {
			System.out.println("존재하지 않는 번호입니다.");
			return;
		}
		System.out.println("추가할 수량을 입력해주세요.");
		int input2 = scanner.nextInt();
		item.goods.get(input).setSales(input2);
		System.out.println("추가되었습니다.");
	}

	@Override
	public void showList(int num) { //0전체 1상의 2하의 3속옷 4신발
		switch (num) {
		case 0:
			for(Goods data : item.goods) {
				System.out.println(data.toString());
			}break;
		case 1:showTypeList(item, 1);break;
		case 2:showTypeList(item, 2);break;
		case 3:showTypeList(item, 3);break;
		case 4:showTypeList(item, 4);break;
		default:break;
		}
	}

	@Override
	public void showTypeList(ItemList itemlist, int num) {
		page = new Page();
		for(int i=0; i<itemlist.goods.size(); i++) {
			if(itemlist.goods.get(i).getTypeNum()==num) {
				page.copy(itemlist.goods, i);
			}
		}
		if(page.array.size()==0) {
			System.out.println("상품이없습니다.");
			return;
		}
		page.show();
	}
	
	@Override
	public void showSalesRate() {
		System.out.println("판매량 순서로 정렬");
		ArrayList<Goods> templist = new ArrayList<Goods>();
		for(Goods data : item.goods) {
			templist.add(data);
		}
		mergeSort(templist);
		for(Goods data : templist) {
			System.out.println(data.toString());
		}
	}

	@Override
	public void buyItem() { //이거는 손님쪽이랑 연계해야함.
		System.out.println("구매하고자 하는 상품번호를 입력해주세요.");
		int input = scanner.nextInt();
		try {
			item.goods.get(input);
		}catch(Exception e) {
			System.out.println("존재하지 않는 번호입니다!");
			return;
		}
		System.out.println("구매하고자 하는 수량을 입력해주세요.");
		int stock = scanner.nextInt();
		if(item.goods.get(input).getStock()<stock) {
			System.out.println("상품수량이 부족합니다.");
			return;
		}
	}
	
	
	
	
	public void mergeSort(ArrayList<Goods> array){
		ArrayList<Goods> temp = new ArrayList<Goods>();
		mergeSort(array,temp,0,array.size()-1);
	}
	public void mergeSort(ArrayList<Goods> array,ArrayList<Goods> temp,int min, int max){
		if(min<max) {
			int mid = (min+max)/2;
			mergeSort(array, temp, min, mid);
			mergeSort(array, temp, mid+1, max);
			merge(array,temp,min,mid,max);
		}
	}
	public void merge(ArrayList<Goods> array,ArrayList<Goods> temp,int min, int mid, int max) {
		temp.clear();
		for(int i=0; i<array.size(); i++) {
			temp.add(array.get(i));
		}
		int left = min;
		int right = mid+1;
		int idx = min;
		while(left<=mid&&right<=max) {
			if(temp.get(left).getSales()>=temp.get(right).getSales()) {
				array.add(idx, temp.get(left));
				array.remove(idx+1);
				left++;
			}else {
				array.add(idx, temp.get(right));
				array.remove(idx+1);
				right++;
			}
			idx++;
		}
		for(int i=0; i<=mid-left; i++) {
			array.add(idx+i,temp.get(left+i));
			array.remove(idx+i+1);
		}
	}

}

class Page{
	Scanner scanner = new Scanner(System.in);
	int max=5;
	int nowpage = 0;
	ArrayList<String> array = new ArrayList<String>();
	void copy(ArrayList<Goods> list, int idx) {
		array.add(list.get(idx).toString());
	}
	void show(){
		Loop1:
		while(true) {
			if(array.size()<max+nowpage*max) {
				for(int i=nowpage*max; i<array.size(); i++) {
					System.out.println(array.get(i));
				}
				System.out.println();
				if(nowpage!=0) {
					System.out.println("이전페이지:1/종료:0\n\n");	
					boolean check = true;
					while(check) {
						int input = scanner.nextInt();
						switch (input) {
						case 0: break Loop1;
						case 1: nowpage--; check = false; break;
						default:System.out.println("잘못입력했습니다.");break;
						}			
					}	
				}
				break;
			}
			for(int i=nowpage*max; i<max+nowpage*max; i++) {
				System.out.println(array.get(i));
			}
			System.out.println();
			
			if(nowpage>0) {
				System.out.println("이전페이지:1/다음페이지:2/종료:0\n\n");	
				boolean check = true;
				while(check) {
					int input = scanner.nextInt();
					switch (input) {
					case 0: break Loop1;
					case 1: nowpage--; check = false; break;
					case 2: nowpage++; check = false; break;
					default:System.out.println("잘못입력했습니다.");break;
					}			
				}
			}else if(nowpage==0) {
				System.out.printf("다음페이지:2/종료:0\n\n");
				boolean check = true;
				while(check) {
					int input = scanner.nextInt();
					switch (input) {
					case 0: break Loop1;
					case 2: nowpage++; check = false; break;
					default:System.out.println("잘못입력했습니다.");break;
					}			
				}
			}
		}
	}
}

class Basket{
	Basket(){
		basket = new ArrayList<Goods>();
		idx = 0;
	}
	ArrayList<Goods> basket;
	int idx;
	
	void addItem(Goods good) {
		basket.add(good);
		idx++;
	}
	void deleteItem(int idx) {
		basket.remove(idx);
	}
	
	String basketString() {
		return "";
	}
}

class ItemList{
	ItemList(){
		goods = new ArrayList<Goods>();
		idx = 0;
	}
	ArrayList<Goods> goods;
	int idx;
	
	void addItem(Goods good) {
		good.setIdx(idx);
		goods.add(good);
		idx++;
	}
	void deleteItem(ItemList item, int aidx) {
		try {
			goods.remove(aidx);			
		}catch(Exception e) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		idx--;
		for(int i=aidx; i<item.goods.size(); i++) {
			item.goods.get(i).setIdx(i);
		}
		System.out.println("해당 항목이 삭제되었습니다.");
	}
}


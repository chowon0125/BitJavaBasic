package dailyProject;

public interface ShoppingService {
	//아이템 추가
	void addItem();
	//아이템 제거
	void eliminateItem();
	//상품 추가
	void addStock();
	//리스트 출력
	void showList(int num);
	//
	void showTypeList(ItemList itemlist, int num);
	//판매량순 정렬
	void showSalesRate();
	//물품 구매
	void buyItem();

}

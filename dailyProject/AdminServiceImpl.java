package dailyProject;

class AdminServiceImpl implements AdminService{
	
	int productIdx = 0;
	int noticeIdx = 0;
	Goods[] productList = new Goods[50]; 
	Notice[] noticeList = new Notice[50];

	public void searchProduct(int idx) {
		boolean check = true;
		for(int i=0; i<productIdx; i++ ) {
			if(idx == productList[i].idx) {
				System.out.printf("상품번호 : %d%n"
						+ "상품명 : %s%n"
						+ "가격 : %d%n"
						+ "재고 : %d%n"
						,productList[i].idx,productList[i].name,productList[i].price,productList[i].stock);
				check = false; break;
			}
		}
		if(check) {System.out.println("일치하는 상품번호가 없습니다.");}
	}
	
	public int getProduct(int idx) {
		boolean check = true;
		int record = -1;
		for(int i=0; i<productIdx; i++ ) {
			if(idx == productList[i].idx) {
				record = i;
				check = false; break;
			}
		}
		if(check) {System.out.println("일치하는 상품번호가 없습니다.");}
		return record;
	}

	public void writeNotice(Notice notice, String content, String date) {
		notice.notice = content;
		notice.date = date;
	}
	
	public void insertNotice(Notice notice) {
		noticeList[noticeIdx] = notice;
		noticeIdx++;
	}
	
	public void printNotice() {
		System.out.println("[공지사항]");
		for(int i=0; i< noticeIdx; i++) {
			System.out.printf("[no.%d]  ", noticeIdx - i);
			System.out.printf("[%s / 작성자 %s / 작성일%s]%n", noticeList[noticeIdx-1-i].notice
					,noticeList[noticeIdx-1-i].writer,noticeList[noticeIdx-1-i].date);
		}
		
	}

	public void writeReview(Review instance, String content, String writer, String date) {
		instance.review = content;
		instance.writer = writer;
		instance.date = date;
	}

	public void insertReview(Goods product, Review review) {
		product.review[product.reviewIdx] = review;
		product.reviewIdx++;
	}

	public void printReview(Goods product) {
		System.out.println("[상품리뷰]");
		for (int i = 0; i < product.reviewIdx; i++) {
			System.out.printf("[no.%d]  ", product.reviewIdx - i);
			System.out.printf("[%s / 작성자 : %s / 작성일 (%s)]%n", (product.review[product.reviewIdx - 1 - i]).review,
					(product.review[product.reviewIdx - 1 - i]).writer,
					(product.review[product.reviewIdx - 1 - i]).date);
		}
	}

}
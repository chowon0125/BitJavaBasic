package dailyProject;

public interface AdminService {
	
	//상품번호 검색(관리자)
	public void searchProduct(int productNum);
	//공지사항 작성
	public void writeNotice(Notice notice, String content, String date);
	//공지사항 등록
	public void insertNotice(Notice notice);
	//공지사항 출력
	public void printNotice();
	//리뷰 작성
	public void writeReview(Review instance, String content, String writer, String date);
	//리뷰 등록
	public void insertReview(Goods product, Review review);
	//리뷰 출력
	public void printReview(Goods product);
	//상품번호 따기
	public int getProduct(int idx);
}
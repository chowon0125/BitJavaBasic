package dailyProject;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerServiceImpl implements CustomerService {
	ArrayList<Customer> customers;
	private int idx;

	public CustomerServiceImpl() {
		customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		idx = 0;
	}

	public boolean idCheck(Customer customer) {
		boolean check = false;
		for (int i = 0; i < customers.size(); i++) {
			if (customer.getUserId().equals(customers.get(i).getUserId())) {
				System.out.println("다시 입력해주세요.");
				check = true;
			}
		}
		return check;
	}

	@Override
	public void join(Customer customer) {
		String gender = customer.getUserBirth();
		String result = "";
		switch (gender.charAt(7)) {
		case '1':
		case '3':
			result = "남성";
			break;
		case '2':
		case '4':
			result = "여성";
			break;
		default:
			result = "오류";
			break;
		}
		customer.setUserGender(result);
		customers.add(customer);
		customers.get(idx).getUserId();
		idx++;
	}

	@Override
	public void print() {
		for (int i = 0; i < customers.size(); i++) {
			System.out.printf("아이디 : %s / 비밀번호 : %s / 이름 : %s / 성별 : %s%n", customers.get(i).getUserId(),
					customers.get(i).getUserPw(), customers.get(i).getUserName(), customers.get(i).getUserGender());
		}
	}

	@Override
	public String login(Customer customer) {
		String result = "로그인 실패";
		for (int i = 0; i < customers.size(); i++) {
			if (customer.getUserId().equals(customers.get(i).getUserId())
					&& customer.getUserPw().equals(customers.get(i).getUserPw())) {
				result = "로그인 성공";
			}
		}
		return result;
	}

	@Override
	public void myPage(Customer customer) {
		for (int i = 0; i < customers.size(); i++) {
			if (customer.getUserId().equals(customers.get(i).getUserId())
					&& customer.getUserPw().equals(customers.get(i).getUserPw())) {
				System.out.printf("아이디: %s 비밀번호: %s 이름: %s 성별: %s%n", customers.get(i).getUserId(),
						customers.get(i).getUserPw(), customers.get(i).getUserName(), customers.get(i).getUserGender());
				break;
			} else {
				System.out.println("등록되지 않은 회원입니다.");
				break;
			}

		}

	}

	@Override
	public String remove(Customer customer) {
		String result = "탈퇴 실패";
		for (int i = 0; i < idx; i++) {
			if (customer.getUserId().equals(customers.get(i).getUserId())
					&& customer.getUserPw().equals(customers.get(i).getUserPw())) {
				Collections.swap(customers, i, idx - 1);
				customers.remove(customers.get(idx - 1));
				idx--;
				result = "탈퇴 완료";
			}
		}
		return result;

	}
}

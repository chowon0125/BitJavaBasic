package p20200622;

public class P0622_4 {
	
	public static void main(String[] args) {
		
		Loop1:
			for(int i=2;i<=9;i++) {
				for(int j=1;j<=9;j++) {
					if(j==5) {
						//break Loop1; // j가 5면 멈추고 Loop1을 아예 빠져나가버린다. 2단 4까지 나옴
						//break; // j가 5면 멈추고 다음 단으로 넘어간다. 각 단 4까지 나옴
						//continue Loop1; // j가 5면 아래 sout 두개를 생략하고 Loop1로 가서 다시 돈다 각 단 4까지 나오는데 줄바꿈이 한번씩 씹힘 
						//continue; // j가 5면 멈추고 j 포문으로 돌아간다. 각단 다 나오는데 5만 빠짐
					}
				System.out.println(i+"*"+j+"="+i*j);
				}
				System.out.println();
			}
		
		
	}

}

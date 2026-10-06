// SWEA #12712 · 파리퇴치3
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AXuARWAqDkQDFARa&solveclubId=AZ7O6ga6XMXHBIQj&probBoxId=AZ7tox26fTHHBINs&problemBoxTitle=+%5B%EB%82%9C%EC%9D%B4%EB%8F%84+%EC%A4%91%5D+SW+%EC%A0%84%EA%B3%B5+%ED%95%84%EC%88%98+%2F+SW+%EB%B9%84%EC%A0%84%EA%B3%B5+%EC%9E%90%EC%9C%A8
// Language: JAVA
// Execution Time: 127 ms
// Memory: 29956 KB

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            int maxFlies = 0;
            
            int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
            int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
                
            int[][] arr = new int[N][N];
            
            for(int i = 0 ; i < N ; i++)
            {
                for(int j = 0 ; j < N ; j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            for(int i = 0 ; i < N ; i++)
            {
                for(int j = 0 ; j < N ; j++)
                {
                    // 십자모양 더하기
                    int flies = arr[i][j];
                    for(int k = 1 ; k < M ; k++)
                    {
                        for(int l= 0 ; l < 4 ; l++)
                        {
                            if(i+k*dy[l] <0 || i+k*dy[l] > N-1)
                                continue;
                            if(j+k*dx[l] <0 || j+k*dx[l] > N-1)
                                continue;
                            flies += arr[i+k*dy[l]][j+k*dx[l]];
                        }
                    }
                    maxFlies = Math.max(maxFlies, flies);
                    // 대각선 더하기
                    flies = arr[i][j];
                    for(int k = 1 ; k < M ; k++)
                    {
                        for(int l= 4 ; l < 8 ; l++)
                        {
                            if(i+k*dy[l] <0 || i+k*dy[l] > N-1)
                                continue;
                            if(j+k*dx[l] <0 || j+k*dx[l] > N-1)
                                continue;
                            flies += arr[i+k*dy[l]][j+k*dx[l]];
                        }
                    }
                    maxFlies = Math.max(maxFlies, flies);
                }
            }
            
            System.out.println("#" + test_case + " " + maxFlies);
		}
	}
}
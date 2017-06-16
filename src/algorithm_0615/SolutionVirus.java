package algorithm_0615;


import java.io.FileInputStream;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class SolutionVirus {
	static int Answer;

	private static int map[][];
	private static int n; //세로 
	private static int m; //가로 
	
	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			// Answer = 0;
			
			//2차원 배열의 지도가 주어진다.
			
			
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			map = new int[n][m];
			int countZero = 0;
			
			//map make
			for ( int i = 0; i < n; i ++ ) {
				
				for ( int j = 0; j < m; j ++ ) {
					
					map[i][j] = sc.nextInt();
					if ( map[i][j] == 0 ) {
						countZero++;
					}
					
				}
				
			}
			
			//map check
			for ( int i = 0; i < n; i ++ ) {
				
				for ( int j = 0; j < m; j ++ ) {
					
					System.out.print(map[i][j] + " ");
						
				}
				
				System.out.println();
				
			}
			
			
				
			//virus play
			for ( int i = 0; i < n; i ++ ) {
				int countWall = 0;
				
				for ( int j = 0; j < m; j ++ ) {
					
					//make the wall
					dfsWall(i, j, countWall);
					
					
						
				}
				
				
			}

			System.out.println("result map---");
			//result map check
			for ( int i = 0; i < n; i ++ ) {
				
				for ( int j = 0; j < m; j ++ ) {
					
					System.out.print(map[i][j] + " ");
					if ( map[i][j] == 0 ) {
						Answer++;
					}
				}
				
				System.out.println();
				
			}
			

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

	private static void dfsWall(int x, int y, int countWall) {
		// TODO Auto-generated method stub
		
		if ( countWall == 3) {
			if ( map[x][y] == 2) {
				virusDFS(x, y);
			}
		}
		
		//possible make the first Wall
		if ( map[x][y] == 0 ) {
			countWall++;
		}
		//possible make the right Wall
		else if ( y+1 < m && map[x][y+1] == 0 ) {
			dfsWall(x, y+1, countWall++);
		}

		//possible make the left Wall
		if ( y-1 >= 0 && map[x][y-1] == 0 ) {
			dfsWall(x, y-1, countWall++ );
		}
		
		//possible make the up Wall
		if ( x-1 >=0 && map[x-1][y] == 0 ) {
			dfsWall(x-1, y, countWall++ );
		}
		
		//possible make the down Wall
		if ( x+1 < n && map[x+1][y] == 0 ) {
			dfsWall(x+1, y, countWall++ );
		}
		
		
		
		
		
		
		
	}

	private static void virusDFS(int i, int j) {
		// TODO Auto-generated method stub
		
		//possible move Up
		if ( i-1 >= 0 && map[i-1][j] == 0 ) {
			map[i-1][j] = 2;
			virusDFS( i-1, j );
		}
		
		//possible move Down
		if ( i+1 < n && map[i+1][j] == 0 ) {
			map[i+1][j] = 2;
			virusDFS( i+1, j );
		}
		
		//possible move Left
		if ( j - 1 >= 0 && map[i][j-1] == 0 ) {
			map[i][j-1] = 2;
			virusDFS( i, j-1 );
		}
		
		//possible move Right
		if ( j + 1 < m && map[i][j+1] == 0 ) {
			map[i][j+1] = 2;
			virusDFS( i, j+1 );
		}
		
		
		
		
	}
}
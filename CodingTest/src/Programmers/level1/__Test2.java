package Programmers.level1;

public class __Test2 {
	
		/*
		 * rows는 2 이상 100 이하인 자연수입니다.
			columns는 2 이상 100 이하인 자연수입니다.
			처음에 행렬에는 가로 방향으로 숫자가 1부터 하나씩 증가하면서 적혀있습니다.
			즉, 아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)입니다.
			queries의 행의 개수(회전의 개수)는 1 이상 10,000 이하입니다.
			queries의 각 행은 4개의 정수 [x1, y1, x2, y2]입니다.
			x1 행 y1 열부터 x2 행 y2 열까지 영역의 테두리를 시계방향으로 회전한다는 뜻입니다.
			1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns입니다.
			모든 회전은 순서대로 이루어집니다.
			예를 들어, 두 번째 회전에 대한 답은 첫 번째 회전을 실행한 다음, 그 상태에서 두 번째 회전을 실행했을 때 이동한 숫자 중 최솟값을 구하면 됩니다.
		 * */
	
	public static void main(String[] args) {
		
		int rows=3;	
		int columns=3;
		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		//result=[1, 1, 5, 3]
		System.out.println(solution(rows,columns,queries));

	}

	static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = {};
		//i 행 j 열에 있는 숫자는 ((i-1) x columns + j)
		
		int[][] box = new int [rows][columns];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				box[i][j] = (i)*columns + j+1;
			}
		}

		for(int i=0;i<queries.length;i++) {		
			int x1 = queries[i][0]; //1행
			int y1 = queries[i][1]; //1열
			int x2 = queries[i][2]; //2행
			int y2 = queries[i][3]; //2열
			
			//1행 1열 -> 1행 2열
			//1행 2열 -> 2행 2열						
			//2행 1열 -> 1행 1열			
			//2행 2열 -> 2행 1열
			
		
			 int row = x1, col = y1;
		     int prev, curr;
		    
		        /*
		        row - Staring row index
		        m - ending row index
		        col - starting column index
		        n - ending column index
		        i - iterator
		        */
		        while (row < rows && col < columns)
		        {
		     
		            if (row + 1 == rows || col + 1 == columns)
		                break;
		     
		            // Store the first element of next
		            // row, this element will replace
		            // first element of current row
		            prev = queries[row + 1][col];
		     
		            // Move elements of first row
		            // from the remaining rows
		            for (int j = col; j < columns; i++)
		            {
		                curr = queries[row][j];
		                queries[row][j] = prev;
		                prev = curr;
		            }
		            row++;
		     
		            // Move elements of last column
		            // from the remaining columns
		            for (int z = row; z < rows; z++)
		            {
		                curr = queries[z][columns-1];
		                queries[i][columns-1] = prev;
		                prev = curr;
		            }
		            columns--;
		     
		            // Move elements of last row
		            // from the remaining rows
		            if (row < rows)
		            {
		                for (int a = columns-1; a >= col; a--)
		                {
		                    curr = queries[rows-1][a];
		                    queries[rows-1][a] = prev;
		                    prev = curr;
		                }
		            }
		            rows--;
		     
		            // Move elements of first column
		            // from the remaining rows
		            if (col < columns)
		            {
		                for (int b = rows-1; b >= row; b--)
		                {
		                    curr = queries[b][col];
		                    queries[b][col] = prev;
		                    prev = curr;
		                }
		            }
		            col++;
		        }
		 
		            // Print rotated matrix
		            for (int c = 0; c < 4; i++)
		            {
		                for (int j = 0; j < 4; j++)
		                System.out.print( queries[i][j] + " ");
		                System.out.print("\n");
		            }
		    }
			
		
		
		//1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns
		//
		
		
		
		return answer;
	}

}

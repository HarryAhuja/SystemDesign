import java.util.Scanner;

public class Game
{
		// final so that reference could not be changed
		private final int  board[][];
		private final int  row_sum[],col_sum[];
		private final User user[];
		private int 	   diag_sum,reverse_diag_sum;		// these are not final as val can be changed
		private final int  N;
		private int 	   winner;
		private int        next_turn;
		private Scanner	   sc;
		
		
		public Game(final int n,User[] user)
		{
			N       		 = n;
			board   		 = new int[n][n];
			row_sum 		 = new int [n];
			col_sum 	     = new int [n];
			this.user		 = user;
			diag_sum 		 = 0;
			reverse_diag_sum = 0;
			sc				 = new Scanner(System.in);
		}
		
		public void print_board()
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(board[i][j]==-1)				System.out.print("H"+" ");
					else if(board[i][j]==1)			System.out.print("S"+" ");
					else							System.out.print("O"+" ");
				}
				System.out.println();
			}
		}
		
		public int get_winner()
		{
			return winner;
		}
		
		/*
		 * Makes move on the board and returns the winner if move is the winning move
		 * @param player : 0 or 1
		 * @param row : 0 to n-1
		 * @param col : 0 to n-1
		 * @return winner : -1: player 0 and +1:player 1 and 0 means otherwise
		 * @throws IllegalArgumentException if move is illegal move
		 */
		
		public int move(int player,int row,int col) throws IllegalArgumentException
		{
			if(row<0 || col<0 || row>=N || col>=N)	throw new IllegalArgumentException("Move out of the board");
			
			if(board[row][col]!=0)					throw new IllegalArgumentException("Cell already occupied");
			
			if(player!=0 && player!=1 )				throw new IllegalArgumentException("Invalid player");
			
			if(get_winner()!=0)					    throw new IllegalArgumentException("Winner is already decided");
			
			board[row][col] = (player==0)?-1:1;
			
			row_sum[row]+= board[row][col];
			col_sum[col]+= board[row][col];
			
			// Add only if its falls on diag or reverse diag
			
			if(row==col)		diag_sum         +=board[row][col];
			if(row+col==N-1)	reverse_diag_sum +=board[row][col];
			
			// just check sum of current cell
			if(N==Math.abs(row_sum[row]) || N==Math.abs(col_sum[col]) ||  N==Math.abs(diag_sum) || N==Math.abs(reverse_diag_sum))
			{
				winner = board[row][col];
			}
			
		
			return winner;
		}
		
		
		public void start_game() throws IllegalArgumentException
		{
			int count  	   = 0;
			User curr_user = user[0];
			int player     = curr_user.getId();								// assuming Harry starts the game
			
			while(true)
			{
				if(count == N*N)
				{
					int winner = get_winner();
					
					switch(winner)
					{
						case 0:
							System.out.println("Match draw");
							break;
						case -1:
							System.out.println("Harry wins");
							break;
						case 1:
							System.out.println("Sherry wins");
							break;
						default:
							System.out.println("Invalid value of winner");
							break;
					}
				}
				System.out.println(curr_user.getName()+"'s Turn");
				print_board();
				
				System.out.println("Enter row index [0:"+(N-1)+"]");
				int row    = sc.nextInt();
				System.out.println("Enter Col index [0:"+(N-1)+"]");
				int col    = sc.nextInt();
				
				int winner = move(player,row,col);
			
				if(winner!=0)
				{
					if(winner==-1)	System.out.println("Harry  wins");
					else			System.out.println("Sherry wins");
					return;
				}
				
				// Toggle players
				player    = player^1;
				curr_user = user[player]; 
				
				count++;
			}
		}
}

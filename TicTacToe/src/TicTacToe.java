
public class TicTacToe
{
	// final so that reference could not be changed
	private final int board[][];
	private final int row_sum[],col_sum[];
	private int 	  diag_sum,reverse_diag_sum;		// these are not final as val can be changed
	private final int N;
	public  int 	  winner;
	
	
	public TicTacToe(final int n)
	{
		N       		 = n;
		board   		 = new int[n][n];
		row_sum 		 = new int [n];
		col_sum 	     = new int [n];
		diag_sum 		 = 0;
		reverse_diag_sum = 0;
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
}

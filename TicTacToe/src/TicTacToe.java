
public class TicTacToe
{
	// final so that reference could not be changed
	private final int board[][];
	private final int N;
	
	public TicTacToe(final int n)
	{
		N     = n;
		board = new int[n][n];
	}
	
	/*
	 * Makes move on the board and returns the winner if move is the winning move
	 * @param player : 0 or 1
	 * @param row : 0 to n-1
	 * @param col : 0 to n-1
	 * @return winner : +1 if first player, -1 if second and 0 otherwise
	 * @throws IllegalArgumentException if move is illegal move
	 */
	
	public int move(int player,int row,int col) throws IllegalArgumentException
	{
		if(row<0 || col<0 || row>=N || col>=N)	throw new IllegalArgumentException("Move out of the board");
		
		if(board[row][col]!=0)	throw new IllegalArgumentException("Cell already occupied");
		
		if(player!=0 && player!=1 )	throw new IllegalArgumentException("Invalid player");
		
		board[row][col] = (player==0)?-1:1;
		
		boolean win_row = true, win_col = true, win_diag = true, win_reverse_diag = true;
		
		for(int i=0;i<N;i++)
		{
			// row
			if(board[i][col]!=board[row][col])
			{
				win_row = false;
				// dont break here bcs we are checking 4 things at a time
				// we can break only if 4 separate for loops
			}
			// col
			if(board[row][i]!=board[row][col])
			{
				win_col = false;
			}
			
			// player can only win in diagonal if row==col
			// diag property is row==col
			if(board[i][i]!=board[row][col])
			{
				win_diag = false;
			}
			 
			// rev diag property is row+col == n-1;
			// if row = i, then col = N-1-row
			if(board[i][N-1-i]!=board[row][col])
			{
				win_diag = false;
			}
		}
	
		
		if(win_row | win_col | win_diag | win_reverse_diag)	return board[row][col];
	}
}

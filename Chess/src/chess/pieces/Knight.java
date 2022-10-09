package chess.pieces;

import chess.Board;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	if(board.getPiece(destination_x, destination_y) != null && 
    			(board.getPiece(destination_x, destination_y).isWhite() == board.getPiece(getX(), getY()).isWhite()))
    			return false;
        	if(Math.abs(getX() - destination_x) == 2 && Math.abs(getY() - destination_y) == 1)
        		return true;
        	else if(Math.abs(getY() - destination_y) == 2 && Math.abs(getX() - destination_x) == 1)
        			return true;
		return false;
    }
}

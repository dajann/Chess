package chess.pieces;

import chess.Board;

public class King extends Piece {

    public King(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	if(board.getPiece(destination_x, destination_y) != null && 
    			(board.getPiece(destination_x, destination_y).isWhite() == board.getPiece(getX(), getY()).isWhite()))
    			return false;
    	if((Math.abs(getX() - destination_x) == 1 && getY() - destination_y == 0) || 
				(Math.abs(getY() - destination_y) == 1 && getX() - destination_x == 0) || 
				(Math.abs(getX() - destination_x) == 1 && Math.abs(getY() - destination_y) == 1)) {
			return true;
		}
		return false;
    }
}

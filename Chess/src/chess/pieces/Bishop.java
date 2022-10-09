package chess.pieces;

import chess.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	if(board.getPiece(destination_x, destination_y) != null && 
    			(board.getPiece(destination_x, destination_y).isWhite() == board.getPiece(getX(), getY()).isWhite()))
    			return false;
    	if(Math.abs(getX() - destination_x) == Math.abs(getY() - destination_y)) {
			if(getX() > destination_x && getY() > destination_y) {
				for(int i = 1 ; i < getX() - destination_x; i++)
					if(board.getPiece(getX() - i, getY() - i) != null)
						return false;
				return true;
			}
			else if(getX() > destination_x && getY() < destination_y) {
				for(int i = 1 ; i < getX() - destination_x; i++)
					if(board.getPiece(getX() - i, getY() + i) != null)
						return false;
				return true;
			}
			else if(getX() < destination_x && getY() > destination_y) {
				for(int i = 1 ; i < destination_x - getX(); i++)
					if(board.getPiece(getX() + i, getY() - i) != null)
						return false;
				return true;
			}
			else if(getX() < destination_x && getY() < destination_y) {
				for(int i = 1 ; i <destination_x - getX(); i++)
					if(board.getPiece(getX() + i, getY() + i) != null)
						return false;
				return true;
			}
		}
		return false;
    }
}

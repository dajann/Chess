package chess.pieces;

import chess.Board;

public class Queen extends Piece {

    public Queen(int x, int y, boolean is_white, String file_path, Board board) {
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
    	else if(destination_x == getX() && destination_y != getY()){
			if(destination_y > getY()) {
				for(int i = getY() + 1; i < destination_y; i++) {
					if(board.getPiece(destination_x, i) != null)
						return false;
					}
				return true;
				}
			else if(destination_y < getY()) {
				for(int i = getY() - 1; i > destination_y; i--) {
					if(board.getPiece(destination_x, i) != null)
						return false;
					}
				return true;
				}
			}
		
		else if(destination_x != getX() && destination_y == getY()){
			if(destination_x > getX()) {
				for(int i = getX() + 1; i < destination_x; i++) {
					if(board.getPiece(i, destination_y) != null)
						return false;
					}
				return true;
				}
			else if(destination_x < getX()) {
				for(int i = getX() - 1; i > destination_x; i--) {
					if(board.getPiece(i, destination_y) != null)
						return false;
					}
				return true;
				}

		}
		return false;
    }
}

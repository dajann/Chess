package chess.pieces;

import chess.Board;

public class Pawn extends Piece {

    public Pawn(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	if(isWhite() && destination_y == getY() + 1 && destination_x == getX() && board.getPiece(destination_x, destination_y)  ==  null)
			return true;
		else if(isWhite() && destination_y == getY() + 1 && ((destination_x == getX() + 1) || destination_x == getX() - 1) &&
				board.getPiece(destination_x, destination_y) != null && board.getPiece(destination_x, destination_y).isBlack())
			return true;
		else if(isBlack() && destination_y == getY() - 1 && destination_x == getX() && board.getPiece(destination_x, destination_y)  ==  null)
			return true;
		else if(isBlack() && destination_y == getY() - 1 && ((destination_x == getX() + 1) || destination_x == getX() - 1) &&
				board.getPiece(destination_x, destination_y) != null && board.getPiece(destination_x, destination_y).isWhite())
			return true;
		return false;
    }
}

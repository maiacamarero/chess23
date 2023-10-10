package gameState

import piece.Piece
import piece.PieceColor

class InitialGameState(private val boardSize : Int, private val pieces : List<Piece>, private val color : PieceColor) {

    fun getBoardSize() : Int{
        return boardSize
    }

    fun getPieces() : List<Piece>{
        return pieces
    }

    fun getColor() : PieceColor{
        return color
    }

}

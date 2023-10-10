package gameState

import piece.Piece
import piece.PieceColor
import turnStrategy.TurnStrategy

class InitialGameState(private val boardSize : Int, private val pieces : List<Piece>, private val color : TurnStrategy) {

    fun getBoardSize() : Int{
        return boardSize
    }

    fun getPieces() : List<Piece>{
        return pieces
    }

    fun getColor() : TurnStrategy{
        return color
    }

}

package gameState

import piece.Piece
import piece.PieceColor

class InvalidMovementState(private val boardSize : Int, private val pieces : List<Piece>, private val color : PieceColor) {

}
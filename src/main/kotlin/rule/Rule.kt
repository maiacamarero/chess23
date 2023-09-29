
import board.Board
import src.validator.Movement

interface Rule {
    fun isValidRule(board: Board, movement: Movement) : Boolean

}

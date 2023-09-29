package rule
import board.Board
import validator.Movement

interface Rule {
    fun isValidRule(board: Board, movement: Movement) : Boolean

}

package validator

import board.Board

interface Validator {
    fun validateMovement(board: Board, movement: Movement) : Boolean
}
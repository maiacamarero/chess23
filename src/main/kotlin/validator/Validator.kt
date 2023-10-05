package validator

import board.Board
import validator.results.ValidatorResult


interface Validator {
    fun validateMovement(board: Board, movement: Movement) : ValidatorResult
}
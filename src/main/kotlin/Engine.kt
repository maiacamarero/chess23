
import board.Board
import piece.Piece
import piece.PieceColor
import gameState.GameState
import gameState.InitialGameState
import gameState.InvalidMovementState
import gameState.NewGameState
import turnStrategy.RegularTurnStrategy
import turnStrategy.TurnStrategy
import validator.Movement
import java.util.*

class Engine {

    private val sc = Scanner(System.`in`)
    private val board = BoardFactory.createInitClassicBoard()
    private val movementStrategy = MovementStrategy()

    fun init() : InitialGameState {
        //chooseConfiguration()
        val turnStrategy : TurnStrategy = RegularTurnStrategy(PieceColor.WHITE)
        return InitialGameState(board.getSizeX(), board.getPiecesPositions().values.toList(), turnStrategy)
    }

    fun applyMove(movement: Movement) : GameState {
        val pieceToMove : Piece = movement.getPiece()
        val turnStrategy : TurnStrategy = RegularTurnStrategy(pieceToMove.getPieceColor())
        val toPosition : Position = movement.getFinalPosition()
        return if (pieceToMove.getPieceColor() != turnStrategy.getCurrentColor()){
            InvalidMovementState("Es el turno del color " + turnStrategy.getCurrentColor())
        }else{
            val newBoard : Board = movementStrategy.moveTo(pieceToMove, toPosition, board)
            NewGameState(newBoard.getPiecesPositions(), turnStrategy.advanceTurn().getCurrentColor())
        }
    }

    private fun chooseConfiguration() {
        var continuar = true
        while (continuar) {
            println("Ingrese la configuración deseada: \n 1. Classic ") //2. Capablanca
            val option: Int = sc.nextInt()
            continuar = if (option == 1) {
                //turnStrategy = RegularTurnStrategy(PieceColor.WHITE)
                false
            } else {
                //boardFactory.createOtherBoard()
                false
            }
        }
    }

    fun getBoard(): Board{
        return board
    }
}
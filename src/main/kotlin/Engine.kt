
import board.Board
import exception.PieceNotFoundException
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
    private val historicalBoards : MutableList<Board> = mutableListOf()
    private val movementStrategy = MovementStrategy()

    fun init() : InitialGameState {
        //chooseConfiguration()
        val board = BoardFactory.createInitialClassicBoard()
        historicalBoards.add(board)
        val turnStrategy : TurnStrategy = RegularTurnStrategy(PieceColor.WHITE)
        return InitialGameState(board.getSizeX(), board.getPiecesPositions(), turnStrategy)
    }

    fun applyMove(movement: Movement) : GameState {
        val pieceToMove : Piece = movement.getPiece()
        val turnStrategy : TurnStrategy = RegularTurnStrategy(pieceToMove.getPieceColor())
        val toPosition : Position = movement.getFinalPosition()
        return if (pieceToMove.getPieceColor() != turnStrategy.getCurrentColor()){
            InvalidMovementState("Es el turno del color " + turnStrategy.getCurrentColor())
        }else{
            val newBoard : Board = movementStrategy.moveTo(pieceToMove, toPosition, getBoard(historicalBoards, historicalBoards.size))
            historicalBoards.add(newBoard)
            NewGameState(newBoard.getPiecesPositions(), turnStrategy.advanceTurn().getCurrentColor(), newBoard.getPositions())
        }
    }

    fun getBoard(historicalBoards : List<Board>, size : Int): Board{
        return historicalBoards[size-1]
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

    fun getBoard() : Board{
        for (board in historicalBoards){
            return board
        }
        throw PieceNotFoundException("")
    }
}
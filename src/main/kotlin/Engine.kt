
import board.Board
import piece.Piece
import piece.PieceColor
import gameState.GameState
import gameState.InitialGameState
import gameState.InvalidMovementState
import gameState.NewGameState
import turnStrategy.RegularTurnStrategy
import validator.Movement
import java.util.*

class Engine(private var turnStrategy: RegularTurnStrategy) {

    private val sc = Scanner(System.`in`)
    private val boardFactory = BoardFactory()
    private val board = boardFactory.createClassicBoard()
    private val movementStrategy = MovementStrategy()

    fun init() : InitialGameState {
        chooseConfiguration()
        return InitialGameState(board.getX(), board.getPiecesPositions().values.toList(), PieceColor.WHITE)
    }

    fun getBoard(): Board{
        return board
    }

//    private var initialColor: PieceColor  EL GAME MANAGER O ALGO ASI DEBERIA SABER DE QUIEN ES EL TURNO
//    LOS STATES PUEDEN SER INVALID MOVE SI EL MOVIMIENTO ES INVALIDO POR ALGUN MOTIVO O GAME STATE SI ES VALIDO
    fun applyMove(movement: Movement) : GameState {
        val pieceToMove : Piece = movement.getPiece()
        val fromPosition : Position = board.getPositionByPiece(pieceToMove)
        val toPosition : Position = movement.getFinalPosition()
    return if (pieceToMove.getPieceColor() != turnStrategy.getCurrentColor()){
        InvalidMovementState("Es el turno del color " + turnStrategy.getCurrentColor())
    }else{
        val moveTo : Boolean = movementStrategy.moveTo(pieceToMove, toPosition, board)
        println(moveTo)
        NewGameState(board.getPiecesPositions(), turnStrategy.advanceTurn().getCurrentColor())
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
}
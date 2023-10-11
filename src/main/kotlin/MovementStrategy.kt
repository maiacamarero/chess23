import board.Board
import gameState.GameState
import gameState.NewGameState
import piece.Piece
import rule.Rule
import turnStrategy.RegularTurnStrategy
import turnStrategy.TurnStrategy
import validator.Movement

class MovementStrategy {

    fun moveTo(pieceToMove: Piece, toPosition: Position, board: Board): Board{

        val piecesPositionsCopy : MutableMap<Position, Piece> = board.getPiecesPositions().toMutableMap()
        val fromPosition : Position = board.getPositionByPiece(pieceToMove)
        val ruleList : List<Rule> = pieceToMove.getRuleList()
        ruleList.forEach{
            rule: Rule -> if (rule.isValidRule(board, Movement(pieceToMove, toPosition))::class.simpleName == "SuccessfulRuleResult"){
                val targetPiece : Piece? = board.getPiecesPositions()[toPosition]
                if (targetPiece == null){
                    piecesPositionsCopy.remove(fromPosition)
                }else {
                    //come
                    piecesPositionsCopy.remove(toPosition)
                }
                piecesPositionsCopy[toPosition] = pieceToMove
                piecesPositionsCopy.toMap()
                return BoardFactory.createNewClassicBoard(piecesPositionsCopy, board)
            }
        }
        return board
    }
}
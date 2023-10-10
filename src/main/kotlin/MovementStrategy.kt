import board.Board
import piece.Piece
import rule.Rule
import validator.Movement

class MovementStrategy {

    fun moveTo(pieceToMove: Piece, toPosition: Position, board: Board): Boolean{
        val mutableMap : MutableMap<Position, Piece> = board.getPiecesPositions().toMutableMap()
        val ruleList : List<Rule> = pieceToMove.getRuleList()
        ruleList.forEach{
            rule: Rule -> if (rule.isValidRule(board, Movement(pieceToMove, toPosition))::class.simpleName == "SuccessfulRuleResult"){
                val targetPiece : Piece? = board.getPiecesPositions()[toPosition]
                if (targetPiece != null){
                    mutableMap.remove(toPosition)
                }
                mutableMap[toPosition] = pieceToMove
                return true
            }
        }
        mutableMap.toMap()
        return false
    }
}
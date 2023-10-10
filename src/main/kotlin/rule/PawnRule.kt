package rule
import Position
import board.Board
import piece.Piece
import piece.PieceColor
import rule.result.FailureRuleResult
import rule.result.SuccessfulRuleResult
import rule.result.RuleValidatorResult
import validator.*

class PawnRule : Rule {

    private val diagonalMovementValidator = DiagonalMovementValidator() //come
    private val verticalMovementValidator = VerticalMovementValidator() //se mueve
    private val piecesInPathValidator = PiecesInPathValidator()
    private val sameColorValidator = SameColorValidator()

    override fun isValidRule(board: Board, movement: Movement): RuleValidatorResult {
        val pieceTarget : Piece? = board.getPiecesPositions().get(movement.getFinalPosition())
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        val incrementByColor : Int = if (movement.getPiece().getPieceColor().equals(PieceColor.WHITE)){ -1 } else 1
        val boardLimit : Int = if (movement.getPiece().getPieceColor().equals(PieceColor.WHITE)){
            board.getY() -1
        }else{
            (board.getY() - (board.getY() - 2))
        }
        // movimiento normal, avanzan 1 para adelante
        if (verticalMovementValidator.validateMovement(board, movement)){
            if ((pieceActualPosition.getY() + incrementByColor == movement.getFinalPosition().getY())){
                if (pieceTarget == null){
                    return SuccessfulRuleResult("Movimiento valido para el peon")
                }
            }
            // movimiento inicial
            else if ((pieceActualPosition.getY() == boardLimit) && (movement.getFinalPosition().getY() == boardLimit + 2 * incrementByColor)){
                if (pieceTarget != null){
                    return FailureRuleResult("No puede tomar esa posicion, hay otra pieza")
                }
                if (piecesInPathValidator.validateMovement(board, movement)){
                    return FailureRuleResult("El peon no puede saltar piezas")
                }
                return SuccessfulRuleResult("Movimiento inicial del peon")
            }
        }
        // movimiento para comer
        else if ((diagonalMovementValidator.validateMovement(board, movement))
            && (movement.getFinalPosition().getY() == pieceActualPosition.getY() + incrementByColor)){
            if (pieceTarget == null){
                return FailureRuleResult("No hay ninguna pieza para comer, movimiento invalido")
            }
            if (sameColorValidator.validateMovement(board, movement)){
                return FailureRuleResult("La pieza es del mismo equipo")
            }
            return SuccessfulRuleResult("Movimiento valido para comer")
        }
        return FailureRuleResult("No es movimiento valido para el peon")
    }
}

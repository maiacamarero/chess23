package turnStrategy

import piece.PieceColor

class RegularTurnStrategy(private val color : PieceColor) : TurnStrategy {
    override fun advanceTurn(): TurnStrategy {
        return if (color == PieceColor.WHITE){
            RegularTurnStrategy(PieceColor.BLACK)
        }else{
            RegularTurnStrategy(PieceColor.WHITE)
        }
    }

    override fun getCurrentColor(): PieceColor {
        return color
    }
}
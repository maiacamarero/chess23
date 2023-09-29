package piece

import rule.Rule

interface Piece {
    fun getId() : String
    fun getPieceColor() : PieceColor
    fun getRuleList() : List<Rule>

}
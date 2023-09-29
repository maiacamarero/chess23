package piece

import rule.Rule


class Bishop(private val id: String, private val pieceColor: PieceColor, private val ruleList: List<Rule>) : Piece {

    override fun getId(): String {
        return id
    }

    override fun getPieceColor(): PieceColor {
        return pieceColor
    }

    override fun getRuleList(): List<Rule> {
        return ruleList
    }
}

class PieceFactory {

    companion object{
        private var id : Int = 0

        fun createKing(pieceColor: PieceColor) : Piece {

            return King(id++.toString(), pieceColor, listOf(KingRule()))
        }

        fun createRook(pieceColor: PieceColor) : Piece {
            return Rook("" + id++, pieceColor, listOf(RookRule()))
        }

        fun createBishop(pieceColor: PieceColor) : Piece {
            return Bishop("" + id++, pieceColor, listOf(BishopRule()))
        }

        fun createQueen(pieceColor: PieceColor) : Piece {
            return Queen("" + id++, pieceColor, listOf(QueenRule()))
        }

        fun createKnight(pieceColor: PieceColor) : Piece {
            return Knight("" + id++, pieceColor, listOf(KnightRule()))
        }

        fun createPawn(pieceColor: PieceColor) : Piece {
            return Pawn("" + id++, pieceColor, listOf(PawnRule()))
        }
    }

}
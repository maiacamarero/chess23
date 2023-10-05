package factory

import piece.Bishop
import rule.BishopRule
import piece.King
import rule.KingRule
import piece.Knight
import rule.KnightRule
import piece.Pawn
import rule.PawnRule
import piece.PieceColor
import piece.Queen
import rule.QueenRule
import piece.Rook
import rule.RookRule
import piece.Piece

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


import board.Board
import board.ClassicBoard
import factory.PieceFactory
import piece.Piece
import piece.PieceColor

class BoardFactory {

    companion object {
        fun createInitialClassicBoard(): Board {
            val piecesPositions: MutableMap<Position, Piece> = mutableMapOf()
            val positions: List<Position> = fillPositions()
            for (position in positions) {
                if ((position.getX() >= 1 || position.getX() <= 8)) {
                    if (position.getY() == 2) {
                        piecesPositions[position] = PieceFactory.createPawn(PieceColor.BLACK)
                    }
                    if (position.getY() == 7) {
                        piecesPositions[position] = PieceFactory.createPawn(PieceColor.WHITE)

                    }
                }
                if ((position.getX() == 1 || position.getX() == 8)) {
                    if (position.getY() == 1) {
                        piecesPositions[position] = PieceFactory.createRook(PieceColor.BLACK)
                    }
                    if (position.getY() == 8) {
                        piecesPositions[position] = PieceFactory.createRook(PieceColor.WHITE)
                    }
                }
                if (position.getX() == 2 || position.getX() == 7) {
                    if (position.getY() == 1) {
                        piecesPositions[position] = PieceFactory.createKnight(PieceColor.BLACK)
                    }
                    if (position.getY() == 8) {
                        piecesPositions[position] = PieceFactory.createKnight(PieceColor.WHITE)
                    }
                }
                if (position.getX() == 3 || position.getX() == 6) {
                    if (position.getY() == 1) {
                        piecesPositions[position] = PieceFactory.createBishop(PieceColor.BLACK)
                    }
                    if (position.getY() == 8) {
                        piecesPositions[position] = PieceFactory.createBishop(PieceColor.WHITE)
                    }
                }
                if (position.getX() == 4) {
                    if (position.getY() == 1) {
                        piecesPositions[position] = PieceFactory.createQueen(PieceColor.BLACK)
                    }
                    if (position.getY() == 8) {
                        piecesPositions[position] = PieceFactory.createQueen(PieceColor.WHITE)
                    }
                }
                if (position.getX() == 5) {
                    if (position.getY() == 1) {
                        piecesPositions[position] = PieceFactory.createKing(PieceColor.BLACK)
                    }
                    if (position.getY() == 8) {
                        piecesPositions[position] = PieceFactory.createKing(PieceColor.WHITE)
                    }
                }
            }

            return ClassicBoard(8, 8, piecesPositions.toMap(), positions)
        }

        fun createNewClassicBoard(piecesPositions : Map<Position, Piece>, board: Board): Board {
            return ClassicBoard(board.getSizeX(), board.getSizeY(), piecesPositions, board.getPositions())
        }

        private fun fillPositions(): List<Position> {
            val positions1: MutableList<Position> = mutableListOf()
            for (i in 1..8) {
                for (j in 1..8) {
                    positions1.add(Position(i, j))
                }
            }
            return positions1.toList()
        }
    }


}
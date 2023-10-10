

import board.Board
import board.ClassicBoard
import factory.PieceFactory
import piece.Piece
import piece.PieceColor

class BoardFactory {

    fun createClassicBoard() : Board {
        val piecesPositions : MutableMap<Position, Piece> = mutableMapOf()
        val positions : List<Position> = fillPositions()
        for (position in positions){
            if ((position.getX() >= 1 || position.getX() <= 8)){
                if (position.getY() == 2){
                    piecesPositions[position] = PieceFactory.createPawn(PieceColor.BLACK)
                }
                if (position.getY() == 7){
                    piecesPositions[position] = PieceFactory.createPawn(PieceColor.WHITE)

                }
            }
            if ((position.getX() == 1 || position.getX() == 8)){
                if (position.getY() == 1){
                    piecesPositions[position] = PieceFactory.createRook(PieceColor.BLACK)
                }
                if (position.getY() == 8){
                    piecesPositions[position] = PieceFactory.createRook(PieceColor.WHITE)
                }
            }
            if (position.getX() == 2 || position.getX() == 7){
                if (position.getY() == 1){
                    piecesPositions[position] = PieceFactory.createKnight(PieceColor.BLACK)
                }
                if (position.getY() == 8){
                    piecesPositions[position] = PieceFactory.createKnight(PieceColor.WHITE)
                }
            }
            if (position.getX() == 3 || position.getX() == 6){
                if (position.getY() == 1){
                    piecesPositions[position] = PieceFactory.createBishop(PieceColor.BLACK)
                }
                if (position.getY() == 8){
                    piecesPositions[position] = PieceFactory.createBishop(PieceColor.WHITE)
                }
            }
            if (position.getX() == 4){
                if (position.getY() == 1){
                    piecesPositions[position] = PieceFactory.createQueen(PieceColor.BLACK)
                }
                if (position.getY() == 8){
                    piecesPositions[position] = PieceFactory.createQueen(PieceColor.WHITE)
                }
            }
            if (position.getX() == 5){
                if (position.getY() == 1){
                    piecesPositions[position] = PieceFactory.createKing(PieceColor.BLACK)
                }
                if (position.getY() == 8){
                    piecesPositions[position] = PieceFactory.createKing(PieceColor.WHITE)
                }
            }
        }
//        piecesPositions[Position(1,1)] = PieceFactory.createRook(PieceColor.BLACK)
//        piecesPositions[Position(1,8)] = PieceFactory.createRook(PieceColor.WHITE)
//        piecesPositions[Position(8,1)] = PieceFactory.createRook(PieceColor.BLACK)
//        piecesPositions[Position(8,8)] = PieceFactory.createRook(PieceColor.WHITE)

//        piecesPositions[Position(2,1)] = PieceFactory.createKnight(PieceColor.BLACK)
//        piecesPositions[Position(2,8)] = PieceFactory.createKnight(PieceColor.WHITE)
//        piecesPositions[Position(7,1)] = PieceFactory.createKnight(PieceColor.BLACK)
//        piecesPositions[Position(7,8)] = PieceFactory.createKnight(PieceColor.WHITE)

//        piecesPositions[Position(3,1)] = PieceFactory.createBishop(PieceColor.BLACK)
//        piecesPositions[Position(3, 8)] = PieceFactory.createBishop(PieceColor.WHITE)
//        piecesPositions[Position(6,1)] = PieceFactory.createBishop(PieceColor.BLACK)
//        piecesPositions[Position(6,8)] = PieceFactory.createBishop(PieceColor.WHITE)

//        piecesPositions[Position(4,1)] = PieceFactory.createQueen(PieceColor.BLACK)
//        piecesPositions[Position(4,8)] = PieceFactory.createQueen(PieceColor.WHITE)
//
//        piecesPositions[Position(5,1)] = PieceFactory.createKing(PieceColor.BLACK)
//        piecesPositions[Position(5,8)] = PieceFactory.createKing(PieceColor.WHITE)

//        for (i in 1..8){
//            piecesPositions[Position(i, 2)] = PieceFactory.createPawn(PieceColor.BLACK)
//            piecesPositions[Position(i, 7)] = PieceFactory.createPawn(PieceColor.WHITE)
//        }

        return ClassicBoard(8, 8, piecesPositions, positions)
    }

    private fun fillPositions() : List<Position>{
        val positions1 : MutableList<Position> = mutableListOf()
        for (i in 1..8) {
            for (j in 1..8) {
                positions1.add(Position(i, j))
            }
        }
        return positions1.toList()
    }


}
package piece

import Engine
import Position
import gameState.NewGameState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import validator.Movement
import kotlin.test.assertContains

class RookTest{
    @Test
    fun validRookVerticalMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(8, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(8, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(8, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(8, 8))
        val whiteRook: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteRook, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), toPosition1)
    }

    @Test
    fun validRookHorizontalMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(8, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(8, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(8, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(8, 8))
        val whiteRook: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteRook, toPosition1)) as NewGameState

        val toPosition3 : Position = engine.getBoard().getPosition(Position(8, 4))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(8, 3))
        val blackPawn1: Piece = gameState1.getPiecesPositions()[fromPosition3]!!
        val gameState3 : NewGameState = engine.applyMove(Movement(blackPawn1, toPosition3)) as NewGameState

        val toPosition4 : Position = engine.getBoard().getPosition(Position(1, 6))
        val fromPosition4 : Position = engine.getBoard().getPosition(Position(8, 6))
        val whiteRook1: Piece = gameState3.getPiecesPositions()[fromPosition4]!!
        val gameState4 : NewGameState = engine.applyMove(Movement(whiteRook1, toPosition4)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState4.getPiecesPositions().size)
        assertContains(gameState4.getPiecesPositions(), toPosition4)
    }

    @Test
    fun invalidRookMoveTest(){
        val engine = Engine()
        engine.init()

        //la torre no salta piezas
        val toPosition1 : Position = engine.getBoard().getPosition(Position(8, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(8, 8))
        val whiteRook: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteRook, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), fromPosition1)
    }
}
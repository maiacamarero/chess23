package piece

import Engine
import Position
import gameState.NewGameState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import validator.Movement
import kotlin.test.assertContains

class KnightTest{
    @Test
    fun validKnightMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition1 : Position = engine.getBoard().getPosition(Position(8, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(7, 8))
        val whiteKnight: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKnight, toPosition1)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState1.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition3 : Position = engine.getBoard().getPosition(Position(7, 4))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(8, 6))
        val whiteKnight1: Piece = gameState2.getPiecesPositions()[fromPosition3]!!
        val gameState3 : NewGameState = engine.applyMove(Movement(whiteKnight1, toPosition3)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState3.getPiecesPositions().size)
        assertContains(gameState3.getPiecesPositions(), toPosition3)
    }

    @Test
    fun validKnightMoveToEatTest(){
        val engine = Engine()
        engine.init()

        val toPosition1 : Position = engine.getBoard().getPosition(Position(8, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(7, 8))
        val whiteKnight: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKnight, toPosition1)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(7, 4))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(7, 2))
        val blackPawn: Piece = gameState1.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition3 : Position = engine.getBoard().getPosition(Position(7, 4))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(8, 6))
        val whiteKnight1: Piece = gameState2.getPiecesPositions()[fromPosition3]!!
        val gameState3 : NewGameState = engine.applyMove(Movement(whiteKnight1, toPosition3)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState3.getPiecesPositions().size)
        assertContains(gameState3.getPiecesPositions(), toPosition3)
    }

    @Test
    fun invalidKnightMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition1 : Position = engine.getBoard().getPosition(Position(7, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(7, 8))
        val whiteKnight: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKnight, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), fromPosition1)
    }
}
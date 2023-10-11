package piece

import Engine
import Position
import gameState.NewGameState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import validator.Movement
import kotlin.test.assertContains

class KingTest{
    @Test
    fun validWhiteKingForwardMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(5, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(5, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(5, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), toPosition1)
    }

    @Test
    fun invalidWhiteKingForwardMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition1 : Position = engine.getBoard().getPosition(Position(5, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), fromPosition1)
    }

    @Test
    fun validWhiteKingForwardRightMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(6, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(6, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(6, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), toPosition1)
    }

    @Test
    fun invalidWhiteKingForwardRightMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition1 : Position = engine.getBoard().getPosition(Position(6, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), fromPosition1)
    }

    @Test
    fun validWhiteKingForwardLeftMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(4, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(4, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(4, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), toPosition1)
    }

    @Test
    fun invalidWhiteKingForwardLeftMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition1 : Position = engine.getBoard().getPosition(Position(4, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), fromPosition1)
    }

    @Test
    fun validBlackKingForwardMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(5, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(5, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(5, 4))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(5, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(5, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(5, 8))
        val whiteKing: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteKing, toPosition1)) as NewGameState

        val toPosition3 : Position = engine.getBoard().getPosition(Position(5, 2))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(5, 1))
        val blackKing: Piece = gameState1.getPiecesPositions()[fromPosition3]!!
        val gameState3 : NewGameState = engine.applyMove(Movement(blackKing, toPosition3)) as NewGameState


        val sizeExpected = 32
        assertEquals(sizeExpected, gameState3.getPiecesPositions().size)
        assertContains(gameState3.getPiecesPositions(), toPosition1)
    }
}
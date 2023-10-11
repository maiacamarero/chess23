package piece

import Engine
import Position
import gameState.NewGameState
import validator.Movement
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertContains

class PawnTest{

    @Test
    fun validPawnInitialMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(1, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(1, 7))
        val piece: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(piece, toPosition)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState.getPiecesPositions().size)
        assertContains(gameState.getPiecesPositions(), toPosition)
    }

    @Test
    fun validPawnMoveTest(){
        val engine = Engine()
        engine.init()

        val toPosition : Position = engine.getBoard().getPosition(Position(1, 6))
        val fromPosition : Position = engine.getBoard().getPosition(Position(1, 7))
        val piece: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(piece, toPosition)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState.getPiecesPositions().size)
        assertContains(gameState.getPiecesPositions(), toPosition)
    }

    @Test
    fun validPawnMoveToEatTest(){
        val engine = Engine()
        engine.init()
        //muevo peon blanco
        val toPosition4 : Position = engine.getBoard().getPosition(Position(1, 6))
        val fromPosition4 : Position = engine.getBoard().getPosition(Position(1,7))
        val whitePawn2: Piece = engine.getBoard().getPiecesPositions()[fromPosition4]!!
        val gameState4 = engine.applyMove(Movement(whitePawn2, toPosition4)) as NewGameState

        //muevo peon negro
        val toPosition : Position = engine.getBoard().getPosition(Position(5,3))
        val fromPosition : Position = engine.getBoard().getPosition(Position(5,2))
        val blackPawn: Piece = gameState4.getPiecesPositions()[fromPosition]!!
        val gameState = engine.applyMove(Movement(blackPawn, toPosition)) as NewGameState

        // muevo otro peon blanco
        val toPosition3 : Position = engine.getBoard().getPosition(Position(7, 6))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(7,7))
        val whitePawn1: Piece = gameState.getPiecesPositions()[fromPosition3]!!
        val gameState3 = engine.applyMove(Movement(whitePawn1, toPosition3)) as NewGameState

        // muevo el alfil para que sea comido
        val toPosition1 = engine.getBoard().getPosition(Position(2, 5))
        val fromPosition1 = engine.getBoard().getPosition(Position(6, 1))
        val blackBishop = gameState3.getPiecesPositions()[fromPosition1]!!
        val gameState1 = engine.applyMove(Movement(blackBishop, toPosition1)) as NewGameState

        // el peon se come el alfil
        val toPosition2 : Position = engine.getBoard().getPosition(Position(2, 5))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(1, 6))
        val whitePawn: Piece = gameState1.getPiecesPositions()[fromPosition2]!!
        val gameState2 = engine.applyMove(Movement(whitePawn, toPosition2)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState2.getPiecesPositions().size)
        assertContains(gameState2.getPiecesPositions(), toPosition2)
    }

    @Test
    fun invalidPawnMoveTest(){
        val engine = Engine()
        engine.init()
        //no se puede mover para atras
        val toPosition : Position = engine.getBoard().getPosition(Position(1, 6))
        val fromPosition : Position = engine.getBoard().getPosition(Position(1,7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState1 = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(1, 7))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(1,6))
        val whitePawnReturnsToOriginalPosition: Piece = gameState1.getPiecesPositions()[fromPosition1]!!
        val gameState4 = engine.applyMove(Movement(whitePawnReturnsToOriginalPosition, toPosition1)) as NewGameState


        val sizeExpected = 32
        assertEquals(sizeExpected, gameState4.getPiecesPositions().size)
        assertContains(gameState4.getPiecesPositions(), fromPosition1)
    }

    @Test
    fun invalidPawnMoveToEatTest(){
        val engine = Engine()
        engine.init()
        // No hay nada para que coma
        val toPosition : Position = engine.getBoard().getPosition(Position(2, 6))
        val fromPosition : Position = engine.getBoard().getPosition(Position(1, 7))
        val piece: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(piece, toPosition)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState.getPiecesPositions().size)
        assertContains(gameState.getPiecesPositions(), fromPosition)

    }

}
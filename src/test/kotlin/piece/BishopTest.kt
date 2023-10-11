package piece

import Engine
import Position
import gameState.NewGameState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import validator.Movement
import kotlin.test.assertContains

class BishopTest{

    @Test
    fun validBishopMoveTest1(){

        //movimiento normal del alfil
        val engine = Engine()
        engine.init()

        //muevo peon para liberar alfil
        val toPosition : Position = engine.getBoard().getPosition(Position(4, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(4, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState

        val toPosition1 : Position = engine.getBoard().getPosition(Position(5, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(3, 8))
        val whiteBishop: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteBishop, toPosition1)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState1.getPiecesPositions().size)
        assertContains(gameState1.getPiecesPositions(), toPosition1)
    }

    @Test
    fun validBishopMoveTest2(){
        // el alfil puede volver para atras
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

        val toPosition1 : Position = engine.getBoard().getPosition(Position(5, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(3, 8))
        val whiteBishop: Piece = gameState2.getPiecesPositions()[fromPosition1]!!
        val gameState1 : NewGameState = engine.applyMove(Movement(whiteBishop, toPosition1)) as NewGameState

        val toPosition3 : Position = engine.getBoard().getPosition(Position(8, 4))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(8, 3))
        val blackPawn3: Piece = gameState1.getPiecesPositions()[fromPosition3]!!
        val gameState3 : NewGameState = engine.applyMove(Movement(blackPawn3, toPosition3)) as NewGameState

        val toPosition4 : Position = engine.getBoard().getPosition(Position(4, 7))
        val fromPosition4 : Position = engine.getBoard().getPosition(Position(5, 6))
        val whiteBishop1: Piece = gameState3.getPiecesPositions()[fromPosition4]!!
        val gameState4 : NewGameState = engine.applyMove(Movement(whiteBishop1, toPosition4)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState4.getPiecesPositions().size)
        assertContains(gameState4.getPiecesPositions(), toPosition4)
    }

    @Test
    fun invalidBishopMoveTest1(){
        val engine = Engine()
        engine.init()

        // el alfil no salta piezas
        val toPosition : Position = engine.getBoard().getPosition(Position(5, 6))
        val fromPosition : Position = engine.getBoard().getPosition(Position(3, 8))
        val whiteBishop: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whiteBishop, toPosition)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState.getPiecesPositions().size)
        assertContains(gameState.getPiecesPositions(), fromPosition)
    }

    @Test
    fun invalidBishopMoveTest2(){
        val engine = Engine()
        engine.init()

        // el alfil no se mueve verticalmente
        val toPosition : Position = engine.getBoard().getPosition(Position(3, 5))
        val fromPosition : Position = engine.getBoard().getPosition(Position(3, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        val gameState : NewGameState = engine.applyMove(Movement(whitePawn, toPosition)) as NewGameState

        val toPosition2 : Position = engine.getBoard().getPosition(Position(8, 3))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(8, 2))
        val blackPawn: Piece = gameState.getPiecesPositions()[fromPosition2]!!
        val gameState2 : NewGameState = engine.applyMove(Movement(blackPawn, toPosition2)) as NewGameState


        val toPosition3 : Position = engine.getBoard().getPosition(Position(3, 7))
        val fromPosition3 : Position = engine.getBoard().getPosition(Position(3, 8))
        val whiteBishop: Piece = gameState2.getPiecesPositions()[fromPosition3]!!
        val gameState3 : NewGameState = engine.applyMove(Movement(whiteBishop, toPosition3)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState3.getPiecesPositions().size)
        assertContains(gameState3.getPiecesPositions(), fromPosition3)
    }
}
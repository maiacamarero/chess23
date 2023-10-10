package piece

import Engine
import Position
import gameState.NewGameState
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import validator.Movement
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertContains

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PawnTest{

    private val engine = Engine()

    @BeforeAll
    fun init(){
        engine.init()
    }

    @Test
    fun validPawnInitialMoveTest(){
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
        val toPosition : Position = engine.getBoard().getPosition(Position(7, 3))
        val fromPosition : Position = engine.getBoard().getPosition(Position(7, 2))
        val blackPawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition]!!
        engine.applyMove(Movement(blackPawn, toPosition))

        val toPosition1 : Position = engine.getBoard().getPosition(Position(3, 6))
        val fromPosition1 : Position = engine.getBoard().getPosition(Position(7, 1))
        val blackBishop: Piece = engine.getBoard().getPiecesPositions()[fromPosition1]!!
        engine.applyMove(Movement(blackBishop, toPosition1))

        val toPosition2 : Position = engine.getBoard().getPosition(Position(3, 6))
        val fromPosition2 : Position = engine.getBoard().getPosition(Position(2, 7))
        val whitePawn: Piece = engine.getBoard().getPiecesPositions()[fromPosition2]!!
        val gameState = engine.applyMove(Movement(whitePawn, toPosition2)) as NewGameState

        val sizeExpected = 32
        assertEquals(sizeExpected, gameState.getPiecesPositions().size)
        assertContains(gameState.getPiecesPositions(), fromPosition)
    }

    @Test
    fun invalidPawnMoveToEatTest(){
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
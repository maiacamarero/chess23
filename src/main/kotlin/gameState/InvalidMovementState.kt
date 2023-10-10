package gameState

import piece.Piece
import piece.PieceColor
import sun.swing.plaf.synth.DefaultSynthStyle.StateInfo

class InvalidMovementState(val reason : String) : GameState {

}
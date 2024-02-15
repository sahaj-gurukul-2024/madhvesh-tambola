import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TambolaTest {
    private lateinit var ticket: Ticket
    private lateinit var game: Game
    @BeforeEach
    fun setup(){
        game = Game()
    }
    @Test
    fun `check for Top Row claim as True in ticket`(){
        //arrange
        val ticketValues = mutableListOf(
            mutableListOf(4, 16, 48, 63, 76),
            mutableListOf(7, 23, 38, 52, 80),
            mutableListOf(9, 25, 56, 64, 83)
        )
        val announcedNumbers = listOf(4, 23, 38, 48, 63, 52, 76)
        val claim = "Top Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //
        assertTrue(booleanValue)
    }
    @Test
    fun `check for Early 5 row claim as True in ticket`(){
        //arrange
        val ticketValues = mutableListOf(
            mutableListOf(4, 16, 48, 63, 76),
            mutableListOf(7, 23, 38, 52, 80),
            mutableListOf(9, 25, 56, 64, 83)
        )
        val announcedNumbers = listOf(4, 23, 48, 63, 76)
        val claim = "Early 5"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //
        assertTrue(booleanValue)
    }
    @Test
    fun `check for Early 5 row claim as False in ticket`(){
        //arrange
        val ticketValues = mutableListOf(
            mutableListOf(4, 16, 48, 63, 76),
            mutableListOf(7, 23, 38, 52, 80),
            mutableListOf(9, 25, 56, 64, 83)
        )
        val announcedNumbers = listOf(4, 23, 48, 63, 76, 90)
        val claim = "Early 5"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //
        assertFalse(booleanValue)
    }

}
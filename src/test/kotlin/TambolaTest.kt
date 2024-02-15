import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TambolaTest {
    private lateinit var game: Game
    private lateinit var ticketValues: MutableList<MutableList<Int>>
    @BeforeEach
    fun setup(){
        game = Game()
        ticketValues = mutableListOf(
            mutableListOf(4, 16, 48, 63, 76),
            mutableListOf(7, 23, 38, 52, 80),
            mutableListOf(9, 25, 56, 64, 83)
        )
    }
    @Test
    fun `check for Top Row claim as True in ticket`(){
        //arrange

        val announcedNumbers = listOf(4, 16, 48, 63, 76)
        val claim = "Top Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //
        assertTrue(booleanValue)
    }
    @Test
    fun `check for Bottom Row claim as True in ticket`(){
        //arrange
        val announcedNumbers = listOf(9, 25, 56, 64, 83)
        val claim = "Bottom Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertTrue(booleanValue)
    }
    @Test
    fun `check for Middle Row claim as True in ticket`(){
        //arrange
        val announcedNumbers = listOf(7, 23, 38, 52, 80)
        val claim = "Middle Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertTrue(booleanValue)
    }

    @Test
    fun `check for Early 5 row claim as True in ticket`(){
        //arrange
        val announcedNumbers = listOf(4, 23, 48, 63, 76)
        val claim = "Early 5"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertTrue(booleanValue)
    }
    @Test
    fun `check for Full House claim as True in ticket`(){
        //arrange
        val announcedNumbers = listOf(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83)
        val claim = "Full House"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertTrue(booleanValue)
    }

    @Test
    fun `check for Top Row claim as False in ticket`(){
        //arrange
        val announcedNumbers = listOf(4, 16, 48, 63, 76, 80)
        val claim = "Top Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertFalse(booleanValue)
    }
    @Test
    fun `check for Bottom Row claim as False in ticket`(){
        //arrange
        val announcedNumbers = listOf(9, 25, 56, 64, 83, 96)
        val claim = "Bottom Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertFalse(booleanValue)
    }
    @Test
    fun `check for Middle Row claim as False in ticket`(){
        //arrange
        val announcedNumbers = listOf(7, 23, 38, 52, 80, 48)
        val claim = "Middle Row"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertFalse(booleanValue)
    }
    @Test
    fun `check for Early 5 row claim as False in ticket`(){
        //arrange
        val announcedNumbers = listOf(4, 23, 48, 63, 76, 90)
        val claim = "Early 5"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertFalse(booleanValue)
    }
    @Test
    fun `check for Full House claim as False in ticket`(){
        //arrange
        val announcedNumbers = listOf(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83, 96)
        val claim = "Full House"
        //act
        val ticket = Ticket(ticketValues)
        val booleanValue = game.validate(ticket, announcedNumbers, claim)
        //assert
        assertFalse(booleanValue)
    }

}
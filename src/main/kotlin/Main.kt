fun main()
{
    val ticketValues = mutableListOf(
        mutableListOf(4, 16, 48, 63, 76),
        mutableListOf(7, 23, 38, 52, 80),
        mutableListOf(9, 25, 56, 64, 83)
    )
    val ticket = Ticket(ticketValues)
    val announcedNumbers = listOf(4, 23, 48, 63, 76, 90)
    val claim = "Early 5"
    val game = Game()
    println(game.validate(ticket, announcedNumbers, claim))
}
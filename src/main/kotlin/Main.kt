fun main()
{
    val ticketValues = listOf(
        listOf(4, 16, 48, 63, 76),
        listOf(7, 23, 38, 52, 80),
        listOf(9, 25, 56, 64, 83)
    )
    val ticket = Ticket(ticketValues)
    val announcedNumbers = listOf(90, 4, 46, 63, 89, 16, 76, 48)
    val claim = "Top Row"
    val game = Game()
    game.validate(ticket, announcedNumbers, claim)
}
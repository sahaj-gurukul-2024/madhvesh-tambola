class Game {
    fun validate(ticket: Ticket, announcedNumbers: List<Int>, claim: String)
    {
        announcedNumbers.forEach() {announceValue ->
            iterateThrough(ticket, announceValue)
        }
    }

    fun iterateThrough(ticket: Ticket, announceValue: Int) {
        val ticketMatrix = ticket.ticketVal
        val numberOfRows = ticket.ticketVal.size
        for (rowNumber in 0..<numberOfRows)
        {
            var numberOfColumns = ticketMatrix[rowNumber].size
            for(columnNumber in 0..<numberOfColumns)
            {
                if(ticketMatrix[rowNumber][columnNumber] == announceValue)
                {
                    ticketMatrix.
                }

            }
        }
    }

}
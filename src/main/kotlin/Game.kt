class Game {
    fun validate(ticket: Ticket, announcedNumbers: List<Int>, claim: String): Boolean
    {
        announcedNumbers.forEach() {announceValue ->
            var ticketMatrix = iterateThrough(ticket, announceValue)
            if(ticketMatrix[0].size == 0 && announcedNumbers.indexOf(announceValue) == announcedNumbers.size-1)
            {
                return true
            }
        }
        return false
    }

    fun iterateThrough(ticket: Ticket, announceValue: Int): MutableList<MutableList<Int>>{
        val ticketMatrix = ticket.ticketVal
        val numberOfRows = ticket.ticketVal.size
        for (rowNumber in 0..<numberOfRows)
        {
            var numberOfColumns = ticketMatrix[rowNumber].size
            for(columnNumber in 0..<numberOfColumns)
            {
                if(ticketMatrix[rowNumber][columnNumber] == announceValue)
                {
                    ticketMatrix[rowNumber].remove(announceValue)
                    return  ticketMatrix

                }

            }
        }
        return ticketMatrix
    }

}
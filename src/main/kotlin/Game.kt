class Game {
    fun validate(ticket: Ticket, announcedNumbers: List<Int>, claim: String): Boolean
    {
        if(claim == "Top Row") {
            announcedNumbers.forEach() { announceValue ->
                var ticketMatrix = iterateThrough(ticket, announceValue)
                if (ticketMatrix[0].size == 0) {
                    if (announcedNumbers.indexOf(announceValue) == announcedNumbers.size - 1)
                        return true
                    else
                        return false
                }
            }
            return false
        }
        else if(claim == "Bottom Row") {
            announcedNumbers.forEach() { announceValue ->
                var ticketMatrix = iterateThrough(ticket, announceValue)
                if (ticketMatrix[ticketMatrix.size-1].size == 0) {
                    if (announcedNumbers.indexOf(announceValue) == announcedNumbers.size - 1)
                        return true
                    else
                        return false
                }
            }
            return false
        }
        else if(claim == "Early 5") {
            var count = 0
            announcedNumbers.forEach() {announceValue->
                count = count + iterate(ticket, announceValue)
                if(count == 5)
                {
                    if (announcedNumbers.indexOf(announceValue) == announcedNumbers.size - 1)
                        return true
                    else
                        return false
                }
            }
            return false
        }
        else
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
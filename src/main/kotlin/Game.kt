class Game {
    fun validate(ticket: Ticket, announcedNumbers: List<Int>, claim: String): Boolean {
        when (claim) {
            "Top Row" -> {
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
            "Bottom Row" -> {
                announcedNumbers.forEach() { announceValue ->
                    var ticketMatrix = iterateThrough(ticket, announceValue)
                    if (ticketMatrix[ticketMatrix.size - 1].size == 0) {
                        if (announcedNumbers.indexOf(announceValue) == announcedNumbers.size - 1)
                            return true
                        else
                            return false
                    }
                }
                return false
            }
            "Middle Row" -> {
                announcedNumbers.forEach() { announceValue ->
                    var ticketMatrix = iterateThrough(ticket, announceValue)
                    if (ticketMatrix[ticketMatrix.size - 2].size == 0) {
                        if (announcedNumbers.indexOf(announceValue) == announcedNumbers.size - 1)
                            return true
                        else
                            return false
                    }
                }
                return false
            }
            "Full House" -> {
                return earlyFiveFullHouseCheck(ticket, announcedNumbers, claim)
            }
            "Early 5" -> {
                 return earlyFiveFullHouseCheck(ticket, announcedNumbers, claim)
            }
            else -> return false
        }
    }
    private fun earlyFiveFullHouseCheck(ticket: Ticket, announcedNumbers: List<Int>, claim: String):Boolean{
        var count = 0
        announcedNumbers.forEach() { announceValue ->
            count = count + iterate(ticket, announceValue)
            if ((count == 5 && claim == "Early 5") || (count == 15 && claim == "Full House") ) {
                if (announcedNumbers.indexOf(announceValue) == announcedNumbers.size - 1)
                    return true
                else
                    return false
            }
        }
        return false
    }
    private fun iterateThrough(ticket: Ticket, announceValue: Int): MutableList<MutableList<Int>> {
        val ticketMatrix = ticket.ticketVal
        val numberOfRows = ticket.ticketVal.size
        for (rowNumber in 0..<numberOfRows) {
            var numberOfColumns = ticketMatrix[rowNumber].size
            for (columnNumber in 0..<numberOfColumns) {
                if (ticketMatrix[rowNumber][columnNumber] == announceValue) {
                    ticketMatrix[rowNumber].remove(announceValue)
                    return ticketMatrix
                }
            }
        }
        return ticketMatrix
    }
    private fun iterate(ticket: Ticket, announceValue: Int): Int {
        val ticketMatrix = ticket.ticketVal
        val numberOfRows = ticket.ticketVal.size
        for (rowNumber in 0..<numberOfRows) {
            var numberOfColumns = ticketMatrix[rowNumber].size
            for (columnNumber in 0..<numberOfColumns) {
                if (ticketMatrix[rowNumber][columnNumber] == announceValue) {
                    ticketMatrix[rowNumber].remove(announceValue)
                    return 1
                }
            }
        }
        return 0
    }
}
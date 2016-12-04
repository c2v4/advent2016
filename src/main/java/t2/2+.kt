package t2


fun main(args: Array<String>) {
    val CHARS = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D')
    var line = readLine()
    var current = 5
    while (!line.isNullOrEmpty()) {
        if (line != null) {
            for (char in line) {
                when (char) {
                    'U' -> {
                        when (current) {
                            3 -> current = 1
                            in 6..8 -> current -= 4
                            in 10..12 -> current -= 4
                            13 -> current = 11
                        }
                    }
                    'D' -> {
                        when (current) {
                            1 -> current = 3
                            in 2..4 -> current += 4
                            in 6..8 -> current += 4
                            11 -> current = 13
                        }
                    }
                    'L' -> current = if (listOf(1, 2, 5, 10, 13).contains(current)) current else current - 1
                    'R' -> current = if (listOf(1, 4, 9, 12, 13).contains(current)) current else current + 1
                    else -> throw RuntimeException()
                }
            }
            print(CHARS[current])
            //////////////////////////////////////
            line = readLine()
        }
    }
}


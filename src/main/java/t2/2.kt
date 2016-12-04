package t2

fun main(args: Array<String>) {
    var line = readLine()
    var current = 5
    while (!line.isNullOrEmpty()) {
        if (line != null) {
            for (char in line) {
                when (char) {
                    'U' -> current = if (current > 3) current - 3 else current
                    'D' -> current = if (current < 7) current + 3 else current
                    'L' -> current = if (listOf(1, 4, 7).contains(current)) current else current - 1
                    'R' -> current = if (listOf(3, 6, 9).contains(current)) current else current + 1
                    else -> throw RuntimeException()
                }
            }
            print(current)
            //////////////////////////////////////
            line = readLine()
        }
    }
}
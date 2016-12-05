package t4

import kotlin.comparisons.compareValuesBy

fun main(args: Array<String>) {

    var line = readLine()
    var sum = 0

    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        if (real(line)) {
            val find = Regex("\\d+").find(line)!!.value.toInt()
            sum+= find
        }
        /////////////////////////////////////
        line = readLine()
    }
    print(sum)

}

fun real(room: String): Boolean {
    val split = room.split(Regex("\\d+"))
    val checksum = split[1].substring(1..5)
    val map = hashMapOf<Char, LetterWithOccurrence>()
    for (char in split[0]) {
        if (char == '-') continue
        if (map.containsKey(char)) {
            map[char]!!.occurrence++
        } else {
            map.put(char, LetterWithOccurrence(char))
        }
    }
    val sorted = map.values.sorted()
    var real = true
    for (i in 0..4) {
        real = real && (sorted[i].char == checksum[i])
    }
    return real
}

data class LetterWithOccurrence(val char: Char, var occurrence: Int = 1) : Comparable<LetterWithOccurrence> {
    override fun compareTo(other: LetterWithOccurrence): Int =
            compareValuesBy(this, other, { -it.occurrence }, { it.char })

}
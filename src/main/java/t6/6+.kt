package t6

import java.util.*

fun main(args: Array<String>) {

    var line = readLine()!!.trim()
    val strings: MutableList<String> = mutableListOf()
    var len: Int = -1
    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        strings.add(line)
        if (len == -1) len = line.length
        /////////////////////////////////////
        line = readLine()!!.trim()
    }
    (0..len-1).forEach {
        i -> strings.map { it[i] }.maxBy {
        -Collections.frequency(strings.map { it[i] },it) }.let(::print) }

}
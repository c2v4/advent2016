package t7

fun Int.isEven() = this % 2 == 0

fun isTLS(input: String): Boolean {
    val split = input.split(Regex("[\\[\\]]"))
    var evenAbba = false
    for (i in (0..split.size - 1)) {
        if (i.isEven()) {
            if (!evenAbba) {
                evenAbba = containsABBA(split[i])
            }
        } else {
            if (containsABBA(split[i])) return false
        }
    }
    return evenAbba
}

fun containsABBA(input: String): Boolean {
    if (input.length < 4) return false
    return (3..(input.length - 1)).any {
        input[it - 3] != input[it - 2] &&
                input[it - 3] == input[it] &&
                input[it - 2] == input[it - 1]
    }
}

fun main(args: Array<String>) {
    var line = readLine()!!.trim()
    var correct =0
    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        if (isTLS(line)) correct++
        /////////////////////////////////////
        line = readLine()!!.trim()
    }
    print(correct)
}
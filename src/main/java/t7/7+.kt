package t7


fun isSSL(input: String): Boolean {
    val split = input.split(Regex("[\\[\\]]"))

    val babs:List<String> = ((0..split.size - 1) step 2)
            .map { getABAs(split[it]) }
            .filterNot { it.isEmpty() }
            .flatten()
            .map(::abaToBab)
    if (babs.isEmpty()) return false

    return (1..split.size - 1 step 2).any { i -> babs.any { split[i].contains(it) } }
}

fun abaToBab(input: String): String {
    return input.substring(1) + input[1]
}

fun getABAs(input: String): List<String> {
    if (input.length < 3) return emptyList()
    return (2..(input.length - 1))
            .filter {
                input[it - 2] != input[it - 1] && input[it - 2] == input[it]
            }.map { input.substring((it - 2)..it) }
}

fun main(args: Array<String>) {
    var line = readLine()!!.trim()
    var correct = 0
    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        if (isSSL(line)) correct++
        /////////////////////////////////////
        line = readLine()!!.trim()
    }
    print(correct)
}
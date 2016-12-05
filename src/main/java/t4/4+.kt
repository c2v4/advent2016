package t4

fun main(args: Array<String>) {

    var line = readLine()

    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        println(Regex("\\d+").find(line)!!.value +':'+ realName(line))
        /////////////////////////////////////
        line = readLine()
    }

}

fun realName(room: String): String {
    val toDecode = room.split(Regex("\\d+"))[0]
    val code = Regex("\\d+").find(room)!!.value.toInt()
    val stringBuilder = StringBuilder(toDecode.length)
    for (char in toDecode) {
        stringBuilder.append(if (char == '-') ' ' else ((char.toInt() - 97 + code) % 26 +97).toChar())
    }
    return stringBuilder.toString()
}

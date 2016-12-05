package t5

fun main(args: Array<String>) {
    val line = readLine()
    var index = 0L
    var password = kotlin.arrayOfNulls<Char>(8)
    while (password.contains(null)) {
        val md5 = md5(line + index)
        if (md5.startsWith("00000")) {
            val toInt = Integer.parseInt(md5[5].toString(),16)
            if ((toInt in 0..7)&&password[toInt] == null) {
                password[toInt] = md5[6]
            }
        }
        index++
    }
    password.forEach(::print)

}
package t3

fun main(args: Array<String>) {

    var line = readLine()
    var fine = 0
    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        if (line != null) {
            val split = line.trim().split(Regex("\\s+"))
            if (split[0].toInt() >= (split[1].toInt() + split[2].toInt())) {
                line = readLine()
                continue
            }
            if (split[1].toInt() >=(split[0].toInt() + split[2].toInt())) {
                line = readLine()
                continue
            }
            if (split[2].toInt() >= (split[0].toInt() + split[1].toInt())) {
                line = readLine()
                continue
            }
            fine++
        }
        /////////////////////////////////////
        line = readLine()
    }
    print(fine)

}
package t5

import java.security.MessageDigest

fun main(args: Array<String>) {
    val line = readLine()
    var index =0L
    var password =""
    while(password.length<8){
        val md5 = md5(line + index)
        if(md5.startsWith("00000")){
            password+=md5[5]
        }
        index++
    }
    print(password)
}

fun md5(input: String): String {
    val md = java.security.MessageDigest.getInstance("MD5")
    val array = md.digest(input.toByteArray())
    val sb = StringBuffer()
    for (i in array.indices) {
        sb.append(Integer.toHexString(array[i].toInt() and 0xFF or 0x100).substring(1, 3))
    }
    return sb.toString()
}
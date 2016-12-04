import java.util.*

fun main(args: Array<String>) {
    var x: Int = 0
    var y: Int = 0
    var dir: Int = 0
    val line = readLine()
    val split = line?.split(", ")
    split?.forEach {
        val direction = it[0]
        val length = it.substring(1..it.length - 1).toInt()
        if (direction == 'R') {
            //right
            dir = (dir + 1) % 4
        } else {
            //left
            dir = (((dir - 1) % 4) + 4) % 4
        }
        when (dir) {
            0 -> y += length
            1 -> x += length
            2 -> y -= length
            3 -> x -= length
        }
    }
    println("first: " + (Math.abs(x) + Math.abs(y)))
    if (split != null) {
        val pair = pair(split)
        println("second: " + pair)
    }
}

private fun pair(split: List<String>): Int {
    val visited = ArrayList<Point>()
    visited.add(Point(0, 0))
    var dir1 = 0
    for (it in split) {
        val direction = it[0]
        val length = it.substring(1..it.length - 1).toInt()
        if (direction == 'R') {
            //right
            dir1 = (dir1 + 1) % 4
        } else {
            //left
            dir1 = (((dir1 - 1) % 4) + 4) % 4
        }
        for (i in 1..length) {
            val point: Point
            val last = visited.last()
            when (dir1) {
                0 -> point = Point(last.x, last.y+1)
                1 -> point = Point(last.x+1, last.y)
                2 -> point = Point(last.x, last.y-1)
                3 -> point = Point(last.x-1, last.y)
                else -> throw RuntimeException()
            }
            if (visited.contains(point)){
                return Math.abs(point.x)+Math.abs(point.y)
            }
            visited.add(point)
        }
    }
    return 0
}

data class Point(val x: Int, val y: Int)

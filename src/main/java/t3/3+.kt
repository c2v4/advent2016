package t3

import java.util.*

fun correct(x:Int,y:Int,z:Int) = (x<(y+z))&&(y<(x+z))&&(z<(y+x))

fun main(args: Array<String>) {

    var line = readLine()
    var fine = 0
    var counter=0
    val triangles = ArrayList<ArrayList<Int>>()
    triangles.add(ArrayList(3))
    triangles.add(ArrayList(3))
    triangles.add(ArrayList(3))
    while (!line.isNullOrEmpty()) {
        if (line!!.isEmpty()) break
        val split = line.trim().split(Regex("\\s+"))
        for (i in 0..2){
            triangles[i].add(split[i].toInt())
        }
        counter++
        if (counter==3){
            counter=0
            for (i in 0..2){
                val list = triangles[i]
                if (correct(list[0],list[1],list[2])) {
                    fine++
                }
                list.clear()
            }
        }
        /////////////////////////////////////
        line = readLine()
    }
    print(fine)

}
//infix  fun Int.doooo (x:Int): Int = this+x
//
//
//infix fun String.bogdan ( str:String) = "$this Bogdan! $str"

fun <D> D.myApply (f: D.()->Unit):D {
    this.f()
  return  this
}

    fun createMap ():Map<Int, String> {
        return hashMapOf<Int,String>().myApply {
            put(0,"zero")
            for (i in 1..10){
                put(i,"$i")
        }
        }
    }
fun main() {
println(createMap())
//    println(7 doooo 4)
//
//    println("Hello" bogdan "=)))")
}
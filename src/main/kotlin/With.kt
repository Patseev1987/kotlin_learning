fun main() {
    var x =10
    println(x)
   val b =  with(x) {
        this+100
    }
    println(b)
    println(x)

    println(createMap())

}
//    fun <T> T.myApply (f:T.()-> Unit):T{
//        this.f()
//      return  this
//    }
//
//fun createMap() : Map<Int,String> {
//    return hashMapOf<Int, String>().myApply {
//        put(0,"zero")
//        for (i in 1..10){
//            put(i,"$i")
//        }
//    }
//}

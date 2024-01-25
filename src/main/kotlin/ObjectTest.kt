object Test {
    fun myFoo(a: Int, b: Int) {
        println(a + b)
    }
}

data class Dog(val name: String, var age: Int) {
    companion object {
        fun letBark() {
            println("gav gav gav")
        }
    }
}


fun myB():String {
    with(StringBuilder()){
        for (l in 'A'..'Z'){
            append(l)
            append(" ")
        }
        append("\nTHE END!")
        return toString()
    }
}


fun main() {
    Test.myFoo(10, 12)
    Dog.letBark()
    val myList = mutableListOf<Int>();
    println(myList)
for (i in 1..100){
   myList.add(i)
}
   val k = myList.filter { it>50 }
    println(myList)
    println(k)
    val l = myList.map { it+10 }
    println(l)
    val m = myList.filter { it>10 && it<20 }.map { it -1 }.map{it.toString()}.map{it+"!"}

    val pair = Pair(1,"a")
   val o = pair.second 
    println(pair)
    println(o)


    val kkk = myB()
    println(kkk)


    myList.apply { for(i in 1..3){
        this.add(i)
        remove(this[i])
    }
    }
    println(myList)

}
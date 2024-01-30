package sem4

data class Student(var name:String, var age:Int){
    val nick:MutableList<String> = mutableListOf()


    fun  show() {
        println(nick)
    }
    operator fun String.unaryPlus() {
        nick.add(this)
    }

    operator fun Int.unaryPlus(){
        nick.add(this.toString())
    }
}

fun student (block:Student.()-> Unit ):Student{
var st = Student("",0)
    st.block()
    return st
}


fun main( ) {


    val s = student {
        name = "John Smith"
        age = 17

        +"red"
        +"dfghjkl;"
        + "asdasd"
    }

    println(s)
    s.show()

}

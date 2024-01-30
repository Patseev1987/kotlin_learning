package sem4.delegate

import kotlin.reflect.KProperty
var fff:Int = 0
class Delegate(){

    var x = 100
    operator fun getValue(foo: Foo, property: KProperty<*>): Int {
              return x
    }

    operator fun setValue(foo: Foo, property: KProperty<*>, i: Int) {
                println("$i will be assigned for $property")
        x = i
    }

}


fun main() {
    val sss = Foo()

   println(sss.p)
    sss.p=999
    println(sss.p)
}

class Foo {
    var p:Int by Delegate()


    var t:Int by ::fff
}

//fun getEmail():String = "asd@asd.com"
//
//class Foo{
//    val email by lazy {
//        println("You got new email!")
//        getEmail() }
//}
//
//fun main() {
//    val foo = Foo()
//
//    println("""The first time
//        |${foo.email}
//    """.trimMargin())
//
//    println("""The second time
//        |${foo.email}
//    """.trimMargin())
//}
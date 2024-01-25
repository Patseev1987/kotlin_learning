fun main  (){
    val number:Int = 10
    val str: String = "Kotlin"
    val flag:Boolean = true
        val number2 = 1000
    println("Hello world! $number \n$str\n$flag")
//   var myStr =  readln()
//    println("This is my string - $myStr")
    println(sum(number,number2))

//  println(  foo(7,8){x,c -> ((x+c)*(x+c)).toString()})


    val x = if (number>11) {
        88
    } else 40
    println(x)
    println(o("10"))

    var count = 0
    while (count<10){
        println(message = "This $count time")
        count++
    }

    for (i in 0..10){
         println(i)
    }

    val person = Person("John",37)
    println(person)
    person.foo = "Bogdan"
    println(person.foo)
}



fun o(str:String) = when (str){
    "10" -> 100
    "1" -> 99
    else -> -1
}

fun sum (number1:Int, number2: Int):Int{
  return  number1+number2
}

fun foo (number:Int, number2: Int, function: (Int,Int) -> String){
    function(number,number2)
}

val test = {x:Int,c:Int -> x*x-c}

data class Person (val name:String, var age:Int) {
    var foo: String = ""
        set(value) {
            println("Kotlin")
            field = value
        }
}
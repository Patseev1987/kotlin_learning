fun addString (str1:String ,str2:String,   union:(String, String)-> String):String{
  return union(str1,str2)
}

fun String.printLettersInString(){
    for (b in this){
        println(b)
    }
}




fun main() {
  val sss =  addString("John", "Poul"){a,b -> a+b}
    println(sss)

    val aaa = addString("ffffff","gggggg"){a,b -> a.substring(0,2)+b.substring(0,2)}
println(aaa)
    sss.printLettersInString()

    fizzBuxx()
}


fun fizzBuxx(){
    for (i in  1..25){
        val result = when {
            ((i%3==0) && (i%5==0)) -> "FizzBuZZ"
            (i%3==0) -> "Fizz"
            (i%5==0) -> "Buzz"
            else -> i
        }
        println(result)
    }
}

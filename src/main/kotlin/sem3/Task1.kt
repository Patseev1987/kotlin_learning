package sem3


//Написать функцию-расширение calc к классу List, такую что
//1. Она имеет обобщенный параметр, такой же как тип элемента
//списка.
//2. Первым аргументом она принимает s типа Int.
//3. Вторым аргументом – лямбда-выражение, принимающее тип
//элемента массива и возвращающее Int.
//4. Функция должна применять лямбда-выражение к каждому s
//элементу списка и суммировать значения, полученные при
//вычислении лямбда-выражения. Итоговая сумма будет
//результатом функции calc.



fun <T> List<T>.calc(s:Int, operation:(T)->Int ):Int{

  val result:Int =  this.map{operation(it)}
      .filter { it==s }
      .fold(0){start,item -> start+item}
    return result
}

fun main() {
    val list1 = listOf("aaa", "add", "ajhw", "yewt", "yedv")
    println(list1.calc(4) {
        it.length
    })
    val list2 = listOf(3, 6, 4, 8, 11, 32, 2, 6, 21, 3)
    println(list2.calc(2) {
        it
    })
    val list3 = emptyList<Double>()
    println(list3.calc(1) {
        it.toInt()
    })
}

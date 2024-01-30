package sem4.task2

//1. Написать программу, которая принимает два аргумента командной
//строки и вычисляет их сумму.
//2. Написать свой класс исключения NotIntArgumentException(arg: String)
//3. Для вычисления суммы реализовать функцию
//sum(a: String, b: String): Int
//4. В этой функции, при преобразовании строки в число, обработать
//исключение NumberFormatException и заменить его на
//NotIntArgumentException.
//5. В функции main, при вызове функции sum, обработать как
//NotIntArgumentException, так и IndexOutOfBoundsException (оно
//возникнет при обращении к массиву args по индексу в случае, если было
//передано менее двух аргументов командной строки).

fun main(vararg st:String) {
    try {
        sum(st[0],st[1])
    } catch (e:NotIntArgumentException){
        println(e.message)
    }catch (e:IndexOutOfBoundsException){
        println("Not enough data")
    }
}
fun sum(a:String, b:String){
    try{
    val left = a.toInt()
    val right = b.toInt()
        println(left+right)
} catch (e:NumberFormatException){
    throw NotIntArgumentException("We can't get integer value")
    }}
class NotIntArgumentException(arg: String):Exception(arg)
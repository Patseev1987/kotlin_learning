package sem4.task1


//1.Переписать объявление переменной stackTraceLogger, с использованием отложенной
//инициализации при помощи функции lazy. После этого stackTraceLogger будет
//создаваться только при первом обращении, а строчки на экране будут напечатаны в
//такой последовательности:
//Enter main()
//SimpleLoggerIml created
//2.Написать класс StackTraceLogger, который будет использовать в качестве делегата
//экземпляр интерфейса SimpleLogger. Обратите внимание, что делегирование не
//является наследованием. Класс SimpleLoggerImpl объявлен без модификатора open,
//соответственно, наследоваться от него нельзя.
//3.Переопределить метод log в классе StackTraceLogger так, чтобы он сначала выводил
//сообщение из класса-делегата, далее стек вызовов до метода, откуда был вызван log.
//Сам вызов метода log выводить не нужно.


interface SimpleLogger  {
    val prefix: String
    fun log(message: String) {
        println(prefix + message)
    }
}
class SimpleLoggerImpl(override val prefix: String) : SimpleLogger {
    init {
        println("SimpleLoggerImpl created")
    }

}
class StackTraceLogger (val s:SimpleLoggerImpl): SimpleLogger by s{
    override fun log(message: String) {
        super.log(message)
        val stackTrace = Thread.currentThread().stackTrace
        for (st in 2 .. stackTrace.size-1) {
            println("${stackTrace[st]}")
        }
    }


}
val stackTraceLogger =   StackTraceLogger(SimpleLoggerImpl("MyLogger: "))
fun main() {
    println("Enter main()")


    stackTraceLogger.log("Hello world")
}



// вывод
//Enter main()
//SimpleLoggerIml created
//MyLogger: Hello world
//sem.Task41Kt.main(Task41.kt:40)
//sem.Task41Kt.main(Task41.kt)
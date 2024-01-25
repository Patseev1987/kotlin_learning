sealed class Expression
    class Num(val value:Int):Expression()
    class Sum(val left:Expression, val right:Expression):Expression()

fun evol( expression: Expression):Int{
    return when(expression){
        is Num -> expression.value
        is Sum -> evol(expression.left)+evol(expression.right)
    }
}

fun main() {
    println( evol(Sum(Sum(Num(4),Num(5)),Num(10))))
}
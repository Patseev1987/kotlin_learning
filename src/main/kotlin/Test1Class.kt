open class Animal {
    var age:Int = 0
        set(value) {
            println("New value foe age = $value")
            field=value
        }
    var name:String = ""

}

fun main() {
    val animal = Animal()
    println("${animal.age}, ${animal.name}")
    animal.age = 10;

    animal.showInfo()


   val cat = Cat(4)
    cat.showInfo()
    cat.eat()
}

fun Animal.showInfo (){
    println("${this.age}  ${this.name}")
}

class Cat(var legs:Int): Animal(){
    init {
        name = "Root"
        age = 1
    }
    fun eat() = println("$name is eating")
}
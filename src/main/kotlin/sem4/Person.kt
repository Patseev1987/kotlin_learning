package sem4

class Personss( var name:String? =null,var age:Int? = null, var address:Address? =null )
class Address (var street:String? = null,var n:Int? = null, var city:String? =null)

fun person (block:Personss.()->Unit):Personss = Personss().apply(block)

fun Personss.address(block:Address.()->Unit):Personss {

    val address = Address()
    address.block()
    this.address=address
    return this
}
fun main   (){



    val person = person {
        name = "John"
        age = 25
        address {
            street = "Leninsky prosp"
            n = 42
            city = "Moscow"
        }
    }

    println(person.address?.street)
}
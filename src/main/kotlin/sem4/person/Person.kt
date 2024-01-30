package sem4.person

class Personsss( val name:String ,val age:Int, var address:Address? )
class Address (var street:String? = null,var n:Int? = null, var city:String? =null)

fun person (block:PersonssBuilder.()->Unit):Personsss = PersonssBuilder().apply(block).build()

fun PersonssBuilder.address(block:AddressBuilder.()->Unit):PersonssBuilder {

    val address = AddressBuilder()
    address.block()
    this.address=address.build()
    return this
}

class PersonssBuilder {
    var name:String = ""
    var age:Int = 0
    var address:Address? =null
    fun build():Personsss = Personsss(name,age,address)
}

class AddressBuilder {
    var street:String = ""
    var n:Int = -1
    var city:String = ""

    fun build():Address = Address(street,n,city)
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
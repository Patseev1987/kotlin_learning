package sem4.json_v1

import com.google.gson.JsonArray
import com.google.gson.JsonObject

val json = """
[
   {
    "name" : "Alice",
    "phones" : [
        "123",
        "456"
    ],
    "emails" : [
        "asd@asd.com",
       "ghjkl@fghjkl.ru"
    ]
   }
   {
   "name" : "John",
   "phones" : [
       "77777",
       "+456789",
   ] , 
   "emails" : [
       "ghjkl@fghjkl.net",
       "uuuuuuuu@iiiiii.su"
   ]    
   }
]
"""

val jsonKotlin = """
array{
   {
    "name" to "Alice"
    "phones" to array {
        +"123"
        +"456"
    }
    "emails" to array {
        "asd@asd.com"
       "ghjkl@fghjkl.ru"
    }
   }
   {
   "name" to "John"
   "phones" to array {
       +"77777"
       +"+456789"
   }
   "emails" to array{
       +"ghjkl@fghjkl.net"
       +"uuuuuuuu@iiiiii.su"
   }    
   }
}
"""

class JsonObjectBuilder {
    val res = JsonObject()

    infix fun String.to(value: String) {
        res.addProperty(this, value)
    }

    infix fun String.to(value: JsonArray) {
        res.add(this, value)
    }


}


fun json(block: JsonObjectBuilder.() -> Unit): JsonObject {
    return JsonObjectBuilder().apply(block).res
}

fun array(block: JsonArrayBuilder.() -> Unit): JsonArray {
    val b = JsonArrayBuilder()
    b.block()
    return b.res
}

class JsonArrayBuilder {
    val res = JsonArray()
    operator fun String.unaryPlus() {
        res.add(this)
    }
    operator fun JsonObject.unaryPlus() {
        res.add(this)
    }
}


fun main() {
    val j = array {
        +json {
            "name" to "Alice"
            "phones" to array {
                +"123"
                +"456"
            }
            "emails" to array {
                +"asd@asd.com"
                +"ghjkl@fghjkl.ru"
                +"fghjkdhfgjdfg"
            }
        }
        +json {
            "name" to "Nick"
            "phones" to array {
                +"3333"
                +"4545454545"
            }
            "emails" to array {
                +"as345345d@a345345sd.com"
                +"ghjkl@frtertertertghjkl.ru"
                +"fghjkdhfgertertertertertjdfg"
            }
        }
    }
    println(j)
}


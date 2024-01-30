package html


open class TAG (val tagName:String,val value:String) {
    val children:MutableList<TAG> = mutableListOf()
    fun add (tag:TAG) = children.add(tag)

    override fun toString(): String {
      return  "<$tagName>$value${children.joinToString (separator = "")}</$tagName>"
    }
}
class Table(value:String):TAG("TABLE",value)
class Tr(value:String):TAG("TR",value)
class Td(value:String):TAG("TD",value)


open class TAGBuilder{
    var value:String = ""

    var tags:MutableList<TAG> = mutableListOf()
    operator fun String.unaryPlus(){
        value = this
    }
}

class TrBuilder: TAGBuilder() {
    fun td(block: TdBuilder.() -> Unit) {
        val t = TdBuilder().apply ( block ).build()
        tags.add(t)
    }
    fun build() = Tr(value).apply { tags.forEach{ add (it) }}
}

class TableBuilder:TAGBuilder(){

    fun tr(block: TrBuilder.()->Unit)  {
      val t =  TrBuilder().apply ( block ).build()
        tags.add(t)
    }
    fun build():Table = Table(value).apply {
        tags.forEach { add( it )}
    }
}

    class TdBuilder:TAGBuilder() {
        fun build() = Td(value).apply {
            tags.forEach { this.children.add(it) }
        }
    }

fun table (block: TableBuilder.() -> Unit):Table = TableBuilder().apply ( block ).build()

fun main() {
    val html = table {
        tr {
            +"213123123"

            td {
                +"14"
            }
            td {
                +"hj"
            }
        }
    }

    println(html)
}


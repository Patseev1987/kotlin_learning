package sem4.html

val html1 = """
    <html>
        <table>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
        </table>        
    </html>
""".trimMargin()

class HTMLBogdan {
    val values = ArrayList<String>()

    override fun toString(): String {
        return values.joinToString(prefix = "<html>", postfix = "</html>", separator = "") { it }
    }
}

class HTMLBogdanBuilder {
    val res = HTMLBogdan()

    operator fun TableBogdan.unaryPlus() {
        res.values.add(this.toString())
    }

}

fun html(block: HTMLBogdanBuilder.() -> Unit): HTMLBogdan {
    return HTMLBogdanBuilder().apply { block }.res
}


class TableBogdan {
    val values = ArrayList<String>()

    override fun toString(): String {
        return values.joinToString(prefix = "<table>", postfix = "</table>", separator = "") { it }
    }
}

class TableBogdanBuilder {
    val res = TableBogdan()

    operator fun Tr.unaryPlus() {
        res.values.add(this.toString())
    }
}

fun table(block: TableBogdanBuilder.() -> Unit): TableBogdan {
    return TableBogdanBuilder().apply { block }.res
}

class Tr {
    val values = ArrayList<String>()
    override fun toString(): String {
        return values.joinToString(prefix = "<tr>", postfix = "</tr>", separator = "") { it }
    }
}

class TrBuilder {
    val res = Tr()

    operator fun Td.unaryPlus() {
        res.values.add(this.toString())
    }
}

fun tr(block: TrBuilder.() -> Unit): Tr {
    return TrBuilder().apply(block).res

}


class Td {
    var value: String = ""
    override fun toString(): String {
        return "<td>$value</td>"
    }
}

class TdBuilder {
    val res = Td()

    operator fun String.unaryPlus() {
        res.value = this
    }
}

fun td(block: TdBuilder.() -> Unit): Td {
    return TdBuilder().apply(block).res
}


fun main() {
    val myHTML = table {
        +tr {
            +td {
                +"1"
            }
            +td {
                +"2"
            }
        }
    }



    println(myHTML)
}
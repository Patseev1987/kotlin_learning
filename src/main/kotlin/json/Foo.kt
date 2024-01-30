package json

import com.mysql.cj.xdevapi.JsonArray

interface JsonBase

class JsonElem : JsonBase {
    val map: MutableMap<String, String> = mutableMapOf()
    fun addValue(str1: String, str2: String) {
        map.put(str1, str2)
    }

    override fun toString(): String {
        return "{${
            map.map { e ->
                (
                        if (e.value.startsWith("[") || e.value.startsWith("{"))
                            "\"${e.key}\" = ${e.value}"
                        else "\"${e.key}\" = \"${e.value}\""
                        )
            }.joinToString(separator = ",")
        }}"
    }

    infix fun String.to(str: String) {
        addValue(this, str)
    }

    infix fun String.to(json: JsonElem) {
        addValue(this, json.toString())
    }

    infix fun String.to(jarray: JsonArr) {
        addValue(this, jarray.toString())
    }
}


class JsonArr : JsonBase {
    val values: MutableList<String> = mutableListOf()

    override fun toString(): String {
        return "[${
            values.map { v ->
                (if (v.startsWith("[") || v.startsWith("{")) v
                else "\"$v\"")
            }.joinToString(separator = ",")
        }]"
    }


    operator fun String.unaryPlus() {
        values.add(this)
    }

    operator fun JsonElem.unaryPlus() {
        values.add(this.toString())
    }
}


fun jsonE(block: JsonElem.() -> Unit): JsonElem = JsonElem().apply(block)
fun jsonArray(block: JsonArr.() -> Unit): JsonArr = JsonArr().apply(block)
fun main() {
    val kkk = jsonArray {
        +jsonE {
            "s" to "fo"
            "v" to "go"
            "b" to jsonArray {
                +"1"
                +"2"
                +"3"
            }
            "jfjfjf" to jsonE {
                "bb" to "100"
                "nn" to "200"
            }
        }
    }
    println(kkk)
}
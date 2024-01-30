package sem4.files

import java.io.FileWriter
import java.util.Scanner
import kotlin.io.path.Path

fun main() {
    val file = Path("rRr.txt").toFile()
    val writer = FileWriter(file)
    writer.use {
        it.write("1111111")
    }

    val reader = Scanner(file)
    reader.use {
        println(it.nextLine())
    }
}
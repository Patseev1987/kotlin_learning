package database

import java.sql.DriverManager

fun main() {
    val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaws", "root", "Root1234")
    val statement = connection.createStatement()
   val resultSet =  statement.executeQuery("""SELECT * FROM jaws""")
    while (resultSet.next()){
        println(" id = ${resultSet.getInt("id")}")
        println(" name = ${resultSet.getString("name")}")
        println(" place = ${resultSet.getString("place")}\n")
    }
}
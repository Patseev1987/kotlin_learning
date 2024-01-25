data class Car (val model:String,val createData:Int){

}
operator fun Car.plus(other:Car):Car{
    return Car(this.model+other.model,this.createData+other.createData)
}
operator fun Car.inc():Car{
    return Car(this.model+"1",this.createData+1)
}

 fun main(){
     val car1 = Car("BMW",1998)
     val car2 = Car("Mercedes",2023)
     val car3 = Car("Voyah", 2023)
     val car5 = Car("BYD",2022)
     var car4 = car1+car2
  val cars = listOf(car1,car2,car3,car4,car5)
     println("${car1}\n${car2}\n${car3}\n${car4}")
     car4++
     println("${car1}\n${car2}\n${car3}\n${car4}")

     println(cars.groupBy { it.model.length })
     println(cars.filter { it.model.length>5 })
     println(cars.asSequence().filter { it.createData <2023 }.toList())
 }
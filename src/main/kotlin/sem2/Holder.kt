package sem2

class Holder (private val _number:Int) {
    var listener:ValueChangeListener? = null

   var number = _number
       set(newValue:Int){
           listener?.onNewValue(newValue)
       }
    companion object {
        val DEFAULT_NUMBER =100500
        fun createHolder(number: Int): Holder {
            return Holder(number)
        }
    }

}

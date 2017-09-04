import java.util.*

/**We're passing our constructor straight into the class declaration here. */
class Book(title : String,  isCheckedOut : Boolean) {

    /**The reason we're making isCheckedOut a var is because it's not read-only, that value can change. this is necessary if we wish to set a value later on. */

    val title : String = title
    var isCheckedOut : Boolean = isCheckedOut
}
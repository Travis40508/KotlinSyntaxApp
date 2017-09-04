import kotlin.system.exitProcess

class Controller(model : LibraryRepository, view : View) {

    /**Setting our member variables */

    val model : LibraryRepository = model
    val view : View = view

    /**Initializing default value of isValidResponse */
    var isValidResponse = false

    /**Initializing beginning behavior of application */
    fun init() {
        view.introduction()
        queryInput()
    }

    /**for while loops, we simply say that while a certain condition is true, do this. */
    /**For case/switch statements, we say we're going to have different behavior based on 'when' this value changes. Then we assign behavior
     * based on its values. We list a default action with 'else' */

    fun queryInput() {
        isValidResponse = false
        while(!isValidResponse) {
            view.displayMenu()
            var response : String? = readLine()
            when(response) {
                "1" -> showBooks()
                "2" -> addBook()
                "3" -> checkOutBook()
                "4" -> returnBook()
                "5" -> exitApp()
                else -> invalidResponse()
            }
        }
    }


    fun showBooks() {
        isValidResponse = true
        for(book : Book in model.getBooks()) {
            if(!book.isCheckedOut) {
                view.showBook(book.title)
            }
        }
        queryInput()
    }

    fun addBook() {
        isValidResponse = true
        view.queryBookToAdd()
        var bookTitle : String? = readLine()

        /**With !! we're saying that we're positive this won't be null. So stop telling me this is wrong. */
        var book : Book = Book(bookTitle!!, false)
        model.addBook(book)
        view.bookAdded()
        queryInput()
    }

    fun checkOutBook() {
        isValidResponse = true
        for(book : Book in model.getBooks()) {
            view.showBook(book.title)
        }

        /**Here we're saying that response is nullable, so if they just push enter without entering anything in the app won't crash with a null-pointer exception */
        view.queryBookToCheckOut()
        var response : String? = readLine()
        for(book : Book in model.getBooks()) {
            if(book.title.equals(response)) {
                book.isCheckedOut = true
                view.bookCheckOutSuccessfully(book.title)
            }
        }
        queryInput()
    }

    fun returnBook() {
        isValidResponse = true
        for(book : Book in model.getBooks()) {
            if(book.isCheckedOut) {
                view.showBook(book.title)
            }
        }
        view.queryBookToReturn()
        var response : String? = readLine()

        for(book : Book in model.getBooks()) {
            if(book.title.equals(response)) {
                book.isCheckedOut = false
                view.bookReturnedSuccessfully(book.title)
            }
        }
        queryInput()
    }

    fun exitApp() {
        isValidResponse = true
        view.goodBye()

        /**This exits the application */
        exitProcess(0)
    }

    private fun invalidResponse() {
        isValidResponse = false
        view.invalidResponse()
    }
}
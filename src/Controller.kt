import kotlin.system.exitProcess

class Controller(model : LibraryRepository, view : View) {

    val model : LibraryRepository = model
    val view : View = view
    var isValidResponse = false

    fun init() {
        view.introduction()
        queryInput()
    }

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
        exitProcess(0)
    }

    private fun invalidResponse() {
        isValidResponse = false
        view.invalidResponse()
    }
}
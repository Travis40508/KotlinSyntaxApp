class LibraryRepository {

    var library : ArrayList<Book> = ArrayList()

    fun getBooks() : ArrayList<Book> {
        return library
    }

    fun addBook(book : Book) {
        library.add(book)
    }

    fun checkOutBook(book : Book) {
        for(item : Book in library) {
            if(item.title.equals(book.title)) {
                item.isCheckedOut = true
            }
        }
    }

    fun returnBook(book : Book) {
        for(item : Book in library) {
            if(item.title.equals(book.title)) {
                item.isCheckedOut = false
            }
        }
    }
}
class LibraryRepository {

    /**mutable values that are read and write-allowed are vars. We have to instantiate them upon declaration, or add a question mark to let the system
     * know that the value is nullable */
    var library : ArrayList<Book> = ArrayList()

    /**We call functions fun, we title them, then pass in the parameters, if there are any, then use a colon and discuss what the function will return. */
    fun getBooks() : ArrayList<Book> {
        return library
    }

    /**Any time we declare any variable, we give it a name, then a colon, then its type */
    fun addBook(book : Book) {
        library.add(book)
    }

    /**for for loops we say that for each named variable, colon, variable type, 'in' arraylist, do this. Remember, we can't 'set' val's, as they're immutable. */
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
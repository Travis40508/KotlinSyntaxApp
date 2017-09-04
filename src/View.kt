class View {

    fun introduction() {
        println("Hello! Welcome to your library.")
    }

    fun displayMenu() {
        println("What would you like to do?\n" +
                "1. View Library\n" +
                "2. Add Book to Library\n" +
                "3. Checkout Book From Library\n" +
                "4. Return Book to Library\n" +
                "5. Exit Application")
    }

    fun queryBookToAdd() {
        println("Which book would you like to add?")
    }

    fun bookAdded() {
        println("Book added!")
    }

    fun showBook(bookTitle : String) {
        println(bookTitle)
    }

    fun queryBookToCheckOut() {
        println("Which book would you like to check out?")
    }

    fun bookCheckOutSuccessfully(title: String) {
        println("You have successfully checked out " + title)
    }

    fun queryBookToReturn() {
        println("Which book would you like to return?")
    }

    fun bookReturnedSuccessfully(title: String) {
        println("You have successfully returned " + title)
    }

    fun goodBye() {
        println("Goodbye, come see us again!")
    }

    fun invalidResponse() {
        println("Invalid response. Please try again.")
    }
}
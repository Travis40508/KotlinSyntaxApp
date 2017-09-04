class app {


    companion object {
        @JvmStatic fun main(args : Array<String>) {
            val view : View = View()
            val model : LibraryRepository = LibraryRepository()
            val controller : Controller = Controller(model, view)
            controller.init()
        }
    }
}
class app {

    /**Using companion object and @Jvm static to make this method static to allow us to start the app. */

    companion object {
        @JvmStatic fun main(args : Array<String>) {
            /**val is for read-only variables. these won't be changing as far as which class they equal is concerned, so we make them read-only.
             * We make a view and a model and pass them both into the controller. */

            val view : View = View()
            val model : LibraryRepository = LibraryRepository()
            val controller : Controller = Controller(model, view)
            controller.init()
        }
    }
}
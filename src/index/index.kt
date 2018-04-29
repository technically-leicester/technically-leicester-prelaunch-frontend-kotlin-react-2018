package index

import app.*
import react.dom.*
import kotlin.browser.*

fun main(args: Array<String>) {
    render(document.getElementById("feedback-form")) {
        app()
    }
}

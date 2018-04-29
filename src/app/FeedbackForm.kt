package app

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import react.*
import react.dom.*

interface FeedbackFormState : RState {
    var name: String
    var emailAddress: String
    var message: String
}

class FeedbackForm : RComponent<RProps, FeedbackFormState>() {
    override fun FeedbackFormState.init() {
        name = ""
        emailAddress = ""
        message = ""
    }

    override fun RBuilder.render() {
        form {
            attrs {
                onSubmitFunction = {
                    it.preventDefault()
                    console.log(state)
                }
            }
            div {
                label {
                    span {
                        +"Name"
                    }
                    input(InputType.text) {
                        attrs {
                            value = state.name
                            placeholder = "Your name"
                            onChangeFunction = {
                                val target = it.target as HTMLInputElement
                                setState {
                                    name = target.value.toUpperCase()
                                }
                            }
                        }
                    }
                }
            }
            div {
                label {
                    span {
                        +"Email"
                    }
                    input(InputType.email) {
                        attrs {
                            value = state.emailAddress
                            placeholder = "Your email address"
                            onChangeFunction = {
                                val target = it.target as HTMLInputElement
                                setState {
                                    emailAddress = target.value
                                }
                            }
                        }
                    }
                }
            }
            div {
                label {
                    span {
                        +"Message"
                    }
                    textArea {
                        attrs {
                            value = state.message
                            placeholder = "Your feedback"
                            onChangeFunction = {
                                val target = it.target as HTMLTextAreaElement
                                setState {
                                    message = target.value
                                }
                            }
                        }
                    }
                }
            }
            div {
                input(InputType.submit) {
                    attrs {
                        value = "Send message"
                    }
                }
            }
        }
    }
}

fun RBuilder.app() = child(FeedbackForm::class) {}

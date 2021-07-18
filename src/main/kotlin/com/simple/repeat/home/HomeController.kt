package com.simple.repeat.home

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController {

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = "Home"
        return "Home"
    }

    @PostMapping("/replace")
    fun replace(
        model: Model,
        @RequestParam("camelText") camelText: String
    ): String {
        model["title"] = "Replace"
        model["text"] = camelText.snakeToLowerCamelCase()
        return "Replace"
    }

    val snakeRegex = "_[a-zA-Z]".toRegex()
    fun String.snakeToLowerCamelCase(): String {
        return snakeRegex.replace(this) {
            it.value.replace("_", "")
                .toUpperCase()
        }
    }

}
package com.alura.forum.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/helloWorld")
class HelloController {
    @GetMapping
    fun hello(): String{
        return "Hello World!"
    }
}
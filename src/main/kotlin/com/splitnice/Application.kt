package com.splitnice

import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
        info = Info(
                title = "SplitNice",
                version = "0.0"
        )
)
class Application

fun main(args: Array<String>) {
    run(*args)
}


package spring.context.parameters.demo

import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {
    // Works as expected
    @GetMapping("/parameter")
    fun exampleParameter(
        httpMethod: HttpMethod,
    ) = "Hello $httpMethod"

    // 500 error
    context(httpMethod: HttpMethod)
    @GetMapping("/context-parameter")
    fun exampleContextParameter() = "Hello $httpMethod"
}
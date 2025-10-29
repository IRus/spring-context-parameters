package spring.context.parameters.demo

import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
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

    // This method works as expected on Spring Boot 3.1.3
    context(httpMethod: HttpMethod)
    @GetMapping("/context-parameter-with-param-explicit-name")
    fun exampleContextParameterWithParamExplicitName(
        @RequestParam("name") name: String,
    ) = "Hello $name $httpMethod"

    // This method fails on Spring Boot 3.1.3
    context(httpMethod: HttpMethod)
    @GetMapping("/context-parameter-with-param")
    fun exampleContextParameterWithParam(
        @RequestParam name: String,
    ) = "Hello $name $httpMethod"
}
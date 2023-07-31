package com.code

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import org.springframework.stereotype.Component


@Consumes("application/json")
@Produces("application/json")
interface HelloService {
    @GET
    @Path("/hello")
    fun hello(): String
}

@Component
class HelloServiceImpl: HelloService {
    override fun hello(): String = """{"msg": "hello back"}"""
}
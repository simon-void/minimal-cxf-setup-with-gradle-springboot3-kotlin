package com.code

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.cxf.Bus
import org.apache.cxf.endpoint.Server
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class HelloApp

fun main() {
    runApplication<HelloApp>()
}

@Configuration
class Config {

    @Bean fun getServer(
        bus: Bus,
        helloService: HelloService,
    ): Server = JAXRSServerFactoryBean().apply {
        setBus(bus)
        address = "/rs"
        setServiceBeans(listOf(helloService))
        setProvider(
            JacksonJsonProvider().apply {
                setMapper(jacksonObjectMapper())
            }
        )
    }.create()
}
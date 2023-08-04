package com.code

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.cxf.Bus
import org.apache.cxf.endpoint.Server
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class HelloApp

fun main() {
    runApplication<HelloApp> {
        addInitializers (
            beans {
                bean<Server> {
                    JAXRSServerFactoryBean().apply {
                        setBus(ref<Bus>())
                        address = "/rs"
                        setServiceBeans(listOf(ref<HelloService>()))
                        setProvider(
                            JacksonJsonProvider().apply {
                                setMapper(jacksonObjectMapper())
                            }
                        )
                    }.create()
                }
            }
        )
    }
}

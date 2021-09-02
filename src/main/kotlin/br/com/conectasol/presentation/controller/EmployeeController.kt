package br.com.conectasol.presentation.controller

import br.com.conectasol.domain.command.EmployeeCommand
import br.com.conectasol.presentation.model.request.EmployeeSaveRequest
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller("/employee")
open class EmployeeController(private val kafkaService: KafkaService) {

    @Post
    open fun create(@Valid @Body employee: EmployeeSaveRequest) {
        kafkaService.send(
            employee.toCommand()
        )
    }
}

@KafkaClient
interface KafkaService {

    @Topic("employee")
    fun send(command: EmployeeCommand)
}


package br.com.conectasol.presentation.controller

import br.com.conectasol.domain.command.EmployeeCommandInformation
import br.com.conectasol.domain.enum.EnumEmployeeCommand
import br.com.conectasol.presentation.model.request.EmployeeSaveRequest
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaListener
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
            EmployeeCommandInformation(
                employee.toCommand(),
                EnumEmployeeCommand.REGISTER_NEW_EMPLOYEE
            )
        )
    }
}

@KafkaClient
interface KafkaService {

    @Topic("employee")
    fun send(command: EmployeeCommandInformation)
}

//@KafkaListener
//class KafkaServiceListener {
//
//    @Topic("employee")
//    fun receive(c: EmployeeCommandInformation) {
//        when (c.commandType) {
//            EnumEmployeeCommand.REGISTER_NEW_EMPLOYEE -> {
//                println("Bem vindo ${c.command.name}")
//            }
//        }
//    }
//}


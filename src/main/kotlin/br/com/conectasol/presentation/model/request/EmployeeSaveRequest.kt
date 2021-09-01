package br.com.conectasol.presentation.model.request

import br.com.conectasol.domain.command.EmployeeCommand
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.*

@Introspected
data class EmployeeSaveRequest(

    @field:[NotBlank Size(min = 5, max = 100)]
    val name: String,

    @field:[NotNull Positive Min(18)]
    val age: Int,

    @field:[NotBlank Email]
    val email: String,

    @field:[NotNull Positive]
    val salary: BigDecimal
) {
    fun toCommand() = EmployeeCommand(
        name, age, email, salary
    )
}

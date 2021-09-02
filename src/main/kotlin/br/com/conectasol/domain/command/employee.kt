package br.com.conectasol.domain.command

import br.com.conectasol.domain.enum.EnumEmployeeCommand
import java.math.BigDecimal
import java.util.UUID

data class EmployeeCommand(
    val id: UUID,
    val name: String,
    val age: Int,
    val email: String,
    val salary: BigDecimal,
    val commandType: EnumEmployeeCommand
) : Command()


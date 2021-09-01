package br.com.conectasol.domain.command

import java.math.BigDecimal

data class EmployeeCommand(
    val name: String,
    val age: Int,
    val email: String,
    val salary: BigDecimal,
) : Command()

package br.com.conectasol.domain.command

import br.com.conectasol.domain.enum.EnumEmployeeCommand

data class EmployeeCommandInformation(
    val command: EmployeeCommand,
    val commandType: EnumEmployeeCommand
)
package ru.finman.operations.model

data class SaveOperationRequest(
	val date: String? = null,
	val type: EOperationType? = null,
	val category: EOperationCategory? = null,
	val sum: Int? = null,
	val name: String? = null,
	val userId: String? = null
)

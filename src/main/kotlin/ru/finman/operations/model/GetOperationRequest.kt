package ru.finman.operations.model

data class GetOperationRequest(
	val dateBegin: String? = null,
	val dateEnd: String? = null,
	val type: EOperationType? = EOperationType.ALL
)
package ru.finman.operations.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.finman.operations.model.EOperationType
import ru.finman.operations.model.Operation

@Repository
interface OperationRepository : CrudRepository<Operation, Long> {
	fun findOperationsByUserIdAndOperationTypeAndDateBeginAndDateEnd(
		userId: String,
		operationType: EOperationType,
		dateBegin: String,
		dateEnd: String
	): List<Operation>
}
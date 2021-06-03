package ru.finman.operations.service

import org.springframework.stereotype.Service
import ru.finman.operations.model.EOperationType
import ru.finman.operations.model.Operation
import ru.finman.operations.model.SaveOperationRequest
import ru.finman.operations.repository.OperationRepository

@Service
class OperationService(
	private val operationRepository: OperationRepository
) {
	fun getOperations(
		userId: String,
		operationType: EOperationType,
		dateBegin: String,
		dateEnd: String
	): List<Operation> {
		val list = operationRepository.findOperationsByUserIdAndOperationTypeAndDateBeginAndDateEnd(
			userId,
			operationType,
			dateBegin,
			dateEnd
		)
		val sortedList = mutableListOf<Operation>()
		sortedList.addAll(list)
		sortedList.sortWith(Comparator.comparing(Operation::date))
		return sortedList

	}

	fun saveOperation(saveOperationRequest: SaveOperationRequest): Operation {
		return operationRepository.save(
			Operation(
				name = saveOperationRequest.name,
				type = saveOperationRequest.type,
				category = saveOperationRequest.category,
				sum = saveOperationRequest.sum,
				//date = saveOperationRequest.date,
				userId = saveOperationRequest.userId
			)
		)
	}

	fun deleteOperation(operationId: Long) {
		return operationRepository.deleteById(operationId)
	}
}
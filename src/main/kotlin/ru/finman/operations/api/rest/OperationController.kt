package ru.finman.operations.api.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.finman.operations.model.EOperationType
import ru.finman.operations.model.SaveOperationRequest
import ru.finman.operations.service.OperationService

@RestController("/api/operation")
class OperationController(
	private val operationService: OperationService
) {
	@GetMapping("/list/{userId}")
	fun getOperations(
		@PathVariable userId: String,
		@RequestParam type: EOperationType,
		@RequestParam dateBegin: String,
		@RequestParam dateEnd: String
	): ResponseEntity<Any> {
		return ResponseEntity.ok(operationService.getOperations(userId, type, dateBegin, dateEnd))
	}

	@PostMapping
	fun saveOperation(@RequestBody request: SaveOperationRequest): ResponseEntity<Any> {
		return ResponseEntity.ok(operationService.saveOperation(request))
	}

	@DeleteMapping("/{operationId}")
	fun deleteOperation(@PathVariable operationId: Long): ResponseEntity<Any> {
		return ResponseEntity.ok(operationService.deleteOperation(operationId))
	}
}
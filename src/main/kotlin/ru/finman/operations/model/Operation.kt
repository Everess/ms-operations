package ru.finman.operations.model

import java.time.ZonedDateTime
import javax.persistence.*

@Entity("t_operations")
@Table
class Operation(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_operations_seq")
	@SequenceGenerator(name = "t_operations_seq", sequenceName = "t_operations_seq", allocationSize = 1)
	val id: Long? = null,
	@Column val name: String? = null,
	@Column val type: EOperationType? = null,
	@Column val category: EOperationCategory? = null,
	@Column val sum: Int? = null,
	@Column val date: ZonedDateTime? = null,
	@Column val userId: String? = null
)
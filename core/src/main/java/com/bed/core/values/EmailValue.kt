package com.bed.core.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

@JvmInline
value class EmailValue private constructor(private val value: String) {

    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Either<Nel<MessageValue>, EmailValue> =
            if (value != null && isValid(value)) EmailValue(value).right()
            else MessageValue(MessagesValues.INVALID_EMAIL.message).leftNel()

        private fun isValid(value: String): Boolean {
            val pattern = "^[a-zA-Z\\d+_.-]+@[a-zA-Z\\d.-]+\\.[a-zA-z]{2,3}\$".toRegex()

            return pattern.matches(value)
        }
    }
}

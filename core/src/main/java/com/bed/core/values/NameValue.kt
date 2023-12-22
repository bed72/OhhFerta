package com.bed.core.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

@JvmInline
value class NameValue private constructor(private val value: String) {

    operator fun invoke() = value

    companion object {
        private const val MAX_LENGTH = 3
        operator fun invoke(value: String?): Either<Nel<MessageValue>, NameValue> =
            if (value != null && isValid(value)) NameValue(value).right()
            else MessageValue(MessagesValues.INVALID_NAME.message).leftNel()

        private fun isValid(value: String): Boolean = value.length >= MAX_LENGTH
    }
}

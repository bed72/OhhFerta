package com.bed.core.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

@JvmInline
value class CodeValue private constructor(private val value: String) {

    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Either<Nel<MessageValue>, CodeValue> =
            if (value != null && isValid(value)) CodeValue(value).right()
            else MessageValue(MessagesValues.INVALID_CODE.message).leftNel()

        private fun isValid(value: String): Boolean = value.isNotEmpty()
    }
}

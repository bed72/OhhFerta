package com.bed.core.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

@JvmInline
value class PasswordValue private constructor(private val value: String) {

    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Either<Nel<MessageValue>, PasswordValue> =
            if (value != null && isValid(value)) PasswordValue(value).right()
            else MessageValue(MessagesValues.INVALID_PASSWORD.message).leftNel()

        private fun isValid(value: String): Boolean {
            val pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,}\$".toRegex()

            return pattern.matches(value)
        }
    }
}

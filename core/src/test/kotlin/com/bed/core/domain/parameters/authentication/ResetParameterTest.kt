package com.bed.core.domain.parameters.authentication

import org.junit.Test
import org.junit.Assert.assertEquals

import com.bed.core.values.MessagesValues
import com.bed.core.values.getFirstMessage

internal class ResetParameterTest {
    @Test
    fun `Should try validate ResetParameter return failure when code is invalid`() {
        ResetParameter("", "P@ssw0rD").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_CODE.message)
        }
    }

    @Test
    fun `Should try validate ResetParameter return failure when password is empty`() {
        ResetParameter("code", "").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_PASSWORD.message)
        }
    }

    @Test
    fun `Should try validate ResetParameter return failure when password is invalid (needs a number)`() {
        ResetParameter("code", "password").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_PASSWORD.message)
        }
    }

    @Test
    fun `Should try validate ResetParameter return failure when password is invalid (needs a capital character)`() {
        ResetParameter("code", "passw0rd").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_PASSWORD.message)
        }
    }

    @Test
    fun `Should try validate ResetParameter return success`() {
        ResetParameter("code", "P@ssw0rD").map { (code, password) ->
            assertEquals(code(), "code")
            assertEquals(password(), "P@ssw0rD")
        }
    }
}

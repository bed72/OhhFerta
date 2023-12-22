package com.bed.core.domain.parameters.authentication

import org.junit.Test
import org.junit.Assert.assertEquals

import com.bed.core.values.MessagesValues
import com.bed.core.values.getFirstMessage

internal class AuthenticationParameterTest {
    @Test
    fun `Should try validate SignInParameter return failure when e-mail is invalid`() {
        AuthenticationParameter("emailemail.com", "P@ssw0rD").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_EMAIL.message)
        }
    }

    @Test
    fun `Should try validate SignInParameter return failure when password is invalid`() {
        AuthenticationParameter("email@email.com", "P@ss").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_PASSWORD.message)
        }
    }

    @Test
    fun `Should try validate SignInParameter return failure when e-mail and password is invalid`() {
        AuthenticationParameter("emailemail.com", "P@ss").mapLeft { message ->
            assertEquals(message.getFirstMessage(), MessagesValues.INVALID_EMAIL.message)
        }
    }

    @Test
    fun `Should try validate SignInParameter return success`() {
        AuthenticationParameter("email@email.com", "P@ssw0rD").map { (email, password) ->
            assertEquals(email(), "email@email.com")
            assertEquals(password(), "P@ssw0rD")
        }
    }
}

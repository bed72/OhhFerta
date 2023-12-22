package com.bed.core.values

import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals

internal class NameValueTest {
    @Test
    fun `Should return the Name when value is valid`() {
        val name = NameValue("Gabriel Ramos")

        assertTrue(name.isRight())
        name.map { assertEquals(it(), "Gabriel Ramos") }
    }

    @Test
    fun `Should return message failure when Name is short`() {
        val message = NameValue("Ga")

        assertTrue(message.isLeft())
        message.mapLeft { assertEquals(it.getFirstMessage(), MessagesValues.INVALID_NAME.message) }
    }

    @Test
    fun `Should return message failure when Name is invalid`() {
        val message = NameValue("")

        assertTrue(message.isLeft())
        message.mapLeft { assertEquals(it.getFirstMessage(), MessagesValues.INVALID_NAME.message) }
    }
}

package com.bed.ohhferta.presentation.commons.states

import org.junit.Test
import org.junit.Rule
import org.junit.Before

import junit.framework.TestCase.assertTrue
import junit.framework.TestCase.assertEquals

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.ExperimentalCoroutinesApi

import com.bed.core.values.MessagesValues

import com.bed.test.rules.MainCoroutineRule
import com.bed.test.factories.authentication.Factories

@OptIn(ExperimentalCoroutinesApi::class)
internal class PasswordFormStateTest {
    @get:Rule
    val rule = MainCoroutineRule()

    private lateinit var form: FormState

    private lateinit var states: MutableList<States<String>>

    @Before
    fun setUp() {
        form = FormState()
        states = mutableListOf()
    }

    @Test
    fun `Should successfully return`() = runTest {
        val job = launch(rule.dispatcher.main()) { form.state.toList(states) }

        form.set("P@ssw0rD", FormState.Type.Password)

        assertEquals(states[Factories.States.INITIAL], States.Initial)
        assertEquals(states[Factories.States.LOADING], States.Loading)
        assertTrue(states[Factories.States.SUCCESS] is States.Success)
        form.state.value.let {
            it as States.Success
            assertEquals(it.data, "P@ssw0rD")
        }

        job.cancel()
    }

    @Test
    fun `Should failure return (empty)`() = runTest {
        val job = launch(rule.dispatcher.main()) { form.state.toList(states) }

        form.set("", FormState.Type.Password)

        assertEquals(states[Factories.States.INITIAL], States.Initial)
        assertEquals(states[Factories.States.LOADING], States.Loading)
        assertTrue(states[Factories.States.FAILURE] is States.Failure)
        form.state.value.let {
            it as States.Failure
            assertEquals(it.data, MessagesValues.INVALID_PASSWORD.message)
        }

        job.cancel()
    }

    @Test
    fun `Should failure return (needs number)`() = runTest {
        val job = launch(rule.dispatcher.main()) { form.state.toList(states) }

        form.set("P@ssworD", FormState.Type.Password)

        assertEquals(states[Factories.States.INITIAL], States.Initial)
        assertEquals(states[Factories.States.LOADING], States.Loading)
        assertTrue(states[Factories.States.FAILURE] is States.Failure)
        form.state.value.let {
            it as States.Failure
            assertEquals(it.data, MessagesValues.INVALID_PASSWORD.message)
        }

        job.cancel()
    }

    @Test
    fun `Should failure return (needs capital letters)`() = runTest {
        val job = launch(rule.dispatcher.main()) { form.state.toList(states) }

        form.set("p@ssw0rd", FormState.Type.Password)

        assertEquals(states[Factories.States.INITIAL], States.Initial)
        assertEquals(states[Factories.States.LOADING], States.Loading)
        assertTrue(states[Factories.States.FAILURE] is States.Failure)
        form.state.value.let {
            it as States.Failure
            assertEquals(it.data, MessagesValues.INVALID_PASSWORD.message)
        }

        job.cancel()
    }
}

package com.vintsarevich.secondlife

import org.junit.Rule
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class AbstractUnitTest {
    @get:Rule
    val thrown = ExpectedException.none()
}

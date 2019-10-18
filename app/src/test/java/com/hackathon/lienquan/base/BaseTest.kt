package com.hackathon.lienquan.base

import com.hackathon.lienquan.RxSchedulersOverrideRule
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.ClassRule
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.stubbing.OngoingStubbing

open class BaseTest {

    // Test rule for making the RxJava to run synchronously in unit test
    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxSchedulersOverrideRule()
    }

    @Before
    open fun setUp() {
        // make annotation work
        MockitoAnnotations.initMocks(this)

        //
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    /**
     *  Call this fun for Object class to avoid non-null error in kotlin
     */
    fun <T> any(type: Class<T>): T {
        Mockito.any(type)
        return uninitialized()
    }

    fun <T> uninitialized(): T = null as T

    fun <T> whenever(methodCall: T): OngoingStubbing<T> = Mockito.`when`(methodCall)
}
package com.hackathon.lienquan.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hackathon.lienquan.base.BaseTest
import com.hackathon.lienquan.ui.screen.main.MainViewModel
import com.hackathon.lienquan.utils.SchedulerProvider
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Spy

class MainViewModelTest: BaseTest() {

    private lateinit var viewModel: MainViewModel

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Spy
    private lateinit var scheduler: SchedulerProvider

    override fun setUp() {
        super.setUp()

        viewModel = MainViewModel(
            schedulerProvider = scheduler
        )
    }

    @Test
    fun sum_test_01() {

        val n = viewModel.sum(2, 3)

        Assert.assertEquals(5, n)
    }

    @Test
    fun sum_test_02() {

        val n = viewModel.sum(3, 5)

        Assert.assertEquals(8, n)
    }
}
package com.example.myunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyPanjang = 12.0
    private val dummyLebar = 7.0
    private val dummyTinggi = 6.0

    private val dummyVolume = 504.0
    private val dummyLingkar = 100.0
    private val dummyLuas = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLebar, dummyPanjang, dummyTinggi)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun getLingkar() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLebar, dummyPanjang, dummyTinggi)
        val lingkar = mainViewModel.getLingkar()
        assertEquals(dummyLingkar, lingkar, 0.0001)
    }

    @Test
    fun getLuas() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLebar, dummyPanjang, dummyTinggi)
        val luas = mainViewModel.getLuas()
        assertEquals(dummyLuas, luas, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockLuas() {
        `when`(mainViewModel.getLuas()).thenReturn(dummyLuas)
        val luas = mainViewModel.getLuas()
        verify(cuboidModel).getLuas()
        assertEquals(dummyLuas, luas, 0.0001)
    }

    @Test
    fun testMockLingkar() {
        `when`(mainViewModel.getLingkar()).thenReturn(dummyLingkar)
        val lingkar = mainViewModel.getLingkar()
        verify(cuboidModel).getLingkar()
        assertEquals(dummyLingkar, lingkar, 0.0001)
    }

    @Test
    fun save() {
    }
}
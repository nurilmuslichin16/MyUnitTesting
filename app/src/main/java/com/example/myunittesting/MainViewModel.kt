package com.example.myunittesting

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getVolume(): Double = cuboidModel.getVolume()

    fun getLingkar(): Double = cuboidModel.getLingkar()

    fun getLuas(): Double = cuboidModel.getLuas()

    fun save(l: Double, p: Double, t: Double) {
        cuboidModel.save(l,p,t)
    }
}
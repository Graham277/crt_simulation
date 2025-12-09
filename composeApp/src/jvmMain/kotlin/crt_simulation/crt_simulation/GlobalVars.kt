package crt_simulation.crt_simulation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

object GlobalVars {

    var length = 1.0f // metres

    var plateSeparation = 1.0f // metres

    var potentialDifference = 100.0f // Volts

    var initialSpeed = 1e6f // m/s

    var acceleration by mutableStateOf(1f) // m/s^2
    var dx by mutableStateOf(1f) // m
    var dy by mutableStateOf(1f) // m
    var time by mutableStateOf(1f) // s

}
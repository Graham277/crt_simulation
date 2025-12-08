package crt_simulation.crt_simulation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

object GlobalVars {

    var length = 10.0f // cm

    var plateSeparation = 10.0f // cm

    var potentialDifference = 10.0f // Volts

    var initialSpeed = 10.0f // m/s

    var acceleration by mutableStateOf(Calculations.calcAcc()) // m/s^2
}
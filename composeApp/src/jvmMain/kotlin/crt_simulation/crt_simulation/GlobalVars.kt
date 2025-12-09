/*
 * Created by: Graham J
 * Last edited on: December 8th 2025
 * Purpose: Store globals variables, starts with default values
 */

package crt_simulation.crt_simulation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

object GlobalVars {

    var length = 1.0f // metres

    var plateSeparation = 0.25f // metres

    var potentialDifference = 100.0f // Volts

    var initialSpeed = 1e7f // m/s

    var acceleration by mutableStateOf(1f) // m/s^2
    var dx by mutableStateOf(1f) // metres
    var dy by mutableStateOf(1f) // metres
    var time by mutableStateOf(1f) // seconds

}
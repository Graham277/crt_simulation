package crt_simulation.crt_simulation

import kotlin.math.min

object Calculations {

    private const val MASS = 9.11e-31 // kg
    private const val CHARGE = 1.6e-19 // C

    fun performCalculations() {
        // Calculate vertical acceleration from electric field
        // a = qV/md
        GlobalVars.acceleration = ((CHARGE * GlobalVars.potentialDifference) / (MASS * GlobalVars.plateSeparation)).toFloat()

        val timeToExitPlates = GlobalVars.length / GlobalVars.initialSpeed
        val timeToHitTopPlate = (kotlin.math.sqrt((2 * GlobalVars.plateSeparation) / GlobalVars.acceleration))

        GlobalVars.time = min(timeToExitPlates, timeToHitTopPlate)

        // Horizontal distance it travels
        // d = v/t
        GlobalVars.dx = GlobalVars.initialSpeed * GlobalVars.time

        // Dy at exit OR full plate separation if collision occurs first
        GlobalVars.dy = 0.5f * GlobalVars.acceleration * GlobalVars.time * GlobalVars.time
    }
}

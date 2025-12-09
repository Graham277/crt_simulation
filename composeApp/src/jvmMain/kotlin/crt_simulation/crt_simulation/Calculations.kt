/*
 * Created by: Graham J
 * Last edited on: December 8th 2025
 * Purpose: Perform calculations required for the program
 * I calculate acceleration from the electric force, horizontal displacement, vertical displacement, and time
 * The simulation stops either when the electron collides with the top plate,
 * or continues travelling rightward and passes the end of the plates, never colliding
 */

package crt_simulation.crt_simulation

object Calculations {

    // Mass and charge of the electron
    private const val MASS = 9.11e-31 // kilograms
    private const val CHARGE = 1.6e-19 // coulombs

    fun performCalculations() {

        /*
            1.
            Calculate vertical acceleration
            Because the Electric Force (Fe) is the only force, I can state that Fe=ma
            We also know that Fe=qV/d, so I can rearrange and get acceleration:
            a = qV/md
            where:
                q is the charge of the charge in C
                m is the mass of the charge in kg
                V is the potential difference between the plates in V
                d is the separation between the plates in m
            Since the charge I'm dealing with is an electron, I already know the charge and mass
         */
        GlobalVars.acceleration = ((CHARGE * GlobalVars.potentialDifference) / (MASS * GlobalVars.plateSeparation)).toFloat()

        /*
            2.
            Calculate the time for the object to move
            There are two scenarios for time:
             A. The charge never hits the top plate and exits out of the side.
                Here, I calculate time based on horizontal distance and acceleration (t = d/v)
             B. The charge collides with the top plate.
                Here I use the formula d = v1*t + 1/2*a*t^2.
                Because it starts from rest (v1=0), I can organise for t = sqrt(2*d*a)
             Then, I find which time value is smaller, as it must be the one that actually happens.
         */
        val timeToExitPlates = GlobalVars.length / GlobalVars.initialSpeed
        val timeToHitTopPlate = (kotlin.math.sqrt(2 * GlobalVars.plateSeparation / GlobalVars.acceleration))
        GlobalVars.time = kotlin.math.min(timeToExitPlates, timeToHitTopPlate)

        /*
            3.
            Calculate the horizontal distance travelled
            The horizontal distance will either be the length of the plates (if it doesn't collide),
            or it will be the horizontal distance travelled before colliding with the top.
            Because I already account for these two possibilities in my time calculation, I can use the
            simple d = v*t formula, as there's no horizontal acceleration
         */
        GlobalVars.dx = GlobalVars.initialSpeed * GlobalVars.time

        /*
            4.
            Calculate the vertical distance travelled
            The vertical distance will either be the separation of the plates (if it collides),
            or it will be distance covered before leaving the end of the plates.
            Because I already account for these two possibilities in my time calculation, I can use the
            d = v1*t + 1/2*a*t^2, where v1 = 0.
         */
        GlobalVars.dy = 0.5f * GlobalVars.acceleration * GlobalVars.time * GlobalVars.time
    }
}

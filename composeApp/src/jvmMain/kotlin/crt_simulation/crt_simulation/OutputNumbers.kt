/*
 * Created by: Graham J
 * Purpose: Display the values of the calculations to the user
 */

package crt_simulation.crt_simulation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun OutputNumbers() {
    Text("Final velocity of block 1: ${GlobalVars.acceleration}m/s^2 [Up]")
}
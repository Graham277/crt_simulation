/*
 * Created by: Graham J
 * Last edited on: December 8th 2025
 * Purpose: An entry point for the program, starts the gui and calls everything in it
 */

package crt_simulation.crt_simulation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "elastic_collision",
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // The input sliders (top of window)
            Inputs()

            // Display the calculated data to the user (middle of window)
            Text("Acceleration: %.3g m/s^2 [Up]".format(GlobalVars.acceleration))
            Text("Horizontal displacement: %.3g m [Right]".format(GlobalVars.dx))
            Text("Vertical displacement: %.3g m [Up]".format(GlobalVars.dy))
            Text("Time: %.3g s".format(GlobalVars.time))

            // Display the animation of the electron (bottom of window)
            Animation()
        }
    }
}
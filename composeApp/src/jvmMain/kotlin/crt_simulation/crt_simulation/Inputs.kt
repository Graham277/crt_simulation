/*
 * Created by: Graham J
 * Purpose: Collect user inputs with sliders and text fields.
 */

package crt_simulation.crt_simulation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.round

@Composable
fun Inputs() {

    val length = GlobalVars.length
    val plateSeparation = GlobalVars.plateSeparation
    val potentialDifference = GlobalVars.potentialDifference
    val initialSpeed = GlobalVars.initialSpeed

    // Length and Plate Separation
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(32.dp) // spacing between columns
    ) {
        // Plate separation
        Column(
            modifier = Modifier.weight(1f) // take half the width
        ) {
            Text("Length of the plates: ${length}cm")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                var lengthText by remember { mutableStateOf(length.toString()) }

                TextField(
                    value = lengthText,
                    onValueChange = { newText ->
                        lengthText = newText

                        val value = newText.toFloatOrNull()
                        if (value != null) {
                            val clamped = value.coerceIn(0.1f, 100f)
                            GlobalVars.length = round(clamped * 10) / 10
                            Calculations.updateAll()
                        }
                    },
                    label = { Text("Value:") },
                    modifier = Modifier.width(80.dp)
                )

                Spacer(Modifier.width(16.dp))

                Slider(
                    value = length,
                    onValueChange = {
                        GlobalVars.length = round(it * 10) / 10
                        lengthText = (round(it * 10) / 10).toString()
                        Calculations.updateAll()
                    },
                    valueRange = 0.1f..100f,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Plate separation
        Column(
            modifier = Modifier.weight(1f) // take half the width
        ) {
            Text("Plate Separation: ${plateSeparation}cm")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                var plateSeparationText by remember { mutableStateOf(plateSeparation.toString()) }

                TextField(
                    value = plateSeparationText,
                    onValueChange = { newText ->
                        plateSeparationText = newText

                        val value = newText.toFloatOrNull()
                        if (value != null) {
                            val clamped = value.coerceIn(0.1f, 25f)
                            GlobalVars.plateSeparation = round(clamped * 10) / 10
                            Calculations.updateAll()
                        }
                    },
                    label = { Text("Value:") },
                    modifier = Modifier.width(80.dp)
                )

                Spacer(Modifier.width(16.dp))

                Slider(
                    value = plateSeparation,
                    onValueChange = {
                        GlobalVars.plateSeparation = round(it * 10) / 10
                        plateSeparationText = (round(it * 10) / 10).toString()
                        Calculations.updateAll()
                    },
                    valueRange = 0.1f..25f,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }


    // Potential Difference and Initial Speed
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(32.dp) // spacing between columns
    ) {
        // Potential Difference
        Column(
            modifier = Modifier.weight(1f) // take half the width
        ) {
            Text("Object 1 initial velocity: ${potentialDifference}V")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                var potentialDifferenceText by remember { mutableStateOf(potentialDifference.toString()) }

                TextField(
                    value = potentialDifferenceText,
                    onValueChange = { newText ->
                        potentialDifferenceText = newText

                        val value = newText.toFloatOrNull()
                        if (value != null) {
                            val clamped = value.coerceIn(0.1f, 1000f)
                            GlobalVars.initialSpeed = round(clamped * 10) / 10
                            Calculations.updateAll()
                        }
                    },
                    label = { Text("Value:") },
                    modifier = Modifier.width(80.dp)
                )

                Spacer(Modifier.width(16.dp))

                Slider(
                    value = potentialDifference,
                    onValueChange = {
                        GlobalVars.potentialDifference = round(it * 10) / 10
                        potentialDifferenceText = (round(it * 10) / 10).toString()
                        Calculations.updateAll()
                    },
                    valueRange = 0.1f..1000f,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Initial Speed
        Column(
            modifier = Modifier.weight(1f) // take half the width
        ) {
            Text("Object 2 initial velocity: ${initialSpeed}m/s [Right]")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                var initialSpeedText by remember { mutableStateOf(initialSpeed.toString()) }

                TextField(
                    value = initialSpeedText,
                    onValueChange = { newText ->
                        initialSpeedText = newText

                        val value = newText.toFloatOrNull()
                        if (value != null) {
                            val clamped = value.coerceIn(1f, 1e10f)
                            GlobalVars.initialSpeed = round(clamped)
                            Calculations.updateAll()
                        }
                    },
                    label = { Text("Value:") },
                    modifier = Modifier.width(80.dp)
                )

                Spacer(Modifier.width(16.dp))

                Slider(
                    value = initialSpeed,
                    onValueChange = {
                        GlobalVars.initialSpeed = round(it * 10) / 10
                        initialSpeedText = (round(it)).toString()
                        Calculations.updateAll()
                    },
                    valueRange = 1f..1e10f,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

/*
 * Created by: Graham Jarrett
 * Created on: 2025-12-08
 * Purpose: CRT electron trajectory animation with bottom-to-top motion
 */

package crt_simulation.crt_simulation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.sp

@Composable
fun Animation(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        key(GlobalVars.time, GlobalVars.acceleration) {
            val infiniteTransition = rememberInfiniteTransition()

            val animationDuration = (GlobalVars.time * 1000).toInt().coerceAtLeast(1000)

            val progress by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(animationDuration, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            )

            val textMeasurer = rememberTextMeasurer()

            Canvas(modifier = Modifier.fillMaxSize()) {
                // Horizontal margins and plate length in pixels
                val leftMargin = size.width * 0.05f

                // Horizontal scaling
                val xScale = size.width * 0.9f / GlobalVars.length

                // Vertical scaling
                val yScale = size.height * 0.8f / GlobalVars.plateSeparation

                val plateLengthPx = GlobalVars.length * xScale

                val midY = size.height / 2f
                val halfPlateHeightPx = (GlobalVars.plateSeparation / 2f) * yScale

                val topPlateHeight = midY - halfPlateHeightPx
                val bottomPlateHeight = midY + halfPlateHeightPx

                // Draw plates and the line of the left end
                drawLine(
                    color = Color.DarkGray,
                    start = Offset(leftMargin, topPlateHeight),
                    end = Offset(leftMargin + plateLengthPx, topPlateHeight),
                    strokeWidth = 4f
                )
                drawLine(
                    color = Color.DarkGray,
                    start = Offset(leftMargin, bottomPlateHeight),
                    end = Offset(leftMargin + plateLengthPx, bottomPlateHeight),
                    strokeWidth = 4f
                )
                drawLine(
                    color = Color.DarkGray,
                    start = Offset(leftMargin, topPlateHeight),
                    end = Offset(leftMargin, bottomPlateHeight),
                    strokeWidth = 4f,
                    cap = StrokeCap.Square
                )
                // Text telling us the difference in height between the plates
                drawText(
                    textMeasurer = textMeasurer,
                    text = "%.3gm".format(GlobalVars.plateSeparation),
                    topLeft = Offset(-10f, (topPlateHeight + bottomPlateHeight) / 2),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                )
                // Text telling us how long the plates are
                drawText(
                    textMeasurer = textMeasurer,
                    text = "%.3gm".format(GlobalVars.length),
                    topLeft = Offset(size.width / 2, bottomPlateHeight + leftMargin / 5),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                )

                // Electron position
                val t = GlobalVars.time * progress

                // Horizontal motion: proportional to plate length
                val electronXOffset = leftMargin + GlobalVars.initialSpeed * t * xScale

                // Vertical motion: physics with acceleration
                val currentYDisplacementMeters = 0.5 * GlobalVars.acceleration * t * t
                val currentYDisplacementPx = currentYDisplacementMeters.toFloat() * yScale

                val electronYOffset = bottomPlateHeight - currentYDisplacementPx

                // Draw electron
                drawCircle(
                    color = Color.Blue,
                    radius = 8f,
                    center = Offset(electronXOffset, electronYOffset)
                )

            }
        }
    }
}

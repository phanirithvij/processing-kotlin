@file:Suppress("SameParameterValue")

import processing.core.PApplet
import processing.core.PConstants

class CircularGradient : PApplet() {

    companion object Factory {
        fun run() {
            val art = CircularGradient()
            art.runSketch()
        }
    }

    override fun settings() {
//        fullScreen()//
        size(displayWidth, displayHeight)
    }

    override fun setup() {
        println(width, height)
        surface.setResizable(true)
        strokeCap(PConstants.ROUND)
        colorMode(PConstants.HSB, 360f, 100f, 100f, 1.0f)
        ellipseMode(PConstants.CORNER)

        for (x in 0..width step 5) {
            for (y in 0..height step 5) {
                val hue = rescale(
                    random(
                        x.toFloat() + y.toFloat(),
                        x + y + 100f), 0f,
                    500f,
                    130f,
                    220f
                )
                fill(hue, 90f, 90f)
                val sizeD = 5f
                ellipse(x.toFloat(), y.toFloat(), sizeD, sizeD)
            }
        }

    }

    private fun rescale(value: Float, oldMin: Float, oldMax: Float, newMin: Float, newMax: Float): Float {
        val oldSpread = oldMax - oldMin
        val newSpread = newMax - newMin
        val a = value - oldMin
        val b = newSpread / oldSpread
        val c = a * b
        return c + newMin
    }

}

fun main(){
    CircularGradient.run()
}

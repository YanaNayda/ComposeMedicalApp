import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import io.github.koalaplot.core.bar.BarScope
import io.github.koalaplot.core.bar.DefaultVerticalBar
import io.github.koalaplot.core.bar.VerticalBarPlotGroupedPointEntry
import io.github.koalaplot.core.util.generateHueColorPalette
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.remember

import androidx.compose.ui.unit.Dp
import io.github.koalaplot.core.bar.GroupedVerticalBarPlot
import io.github.koalaplot.core.bar.VerticalBarPlot
import io.github.koalaplot.core.bar.solidBar
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel


// Main function to display the screen containing the graph
@Composable
fun GraphScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFA1ECD4)) // Set background color for the entire screen
    ){
        // Header box with a title
        Box(
            modifier = Modifier
                .background(color = Color(0xFF28C894)) // Set background color for the header
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Graphs",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center) // Center alignment
            )
        }
        Spacer(modifier = Modifier.height(10.dp)) // Add space between header and graph

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            GroupedBarChart() // Call the function to draw the grouped bar chart
        }
    }
}



// Function to create a grouped bar chart
@OptIn(ExperimentalKoalaPlotApi::class) // Use experimental API from KoalaPlot
@Composable
fun GroupedBarChart() {

    // Define categories for the x-axis
    val boroughs = listOf("20/03/23", "21/03/24", "10/04/24", "12/04/24", "20/05/24")

    // Define the series/groups (e.g., different years)
    val years = listOf(1, 2)

    val colors = listOf(
        Color.hsv(0f, 1f, 0.7f),    // Red color
        Color.hsv(120f, 1f, 0.7f)   // Green color
    )

    val population = listOf(
        listOf(4.5f, 3f),
        listOf(3.5f, 3.5f),
        listOf(7.5f, 4.5f),
        listOf(3.5f, 4.5f),
        listOf(5.5f, 0f)
    )

    // Build the grouped bar chart
    XYGraph(
        xAxisModel = remember { CategoryAxisModel(boroughs) }, // Set x-axis model with categories
        yAxisModel = rememberFloatLinearAxisModel(0f..8f, minorTickCount = 0), // Set y-axis range
    ) {
        // Create grouped bars
        GroupedVerticalBarPlot(
            maxBarGroupWidth = 0.35f, // Adjust the maximum width of the bar groups
        ) {
            years.indices.forEach { yearIndex -> // Iterate over each year (group)
                series(solidBar(colors[yearIndex])) {
                    boroughs.forEachIndexed { boroughIndex, borough ->
                        item(borough, 0f, population[boroughIndex][yearIndex])
                    }
                }
            }
        }
    }
}

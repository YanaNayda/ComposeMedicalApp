package com.plcoding.composemedicallapp.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import composemedicalapp.composeapp.generated.resources.Res
import composemedicalapp.composeapp.generated.resources.img_activities
import composemedicalapp.composeapp.generated.resources.img_exit
import composemedicalapp.composeapp.generated.resources.img_graph
import composemedicalapp.composeapp.generated.resources.img_measurements
import composemedicalapp.composeapp.generated.resources.img_medications
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

// A function to load images dynamically
@Composable
expect fun loadImage(resourcePath: String): Painter

// Main screen with navigation and cards
@Composable
fun MainScreen(onNavigateToGraph: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFA1ECD4)) // Set background color for the screen
    ) {
        // Top Row with button and title text
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF28C894)) // Green background
                .padding(vertical = 10.dp)
        ) {
            // Button on the left side with padding from the edge
            Box(
                modifier = Modifier
                    .size(40.dp) // Button size
                    .clickable(onClick = { println("Image button clicked") }) // Action on click
                    .padding(start = 16.dp) // Padding from the left edge
            ) {
                // Exit icon in the button
                Icon(
                    painter = painterResource(Res.drawable.img_exit), // Image resource for the icon
                    contentDescription = null,
                    tint = Color.Unspecified, // Keep the original colors of the image
                    modifier = Modifier.fillMaxSize() // Fill the entire button area with the icon
                )
            }

            // Title text centered in the Row
            Text(
                text = "Home",
                color = Color.White,
                fontSize = 30.sp, // Font size for the title
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally) // Center the text horizontally
            )
        }

        // Card with messages
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .padding(top = 100.dp), // Top padding to place the card lower

            shape = RoundedCornerShape(15.dp), // Rounded corners for the card
            elevation = 5.dp // Card shadow elevation
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White) // Card background color

            ) {
                // Header for the messages section
                Text(
                    text = "Messages",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 35.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF28C894)) // Green background for the header
                        .padding(10.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally), // Center the header text
                )

                // LazyColumn to display a list of messages
                LazyColumn(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .background(color = Color.White) // White background for the list
                ) {
                    // Messages list (items are hardcoded here)
                    itemsIndexed(
                        listOf(
                            "Don't forget to take your test",
                            "Take 2 pills at 12:00.",
                            "Don't forget to call the doctor at 16:00",
                            "Have a good day !"
                        )
                    ) { _, item ->
                        // Display each message with a bullet point
                        Text(
                            text = "•" + item,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(vertical = 10.dp) // Vertical padding for each item
                                .background(color = Color.White) // White background for each item
                        )
                    }
                }
            }
        }

        // Grid of buttons for different sections
        ButtonGrid(onNavigateToGraph)
    }
}

// A grid layout of buttons for different sections
@Composable
fun ButtonGrid(onNavigateToGraph: () -> Unit) {
    val buttonSize = 100.dp // Size of the buttons
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly // Space buttons evenly
    ) {
        // First column: Medications and Measurements buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButtonWithText(
                iconRes = Res.drawable.img_medications,
                text = "Medications",
                onClick = { println("Medications clicked") },
                buttonSize = buttonSize
            )
            IconButtonWithText(
                iconRes = Res.drawable.img_measurements,
                text = "Measurements",
                onClick = { println("Measurements clicked") },
                buttonSize = buttonSize
            )
        }

        // Second column: Graph button
        IconButtonWithText(
            iconRes = Res.drawable.img_graph,
            text = "Graphs",
            onClick = onNavigateToGraph, // Navigate to the Graph screen
            buttonSize = buttonSize
        )

        // Third column: Activities button
        IconButtonWithText(
            iconRes = Res.drawable.img_activities,
            text = "Activities",
            onClick = { println("Activities clicked") },
            buttonSize = buttonSize
        )
    }
}

// A button with an icon and text
@Composable
fun IconButtonWithText(iconRes: DrawableResource, text: String, onClick: () -> Unit, buttonSize: Dp = 100.dp) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier.size(buttonSize ) // Set button size
    ) {
        // Column to arrange the icon and text vertically
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            // Display the icon
            Image(
                painter = painterResource(iconRes), // Icon resource
                contentDescription = null,
                modifier = Modifier.size(40.dp) // Icon size
            )
            Spacer(modifier = Modifier.height(8.dp)) // Space between icon and text
            // Display the text under the icon
            Text(
                text = text,
                color = Color.Black,
                fontSize = 9.sp // Font size for the text
            )
        }
    }
}

package com.rach.udemyteachingjetpackcompose.bottomBar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rach.udemyteachingjetpackcompose.R
import com.rach.udemyteachingjetpackcompose.ui.theme.selectedColor
import com.rach.udemyteachingjetpackcompose.ui.theme.unselectedColor

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val items = listOf(
        BottomBarDataClass(
            imageVector = ImageVector.vectorResource(R.drawable.baseline_account_circle_24),
            label = "Account",
            route = Screens.HomeScreen.route
        ),
        BottomBarDataClass(
            imageVector = ImageVector.vectorResource(R.drawable.outline_electric_bolt_24),
            label = "Transfer",
            route = Screens.Screen2.route
        ),

        BottomBarDataClass(
            imageVector = ImageVector.vectorResource(R.drawable.baseline_payments_24),
            route = Screens.Screen3.route,
            label = "Payment"
        ),
        BottomBarDataClass(
            imageVector = ImageVector.vectorResource(R.drawable.baseline_explore_24),
            label = "Explore",
            route = Screens.Screen4.route
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.navigationBars),
        bottomBar = {
            AdvanceBottomBarNew(
                modifier = Modifier.fillMaxWidth(),
                navItems = items,
                navController = navController,
                currentRoute = currentRoute
            )
        }
    ) { paddingValues ->

        MyAppNav(
            modifier = Modifier.padding(paddingValues),
            navController = navController
        )
    }

}


@Composable
fun AdvanceBottomBarNew(
    modifier: Modifier = Modifier,
    navItems: List<BottomBarDataClass>,
    fabSize: Dp = 64.dp,
    barHeight: Dp = 70.dp,
    currentRoute: String?,
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(barHeight + fabSize / 2)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 24.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                navItems.forEachIndexed { index, item ->
                    if (index == 2) Spacer(modifier = Modifier.size(fabSize))
                    SingleBottomNavItem(
                        bottomNav = item,
                        selected = currentRoute == item.route
                    ) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            }
        }

        LargeFloatingActionButton(
            onClick = {},
            modifier = Modifier
                .size(fabSize)
                .align(Alignment.Center)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = CircleShape
                ),
            shape = CircleShape,
            containerColor = Color(0xFFFF2121)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_qr_code_scanner_24),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }

}


@Composable
fun SingleBottomNavItem(
    modifier: Modifier = Modifier,
    bottomNav: BottomBarDataClass, selected: Boolean = false,
    onClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.92f else 1f
    )

    Column(
        modifier = modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clickable(
                interactionSource = interactionSource,
                onClick = onClick,
                indication = ripple(
                    bounded = true,
                    color = Color.Red.copy(alpha = 0.3f),
                    radius = 40.dp
                )
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = bottomNav.imageVector,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = if (selected) selectedColor else unselectedColor
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = bottomNav.label,
            color = if (selected) selectedColor else unselectedColor,
            fontSize = 12.sp,
            style = MaterialTheme.typography.labelSmall
        )

    }

}

data class BottomBarDataClass(
    val imageVector: ImageVector,
    val route: String,
    val label: String
)
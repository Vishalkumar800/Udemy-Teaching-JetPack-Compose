package com.rach.udemyteachingjetpackcompose.bottomBar

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rach.udemyteachingjetpackcompose.R
import com.rach.udemyteachingjetpackcompose.ui.theme.selectedColor
import com.rach.udemyteachingjetpackcompose.ui.theme.unselectedColor


//@Composable
//fun TomuScreen(modifier: Modifier = Modifier) {
//
//
//    val navController = rememberNavController()
//    val currentBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = currentBackStackEntry?.destination?.route
//
//    val iconList = listOf(
//        R.drawable.baseline_account_circle_24,
//        R.drawable.outline_electric_bolt_24,
//        R.drawable.baseline_payments_24,
//        R.drawable.baseline_explore_24
//    )
//
//    val labels = listOf(
//        "Account",
//        "Transfer",
//        "Payment",
//        "Explore"
//    )
//
//    var selectedIndex = rememberSaveable { mutableIntStateOf(0) }
//
//    val buttons = iconList.mapIndexed { index, iconData ->
//        NavigationBottomBar(
//            imageVector = ImageVector.vectorResource(iconData),
//            selected = index == selectedIndex.intValue,
//            label = labels[index],
//            onClick = { selectedIndex.intValue = index }
//        )
//    }
//
//    Scaffold(
//        modifier = Modifier
//            .fillMaxSize()
//            .windowInsetsPadding(WindowInsets.navigationBars),
//        bottomBar = {
//
//            AdvanceBottomBar(
//                buttons = buttons,
//                onFabClick = {}
//            )
//
//        }
//    ) { paddingValues ->
//        MyAppNav(
//            modifier = Modifier.padding(paddingValues)
//        )
//    }
//
//}


@Composable
fun AdvanceBottomBar(
    modifier: Modifier = Modifier,
    buttons: List<NavigationBottomBar>,
    fabSize: Dp = 70.dp,
    barHeight: Dp = 70.dp,
    onFabClick: () -> Unit
) {

    require(buttons.size == 4) { "Bottom Bar need 4 buttons" }

    Box(
        modifier = modifier
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
                SingleBottomBarItem(
                    navDataClass = buttons[0]
                )

                SingleBottomBarItem(
                    navDataClass = buttons[1]
                )

                Spacer(modifier = Modifier.size(fabSize))

                SingleBottomBarItem(
                    navDataClass = buttons[2]
                )

                SingleBottomBarItem(
                    navDataClass = buttons[3]
                )

            }
        }

        LargeFloatingActionButton(
            onClick = onFabClick,
            modifier = Modifier
                .size(fabSize)
                .align(Alignment.Center)
                .border(
                    shape = CircleShape,
                    width = 2.dp,
                    color = Color.White
                ),
            shape = CircleShape,
            containerColor = Color(0xFFFF2121)
        ) {
            Icon(
                painterResource(
                    R.drawable.baseline_qr_code_scanner_24,
                ),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = Color.White
            )
        }
    }

}

@Composable
fun SingleBottomBarItem(
    modifier: Modifier = Modifier,
    navDataClass: NavigationBottomBar,
    itemPadding: Dp = 8.dp,
    spaceBetweenIconAndText: Dp = 4.dp
) {

    Column(
        modifier = modifier
            .padding(itemPadding)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                navDataClass.onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (navDataClass.imageVector != null) {
            Icon(
                imageVector = navDataClass.imageVector,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = if (navDataClass.selected) selectedColor else unselectedColor
            )
        } else if (navDataClass.drawableResource != null) {
            Icon(
                painter = painterResource(navDataClass.drawableResource),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = if (navDataClass.selected) selectedColor else unselectedColor
            )
        }

        Spacer(modifier = Modifier.height(spaceBetweenIconAndText))

        Text(
            text = navDataClass.label,
            fontSize = 12.sp,
            color = if (navDataClass.selected) selectedColor else unselectedColor,
            style = MaterialTheme.typography.labelSmall
        )
    }

}

data class NavigationBottomBar(
    val imageVector: ImageVector? = null,
    val drawableResource: Int? = null,
    val selected: Boolean = false,
    val onClick: () -> Unit,
    val label: String
)
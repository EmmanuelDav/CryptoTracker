package com.iyke.crypto_tracker.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.model.Constants
import com.iyke.crypto_tracker.ui.theme.Black
import com.iyke.crypto_tracker.ui.theme.Typography
import com.iyke.crypto_tracker.ui.theme.White


@Composable
fun SettingsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = Black
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 50.dp)
        ) {

            Spacer(modifier = Modifier.height((2* Constants.PADDING_SIDE_VALUE).dp))

            UserInfoSection()

            SettingsColumn()
        }
    }
}

@Composable
private fun SettingsColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_SIDE_VALUE.dp)
    ) {

        SettingsItem(
            iconImageVector = Icons.Default.Person,
            text = "Profile"
        )

        SettingsItem(
            iconImageVector = Icons.Default.Tune,
            text = "Preferences"
        )

        SettingsItem(
            iconImageVector = Icons.Default.Notifications,
            text = "Notifications"
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth().padding(vertical = Constants.PADDING_SIDE_VALUE.dp)
                .background(color = White)
        )

        SettingsItem(
            iconImageVector = Icons.Default.Security,
            text = "Security"
        )

        SettingsItem(
            iconImageVector = Icons.Default.Lock,
            text = "Privacy"
        )

        SettingsItem(
            iconImageVector = Icons.Default.Info,
            text = "About"
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Constants.PADDING_SIDE_VALUE.dp)
                .background(color = White)
        )

        SettingsItem(
            iconImageVector = Icons.Default.Logout,
            text = "Logout"
        )
    }
}

@Composable
private fun SettingsItem(
    iconImageVector: ImageVector,
    text: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconTextRow(
            iconImageVector = iconImageVector,
            text = text
        )

        Icon(
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = null,
            tint = White,
            modifier = Modifier
                .clipToBounds()
                .padding(horizontal = (Constants.PADDING_SIDE_VALUE * 1.5).dp)
                .size(Constants.PADDING_SIDE_VALUE.dp)
        )
    }
}

@Composable
private fun IconTextRow(
    iconImageVector: ImageVector,
    text: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = Constants.PADDING_SIDE_VALUE.dp)
    ) {
        Icon(
            imageVector = iconImageVector,
            contentDescription = text,
            tint = White,
            modifier = Modifier.size((2*Constants.PADDING_SIDE_VALUE).dp)
        )

        Spacer(modifier = Modifier.width(Constants.ELEVATION_VALUE.dp))

        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White,

                        lineHeight = 22.sp
            ),
        )
    }
}

@Composable
private fun UserInfoSection() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(Constants.PADDING_SIDE_VALUE.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "IYKE EMMANUEL",
            style = Typography.body1,
            color = Color.White
        )

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Image",
            tint = White,
            modifier = Modifier.size((4 * Constants.PADDING_SIDE_VALUE).dp)
        )
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
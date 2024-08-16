package com.example.bankingapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingapp.data.Finace
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleStart

val finace = listOf(
    Finace(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    Finace(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finace(
        icon = Icons.Rounded.Analytics,
        name = "My\nAnalytics",
        background = PurpleStart
    ),
    Finace(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    )
)
@Preview
@Composable
fun FinaceSection(){
    Column {
        Text(
            text ="Finace",""
        )
    }
}
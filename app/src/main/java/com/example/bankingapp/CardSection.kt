package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Card
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "0004 0703 2004 0105",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(startColor = PurpleStart, endColor = PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "3223 2342 7654 2766",
        cardName = "Savings",
        balance = 42.652,
        color = getGradient(startColor = BlueStart, endColor = BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "4544 5345 2226 8559",
        cardName = "School",
        balance = 1.242,
        color = getGradient(startColor = OrangeStart, endColor = OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1114 4623 6633 6783",
        cardName = "Trips",
        balance = 12.533,
        color = getGradient(startColor = GreenStart, endColor = GreenEnd)
    )
)

fun getGradient(
    startColor : Color,
    endColor : Color
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
){
    val card = cards[index]
    val lastItemPadding = if(index==cards.size-1) 16.dp else 0.dp

    val image = when(card.cardType){
        "MASTER CARD" -> painterResource(id = R.drawable.ic_mastercard)
        else -> painterResource(id = R.drawable.ic_visa)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPadding)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
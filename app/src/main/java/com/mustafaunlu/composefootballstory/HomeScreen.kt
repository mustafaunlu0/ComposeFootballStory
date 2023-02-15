package com.mustafaunlu.composefootballstory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.mustafaunlu.composefootballstory.ui.theme.*
import com.mustafaunlu.composefootballstory.ui.theme.TextWhite
import kotlin.math.sign


@Composable
fun HomeScreen() {
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DeepGreen)) {
        Column(
            ) {
            WelcomeSection("Mustafa")
            LeaguesSection(listOf("Premier","La Liga","Super Lig"," Ligue 1","Serie A"))
        }
    }
    
    
    
    
}

@Composable
fun WelcomeSection(name : String) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(verticalArrangement = Arrangement.Center)
        {
            Text(text = "Welcome, $name", style = MaterialTheme.typography.h2)
            Text(text = "You can search for match highlights!", style = MaterialTheme.typography.body1)

        }
        
        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription ="Search", modifier = Modifier.size(24.dp), tint = Color.White )



    }
    
}

@Composable
fun LeaguesSection( leagueList :List<String>) {

    var selectedChipIndex by remember{
        mutableStateOf(0)
    }
    LazyRow(){
        items(leagueList.size){
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                               selectedChipIndex=it
                    }.clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonGreen
                        else Color.DarkGray
                    )
                    .padding(10.dp),

                ){
                Text(text = leagueList[it], color = TextWhite, fontFamily = FontFamily(Font(R.font.gothica1_regular)))
            }

        }
    }


    
}



package com.mustafaunlu.composefootballstory

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafaunlu.composefootballstory.ui.theme.*
import com.mustafaunlu.composefootballstory.ui.theme.TextWhite
import kotlin.math.sign

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DeepGreen)) {
        Column {
            WelcomeSection("Mustafa")
            LeaguesSection(listOf("Premier","La Liga","Super Lig"," Ligue 1","Serie A"))
            HighlightScreen()
            ActivitySection(listOf(
                Activity(
                    title = "Manager Effect",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                Activity(
                    title = "Match Highlights",
                    R.drawable.ic_videocam,
                    LightGreen1,
                    LightGreen2,
                    LightGreen3
                ),
                Activity(
                    title = "Which is real one?",
                    R.drawable.ic_headphone,
                    OrangeYellow1,
                    OrangeYellow2,
                    OrangeYellow3
                ),
                Activity(
                    title = "Real Ronaldo!",
                    R.drawable.ic_headphone,
                    Beige1,
                    Beige2,
                    Beige3
                )
            ))

        }
        BottomNavigationBar(items=listOf(
            BottomMenuContent("Home",R.drawable.ic_home),
            BottomMenuContent("Meditate",R.drawable.ic_bubble),
            BottomMenuContent("Sleep",R.drawable.ic_moon),
            BottomMenuContent("Music",R.drawable.ic_music),
            BottomMenuContent("Profile",R.drawable.ic_profile)
        ), modifier = Modifier.align(Alignment.BottomCenter))




    }
    
    
    
    
}

@Composable
fun BottomNavigationBar(
    items : List<BottomMenuContent>,
    modifier: Modifier = Modifier ,
    activeHighColor: Color = DeepGreen,
    activeTextColor: Color = Color.White,
    inActiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex : Int  = 0
) {
    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(ButtonGreen)
            .padding(top = 2.dp, bottom = 4.dp)
        ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(item = item,
                isSelected = index == selectedItemIndex,
                activeHighColor=activeHighColor,
                activeTextColor=activeTextColor,
                inActiveTextColor=inActiveTextColor

                ) {

                selectedItemIndex=index

            }
        }

    }





}
@Composable
fun BottomMenuItem(
    item : BottomMenuContent,
    isSelected : Boolean = false,
    activeHighColor: Color = ButtonGreen,
    activeTextColor: Color = Color.White,
    inActiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighColor else Color.Transparent)
                .padding(10.dp)
            ){
                Icon(painter = painterResource(id = item.iconId) , contentDescription = item.title,
                    tint =  if(isSelected) activeTextColor else inActiveTextColor,
                    modifier = Modifier.size(20.dp)

                    )


            }
        Text(text = item.title,
            color = if (isSelected) activeTextColor else inActiveTextColor
        )
    }

}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActivitySection(
    activities : List<Activity>
) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(text = "Activities", style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
            )
        LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(
            start = 7.5.dp, end = 7.5.dp, bottom = 100.dp
        ), modifier = Modifier.fillMaxHeight() ){
            items(activities.size){
                ActivityItem(activity = activities[it])
            }
        }

    }
}

@Composable
fun ActivityItem(activity: Activity) {

    BoxWithConstraints (
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(ButtonGreen)
            )
    {
        val width=constraints.maxWidth
        val height= constraints.maxHeight

        //Medium colored path
        //Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width*0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width*0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width*0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width*1.4f, -height.toFloat())

        val mediumColorPath= Path().apply {
            moveTo(mediumColoredPoint1.x,mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1,mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2,mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3,mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4,mediumColoredPoint5)
            lineTo(width.toFloat() + 100f,height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100)
            close()
        }

        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()

        }

        Canvas(modifier = Modifier.fillMaxSize()){
            drawPath(
                path = mediumColorPath,
                color = activity.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = activity.lightColor
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)){

            Text(text = activity.title, style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
                )
            Icon(painter = painterResource(id = activity.icon) , contentDescription = activity.title,
                tint = Color.White, modifier = Modifier.align(Alignment.BottomStart)
                )
            Text(text = "Start",
                color= TextWhite,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(DeepGreen)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
                )


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
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
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

@Composable
fun HighlightScreen(
){

    Box(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(200.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.Blue)) {

        Image(painter = painterResource(id = R.drawable.manu), contentDescription = "highlights", contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxSize())

        Box(modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color.Blue)
            .align(
                Alignment.Center
            )){
            Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "Play button", tint = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(20.dp))
        }

       Row(modifier = Modifier
           .fillMaxSize()
           .padding(5.dp),
            verticalAlignment = Alignment.Bottom
           ) {


            Text(text = "Manchester U. - Totenham H.", color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight =
            FontWeight.Bold)
        }

    }

}



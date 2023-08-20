package com.example.Affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.Affirmations.model.Affirmation
import com.example.Affirmations.ui.theme.ScrollableListTheme
import com.example.scrollablelist.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                 AffirmationApp()
                }
            }
        }
    }
}
@Composable
fun AffirmationApp(){
    AffirmationList(affirmationList = Datasource().loadAffirmation())
}
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier=Modifier){
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
     }
    }
@Composable
fun AffirmationCard(affirmation: Affirmation,modifier: Modifier= Modifier){
    Card(modifier = modifier) {
        Column {
            Image(painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier= Modifier
                    .fillMaxSize()
                    .height(134.dp),
                contentScale = ContentScale.Crop
                )
            Text(text = LocalContext.current.getString(affirmation.stringResourceId),
            modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h4
                )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScrollableListTheme {
      AffirmationApp()
    }
}
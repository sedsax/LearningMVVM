package com.ankauniss.learningmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ankauniss.learningmvvm.ui.theme.LearningMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Sayfa(){
    val viewModel : SayfaViewModel = viewModel()
    val sayi1 = remember { mutableStateOf("")}
    val sayi2 = remember { mutableStateOf("")}
    val sonuc = remember { mutableStateOf("0")}
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Text(text = sonuc.value, fontSize = 50.sp)
        
        TextField(
            value = sayi1.value, 
            onValueChange = {sayi1.value=it},
            label = { Text(text = "Sayı 1")}
        )

        TextField(
            value = sayi2.value,
            onValueChange = {sayi1.value=it},
            label = { Text(text = "Sayı 2")}
        )

        Button(onClick = {
            val alinanSayi1 = sayi1.value
            val alinanSayi2 = sayi2.value

            val s1 = alinanSayi1.toInt()
            val s2 = alinanSayi2.toInt()

            val toplam = s1+s2

            sonuc.value = toplam.toString()

        }) { Text(text = "TOPLAMA")}

        Button(onClick = {
            val alinanSayi1 = (sayi1.value).toInt()
            val alinanSayi2 = (sayi2.value).toInt()

            sonuc.value = (alinanSayi1*alinanSayi2).toString()

        }) { Text(text = "ÇARPMA")}

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningMVVMTheme {
        Sayfa()
    }
}
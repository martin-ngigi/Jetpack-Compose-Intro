package com.example.jetpack_compose_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_intro.ui.theme.JetpackComposeIntroTheme
import org.w3c.dom.NameList
import java.util.jar.Attributes.Name

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroTheme {

                // remember to import runtime.setValue
                var name by remember{
                    mutableStateOf("")
                }

                var names by remember{
                    mutableStateOf(listOf<String>())
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    // Name and Add Button
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        OutlinedTextField(
                            value = name,
                            onValueChange = { text ->
                                name = text
                            },
                            modifier = Modifier.weight(1f) /// Will expand to cover all remaining space
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Button(onClick = {
                            if(name.isNotBlank()){
                                names = names + name // Add name to the list
                                name = "" // clear the UI after adding the name.
                            }
                        }) {
                            Text(text = "Add")
                        }

                    }

                    /// List of names
                    NameList(names = names, )

                }
            }
        }
    }
}

@Composable
fun NameList(
    names: List<String>,
    modifier: Modifier= Modifier
) {
    LazyColumn{
        items(names){currentName ->
            Text(
                text = currentName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Divider()
        }
    } 

}


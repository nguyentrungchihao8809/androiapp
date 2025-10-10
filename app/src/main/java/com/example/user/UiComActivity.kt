package com.example.user

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext



class UiComActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                UiComScreen()
            }
        }
    }
}
@Composable
fun  UiComScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "UI Components List",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color(0xFF4ABDE0),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 20.dp)
        )

        Text(
            text = "Display",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, bottom = 0.dp)
        )

        // Card chứa các Box
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                // Box 1
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4ABDE0), RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                            val intent = Intent(context, textdetail::class.java)
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            text = "Text",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Display Text",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }

                // Box 2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4ABDE0), RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                val intent = Intent(context, ImageActivity::class.java)
                                context.startActivity(intent)
                            }
                    ) {
                        Text(
                            text = "Image",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Display Image",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }


        Text(
            text = "Input",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp, top = 30.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                // Box 1
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4ABDE0), RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                val intent = Intent(context, TextFieldActivity::class.java)
                                context.startActivity(intent)
                            }
                    ) {
                        Text(
                            text = "TextField",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Input field for text",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }

                // Box 2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4ABDE0), RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column {
                        Text(
                            text = "PasswordField",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Input field for password",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }



        Text(
            text = "Layout",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp, top = 30.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                // Box 1
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4ABDE0), RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                val intent = Intent(context, RowLayoutActivity::class.java)
                                context.startActivity(intent)
                            }
                    ) {
                        Text(
                            text = "Column",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Arranges elements vertically",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }

                // Box 2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4ABDE0), RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column {
                        Text(
                            text = "Row",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Arranges elements horizontally",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }



    }
}


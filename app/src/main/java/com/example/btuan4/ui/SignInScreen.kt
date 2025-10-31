// com/example/myapplication/ui/SignInScreen.kt

package com.example.btuan4.ui

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.btuan4.viewmodel.SignInViewModel
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.btuan4.R
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Divider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = viewModel()
) {
    // 1. Khởi tạo Activity Result Launcher
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            viewModel.handleGoogleSignInResult(result.data)
        } else {
            // Đăng nhập bị hủy hoặc thất bại
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = R.drawable.uth),
            contentDescription = "anh uth",
            modifier = Modifier
                .size(300.dp)
                .padding(top = 150.dp)
        )
        Text("SmartTasks",
            fontSize = 20.sp,
            color = Color.Blue,
            modifier = Modifier
                .padding(top = 15.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 0.2.dp,
            modifier = Modifier
                .padding(vertical = 2.dp)
        )
        Text("Simple and efficient to do app",
            fontSize = 10.sp,
            color = Color.Blue
        )


        Text("Welcome",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 200.dp))
        Text("Ready to explore? Log in to get started.")

        Button(
            onClick = {
                // 2. Bắt đầu quá trình đăng nhập
                val signInIntent = viewModel.getSignInIntent()
                launcher.launch(signInIntent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE3F2FD),
                contentColor = Color(0xFF0D47A1)
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 30.dp)
                .width(300.dp)
                .height(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gg),
                    contentDescription = "Google logo",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "SIGN IN WITH GOOGLE",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
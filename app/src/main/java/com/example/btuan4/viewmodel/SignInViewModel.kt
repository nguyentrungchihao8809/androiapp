// com/example/myapplication/viewmodel/SignInViewModel.kt

package com.example.btuan4.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import com.example.btuan4.R // Import lớp R của dự án
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignInViewModel(application: Application) : AndroidViewModel(application) {

    private val auth = FirebaseAuth.getInstance()
    private val context = application.applicationContext

    // Lấy client ID của máy chủ từ resources string (tạo tự động từ google-services.json)
    private val serverClientId = context.getString(R.string.default_web_client_id)

    // 1. Cấu hình Google Sign-In Options
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(serverClientId)
        .requestEmail()
        .build()

    // 2. Khởi tạo Google Sign-In Client
    private val googleSignInClient = GoogleSignIn.getClient(context, gso)

    /** Trả về Intent cần thiết để khởi chạy màn hình chọn tài khoản Google */
    fun getSignInIntent(): Intent {
        return googleSignInClient.signInIntent
    }

    /**
     * 3. Xử lý kết quả trả về từ Google Sign-In và xác thực với Firebase.
     */
    fun handleGoogleSignInResult(data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            // Lấy ID token
            val idToken = account?.idToken ?: return

            // Xác thực với Firebase
            firebaseAuthWithGoogle(idToken)

        } catch (e: ApiException) {
            // Xử lý lỗi Google Sign-In (ví dụ: người dùng hủy, kết nối mạng)
            // Log.e("SignInViewModel", "Google sign in failed", e)
        }
    }

    /**
     * 4. Sử dụng ID Token để đăng nhập vào Firebase.
     */
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Đăng nhập Firebase thành công. MainActivity listener sẽ tự xử lý chuyển hướng.
                } else {
                    // Xử lý lỗi đăng nhập Firebase
                    // Log.e("SignInViewModel", "Firebase auth failed", task.exception)
                }
            }
    }
}
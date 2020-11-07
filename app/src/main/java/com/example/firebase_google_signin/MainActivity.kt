package com.example.firebase_google_signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_SIGN_IN_CODE =0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoogleSignIn.setOnClickListener {
            val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.webclient_id))
                    .requestEmail()
                    .build()
            val signInClient = GoogleSignIn.getClient(this,options)
            signInClient.signInIntent.also{
                startActivityForResult(it, REQUEST_SIGN_IN_CODE)
                //hahahahahah
            }
        }
    }
}
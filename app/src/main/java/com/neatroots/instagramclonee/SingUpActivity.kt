package com.neatroots.instagramclonee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.neatroots.instagramclonee.databinding.ActivitySingUpBinding

class SingUpActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySingUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.singUpBtn.setOnClickListener {
            if(binding.name.editText?.text.toString().equals("")or
                binding.email.editText?.text.toString().equals("")or
                binding.password.editText?.text.toString().equals("")
                ){
                Toast.makeText(this@SingUpActivity, "Please fill the all Information", Toast.LENGTH_SHORT).show()
            }else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.editText?.text.toString(),
                    binding.password.editText?.text.toString()
                ).addOnCompleteListener {
                    result->

                    if (result.isSuccessful){
                        Toast.makeText(this@SingUpActivity, "Login Successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@SingUpActivity, result.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
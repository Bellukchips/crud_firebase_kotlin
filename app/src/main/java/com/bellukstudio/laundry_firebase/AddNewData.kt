package com.bellukstudio.laundry_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.bellukstudio.laundry_firebase.config.ConfigFirebase
import com.bellukstudio.laundry_firebase.model.LaundryModel
import com.bellukstudio.laundry_firebase.util.GenerateString
import com.google.android.material.textfield.TextInputEditText

class AddNewData : AppCompatActivity() {
    private lateinit var modelLaundry: LaundryModel
    private lateinit var configFirebase : ConfigFirebase
    private lateinit var saveBtn: Button
    private lateinit var inputName: TextInputEditText
    private lateinit var inputAddress: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_data)
        //
        initForm()
        configFirebase = ConfigFirebase()
        configFirebase.firebaseConfig()
        saveData()
    }

    private fun initForm(){
        inputName = findViewById(R.id.txt_name)
        inputAddress = findViewById(R.id.txt_address)
    }

    private fun saveData(){
        saveBtn = findViewById(R.id.btn_save)
        saveBtn.setOnClickListener {
            val randomStr = GenerateString.randomString(10)
            configFirebase.setChild(randomStr)
            modelLaundry = LaundryModel()
            modelLaundry.setId(randomStr)
            modelLaundry.setName(inputName.text.toString())
            modelLaundry.setAddress(inputAddress.text.toString())

            //
            configFirebase.addNewData(modelLaundry).addOnSuccessListener {
                Toast.makeText(this,"Success add new data",Toast.LENGTH_LONG).show()
                goToMainAct()
            }.addOnFailureListener {
                Toast.makeText(this,"Fail : $it",Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun goToMainAct(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
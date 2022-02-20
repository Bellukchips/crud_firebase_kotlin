package com.bellukstudio.laundry_firebase.config

import com.bellukstudio.laundry_firebase.model.LaundryModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfigFirebase : FirebaseMethod{
    private lateinit var dbReference: DatabaseReference
    private lateinit var db: FirebaseDatabase
    private lateinit var path:String
    fun firebaseConfig() : DatabaseReference{
        db = FirebaseDatabase.getInstance()
        dbReference = db.getReference("laundry")
        return dbReference
    }
    fun setChild(path:String){
        this.path = path
    }
    override fun addNewData(laundry: LaundryModel?): Task<Void?> {
        return dbReference.child(this.path).setValue(laundry)
    }

    override fun showData(laundryList: ArrayList<LaundryModel>,snapshot: DataSnapshot) {
        for (datasnap in snapshot.children) {
            val laundry = datasnap.getValue(LaundryModel::class.java)
            laundryList.add(laundry!!)
        }
    }

}


package com.bellukstudio.laundry_firebase.config

import com.bellukstudio.laundry_firebase.model.LaundryModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface FirebaseMethod {
    fun addNewData(laundry: LaundryModel?): Task<Void?>?
    fun showData(laundryList : ArrayList<LaundryModel>,snapshot: DataSnapshot)
}


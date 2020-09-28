package com.example.intenttest

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {
    val PICK_CONTACT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClick(view: View) {
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", "Vasya")
        startActivity(intent)
    }

    fun onPhoneClick(view: View) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+79025106316"))
        startActivity(intent)
    }

    fun onPickContact(view: View) {
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, PICK_CONTACT)
    }
    fun displayContact() {

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_CONTACT && resultCode == Activity.RESULT_OK) {
            if (data != null ) {
                Log.d("Intent_demo", data.dataString)
                val  uri = data.data as Uri
                /*
                val PROJECTION_NUMBERS = arrayOf(ContactsContract.Contacts._ID, ContactsContract.CommonDataKinds.Phone.NUMBER)
                val cursor = getContentResolver().query(uri, PROJECTION_NUMBERS, null, null, null) as Cursor
                if (cursor.moveToFirst()) {
                    val contactId = cursor.getLong(0)

                }*/
            }
        }

    }


}

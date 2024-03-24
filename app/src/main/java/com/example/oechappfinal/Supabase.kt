package com.example.oechappfinal

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

class Supabase{


    fun getData(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycleScope.launch {
            val client = getClients()
            val supabaseResponse =  client.postgrest["users"].select()
            val data = supabaseResponse.decodeList<User>()
            Log.e("supabase", data.toString())
        }
    }
@Serializable
data class User(
    val id:Int = 0,
    val first_name: String = "",
    val last_name: String = "",
    val email: String = "",
    val password: String = ""
)



    private fun getClients(): SupabaseClient{
        return createSupabaseClient(
            supabaseUrl = "https://dlojedfrktlqdxlxcpgc.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRsb2plZGZya3RscWR4bHhjcGdjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTEyODA2ODQsImV4cCI6MjAyNjg1NjY4NH0.HYCTgzbL0o7mNsquMhiqikFJ5Y_nnjhbaUbUOhQSrjM"
        ){
            install(Postgrest)
        }
    }

}
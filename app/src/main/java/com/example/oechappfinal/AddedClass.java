package com.example.oechappfinal

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.serialization.Serializable




class SupabaseHelper(){
    private fun getClients(){



        val client = createSupabaseClient(
                supabaseUrl = "https://dlojedfrktlqdxlxcpgc.supabase.co",
                supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRsb2plZGZya3RscWR4bHhjcGdjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTEyODA2ODQsImV4cCI6MjAyNjg1NjY4NH0.HYCTgzbL0o7mNsquMhiqikFJ5Y_nnjhbaUbUOhQSrjM"
        ) {
            install(Postgrest)
        }
    }
}

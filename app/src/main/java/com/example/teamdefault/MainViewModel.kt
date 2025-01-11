package com.example.teamdefault

import com.example.myapplication.GenerateQARequest
import com.example.myapplication.RetrieveContextRequest
import com.example.myapplication.RetrofitInstance
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class MainViewModel : ViewModel() {

    fun fetchResponse(query: String, onResult: (String?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api
                    .retrieveContext(RetrieveContextRequest(query, "path/to/document"))
                    .awaitResponse()

                if (response.isSuccessful) {
                    val context = response.body()?.context
                    val qaResponse = context?.let {
                        RetrofitInstance.api
                            .generateQA(GenerateQARequest(it))
                            .awaitResponse()
                    }
                    onResult(qaResponse?.body()?.qa)
                } else {
                    onResult("Failed to retrieve context")
                }
            } catch (e: Exception) {
                onResult("Error: ${e.message}")
            }
        }
    }
}

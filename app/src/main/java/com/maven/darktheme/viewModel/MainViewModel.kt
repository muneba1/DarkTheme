package com.maven.darktheme.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maven.darktheme.model.User
import java.util.*

class MainViewModel : ViewModel() {
    var userLiveData: MutableLiveData<ArrayList<User>?>
    var userArrayList: ArrayList<User>? = null
    val userMutableLiveData: MutableLiveData<ArrayList<User>?>
        get() = userLiveData

    fun init() {
        populateList()
        userLiveData.value = userArrayList
    }

    fun populateList() {
        val user = User()
        user.title = "Darknight"
        user.description = "Best rating movie"
        userArrayList = ArrayList<User>()
        userArrayList!!.add(user)
        userArrayList!!.add(user)
        userArrayList!!.add(user)
        userArrayList!!.add(user)
        userArrayList!!.add(user)
        userArrayList!!.add(user)
    }

    init {
        userLiveData = MutableLiveData<ArrayList<User>?>()

        // call your Rest API in init method
        init()
    }
}
package com.alexisflop.labo03.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexisflop.labo03.data.objectList
import com.alexisflop.labo03.model.Subject
import kotlinx.coroutines.launch

class DataViewModel: ViewModel(){
    fun setData(myList: Subject){
        viewModelScope.launch{
            objectList.add(myList)
        }
    }

    fun getData():List<Subject> {
        return objectList.toList()
    }

}


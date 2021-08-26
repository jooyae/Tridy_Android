package org.journey.tridy_android.jejulife

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.journey.tridy_android.base.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class JejuLifeViewModel @Inject constructor()
    :DisposableViewModel(){
        private val _contentList = MutableLiveData<List<JejuLifeModelItem>>()
        val contentList : LiveData<List<JejuLifeModelItem>>
            get() = _contentList
        //제주생활 장소 검색창
}
package software.rsquared.template.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import software.rsquared.template.utils.AppExecutors
import javax.inject.Inject


class MainViewModel @Inject constructor(private val appExecutors: AppExecutors) : ViewModel() {


    val inputText: ObservableField<String> = ObservableField()

    val res: MutableLiveData<String> = MutableLiveData<String>()

    fun postResult() {
        val cache = inputText.get()
        appExecutors.diskIO.execute(object : Runnable {
            override fun run() {
                Thread.sleep(3000)
                res.postValue(cache)
            }
        })
    }


}
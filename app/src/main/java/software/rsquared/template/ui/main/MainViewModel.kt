package software.rsquared.template.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import software.rsquared.template.utils.AppExecutors
import javax.inject.Inject


class MainViewModel @Inject constructor(private val appExecutors: AppExecutors) : ViewModel() {


	val inputText = MutableLiveData<String>().apply { value = "" }

	private val resultLiveData = MutableLiveData<String>().apply { value = "init value" }
	val result: MutableLiveData<String> = resultLiveData

	fun postResult() {
		appExecutors.diskIO.execute {
			Thread.sleep(3000)
			inputText.value.also {
				result.postValue(it ?: "passed null")
			}
		}
	}


}
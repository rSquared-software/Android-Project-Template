package software.rsquared.template.ui.loading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import software.rsquared.androidlogger.Logger
import software.rsquared.template.utils.AppExecutors
import javax.inject.Inject

/**
 * @author Rafal Orlik
 */
class LoadingViewModel @Inject constructor(private val appExecutors: AppExecutors) : ViewModel() {

	private val progressLiveData = MutableLiveData<Int>().apply { value = 0 }
	val progress: LiveData<Int> = progressLiveData

	val running: LiveData<Boolean> = Transformations.map(progress) {
		it < 100
	}

	init {
		nextStep()
	}

	fun restart() {
		progressLiveData.postValue(0)
		nextStep()
	}

	private fun nextStep() {
		appExecutors.networkIO.execute {
			Thread.sleep((Math.random() * 1000 + 500).toLong())
			incrementUntil100()
		}
	}

	private fun incrementUntil100() {
		progress.value.takeUnless { it ?: 0 >= 100 }?.let { value ->
			progressLiveData.postValue(value.plus(Math.random() * 19 + 1).toInt())
			nextStep()
		} ?: finished()

	}

	private fun finished() {
		Logger.debug("finished loading")
	}


}
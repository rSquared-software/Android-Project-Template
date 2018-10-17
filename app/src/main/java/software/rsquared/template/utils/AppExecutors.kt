package software.rsquared.template.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class AppExecutors @Inject constructor() {
	val diskIO: Executor = Executors.newSingleThreadExecutor()
	val networkIO: Executor = Executors.newFixedThreadPool(3)
	val mainThread: Executor = object : Executor {
		private val mainThreadHandler = Handler(Looper.getMainLooper())

		override fun execute(command: Runnable) {
			mainThreadHandler.post(command)
		}
	}
}
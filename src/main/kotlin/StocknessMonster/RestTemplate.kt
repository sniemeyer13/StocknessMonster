package StocknessMonster

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class RestTemplate {
    private val client = OkHttpClient()

    fun get(url: String): RestResult<String> =
        buildRequest(url)
            .execute { response ->
                when {
                    response.isSuccessful -> RestResult.Success(response.body().string())
                    else -> RestResult.Error(response.message(), response.code())
                }
            }

    private fun buildRequest(url: String, buildInstructions: (Request.Builder.() -> Unit) = {}) =
        Request.Builder().run {
            url(url)
            buildInstructions()
            build()
        }

    private fun <T> Request.execute(handler: (Response) -> T) =
        client.newCall(this).execute().use(handler)
}

sealed class RestResult<T> {
    class Success<T>(val value: T) : RestResult<T>()
    class Error<T>(val error: String, val code: Int) : RestResult<T>()
}


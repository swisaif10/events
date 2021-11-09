package tn.tekup.eventapp.webservices

 import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

     private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()
    val INSTANCE: IcWS by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.152:50685/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(IcWS::class.java)
    }

    fun getToken() {
    }
}
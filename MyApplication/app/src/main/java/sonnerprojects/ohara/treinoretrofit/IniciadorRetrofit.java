package sonnerprojects.ohara.treinoretrofit;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ohara on 06/08/17.
 * Classe para consumir json do android
 */

public class IniciadorRetrofit {

    public static final String BASE_URL = "https://community-neutrino-currency-conversion.p.mashape.com/";

    public static <S> S createService(Class<S> serviceClass){

        //configurando o client htpp para o tempo maximo de requisição de 15 segundos
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS);

        //Instancia do interceptador das requisições
        //captura as requisições para serem exibidas no log
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor); //adicionando o interceptor no log


        //Instância do retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //url base de conexão
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }
}

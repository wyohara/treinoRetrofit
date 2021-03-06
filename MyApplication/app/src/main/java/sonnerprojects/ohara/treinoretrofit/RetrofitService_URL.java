package sonnerprojects.ohara.treinoretrofit;

import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by ohara on 06/08/17.
 * Classe que contém a configuração de conexao usando o retrofit
 */

public interface RetrofitService_URL {
    //Chave de autentificação para usar a api
    @Headers("X-Mashape-Key: AuuyclCPjcmshv2iOPq190OpzLrMp1FJWwejsnJrdfwOUr4h44")

    //criando a requisição por meio de um formulario post
    @FormUrlEncoded
    @POST("convert")
    Call<RespostaServidor> converterUnidade(@Field("from-type") String from_type,
                                            @Field("from-value") String from_value,
                                            @Field("to-type") String to_type);
}

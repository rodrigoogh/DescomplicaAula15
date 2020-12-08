package descomplica.desenvolvimentomobile.aula15;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface DescomplicaService {
    @GET("alunos/{aluno}")
    Call<Aluno> getAluno(@Path("aluno") String id);

    @GET("alunos")
    Call<List<Aluno>> getAlunos();

    @GET("turma/{id}/alunos")
    Call<List<Aluno>> buscarAlunosPorNome(@Path("id") int turmaId, @Query("nome") String nome);

    @GET("turma/{id}/alunos")
    Call<List<Aluno>> listarAlunos(@Path("id") int turmaId, @QueryMap Map<String, String> opcoes);

    @POST("alunos")
    Call<Aluno> criarAluno(@Body Aluno aluno);

    @PUT("alunos/foto")
    @Multipart
    Call<Aluno> uploadFotoAluno(@Part("foto") RequestBody foto,
                                @Part("descricao") RequestBody descricao);



}

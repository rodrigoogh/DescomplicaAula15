package descomplica.desenvolvimentomobile.aula15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String URL_BASE = "https://api.descomplica.com.br";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DescomplicaService descomplicaService = retrofit.create(DescomplicaService.class);

        descomplicaService.getAluno("id_matricula_123").enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                //Sucesso ao realizar requisição
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                //Erro ao realizar requisição
            }
        });

        Aluno aluno = new Aluno();
        aluno.setId(1);
        aluno.setNome("Rodrigo");
        aluno.setSobrenome("Gonçalves");

        Call<Aluno> call = descomplicaService.criarAluno(aluno);
        call.enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {

            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}

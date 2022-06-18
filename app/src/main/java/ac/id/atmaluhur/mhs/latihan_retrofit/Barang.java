package ac.id.atmaluhur.mhs.latihan_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Barang extends AppCompatActivity {
    public TextView textViewResult;
    private Button btn_tambah;
    private BarangJsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);
        btn_tambah=findViewById(R.id.button);
        btn_tambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Barang.this,EBarang.class);
                startActivity(i);
            }
        });
        textViewResult = findViewById(R.id.text_barang_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.1/mobtech_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderAPI = retrofit.create(BarangJsonPlaceHolderAPI.class);
        getPosts();
    }

    private void getPosts(){
        Map<String, String> parameters = new HashMap<>();
        Call<List<BarangPost>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<BarangPost>>() {
            @Override
            public void onResponse(Call<List<BarangPost>> call, Response<List<BarangPost>> response){
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }
                List<BarangPost> posts = response.body();
                for (BarangPost post:posts){
                    String content = "";
                    content += "ID: " +post.getId() + "\n";
                    content += "Nama: " +post.getNamaBarang() + "\n";
                    content += "Stok: " +post.getStok() + "\n";
                    content += "Deskripsi: " +post.getDeskripsi() + "\n\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<BarangPost>> call, Throwable t){
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
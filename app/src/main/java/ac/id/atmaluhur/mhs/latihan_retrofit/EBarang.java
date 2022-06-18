package ac.id.atmaluhur.mhs.latihan_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import java.util.HashMap;

public class EBarang extends AppCompatActivity {
    private EditText txtnmbarang,txtstok,txtdeskripsi,txtidkategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebarang);

        txtnmbarang = (EditText) findViewById(R.id.et_nmbarang);
        txtstok = (EditText) findViewById(R.id.et_stok);
        txtdeskripsi = (EditText) findViewById(R.id.et_deskripsi);
    }

    public void tambahbarang(View View) {
        final String nmbarang = txtnmbarang.getText().toString().trim();
        final String stok = txtstok.getText().toString().trim();
        final String deskripsi = txtdeskripsi.getText().toString().trim();

        class tambahbarang extends AsyncTask<Void, Void, String> {
            ProgressDialog load;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                load = ProgressDialog.show(
                        EBarang.this, "Add...","Wait...",false,false );
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put("nama barang",nmbarang);
                params.put("stok", stok);
                params.put("deskripsi",deskripsi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.137.1/mobtech_api/tambah.php",params);
                return res;
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                load.dismiss();
                Toast.makeText(EBarang.this,s,Toast.LENGTH_LONG).show();
            }
        }
        tambahbarang tb = new tambahbarang();
        tb.execute();
    }
}
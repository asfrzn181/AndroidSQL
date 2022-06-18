package ac.id.atmaluhur.mhs.latihan_retrofit;

import java.util.List;
import retrofit2.http.GET;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.QueryMap;
public interface BarangJsonPlaceHolderAPI {
    @GET("barang.php")
    Call<List<BarangPost>> getPosts(

    );
    @GET("barang.php")
    Call<List<BarangPost>> getPosts(@QueryMap Map<String,String> parameters);
}

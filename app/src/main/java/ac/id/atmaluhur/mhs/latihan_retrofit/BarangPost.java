package ac.id.atmaluhur.mhs.latihan_retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class BarangPost {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_barang")
    @Expose
    private String namaBarang;
    @SerializedName("stok")
    @Expose
    private String stok;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getNamaBarang(){
        return namaBarang;
    }
    public String getStok(){
        return stok;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
}

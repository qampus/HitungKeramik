package us.kurniawan.hitungkeramik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {


    TextView luas_kamar, luas_keramik, jumlah_keramik, jumlah_dus, harga_total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(us.kurniawan.hitungkeramik.R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null)

        {
            String LuasKamar = extras.getString("LUASKAMAR");
            String LuasKeramik = extras.getString("LUASKERAMIK");
            String JumlahKeramik = extras.getString("JUMLAHKERAMIK");
            String JumlahDus = extras.getString("JUMLAHDUSKERAMIK");
            String HargaTotal = extras.getString("TOTAL");

            luas_kamar = (TextView)findViewById(us.kurniawan.hitungkeramik.R.id.luas_kamar);
            luas_keramik = (TextView)findViewById(us.kurniawan.hitungkeramik.R.id.luas_keramik);
            jumlah_keramik = (TextView)findViewById(us.kurniawan.hitungkeramik.R.id.jumlah_keramik);
            jumlah_dus = (TextView)findViewById(us.kurniawan.hitungkeramik.R.id.jumlah_dus);
            harga_total = (TextView)findViewById(us.kurniawan.hitungkeramik.R.id.harga_total);

            luas_kamar.setText(LuasKamar);
            luas_keramik.setText(LuasKeramik);
            jumlah_keramik.setText(JumlahKeramik);
            jumlah_dus.setText(JumlahDus);
            harga_total.setText(HargaTotal);

        }


    }
}

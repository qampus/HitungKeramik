package us.kurniawan.hitungkeramik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button proses;
    EditText panjang_kamar, lebar_kamar, panjang_keramik, lebar_keramik, isi_keramik, harga_keramik;

    Double LuasKeramik, JumlahKeramik, LuasKamar, JumlahDusKeramik, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        proses = (Button) findViewById(R.id.proses);

        panjang_kamar = (EditText) findViewById(R.id.panjang_kamar);
        lebar_kamar = (EditText) findViewById(R.id.lebar_kamar);
        panjang_keramik = (EditText) findViewById(R.id.panjang_keramik);
        lebar_keramik = (EditText) findViewById(R.id.lebar_keramik);
        isi_keramik = (EditText) findViewById(R.id.isi_keramik);
        harga_keramik = (EditText) findViewById(R.id.harga_keramik);


        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (panjang_kamar.getText().length() == 0) {
                    SetRequired(panjang_kamar);
                }
                if (lebar_kamar.getText().length() == 0) {
                    SetRequired(lebar_kamar);
                }
                if (panjang_keramik.getText().length() == 0) {
                    SetRequired(panjang_keramik);
                }
                if (lebar_keramik.getText().length() == 0) {
                    SetRequired(lebar_keramik);
                }
                if (isi_keramik.getText().length() == 0) {
                    SetRequired(isi_keramik);
                }
                if (harga_keramik.getText().length() == 0) {
                    SetRequired(harga_keramik);
                } else {
                    Double PanjangKamar = Double.parseDouble(panjang_kamar.getText().toString());
                    Double LebarKamar = Double.parseDouble(lebar_kamar.getText().toString());
                    Double PanjangKeramik = Double.parseDouble(panjang_keramik.getText().toString());
                    Double LebarKeramik = Double.parseDouble(lebar_keramik.getText().toString());
                    Double IsiKeramik = Double.parseDouble(isi_keramik.getText().toString());
                    Double HargaKeramik = Double.parseDouble(harga_keramik.getText().toString());
                    LuasKamar = fLuasKamar(PanjangKamar, LebarKamar);
                    LuasKeramik = fLuasKeramik(PanjangKeramik, LebarKeramik);
                    JumlahKeramik = fJumlahKeramik(LuasKamar, LuasKeramik);
                    JumlahDusKeramik = fJumlahDusKeramik(JumlahKeramik, IsiKeramik);
                    total = Uang(JumlahDusKeramik, HargaKeramik);

                    Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                    i.putExtra("LUASKAMAR", LuasKamar.toString());
                    i.putExtra("LUASKERAMIK", LuasKeramik.toString());
                    i.putExtra("JUMLAHKERAMIK", JumlahKeramik.toString());
                    i.putExtra("JUMLAHDUSKERAMIK", JumlahDusKeramik.toString());
                    i.putExtra("TOTAL", total.toString());
                    startActivity(i);
                }
            }
        });

    }

    private Double fLuasKamar(Double PanjangKamar, Double LebarKamar) {
        return PanjangKamar * LebarKamar;
    }

    private Double fLuasKeramik(Double PanjangKeramik, Double LebarKeramik) {
        return PanjangKeramik * LebarKeramik;
    }

    private Double fJumlahKeramik(Double LuasKamar, Double LuasKeramik) {
        return LuasKamar / LuasKeramik;
    }

    private Double fJumlahDusKeramik(Double JumlahKeramik, Double IsiKeramik) {
        return JumlahKeramik / IsiKeramik;
    }

    private Double Uang(Double JumlahDusKeramik, Double HargaDus) {
        return JumlahDusKeramik * HargaDus;
    }

    private void SetRequired(EditText a) {
        a.setError("Diperlukan");
    }

}

package com.example.indah.menghitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edSisi;
    Button btHitung;
    TextView txHasil;
    Spinner spnPilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSisi = findViewById(R.id.edtSisi);
        btHitung = findViewById(R.id.btnHitung);
        txHasil = findViewById(R.id.txtHasil);
        spnPilihan = findViewById(R.id.spinerPilihan);

        btHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //untuk membuat method = ctrl+alt+m
                if(spnPilihan.getSelectedItem().toString().equals(pilihanHitung[0])){
                    //rumus volume
                    rumusVolume();
                } else if(spnPilihan.getSelectedItem().toString().equals(pilihanHitung[1])){
                    //rumus keliling
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    rumusKeliling(sisi);
                } else if(spnPilihan.getSelectedItem().toString().equals(pilihanHitung[2])){
                    //rumus luas permukaan
                    Double hasil = rumusLuasPermukaan();
                    txHasil.setText(hasil.toString());
                }
            }
        });

        //data adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spnPilihan.setAdapter(adapter);
    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = 12 * sisi;
        return hasil;
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 6 * sisi * sisi;
        txHasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        txHasil.setText(hasil.toString());
    }
}

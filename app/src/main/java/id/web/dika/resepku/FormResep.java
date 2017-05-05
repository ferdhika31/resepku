package id.web.dika.resepku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.web.dika.resepku.db.ResepDAO;
import id.web.dika.resepku.model.Resep;

public class FormResep extends AppCompatActivity {
    private String nama;
    private String id;

    private EditText inpNama;
    private EditText inpWaktu;
    private EditText inpBahan;
    private EditText inpCara;
    private EditText inpKeterangan;

    Resep resep = null;
    private ResepDAO resepDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_resep);

        // Parsing Parameter
        Intent myIntent = getIntent(); // gets the previously created intent

        nama = (myIntent.getStringExtra("nama")!=null) ? myIntent.getStringExtra("nama") : "Tambah Resep"; // will return "SecondKeyValue"
        id = (myIntent.getStringExtra("id")!=null) ? myIntent.getStringExtra("id") : "0"; // will return "SecondKeyValue"

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(nama);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        resepDAO = new ResepDAO(FormResep.this);

        inpNama = (EditText) findViewById(R.id.inpNama);
        inpWaktu = (EditText) findViewById(R.id.inpWaktu);
        inpBahan = (EditText) findViewById(R.id.inpBahan);
        inpCara = (EditText) findViewById(R.id.inpCara);
        inpKeterangan = (EditText) findViewById(R.id.inpKeterangan);

        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Validasi */
                if (!validate(inpNama)) {
                    return;
                }
                if (!validate(inpWaktu)) {
                    return;
                }
                if (!validate(inpBahan)) {
                    return;
                }
                if (!validate(inpCara)) {
                    return;
                }
                if (!validate(inpKeterangan)) {
                    return;
                }

                /* Aksi button */
                Intent myIntent = getIntent(); // gets the previously created intent
                if(id=="0"){ // Simpan
                    resep = new Resep();
                    resep.setNama(inpNama.getText().toString());
                    resep.setWaktu(inpWaktu.getText().toString());
                    resep.setBahan(inpBahan.getText().toString());
                    resep.setCara(inpCara.getText().toString());
                    resep.setKeterangan(inpKeterangan.getText().toString());

                    long result = resepDAO.save(resep);

                    if (result != -1){
                        Toast.makeText(FormResep.this, "Resep tersimpan", Toast.LENGTH_LONG).show();

                        Intent pindahIntent = new Intent(FormResep.this, id.web.dika.resepku.DaftarResep.class);
                        startActivity(pindahIntent);
                    }else{
                        Toast.makeText(FormResep.this, "Gagal tersimpan", Toast.LENGTH_LONG).show();
                    }
                }else{ // Ubah
                    Toast.makeText(FormResep.this, "Ubah", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean validate(EditText inputan) {
        if (inputan.getText().toString().trim().isEmpty()) {
            inputan.setError(inputan.getHint() + " is Required");
            return false;
        } else {
            inputan.setError(null);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}

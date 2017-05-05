package id.web.dika.resepku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import id.web.dika.resepku.db.ResepDAO;
import id.web.dika.resepku.model.Resep;

public class DetailResep extends AppCompatActivity {

    String LOG_NAME = "Detail Resep";

    public String nama;
    public String id;

    Resep resep = null;
    private ResepDAO resepDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);

        // Parsing Parameter
        Intent myIntent = getIntent(); // gets the previously created intent

        nama = (myIntent.getStringExtra("nama")!=null) ? myIntent.getStringExtra("nama") : ""; // will return "SecondKeyValue"
        id = (myIntent.getStringExtra("id")!=null) ? myIntent.getStringExtra("id") : "0"; // will return "SecondKeyValue"

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(nama);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        resepDAO = new ResepDAO(DetailResep.this);

        TextView lblJudul = (TextView)findViewById(R.id.lblJudul);
        TextView lblWaktu = (TextView)findViewById(R.id.lblWaktu);
        TextView lblBahan = (TextView)findViewById(R.id.lblBahan);
        TextView lblCara = (TextView)findViewById(R.id.lblCara);
        TextView lblKeterangan = (TextView)findViewById(R.id.lblKeterangan);

        resep = resepDAO.getOneData(Integer.parseInt(id));

        lblJudul.setText(resep.getNama());
        lblWaktu.setText(resep.getWaktu());
        lblBahan.setText(resep.getBahan());
        lblCara.setText(resep.getCara());
        lblKeterangan.setText(resep.getKeterangan());

        Log.d(LOG_NAME,"Masuk detail resep");
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

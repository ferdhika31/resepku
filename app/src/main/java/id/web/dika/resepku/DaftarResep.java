package id.web.dika.resepku;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import id.web.dika.resepku.adapter.CustomList;
import id.web.dika.resepku.db.ResepDAO;

public class DaftarResep extends AppCompatActivity {
    String LOG_NAME = "Daftar Resep";

    ListView list;

    Integer[] imageId = {};
    private String[] namaResep = {};
    private String[] idResep = {};

    private ResepDAO resepDAO;

    public void refresh(){
        CustomList adapter = new CustomList(DaftarResep.this, namaResep, imageId);

        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_resep);

        resepDAO = new ResepDAO(DaftarResep.this);

        // Kalo belum ada data, inisialisasi
        if(resepDAO.getAllData().getCount() == 0){
            resepDAO.initResep();
            Log.d(LOG_NAME,"Masuk init");
        }

        view();

        CustomList adapter = new CustomList(DaftarResep.this, namaResep, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent myIntent = new Intent(DaftarResep.this, id.web.dika.resepku.DetailResep.class);
                myIntent.putExtra("id",idResep[position]);
                myIntent.putExtra("nama",namaResep[position]);
                startActivity(myIntent);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                final int posisi = pos;

                new AlertDialog.Builder(DaftarResep.this)
                        .setTitle("Hapus")
                        .setMessage("Apakah resep "+ namaResep[pos] + " akan dihapus?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                int result = resepDAO.delete(idResep[posisi]);

                                if(result==1){
                                    refresh();
                                    Toast.makeText(DaftarResep.this, "Resep sukses di hapus", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(DaftarResep.this, "Resep gagal di hapus", Toast.LENGTH_SHORT).show();
                                }
                            }})
                        .setNegativeButton(android.R.string.no, null).show();



                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaftarResep.this, FormResep.class));
            }
        });
    }

    public void view(){

        Cursor res = resepDAO.getAllData();

        int jum = res.getCount();

        idResep = new String[jum];
        namaResep = new String[jum];
        imageId = new Integer[jum];

        if(res.getCount() == 0) {
            // show message
            Toast.makeText(this, "Tidak Ada Data ",
                    Toast.LENGTH_LONG).show();
            return;
        }else{
            int indeks=0;
            while (res.moveToNext()) {
                imageId[indeks] = R.drawable.dinner;
                idResep[indeks] = res.getString(0);
                namaResep[indeks] = res.getString(1);
                indeks++;
            }
        }
    }
}

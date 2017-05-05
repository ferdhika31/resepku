package id.web.dika.resepku.db;

/**
 * Created by ferdhika on 05/05/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import id.web.dika.resepku.model.Resep;

public class ResepDAO extends ResepKuDAO{
    private static final String WHERE_ID_EQUALS = DatabaseHelper.FIELD_ID + " =?";

    public ResepDAO(Context context) {
        super(context);
    }

    public Cursor getAllData() {
        Cursor res = database.rawQuery("select * from "+DatabaseHelper.RESEP_TABLE,null);
        return res;
    }

    public Resep getOneData(int id){
        String selectQuery = "SELECT * FROM " + DatabaseHelper.RESEP_TABLE + " WHERE "
                + DatabaseHelper.FIELD_ID + " ='" + id +"'";

        Cursor c = database.rawQuery(selectQuery, null);

        Resep r = new Resep();

        Log.d("Jumlah : ",c.getCount()+"");
        if (c.getCount() != 0){
            c.moveToFirst();

            r.setId(c.getInt(c.getColumnIndex(DatabaseHelper.FIELD_ID)));
            r.setNama(c.getString(c.getColumnIndex(DatabaseHelper.FIELD_NAMA)));
            r.setWaktu(c.getString(c.getColumnIndex(DatabaseHelper.FIELD_WAKTU)));
            r.setBahan(c.getString(c.getColumnIndex(DatabaseHelper.FIELD_BAHAN)));
            r.setCara(c.getString(c.getColumnIndex(DatabaseHelper.FIELD_CARA)));
            r.setKeterangan(c.getString(c.getColumnIndex(DatabaseHelper.FIELD_KETERANGAN)));
            r.setCreated_at(c.getString(c.getColumnIndex(DatabaseHelper.FIELD_CREATE_DATE)));
        }

        return r;
    }

    // Default config
    public void initResep() {
        ContentValues values = new ContentValues();

        // Data dari http://selerasa.com

        // Data 1
        values.put(DatabaseHelper.FIELD_NAMA, "Nasi Bukhari Daging Kambing");
        values.put(DatabaseHelper.FIELD_WAKTU, "Persiapan: 30 menit\n" +
                "Memasak: 90 menit\n" +
                "Total: 120 menit");
        values.put(DatabaseHelper.FIELD_BAHAN, "(+) Bahan Utama Nasi Bukhari Daging Kambing\n" +
                " - 750 gram daging kambing,lalu potong ukuran dadu\n" +
                " - 2 liter air\n" +
                " - 3 sdm ghee, atau diganti menggunakan minyak samin ataupun mentega tawar\n" +
                " - 300 gram bawang bombay,lalu potong juring\n" +
                " - 450 gram tomat merah, blender\n" +
                " - 300 gram beras basmati,lalu cuci bersih\n" +
                "\n" +
                "(+) Bahan Bumbu Nasi Bukhari Daging Kambing\n" +
                " - 1 sdt merica hitam bubuk\n" +
                " - 3/4 sdt kunyit bubuk\n" +
                " - 3/4 sdt kapulaga bubuk\n" +
                " - 2 sdt garam\n" +
                " - 1 ruas jari kayu manis, memarkan\n" +
                " - 1/2 sdt jinten bubuk\n" +
                "\n" +
                "(+) Bahan Pelengkap Nasi Bukhari Daging Kambing\n" +
                " - Daging kambing\n" +
                " - Kuah tomat\n" +
                " - Bumbu rempah\n");
        values.put(DatabaseHelper.FIELD_CARA, "1. Langkah pertama panaskan terlebih dahulu ghee ke dalam panci kemudian tumis bawang bombay hingga layu dan harum.\n" +
                "2. Kemudian masukan daging kambing dan aduk hingga berubah warna\n" +
                "3. Selanjutnya tambahkan air kemudian bumbu dan tomat hingga mendidih\n" +
                "4. Tutup kembali panci sehingga daging empuk , kurang lebih selama 60 menit\n" +
                "5. Setelah matang kemudian masukan beras kurang lebih 30 menit\n" +
                "6. Tata kembali nasi diatas piring kemudian tambahkan bahan pelengkap\n");
        values.put(DatabaseHelper.FIELD_KETERANGAN, "Membuat nasi bukhari simpel dan mudah dapat anda praktekan di rumah sendiri. Nasi bukhari dengan daging kambing dapat menjadi salah satu alternatif untuk keluarga anda dalam menyantap hidangan khas arab di rumah.");

        database.insert(DatabaseHelper.RESEP_TABLE, null, values);

        // Data 2
        values.put(DatabaseHelper.FIELD_NAMA, "Udon Kuah Ala Jepang Topping");
        values.put(DatabaseHelper.FIELD_WAKTU, "Persiapan: 20 menit\n" +
                "Memasak: 80 menit\n" +
                "Total: 100 menit");
        values.put(DatabaseHelper.FIELD_BAHAN, "(+) Bahan Utama Udon Kuah Ala Jepang\n" +
                " - 1/2 buah bawang bombay, iris panjang\n" +
                " - 1 siung bawang putih, cincang halus\n" +
                " - 100 gram daging sukiyaki, potong-potong\n" +
                " - 1 1/2 sendok makan kecap kikoman\n" +
                " - 1 sendok makan minyak untuk menumis\n" +
                " - 8 slice kamaboko (fish paste)\n" +
                " - 500 gram udon basah,kemudian seduh air panas dan jangan lupa untuk tiriskan\n" +
                " - 100 gram jamur shitake segar, buang tengahnya, kerat bintang, rebus\n" +
                " - 230 gram egg tofu ,potong\n" +
                " - 1 batang daun bawang, iris tipis\n" +
                "\n" +
                "(+) Bahan Bumbu Udon Kuah Ala Jepang\n" +
                " - 1.000 ml air kaldu ayam\n" +
                " - 2 sendok makan kikkoman\n" +
                " - 5 sendok teh mirin\n" +
                " - 10 gram bonnito\n" +
                " - 3/4 sendok teh garam\n" +
                " - 1/2 sendok teh merica bubuk\n");
        values.put(DatabaseHelper.FIELD_CARA, "1. Langkah pertama yang dilakukan menumis bawang bombay hingga mengeluarkan aroma harum\n" +
                "2. Kemudian masukan daging dan aduk hingga daging berubah warna\n" +
                "3. Selanjutnya tambahkan kikkoman dan aduk kembali hingga merata,angkat dan sisihkan\n" +
                "4. Selanjutnya untuk membuat kuah, rebus terlebih dahulu hingga mendidih kemudian masukan mirin, kikkoman ,garam ,merica dan bonito .Masak kembali hingga mendidih hingga harum\n" +
                "5. Selanjutnya untuk saran penyajian , udon dapat ditata dengan tumisan daging kemudian jamur shitake  tambahkan kamaboko , egg tofu dan juga daun bawang lalu siram dengan kuah.\n");
        values.put(DatabaseHelper.FIELD_KETERANGAN, "Udon kuah ala Jepang dengan topping seperti egg tofu dan kamaboko merupakan hidangan yang istimewa yang disajikan di tengah keluarga tercinta.");

        database.insert(DatabaseHelper.RESEP_TABLE, null, values);

        // Data 3
        values.put(DatabaseHelper.FIELD_NAMA, "Cap Cay Goreng");
        values.put(DatabaseHelper.FIELD_WAKTU, "Persiapan: 20 menit\n" +
                "Memasak: 80 menit\n" +
                "Total: 100 menit");
        values.put(DatabaseHelper.FIELD_BAHAN, "(+) Bahan Utama Cap Cay Goreng Rumahan\n" +
                " - 1 buah wortel,lalu dipotong tipis arag serong\n" +
                " - 9 batang buncis,lalu dipotong serong\n" +
                " - 60 gram kapri,lalu dipotong serong\n" +
                " - 8  buah jagung muda/putren,lalu dipotong serong\n" +
                " - 100 gram sawi hijau,lalu iris\n" +
                " - 100 gram kembang kol/brokoli,lalu ambil kuntumnya\n" +
                " - 50 gram jamur kuping/jamur merang,lalu rendam air panas, tiriskan\n" +
                " - 2 batang sosis,lalu dipotong-potong\n" +
                " - 3 butir bakso sapi,lalu diiris-iris\n" +
                " - 3 butir bakso ikan,lalu diiris-iris\n" +
                " - 1 sendok makan tepung maizena\n" +
                " - 50 ml air\n" +
                "\n" +
                "(+) Bahan Bumbu Cap Cay Goreng Rumahan\n" +
                " - 1 buah tomat merah (dipotong-potong)\n" +
                " - 2 cm jahe (digeprak atau dimemarkan)\n" +
                " - 1 sendok teh bubuk merica\n" +
                " - 2 sendok makan kecap ikan\n" +
                " - 1 sendok teh garam\n" +
                " - 1 sendok teh gula pasir\n" +
                " - 1 sendok teh penyedap\n" +
                " - 2 batang daun bawang\n" +
                "\n" +
                "(+) Bahan Pelengkap Cap Cay Goreng Rumahan\n" +
                " - Acar mentimun\n");
        values.put(DatabaseHelper.FIELD_CARA, "1. Langkah pertama panaskan minyak goreng kemudian tumis bawang merah, bawang putih dan bawang bombay hingga berubah warna dan layu\n" +
                "2. Kemudian tambahkan jahe dan tomat,selanjutnya masukan air hingga mendidih\n" +
                "3. Masukan juga buncis, wortel,kapri, sawi,jagung muda, kembang kol,jamur,sosis , kembang kol , bakso ikan, bakso sapi hingga semua bahan tercampur rata\n" +
                "4. Selanjutnya masukan saus tiram, gula pasir, merica ,garam ,kecap ikan dan penyedap rasa(apabila diperlukan).Aduk hingga merata\n" +
                "5. Kemudian masukan daun bawang dan juga larutan maizena hingga mengental. Angkat dan sajikan selagi hangat dengan bahan pelengkap sesuai dengan selera.\n");
        values.put(DatabaseHelper.FIELD_KETERANGAN, "Anda dapat berbagi resep dengan teman dan keluarga di akun media sosial anda, kunjungi juga web kami yang menyediakan aneka macam hidangan utama berbahan daging, bahan nasi, bahan aneka sayur, bahan ikan dan juga hidangan utama khas mancanegara.");

        database.insert(DatabaseHelper.RESEP_TABLE, null, values);

        // Data 4
        values.put(DatabaseHelper.FIELD_NAMA, "Steak Daging Sapi Sirloin Saus Barbeque");
        values.put(DatabaseHelper.FIELD_WAKTU, "Persiapan: 15 menit\n" +
                "Memasak: 25 menit\n" +
                "Total: 35 menit");
        values.put(DatabaseHelper.FIELD_BAHAN, "(+) Bahan Utama Steak Daging Sirloin yang Diperlukan:\n" +
                " - 6 buah (175 gram) daging sirloin (siap pakai)\n" +
                " - 1/2 sdt garam\n" +
                " - 1/2 sdt merica bubuk\n" +
                " - 2 sdm minyak zaitun\n" +
                "(+) Bahan Bumbu Steak Daging Sirloin:\n" +
                " - 3 sdm mentega tawar\n" +
                " - 2 sdm daun basil cincang\n" +
                " - 2 sdm mustard dijon\n" +
                "(+) Bahan Pelengkap Untuk Steak Daging Sirloin:\n" +
                " - 200 gram buncis\n" +
                " - 150 gram wortel (potong korek api, rebus)\n" +
                " - 150 gram lobak (kupas)\n" +
                " - 150 gram zucchini (iris korek api)\n" +
                "(+) Bahan Saus Barbeque:\n" +
                " - 4 sdm saus barbeque\n" +
                " - 1 sdm kecap manis\n" +
                " - 3 sdm saus tomat\n" +
                " - 1 siung bawang putih, cincang\n" +
                " - 1 sdm tepung maizena (larutkan denganair)\n" +
                " - 1 sdm mentega\n" +
                " - 2 butir bawang merah, cincang\n" +
                " - 1/4 buah bawang bombay, cincang\n" +
                " - 150 ml air\n" +
                " - garam secukupnya\n");
        values.put(DatabaseHelper.FIELD_CARA, "1. Langkah pertama yang bisa anda lakukan terlebih dahulu untuk memulai langkah pada resep kali ini adalah dengan telebih dahulu memukul-mukul daging dengan menggunakan palu pemukul daging. Hal ini berguna agar daging menjadi lebih empuk dan dan bumbu meresap. Adapun tips untuk bisa mendapatkan daging steak yang empuk dan lezat sewaktu dipanggang adalah dengan memotong daging berbalik dengan serat atau urat daging. Selain itu, hindari pula memasak steak terlalu lama, sebab hal ini dapat berpengaruh pada kealotan daging.\n" +
                "2. Setelah dipuku-pukul, lumuri potongan daging dengan minyak zaitun, garam dan berikan taburan merica, kemudian rata dan pastikan jika semua bagian daging terlumuri dengan sempurna.\n" +
                "3. Diamkan sementara daging yang telah dilumuri dengan bumbu selama kurang lebih 30 menit dan tempatkan dalam lemari es agar bumbu meresap dengan sempurna.\n" +
                "4. Setelah didiamkan selama 30 menit. Bakar daging diatas bara api sambil sesekali diolesi dengan menggunakan bumbu yang telah diaduk rata (bahan bumbu).\n" +
                "5. Angkat dan sajikan diatas piring.\n");
        values.put(DatabaseHelper.FIELD_KETERANGAN, "Anda dapat berbagi resep dengan teman dan keluarga di akun media sosial anda, kunjungi juga web kami yang menyediakan aneka macam hidangan utama berbahan daging, bahan nasi, bahan aneka sayur, bahan ikan dan juga hidangan utama khas mancanegara.");

        database.insert(DatabaseHelper.RESEP_TABLE, null, values);

        // Data 5
        values.put(DatabaseHelper.FIELD_NAMA, "Kue Pukis Oreo");
        values.put(DatabaseHelper.FIELD_WAKTU, "Persiapan: 30 menit\n" +
                "Memasak: 10 menit\n" +
                "Total: 40 menit");
        values.put(DatabaseHelper.FIELD_BAHAN, "(+) Bahan-Bahan Kue:\n" +
                " - 250 gram tepung terigu\n" +
                " - 400 cc santan hangat\n" +
                " - 50 gram margarin\n" +
                " - 1 sdt ragi\n" +
                " - 1/2 sdt gram\n" +
                " - 125 gram gula pasir\n" +
                " - 2 buah kuning telur\n" +
                " - 1 sdm susu kentl manis putih\n" +
                " - 1 sdt pasta vanila\n" +
                "(+) Bahan Taburan:\n" +
                " - 5 keping Oreo\n");
        values.put(DatabaseHelper.FIELD_CARA, "(+) Tips Mempersiapkan Bahan:\n" +
                " 1. Penting sekali mengetahui bagaimana mengolah beberapa bahan pada resep sebelum dicampur dan disatukan bersama dengan bahan-bahan lainnya menjadi adonan dari hidangan yang lezat yang nikmat. Untuk itu, sebaiknya pastikan bila anda sudah mempersiapkan semua peralatan yang akan dibutuhkan untuk membuat hidangan kali ini. Adapun beberapa peralatan yang dibutuhkan diantaranya adalah sebuah mixer untuk mengocok adonan agar lebih mudah. Lalu beberapa baskom untuk membuat adonan, sebuah spatula untuk memudahkan anda mencampurkan adonan dengan bahan lainnya dan sebuah piring saji. Dengan mempersiapkan peralatan ini maka anda akan siap membuat hidangan kali ini.\n" +
                " 2. Setelah selesai dengan peralatan silahkan lanjutkan cara kali ini dengan mencairkan margarin dengan menggunakan wajan. Caranya, silahkan siapkan sebuah wajan dan panaskan diatas kompor dengan menggunakan api yang sedang. Lalu setelah itu, silahkan masukkan margarin kedalamnya dan biarkan samapi mencair hingga teksturnya lebih terlihat seperti minyak.\n" +
                " 3. Kemudian silahkan hangatkan santan dalam panci. Silahkan masukkan santan dan tempatkan diatas kompor dengan menggunakan api yang kecil saja. Angkat bila sudah hangat dan sisihkan sementara.\n" +
                " 4. Sementara itu, untuk bahan oreo silahkan buang bagian krimnya. Lalu hancurkan biskuitnya dengan menggunakan mesin penggiling atau dihancurkan dengan menggunakan tangan dan sisihkan sementara.\n" +
                "\n" +
                "(+) Cara Membuat Adonan:\n" +
                " 1. Untuk membuat hidangan kali ini dapat dilakukan dengan mempersiapkan sebuah baskom lalu masukkan kedalamnya ragi bersama dengan santan dan juga gula pasir. Aduk-aduk semua bahan ini secara merata hingga larut dan sisihkan sementara.\n" +
                " 2. Setelah itu, tuangkan telur bersama dengan garam dan aduk-aduk semua bahan ini sampai mengembang dengan menggunakan kecepatan tinggi pada mixer. Aduk-aduk merata.\n" +
                " 3. Masukkan tepung terigu bersama dengan susu kental manis dan juga pasta vanili. Aduk-aduk kembali hingga semua bahan ini merata dan tercampur dengan bahan lainnya.\n" +
                " 4. Masukkan pula bahan campuran ragi yang sudah dibuat tadi dan aduk-aduk semuanya merata sampai tercampur. Setelah itu, diamkan sementara adonan selama kurang lebih 30 menit sampai mengembang dan ukurannya lebih besar dari sebelumnya.\n" +
                " 5. Bila sudah selesai, silahkan siapkan sebuah cetakan pukis dan tempatkan diatas kompor. Lalu tuangkan adonan kedalamnya sampai hampir penuh. Tutupi dengan menggunakan penutupnya lalu masak sampai setengah matang.\n" +
                " 6. Setelah hampir matang, buka penutup dan taburi dengan menggunakan bubuk oreo yang sudah anda buat tadi. Tutup kembali dan masak semua bahan ini sampai matang merata.\n");
        values.put(DatabaseHelper.FIELD_KETERANGAN, "Hidangkan sajian ini dalam piring saji untuk kemudian akan siap anda nikmati bersama dengan keluarga.");

        database.insert(DatabaseHelper.RESEP_TABLE, null, values);
    }

    public long save(Resep resep) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.FIELD_NAMA, resep.getNama());
        values.put(DatabaseHelper.FIELD_WAKTU, resep.getWaktu());
        values.put(DatabaseHelper.FIELD_BAHAN, resep.getBahan());
        values.put(DatabaseHelper.FIELD_CARA, resep.getCara());
        values.put(DatabaseHelper.FIELD_KETERANGAN, resep.getKeterangan());
        values.put(DatabaseHelper.FIELD_CREATE_DATE, resep.getCreated_at());

        long result = database.insert(DatabaseHelper.RESEP_TABLE,null ,values);

        return result;
    }

    public int update(Resep resep) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.FIELD_NAMA, resep.getNama());
        values.put(DatabaseHelper.FIELD_WAKTU, resep.getWaktu());
        values.put(DatabaseHelper.FIELD_BAHAN, resep.getBahan());
        values.put(DatabaseHelper.FIELD_CARA, resep.getCara());
        values.put(DatabaseHelper.FIELD_KETERANGAN, resep.getKeterangan());
        values.put(DatabaseHelper.FIELD_CREATE_DATE, resep.getCreated_at());

        return database.update(DatabaseHelper.RESEP_TABLE, values, DatabaseHelper.FIELD_ID + " = ?",
                new String[] { String.valueOf(resep.getId()) });
    }

    public int delete(String id) {
        return database.delete(DatabaseHelper.RESEP_TABLE, DatabaseHelper.FIELD_ID + " = ?",
                new String[] { String.valueOf(id) });
    }
}

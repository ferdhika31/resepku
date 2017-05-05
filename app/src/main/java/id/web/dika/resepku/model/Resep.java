package id.web.dika.resepku.model;

/**
 * Created by ferdhika on 05/05/17.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Resep {
    private int id;
    private String nama;
    private String waktu;
    private String bahan;
    private String cara;
    private String keterangan;
    private String created_at;

    public Resep() {
        super();
    }

    private Resep(Parcel in) {
        super();
        this.id = in.readInt();
        this.nama = in.readString();
        this.waktu = in.readString();
        this.bahan = in.readString();
        this.cara = in.readString();
        this.keterangan = in.readString();
        this.created_at = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String val) {
        this.nama = val;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String val) {
        this.waktu = val;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String val) {
        this.bahan = val;
    }

    public String getCara() {
        return cara;
    }

    public void setCara(String val) {
        this.cara = val;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String val) {
        this.keterangan = val;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String val) {
        this.created_at = val;
    }

    @Override
    public String toString() {
        return "Resep [id=" + id + ", nama=" + nama +"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resep other = (Resep) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getId());
        parcel.writeString(getNama());
        parcel.writeString(getWaktu());
        parcel.writeString(getBahan());
        parcel.writeString(getCara());
        parcel.writeString(getKeterangan());
        parcel.writeString(getCreated_at());
    }

    public static final Parcelable.Creator<Resep> CREATOR = new Parcelable.Creator<Resep>() {
        public Resep createFromParcel(Parcel in) {
            return new Resep(in);
        }

        public Resep[] newArray(int size) {
            return new Resep[size];
        }
    };
}

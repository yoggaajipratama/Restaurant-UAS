package com.restaurant.yogga.model;

import com.google.gson.annotations.SerializedName;

public class RestaurantItem {
    @SerializedName("rmid")
    private String rmid;
    @SerializedName("foto")
    private String foto;
    @SerializedName("kategori")
    private String kategori;
    @SerializedName("namarm")
    private String namarm;
    @SerializedName("alamat")
    private String alamat;
    public void setRmid(String rmid){
        this.rmid = rmid;
    }
    public String getRmid(){
        return rmid;
    }
    public void setFoto(String foto){
        this.foto = foto;
    }
    public String getFoto(){
        return foto;
    }
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    public String getKategori(){
        return kategori;
    }
    public void setNamarm(String namarm){
        this.namarm = namarm;
    }
    public String getNamarm(){
        return namarm;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getAlamat(){
        return alamat;
    }
}
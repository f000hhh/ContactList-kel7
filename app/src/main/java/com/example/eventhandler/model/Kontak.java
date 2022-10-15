package com.example.eventhandler.model;

public class Kontak {
    String _nama;
    String _noHP;
    int _foto;

    public Kontak(String _nama, String _noHP, int _foto) {
        this._nama = _nama;
        this._noHP = _noHP;
        this._foto = _foto;
    }

    public String get_nama() {
        return _nama;
    }

    public String get_noHP() {
        return _noHP;
    }

    public int get_foto() {
        return _foto;
    }

}

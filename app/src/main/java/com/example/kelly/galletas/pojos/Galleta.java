package com.example.kelly.galletas.pojos;

/**
 * Created by AlumnoFP on 18/10/2017.
 */

public class Galleta {
    String marca;
    int stock;

    public Galleta(String marca, int stock) {
        this.marca = marca;
        this.stock = stock;
    }

    public Galleta() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

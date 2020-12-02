package com.example.juego21cartas;

public class Carta {
    private int num;
    private int imagenCarta;

    public Carta(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setImagenCarta(int imagenCarta) {
        this.imagenCarta = imagenCarta;
    }

    public int getImagenCarta() {
        return imagenCarta;
    }

    public Carta(int num, int imagenCarta) {
        this.num = num;
        this.imagenCarta = imagenCarta;
    }


}

package com.example.projekt4;

public class Rzecz {

    private Long id;
    private String kolumna1;
    private String kolumna2;

    public String getKolumna2() {
        return kolumna2;
    }

    public String getKolumna1() {
        return kolumna1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKolumna1(String kolumna1) {
        this.kolumna1 = kolumna1;
    }

    public void setKolumna2(String kolumna2) {
        this.kolumna2 = kolumna2;
    }
}

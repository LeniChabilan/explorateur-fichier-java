package com.esiea.pootd2.models;

public abstract class Inode {
    protected final String name;

    public Inode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // taille en octets (ou unité arbitraire)
    public abstract int getSize();

    @Override
    public String toString() {
        return name;
    }
}

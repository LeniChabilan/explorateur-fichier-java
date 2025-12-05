package com.esiea.pootd2.models;

import java.util.Random;

public class FileInode extends Inode {
    private final int size;

    public FileInode(String name) {
        super(name);
        this.size = new Random().nextInt(100_000) + 1; // 1..100000
    }

    public FileInode(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}

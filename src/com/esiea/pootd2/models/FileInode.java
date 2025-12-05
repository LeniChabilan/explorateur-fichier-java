package com.esiea.pootd2.models;

import java.util.Random;

/**
 * Class representing a file inode in the file system.
 */
public class FileInode extends Inode {
    /**
     * The size of the file in bytes (or arbitrary unit).
     */
    private final int size;

    /**
     * Constructs a FileInode with the specified name and a random size.
     * @param name the name of the file
     */
    public FileInode(String name) {
        super(name);
        this.size = new Random().nextInt(100_000) + 1; // Size between 1 and 100,000
    }

    /**
     * Constructs a FileInode with the specified name and size.
     * @param name the name of the file
     * @param size the size of the file
     */
    public FileInode(String name, int size) {
        super(name);
        this.size = size;
    }

    /**
     * Returns the size of this file.
     * @return the size
     */
    @Override
    public int getSize() {
        return size;
    }
}

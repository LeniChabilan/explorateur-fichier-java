package com.esiea.pootd2.models;

/**
 * Abstract base class representing a file system inode.
 */
public abstract class Inode {
    protected final String name;

    /**
     * Constructs an Inode with the specified name.
     *
     * @param name the name of the inode
     */
    public Inode(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this inode.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    // Size of the inode in bytes (or arbitrary unit)
    public abstract int getSize();

    @Override
    public String toString() {
        return name;
    }
}

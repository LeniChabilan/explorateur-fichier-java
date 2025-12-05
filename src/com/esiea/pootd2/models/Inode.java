/*
 * Inode.java
 * 
 * Version 1.0
 * Date: December 2025
 * 
 * Copyright (c) 2025 ESIEA. All rights reserved.
 * 
 * Abstract base class representing a file system inode.
 * All files and folders inherit from this class.
 */

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

    /**
     * Returns the size of this inode.
     *
     * @return the size
     */
    public abstract int getSize();

    /**
     * Returns a string representation of the inode.
     *
     * @return the name of the inode
     */
    @Override
    public String toString() {
        return name;
    }
}

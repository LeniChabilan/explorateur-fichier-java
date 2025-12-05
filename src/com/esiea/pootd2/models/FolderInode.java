package com.esiea.pootd2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a folder inode in the file system.
 */
public class FolderInode extends Inode {
    
    /**
     * A list of child inodes contained within this folder.
     */
    private final List<Inode> children = new ArrayList<>();
    
    /**
     * Reference to the parent FolderInode. Used for traversing up the directory tree.
     */
    private FolderInode parent = null;

    /**
     * Constructs a FolderInode with the specified name.
     * 
     * @param name the name of the folder
     */
    public FolderInode(String name) {
        super(name);
    }

    /**
     * Adds an inode (file or folder) as a child of this folder.
     * If the inode being added is a FolderInode, its parent is automatically set to this folder.
     * 
     * @param inode the inode to add as a child
     */
    public void addInode(Inode inode) {
        children.add(inode);
        if (inode instanceof FolderInode) {
            ((FolderInode) inode).setParent(this);
        }
    }

    /**
     * Retrieves the list of child inodes contained in this folder.
     * 
     * @return a list of child inodes
     */
    public List<Inode> getChildren() {
        return children;
    }

    /**
     * Sets the parent FolderInode of this folder.
     * 
     * @param parent the parent FolderInode
     */
    public void setParent(FolderInode parent) {
        this.parent = parent;
    }

    /**
     * Retrieves the parent FolderInode of this folder.
     * 
     * @return the parent FolderInode, or null if this is the root folder
     */
    public FolderInode getParent() {
        return parent;
    }

    /**
     * Calculates the total size of this folder by summing the sizes of all child inodes.
     * 
     * @return the cumulative size of all children
     */
    @Override
    public int getSize() {
        int sum = 0;
        for (Inode i : children) {
            sum += i.getSize();
        }
        return sum;
    }
}

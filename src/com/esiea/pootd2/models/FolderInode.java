package com.esiea.pootd2.models;

import java.util.ArrayList;
import java.util.List;

public class FolderInode extends Inode {
    private final List<Inode> children = new ArrayList<>();
    private FolderInode parent = null; // pratique pour cd ..

    public FolderInode(String name) {
        super(name);
    }

    public void addInode(Inode inode) {
        children.add(inode);
        if (inode instanceof FolderInode) {
            ((FolderInode) inode).setParent(this);
        }
    }

    public List<Inode> getChildren() {
        return children;
    }

    public void setParent(FolderInode parent) {
        this.parent = parent;
    }

    public FolderInode getParent() {
        return parent;
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (Inode i : children) {
            sum += i.getSize();
        }
        return sum;
    }
}

package com.barracuda.rtdict.util.startdict;

/**
 *
 * @author RT
 */
public class Pos {
    private long pos;
    private long size;
    
    Pos(long pos, long size) {
        this.pos = pos;
        this.size = size;
    }

    /**
     * @return the pos
     */
    public long getPos() {
        return pos;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }
   
}

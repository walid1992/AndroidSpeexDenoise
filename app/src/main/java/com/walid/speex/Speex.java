package com.walid.speex;

public class Speex {

    public Speex() {
    }

    static {
        System.loadLibrary("speexdsp");
    }

    public native void init(int frame_size, int sample_rate);

    public native void preprocess(byte[] inbuffer);

    public native void destroy();
}
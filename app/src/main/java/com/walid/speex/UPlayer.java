package com.walid.speex;

import android.media.MediaPlayer;
import android.util.Log;

/**
 * Author   : walid
 * Date     : 2017-09-22  11:31
 * Describe :
 */

public class UPlayer {

    private final String TAG = UPlayer.class.getName();
    private String path;

    private MediaPlayer mPlayer;

    public UPlayer(String path) {
        this.path = path;
    }


    public boolean start() {
        try {
            if (mPlayer == null) {
                mPlayer = new MediaPlayer();
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Log.d("UPlayer", "onCompletion");
                        stop();
                    }
                });
            }
            //设置要播放的文件
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            //播放
            mPlayer.start();
        } catch (Exception e) {
            Log.e(TAG, "prepare() failed");
        }

        return false;
    }


    public boolean stop() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        return false;
    }

}
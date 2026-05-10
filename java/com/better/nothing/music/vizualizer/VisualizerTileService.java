package com.better.nothing.music.vizualizer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.os.Build;

public class VisualizerTileService extends TileService {

    // 外部（サービス等）からタイルを即時更新させるためのメソッド
    public static void requestListeningState(Context context) {
        TileService.requestListeningState(context,
                new ComponentName(context, VisualizerTileService.class));
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        Tile t = getQsTile();
        if (t != null) {
            refresh();
        }
    }

    @Override
    public void onClick() {
        boolean running = AudioCaptureService.isRunning();
        Intent intent = new Intent(this, AudioCaptureService.class);

        if (running) {
            stopService(intent);
        } else {
            // 重要：Android 14+ では TileService からの FGS 起動は許可されていますが、
            // 念のためこの「タイルコンテキスト」を維持して起動します。
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                // サービスを起動
                startForegroundService(intent);
            } else {
                startForegroundService(intent);
            }
        }


        refresh(!running);
    }

    private void refresh() {
        refresh(AudioCaptureService.isRunning());
    }

    private void refresh(boolean on) {
        Tile t = getQsTile();
        if (t == null) return;

        t.setState(on ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        t.setLabel("Glyph Viz");
        t.setSubtitle(on ? "ON (Tap to stop)" : "OFF (Tap to start)");

        // アイコンの設定
        t.setIcon(Icon.createWithResource(this,
                on ? android.R.drawable.ic_media_pause : android.R.drawable.ic_media_play));

        t.updateTile();
    }
}
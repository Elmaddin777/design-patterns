package adapter;

import java.util.HashMap;
import java.util.Map;

// target
public interface MediaPlayerWithCache {
    void play(String fileName, String fileType);
}

// adaptee
class AdvancedMediaPlayer2 {

   void playVlc(String fileName) {
       System.out.println("Playing vlc file: " + fileName);
   }

   void playMp4(String fileName) {
       System.out.println("Playing mp4 file: " + fileName);
   }

}

// adapter
class AdvancedMediaPlayer2Adapter implements MediaPlayerWithCache {

    private final AdvancedMediaPlayer2 advancedMediaPlayer2;

    public AdvancedMediaPlayer2Adapter() {
        this.advancedMediaPlayer2 = new AdvancedMediaPlayer2();
    }

    @Override
    public void play(String fileName, String fileType) {
        if (fileType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer2.playVlc(fileName);
        } else if (fileType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer2.playMp4(fileName);
        } else {
            System.out.println("Unknown file type: " + fileType);
        }
    }

}

// adapter cache
class AdapterCache {

    private static final Map<String, AdvancedMediaPlayer2Adapter> cache = new HashMap<>();

    public static AdvancedMediaPlayer2Adapter getAdapter(String mediaType) {
        if (cache.containsKey(mediaType)) {
            System.out.println("Reusing adapter for media type: " + mediaType);
            return cache.get(mediaType);
        } else {
            System.out.println("Creating new adapter for media type: " + mediaType);
            cache.put(mediaType, new AdvancedMediaPlayer2Adapter());
        }

        return cache.get(mediaType);
    }

}

// player
class AudioPlayer {

    public void play( String fileName, String mediaType) {
        var advancedMediaPlayerAdapter = AdapterCache.getAdapter(mediaType);
        advancedMediaPlayerAdapter.play(fileName, mediaType);
    }

}

class AdapterCacheDemo {

    public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();
      audioPlayer.play("somemp4file.mp4", "mp4");
      System.out.println("==========================================");
      audioPlayer.play("anothermp4file.mp4", "mp4");
    }

}

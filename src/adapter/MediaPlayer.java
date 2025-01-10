package adapter;

// target
interface MediaPlayer {
    void play(String fileName, String fileType);
}

// adaptee
class AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing VLC file");
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file");
    }

}

// adapter
class MediaPlayerAdapter implements MediaPlayer {

    private final AdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayerAdapter() {
        this.advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String fileName, String fileType) {
        if (fileType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (fileType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else {
            System.out.println("Unsupported file type");
        }
    }

}

class Demo {
    public static void main(String[] args) {
        MediaPlayerAdapter mediaPlayerAdapter = new MediaPlayerAdapter();
        mediaPlayerAdapter.play("test.mp4", "mp4");
    }
}
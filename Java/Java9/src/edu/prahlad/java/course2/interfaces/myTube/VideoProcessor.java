package edu.prahlad.java.course2.interfaces.myTube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private NotificationService service;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, NotificationService service) {
        this.encoder = encoder;
        this.database = database;
        this.service = service;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        service.sendEmail(video.getUser());
    }
}


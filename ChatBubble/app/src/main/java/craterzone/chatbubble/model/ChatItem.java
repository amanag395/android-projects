package craterzone.chatbubble.model;

import java.sql.Time;

/**
 * Created by aMAN GUPTA on 3/3/2017.
 */

public class ChatItem {
    private String message;
    private String time;

    public ChatItem(String message, String time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatItem chatItem = (ChatItem) o;

        return message.equals(chatItem.message);

    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }
}

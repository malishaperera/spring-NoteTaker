package lk.ijse.note.notetaker.util;

import java.util.UUID;

public class AppUtil {
    public static String createNoteID(){
        return "NOTE-"+ UUID.randomUUID();
    }
}

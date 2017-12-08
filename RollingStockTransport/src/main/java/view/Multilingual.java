package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class Multilingual {
    private static ResourceBundle resource;
    private static Locale UKRAINE;
    private static Multilingual instances;
    private final UTF8Control utf8Control;

    private Multilingual() {
        // private constructor
        // default
        utf8Control = new UTF8Control();
        resource = ResourceBundle.getBundle("messages_eng",
                Locale.ENGLISH,utf8Control);
        UKRAINE = new Locale("ua","UA");
    }

    public static Multilingual getInstances() {
        if (instances == null) {
            synchronized (Multilingual.class) {
                if (instances == null) {
                    instances = new Multilingual();
                }
            }
        }
        return instances;
    }

    public static ResourceBundle rs() {
        return resource;
    }

    public enum Language {
        UA, ENG
    }

    public void switchLanguage(Language language) {
        switch (language) {
            case UA:
                resource = ResourceBundle.getBundle("messages_ua",
                        UKRAINE, utf8Control);
                break;
            case ENG:
                resource = ResourceBundle.getBundle("messages_eng",
                        Locale.ENGLISH, utf8Control);
                break;
        }
    }
}

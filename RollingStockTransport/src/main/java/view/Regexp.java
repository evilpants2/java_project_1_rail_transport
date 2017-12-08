package view;

public interface Regexp {
    String SELECT_LANGUAGE_REGEXP = "-ua|-eng";
    String CMD_SHOW = "-show";
    String CMD_SORT = "-sort";
    String CMD_COUNT_PASSENGER = "-count p";
    String CMD_COUNT_BAG = "-count bag";
    String COUNT_IN_RANGE = "-count in range ([\\d{1,2}],[\\d{1,2}])";
    String CMD_QUIT = "-quit|-exit";
    String CMD_HELP = "-help";
    String CMD_SELECT = "-select (\\d{1,3})";
    String CMD_SELECTED = "-show selected";
    String CMD_SHOW_TRAIN = "-show train (\\d{1,3})";
    String CMD_COUNT = "-count";
}

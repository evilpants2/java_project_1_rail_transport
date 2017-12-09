package view;

public interface CommandsRegexp {
    //language
    String UA = "-ua";
    String ENG = "-eng";
    //commands
    String CMD_SHOW = "-show";
    String CMD_SORT = "-sort";
    String CMD_COUNT = "-count";
    String CMD_HELP = "-help";
    String CMD_SELECTED = "-show selected";
    String CMD_QUIT = "-quit";
    //regexp
    String SHOW_TRAIN_REGEX = "-show train [0-9]{1,3}";
    String COUNT_IN_RANGE_REGEX = "-count in range \\([0-9]{1,2}[\\s]*,[\\s]*[0-9]{1,2}\\)";
    String SELECT_REGEX = "-select (\\d{1,3})";
}

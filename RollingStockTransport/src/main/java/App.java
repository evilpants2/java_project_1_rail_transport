import controller.Controller;
import model.train.RailwayStation;
import model.train.ComfortLevel;
import view.View;

public class App {
    public static void main(String[] args) {
        RailwayStation railway = new RailwayStation();
        View view = new View();
        Controller controller = new Controller(railway, view);
        controller.userProcess();
    }
}

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecordGUI.fxml"));
        try {
            FlowPane flowPane = loader.load();
            primaryStage.setScene(new Scene(flowPane));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

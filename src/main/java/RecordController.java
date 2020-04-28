import data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RecordController implements WeatherListener {

    @FXML
    public TextArea dataOutput;
    private boolean recording = false;
    private final WeatherDAO weatherDAO = new WeatherDAOSqlImpl();

    @FXML
    public void startSensor(ActionEvent actionEvent) {
        WeatherObservable weatherGenerator = new WeatherGenerator();
        weatherGenerator.register(this);
        new Thread(weatherGenerator).start();


    }
    @FXML
    public void startRecording(ActionEvent actionEvent) {
        this.recording= !this.recording;

    }

    @Override
    public void notify(WeatherData data) {
        System.out.println("Got data!" + dataOutput);
        if (dataOutput!=null){
            String text = dataOutput.getText();
            text += "\r\n" + "windDirection: " + data.getWindDirection();
            text += "windSpeed: " + data.getWindSpeed();
            dataOutput.setText(text);
        }
        if (recording){
            System.out.println("Storing data in datadase");
            weatherDAO.save(data);

        }
    }

    public void RecallData(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecallGUI.fxml"));
        try {
            FlowPane flowPane = fxmlLoader.load();
            Stage root = new Stage();
            root.setScene(new Scene(flowPane));
            root.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

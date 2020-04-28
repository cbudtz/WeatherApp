import data.WeatherDAO;
import data.WeatherDAOSqlImpl;
import data.WeatherData;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.sql.Timestamp;
import java.util.List;

public class RecallController {
    public TextArea recallArea;
    private WeatherDAO weatherDao = new WeatherDAOSqlImpl();

    public void recallData(ActionEvent actionEvent) {
        Timestamp from = new Timestamp(System.currentTimeMillis()-5*60*1000);
        List<WeatherData> load = weatherDao.load(from, new Timestamp(System.currentTimeMillis()));
        for (WeatherData data:load){
            String text = recallArea.getText();
            text += "ID: " + data.getId() + "WindSpeed: " + data.getWindSpeed() + "\r\n";
            recallArea.setText(text);
        }


    }
}

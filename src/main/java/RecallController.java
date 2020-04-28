import data.WeatherDAO;
import data.WeatherDAOSqlImpl;
import data.WeatherData;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.sql.Timestamp;
import java.util.List;

public class RecallController {
    public TextArea recallArea;
    public DatePicker dateStart;
    private WeatherDAO weatherDao = new WeatherDAOSqlImpl();

    public void recallData(ActionEvent actionEvent) {
        Timestamp from = Timestamp.valueOf(dateStart.getValue().atStartOfDay());
        List<WeatherData> load = weatherDao.load(from, new Timestamp(System.currentTimeMillis()));
        String text = "";
        for (WeatherData data:load){
            text += "ID: " + data.getId() + "WindSpeed: " + data.getWindSpeed() + "\r\n";
        }
        recallArea.setText(text);

    }
}

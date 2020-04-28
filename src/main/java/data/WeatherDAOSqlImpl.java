package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAOSqlImpl implements WeatherDAO {

    @Override
    public void save(WeatherData weatherData) {
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO weatherdata(time, windspeed, winddirection) VALUES (?,?,?)");
            preparedStatement.setTimestamp(1,weatherData.getTime());
            preparedStatement.setDouble(2,weatherData.getWindSpeed());
            preparedStatement.setDouble(3,weatherData.getWindDirection());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    @Override
    public List<WeatherData> load(Timestamp start, Timestamp end) {
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM weatherdata WHERE time> ? AND time < ?");
            preparedStatement.setTimestamp(1,start);
            preparedStatement.setTimestamp(2,end);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<WeatherData> weatherData = new ArrayList<>();
            while (resultSet.next()){

                WeatherData data = new WeatherData();
                data.setWindSpeed(resultSet.getDouble("windspeed"));
                data.setWindDirection(resultSet.getDouble("winddirection"));
                data.setTime(resultSet.getTimestamp("time"));
                data.setId(resultSet.getInt("id"));
                weatherData.add(data);
            }
            return weatherData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }
}

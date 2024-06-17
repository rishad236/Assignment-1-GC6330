package mobile.app.mobile;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TableView<Mobile> tableView;

    @FXML
    private TableColumn<Mobile, String> brandColumn;

    @FXML
    private TableColumn<Mobile, String> modelColumn;

    @FXML
    private TableColumn<Mobile, Double> priceColumn;

    @FXML
    private TableColumn<Mobile, Integer> ramColumn;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Loading Data...");
        loadChartData();
        loadTableData();
    }

    private void loadChartData() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Mobile Prices");

        try {
            ResultSet resultSet = Database.getMobiles();
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                double price = resultSet.getDouble("price");
                series.getData().add(new XYChart.Data<>(brand, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            welcomeText.setText("Error loading chart data.");
            return;
        }

        barChart.getData().clear();
        barChart.getData().add(series);
        welcomeText.setText("Chart Data Loaded!");
    }

    private void loadTableData() {
        try {
            ResultSet resultSet = Database.getMobiles();

            tableView.getItems().clear();

            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                int ram = resultSet.getInt("ram");

                tableView.getItems().add(new Mobile(brand, model, price, ram));
            }

            // Set cell value factories for each column
            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
            modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            ramColumn.setCellValueFactory(new PropertyValueFactory<>("ram"));

            welcomeText.setText("Table Data Loaded!");
        } catch (SQLException e) {
            e.printStackTrace();
            welcomeText.setText("Error loading table data.");
        }
    }
}

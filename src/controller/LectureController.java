package controller;

import DAO.CrudUtil;
import business.BOFactory;
import business.BOTypes;
import business.custom.LectureBO;
import business.exception.AlreadyExistsInOrderException;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;
import dto.LectureDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.LectureTM;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectureController implements Initializable {

    public JFXDatePicker date;
    public JFXTimePicker time;
    public JFXTextField venue;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnNew;
    public TableColumn coldate;
    public TableColumn coltime;
    public TableColumn colvenue;
    public TableColumn colparticipant;
    public TableColumn coltotpass;
    public TableColumn coltotfail;
    public TableColumn colview;
    public TableColumn coldel;
    public TableColumn collecid;
    public ScrollPane LectureForm;
    public JFXTextField lecaid;
    public JFXTextField LecName;
    public TableColumn colLecNm;
    public TableView<LectureTM> tblLec;
    public Button btnDelete;
    public PieChart pie;
    public BarChart<String,Number> bar;
    public Pane paneView;
    private LectureBO lectureBO = BOFactory.getInstance().getBO(BOTypes.LECTURE);



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        collecid.setCellValueFactory(new PropertyValueFactory<>("leci"));
        colLecNm.setCellValueFactory(new PropertyValueFactory<>("lecNm"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colvenue.setCellValueFactory(new PropertyValueFactory<>("venue"));


        System.out.println("hello");

       /* try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM lecture");

            ObservableList<LectureTM> row = FXCollections.observableArrayList();

            while (rst.next()) {

                System.out.println(rst.getString(1));
                System.out.println(rst.getString(2));
                System.out.println(rst.getDate(3));
                System.out.println(rst.getTime(4));
                System.out.println(rst.getString(5));

                String date = String.valueOf(rst.getDate(3));
                String time = String.valueOf(rst.getTime(4));

                row.add(new LectureTM(rst.getString(1), rst.getString(2), date, time, rst.getString(5)));

                System.out.println("jdbc" + Arrays.toString(new ObservableList[]{row}));
            }
            ObservableList<LectureTM> Ilist = FXCollections.observableArrayList(row);
            tblLec.setItems(Ilist);
            tblLec.refresh();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/





       try {
            List<LectureDTO> alllectures = lectureBO.findAllLectures();
            ObservableList<LectureTM> lectureTMS = tblLec.getItems();

            System.out.println(Arrays.toString(new List[]{alllectures}));

            for (LectureDTO lecture : alllectures) {

                String date= String.valueOf(lecture.getDate());
                String time=String.valueOf(lecture.getTime());
                lectureTMS.add(new LectureTM(lecture.getLecture_id(),lecture.getLecture_name(),date,time,lecture.getVenue()));
            }
            tblLec.setItems(lectureTMS);
            tblLec.refresh();

            System.out.println(Arrays.toString(new ObservableList[]{lectureTMS}));

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            Logger.getLogger("controller").log(Level.SEVERE, null,e);
        }

        tblLec.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            LectureTM SelectedItem = newValue;

            lecaid.setDisable(false);
            LecName.setDisable(false);
            date.setDisable(false);
            time.setDisable(false);
            venue.setDisable(false);

            btnSave.setText("UPDATE");
            btnSave.setDisable(false);
            btnDelete.setDisable(false);

            lecaid.setText(SelectedItem.getLeci());
            LecName.setText(SelectedItem.getLecNm());
            date.setValue(LocalDate.parse(SelectedItem.getDate()));
            time.setValue(LocalTime.parse(SelectedItem.getTime()));
            venue.setText(SelectedItem.getVenue());


        });


        pie.setData(getChartData());
        pie.setLegendSide(Side.LEFT);
        pie.setTitle("Computer Language Popularities");
        pie.setClockwise(false);

//.......................................................................................

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>
                observableArrayList(Arrays.asList("Speed", "User rating", "Milage", "Safety")));
        xAxis.setLabel("category");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("score");

        //Creating the Bar chart
         bar = new BarChart<>(xAxis, yAxis);
        bar.setTitle("Comparison between various cars");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Fiat");
        series1.getData().add(new XYChart.Data<>("Speed", 1.0));
        series1.getData().add(new XYChart.Data<>("User rating", 3.0));
        series1.getData().add(new XYChart.Data<>("Milage", 5.0));
        series1.getData().add(new XYChart.Data<>("Safety", 5.0));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Audi");
        series2.getData().add(new XYChart.Data<>("Speed", 5.0));
        series2.getData().add(new XYChart.Data<>("User rating", 6.0));
        series2.getData().add(new XYChart.Data<>("Milage", 10.0));
        series2.getData().add(new XYChart.Data<>("Safety", 4.0));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Ford");
        series3.getData().add(new XYChart.Data<>("Speed", 4.0));
        series3.getData().add(new XYChart.Data<>("User rating", 2.0));
        series3.getData().add(new XYChart.Data<>("Milage", 3.0));
        series3.getData().add(new XYChart.Data<>("Safety", 6.0));

        //Setting the data to bar chart
        bar.getData().addAll(series1, series2, series3);
        paneView.getChildren().add(bar);



    }



    public void GoToHome(MouseEvent mouseEvent) throws IOException {
        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent= FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.LectureForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }


    public void Save(ActionEvent event) {

        if(btnSave.getText().equalsIgnoreCase("Save")) {

            ArrayList<LectureDTO> lectureDTOS = new ArrayList<LectureDTO>();
            LectureDTO lectureDTO = new LectureDTO(lecaid.getText(), LecName.getText(), date.getValue(), time.getValue(), venue.getText());

            System.out.println(Arrays.toString(new ArrayList[]{lectureDTOS}));

            try {
                lectureBO.saveLecture(lectureDTO);
                lectureDTOS.add(lectureDTO);
                new Alert(Alert.AlertType.INFORMATION, "New Lecture Added Successfully").show();
                //btnAddNew_OnAction(event);
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
                Logger.getLogger("controller").log(Level.SEVERE, null, e);
            }
        }
        else {

            Update();

        }

    }

    public void Update() {
    }

    public void AddNew(ActionEvent event) {

        lecaid.setDisable(false);
        LecName.setDisable(false);
        date.setDisable(false);
        time.setDisable(false);
        venue.setDisable(false);
    }

    public void Delete(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this item?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            LectureTM selectedItem = tblLec.getSelectionModel().getSelectedItem();
            try {
                lectureBO.deleteLectures(selectedItem.getLeci());
                tblLec.getItems().remove(selectedItem);
            }catch (AlreadyExistsInOrderException e){
                new Alert(Alert.AlertType.INFORMATION,e.getMessage()).show();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact DEPPO").show();
                Logger.getLogger("controller").log(Level.SEVERE, null,e);
            }
        }

    }


    public void lecidAction(ActionEvent event) {
         

    }

    private ObservableList<PieChart.Data> getChartData() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));

        return pieChartData;
    }
}

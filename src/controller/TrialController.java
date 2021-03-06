package controller;

import DAO.CrudUtil;
import business.BOFactory;
import business.BOTypes;
import business.custom.TrialBO;
import business.exception.SomeThingsWrongException;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import db.DBConnection;
import dto.ExamDTO;
import dto.TrialDTO;
import entity.Trial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import util.ExamTM;
import util.TrialTM;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrialController  {
    public ScrollPane TrialForm;
    public JFXTextField trialid;
    public JFXDatePicker date;
    public JFXTimePicker time;
    public JFXTextField venue;
    public TableView<TrialTM> tblTrial;
    public TableColumn coltrialid;
    public TableColumn coldate;
    public TableColumn coltime;
    public TableColumn colvenue;
    public TableColumn colparticipant;
    public TableColumn coltotpass;
    public TableColumn coltotfail;
    public TableColumn colab;
    public PieChart pie;
    public Button btnSave;
    public Button btnDelete;
    public Pane paneView;
    public BarChart<String,Number> bar;
    public Button btnAddNew;
    public TableColumn colDel;
    private TrialBO TrialBO=BOFactory.getInstance().getBO(BOTypes.TRIAL);


    public void initialize() {
        tblTrial.getItems().clear();

        TrialForm.setMaxHeight(1500);
        TrialForm.setMaxWidth(2500);


            coltrialid.setCellValueFactory(new PropertyValueFactory<>("Trail_ID"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            coltime.setCellValueFactory(new PropertyValueFactory<>("Time"));
            colvenue.setCellValueFactory(new PropertyValueFactory<>("Venue"));
            colparticipant.setCellValueFactory(new PropertyValueFactory<>("totpass"));
            coltotpass.setCellValueFactory(new PropertyValueFactory<>("totpass"));
            coltotfail.setCellValueFactory(new PropertyValueFactory<>("totfail"));
            colab.setCellValueFactory(new PropertyValueFactory<>("totab"));
            colDel.setCellValueFactory(new PropertyValueFactory<>("button"));




       try {

            System.out.println("trial");

            List<TrialDTO> alltrials = TrialBO.findAllTrials();
            ObservableList<TrialTM> trials = tblTrial.getItems();


            System.out.println(trials);

            for (TrialDTO trial : alltrials) {

               String date=trial.getDate();
               String time=trial.getTime();

                String p = getStatusCount(trial.getTrial_id(), "passed");
                String f = getStatusCount(trial.getTrial_id(), "failed");
                String a = getStatusCount(trial.getTrial_id(), "absent");

                int pass = Integer.parseInt(p);
                int fail = Integer.parseInt(f);
                int ab = Integer.parseInt(a);
                String tot = String.valueOf(pass + fail + ab);

                Button button=new Button("Delete");
                button.setStyle("-fx-background-color: red");

                trials.add(new TrialTM(trial.getTrial_id(), date, time, trial.getVenue(), tot, p, f, a,button));

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        TrialTM trialTM=new TrialTM(trial.getTrial_id(),date, time, trial.getVenue(),tot, p, f, a,button);
                        btnDeleteOnAction(trialTM);
                        tblTrial.getSelectionModel().clearSelection();
                        trials.remove(trialTM);
                        trials.clear();
                        tblTrial.refresh();
                        initialize();

                    }
                });


            }


            System.out.println(Arrays.toString(new ObservableList[]{trials}));



        } catch (Exception e) {


            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            Logger.getLogger("controller").log(Level.SEVERE, null,e);
        }

        tblTrial.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            TrialTM SelectedItem = (TrialTM) newValue;

            trialid.setDisable(false);
            date.setDisable(false);
            time.setDisable(false);
            venue.setDisable(false);

            btnSave.setText("UPDATE");
            btnSave.setDisable(false);
            //btnDelete.setDisable(false);

            trialid.setText(SelectedItem.getTrail_ID());
            System.out.println("XXXXX"+SelectedItem.getTrail_ID());
            date.setValue(LocalDate.parse(SelectedItem.getDate()));
            time.setValue(LocalTime.parse(SelectedItem.getTime()));
            venue.setText(SelectedItem.getVenue());


            int pass= Integer.parseInt(SelectedItem.getTotpass());
            int fail= Integer.parseInt(SelectedItem.getTotfail());
            int ab= Integer.parseInt(SelectedItem.getTotab());
            int tot= Integer.parseInt(SelectedItem.getTot());

            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Total Pass",pass ),
                            new PieChart.Data("Total Fail", fail),
                            new PieChart.Data("Total Absent", ab));

            pie.setData(pieChartData);
            pie.setLegendSide(Side.LEFT);
            pie.setTitle("The Pie Chart");
            pie.setClockwise(false);

//........................................................................................................................

            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setCategories(FXCollections.<String>
                    observableArrayList(Arrays.asList("Tot", "Pass", "Fail", "Absent")));
            xAxis.setLabel("category");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("score");

            //Creating the Bar chart
            bar = new BarChart<>(xAxis, yAxis);
            bar.setTitle("The Bar Chart");

            //Prepare XYChart.Series objects by setting data
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            series1.setName("Fiat");
            series1.getData().add(new XYChart.Data<>("Tot", tot));
            series1.getData().add(new XYChart.Data<>("Pass", pass));
            series1.getData().add(new XYChart.Data<>("Fail", fail));
            series1.getData().add(new XYChart.Data<>("Absent", ab));



            //Setting the data to bar chart
            bar.getData().addAll(series1);
            paneView.getChildren().add(bar);



        });







    }
    public void GoToHome(MouseEvent mouseEvent) throws IOException {
        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent= FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.TrialForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }

    private String getStatusCount(String x,String y) throws Exception {

        System.out.println(x);

        //String sqla = "SELECT count(*) FROM student_status where Exam_ID = ? AND Exam_Status = 'passed' ORDER BY Exam_ID ASC", x;
        ResultSet rst = CrudUtil.execute( "SELECT count(*) FROM student_status where Trial_ID = ? AND Trial_Status = ? ORDER BY Exam_ID ASC", x,y);


        rst.absolute(1);
        String c = rst.getString(1);
        System.out.println("pcount" + c);

        return c;

    }


    public void Save(ActionEvent event) {

        ArrayList<TrialDTO> trialDTOS=new ArrayList<TrialDTO>();
        TrialDTO trialDTO=new TrialDTO(trialid.getText(),date.getValue().toString(),time.getValue().toString(),venue.getText());

        String d= String.valueOf(date.getValue());
        String t= String.valueOf(time.getValue());

        System.out.println(Arrays.toString(new ArrayList[]{trialDTOS}));

        try {
            TrialBO.saveTrial(trialDTO);
            trialDTOS.add(trialDTO);
            new Alert(Alert.AlertType.INFORMATION,"Trial Added Successfully").show();

            tblTrial.refresh();
            initialize();
            //btnAddNew_OnAction(event);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            Logger.getLogger("controller").log(Level.SEVERE, null,e);
        }

    }

    public void btnDeleteOnAction(TrialTM trialTM) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this item?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            TrialTM selectedItem = tblTrial.getSelectionModel().getSelectedItem();
            try {
                PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM Trial WHERE Trial_ID=?");
                pstm.setObject(1, trialTM.getTrail_ID());
                if (pstm.executeUpdate() == 0) {
                    new Alert(Alert.AlertType.ERROR, "Failed to delete the item", ButtonType.OK).show();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK).show();
                    tblTrial.getItems().remove(trialTM);
                    tblTrial.getSelectionModel().clearSelection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void AddNew(ActionEvent event) throws Exception {

        trialid.clear();
        date.getEditor().clear();
        time.getEditor().clear();
        venue.clear();

        btnSave.setText("Save");
        btnDelete.setDisable(true);

        try {
            String lid = null;
            int id= Integer.parseInt(TrialBO.getLastTrialid())+1;
            if(id<10){
                lid="00"+id;
                trialid.setText(lid);
            }
            else if(id>=10 && id<100){
                lid="0"+id;
                trialid.setText(lid);
            }
            else {
                lid=id+"";
                trialid.setText(lid);
            }

            //throw new SomeThingsWrongException("Some Things Went Wrong, Please Contact Sula!");
        } catch (SomeThingsWrongException e) {
            e.printStackTrace();
        }

    }
}

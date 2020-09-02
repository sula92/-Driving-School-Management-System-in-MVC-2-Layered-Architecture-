package controller;

import business.BOFactory;
import business.BOTypes;
import business.custom.ExamBO;
import business.exception.AlreadyExistsInExamException;
import business.exception.SomeThingsWrongException;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import dto.ExamDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.ExamTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamController  {
    public ScrollPane ExamForm;
    public JFXTextField examid;
    public JFXDatePicker date;
    public JFXTimePicker time;
    public JFXTextField venue;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnNew;
    public TableView<ExamTM> tblExam;
    public TableColumn colexid;
    public TableColumn coldate;
    public TableColumn coltime;
    public TableColumn colvenue;
    public TableColumn colparticipant;
    public TableColumn coltotpass;
    public TableColumn coltotfail;
    public TableColumn colview;
    public TableColumn coldel;
    public BarChart<String,Number> bar;
    public PieChart pie;
    public Pane paneView;
    public Button btnDelete;
    private ExamBO examBO = BOFactory.getInstance().getBO(BOTypes.EXAM);





    public void initialize() {

        tblExam.getItems().clear();
        colview.setText("Total Absent");


        colexid.setCellValueFactory(new PropertyValueFactory<>("Exam_ID"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        colvenue.setCellValueFactory(new PropertyValueFactory<>("Venue"));
        colparticipant.setCellValueFactory(new PropertyValueFactory<>("totpass"));
        coltotpass.setCellValueFactory(new PropertyValueFactory<>("totpass"));
        coltotfail.setCellValueFactory(new PropertyValueFactory<>("totfail"));
        colview.setCellValueFactory(new PropertyValueFactory<>("totab"));
        coldel.setCellValueFactory(new PropertyValueFactory<>("button"));


     try {
            List<ExamDTO> allexams = examBO.findAllExams();
            ObservableList<ExamTM> exams = tblExam.getItems();

            for (ExamDTO exam : allexams) {

                String date= String.valueOf(exam.getDate());
                String time=String.valueOf(exam.getTime());
                String exid=exam.getExam_ID();
                String ven=exam.getVenue();

                String p=examBO.getStatusCount(exid,"passed");
                String f=examBO.getStatusCount(exid,"failed");
                String a=examBO.getStatusCount(exid,"absent");

                int pass= Integer.parseInt(p);
                int fail= Integer.parseInt(f);
                int ab= Integer.parseInt(a);
                String tot= String.valueOf(pass+fail+ab);

                Button button=new Button("Delete");
                button.setStyle("-fx-background-color: red;-fx-font-style: white");

                exams.add(new ExamTM(exam.getExam_ID(), date,
                        time, exam.getVenue(),tot,p,f,a,button));
            }


            System.out.println(Arrays.toString(new ObservableList[]{exams}));

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            Logger.getLogger("controller").log(Level.SEVERE, null,e);
            }

        tblExam.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            ExamTM SelectedItem = (ExamTM) newValue;




            examid.setDisable(false);
            date.setDisable(false);
            time.setDisable(false);
            venue.setDisable(false);

            btnSave.setText("UPDATE");
            btnSave.setDisable(false);
            btnDelete.setDisable(false);
            //btnDelete.setDisable(false);

            examid.setText(SelectedItem.getExam_ID());
            date.setValue(LocalDate.parse(SelectedItem.getDate()));
            time.setValue(LocalTime.parse(SelectedItem.getTime()));
            venue.setText(SelectedItem.getVenue());

            try {

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



            } catch (Exception e) {
                e.printStackTrace();
            }






        });




//.......................................................................................




    }

   /* private String getStatusCount(String x,String y) throws Exception {

        System.out.println(x);

        //String sqla = "SELECT count(*) FROM student_status where Exam_ID = ? AND Exam_Status = 'passed' ORDER BY Exam_ID ASC", x;
        ResultSet rst = CrudUtil.execute( "SELECT count(*) FROM student_status where Exam_ID = ? AND Exam_Status = ? ORDER BY Exam_ID ASC", x,y);


            rst.absolute(1);
            String c = rst.getString(1);
            System.out.println("pcount" + c);

         return c;

    }*/


    public void GoToHome(MouseEvent mouseEvent) throws IOException {
        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent= FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.ExamForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }


    public void Save(ActionEvent event) {

         ArrayList<ExamDTO> examDTOS = new ArrayList<ExamDTO>();
         ExamDTO examDTO = new ExamDTO(examid.getText(), date.getValue().toString(), time.getValue().toString(), venue.getText());

         System.out.println(Arrays.toString(new ArrayList[]{examDTOS}));

        if(btnSave.getText().equalsIgnoreCase("save")) {

         try {
             examBO.saveExam(examDTO);
             examDTOS.add(examDTO);
             new Alert(Alert.AlertType.INFORMATION, "Exam Added Successfully").show();
             initialize();
             tblExam.refresh();
             //btnAddNew_OnAction(event);
         } catch (Exception e) {
             new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
             Logger.getLogger("controller").log(Level.SEVERE, null, e);
         }
     }
     else {
            try {
                examBO.updateExam(examDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void Update(ActionEvent event) throws Exception {
        examBO.updateExam(new ExamDTO(examid.getText(),date.getValue().toString(),time.getValue().toString(),venue.getText()));
    }

    public void AddNew(ActionEvent event) throws Exception {

        btnSave.setText("Save");

        examid.clear();
        date.getEditor().clear();
        time.getEditor().clear();
        venue.clear();

        btnSave.setText("Save");
        btnDelete.setDisable(true);
        tblExam.getSelectionModel().clearSelection();

        try {
            String lid = null;
            int id= Integer.parseInt(examBO.getLastExamID())+1;
            if(id<10){
                lid="00"+id;
                examid.setText(lid);
            }
            else if(id>=10 && id<100){
                lid="0"+id;
                examid.setText(lid);
            }
            else {
                lid=id+"";
                examid.setText(lid);
            }

            //throw new SomeThingsWrongException("Some Things Went Wrong, Please Contact Sula!");
        } catch (SomeThingsWrongException e) {
            e.printStackTrace();
        }

    }


    public void Delete(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this item?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            ExamTM selectedItem = tblExam.getSelectionModel().getSelectedItem();
            try {
                examBO.deleteExam(selectedItem.getExam_ID());
                tblExam.getItems().remove(selectedItem);
            }catch (AlreadyExistsInExamException e){
                new Alert(Alert.AlertType.INFORMATION,e.getMessage()).show();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact DEPPO").show();
                Logger.getLogger("controller").log(Level.SEVERE, null,e);
            }
        }


    }




}

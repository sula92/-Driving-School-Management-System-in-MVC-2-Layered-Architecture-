package controller;

import DAO.CrudUtil;
import business.BOFactory;
import business.BOTypes;
import business.custom.ExamBO;
import business.custom.TrialBO;
import business.exception.AlreadyExistsInOrderException;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import dto.ExamDTO;
import entity.Exam;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.ExamTM;
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

        colview.setText("Total Absent");


        colexid.setCellValueFactory(new PropertyValueFactory<>("Exam_ID"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        colvenue.setCellValueFactory(new PropertyValueFactory<>("Venue"));
        colparticipant.setCellValueFactory(new PropertyValueFactory<>("totpass"));
        coltotpass.setCellValueFactory(new PropertyValueFactory<>("totpass"));
        coltotfail.setCellValueFactory(new PropertyValueFactory<>("totfail"));
        colview.setCellValueFactory(new PropertyValueFactory<>("totab"));


        /*try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM exam");

            ObservableList<ExamTM> row = FXCollections.observableArrayList();


            while (rst.next()) {

                String p=getStatusCount(rst.getString(1),"passed");
                String f=getStatusCount(rst.getString(1),"failed");
                String a=getStatusCount(rst.getString(1),"absent");

                int pass= Integer.parseInt(p);
                int fail= Integer.parseInt(f);
                int ab= Integer.parseInt(a);
                String tot= String.valueOf(pass+fail+ab);


                String date = String.valueOf(rst.getDate(2));
                String time = String.valueOf(rst.getTime(3));



                row.add(new ExamTM(rst.getString(1), date, time, rst.getString(4),p,f,a,tot));

                System.out.println("jdbc" + Arrays.toString(new ObservableList[]{row}));

            }
            ObservableList<ExamTM> Ilist = FXCollections.observableArrayList(row);
            tblExam.setItems(Ilist);
            tblExam.refresh();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/





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



                exams.add(new ExamTM(exam.getExam_ID(), date,
                        time, exam.getVenue(),tot,p,f,a));
            }
            tblExam.setItems(exams);

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

        ArrayList<ExamDTO> examDTOS=new ArrayList<ExamDTO>();
        ExamDTO examDTO=new ExamDTO(examid.getText(),date.getValue().toString(),time.getValue().toString(),venue.getText());

        System.out.println(Arrays.toString(new ArrayList[]{examDTOS}));

        try {
            examBO.saveExam(examDTO);
            examDTOS.add(examDTO);
            new Alert(Alert.AlertType.INFORMATION,"Exam Added Successfully").show();
            initialize();
            tblExam.refresh();
            //btnAddNew_OnAction(event);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            Logger.getLogger("controller").log(Level.SEVERE, null,e);
        }


    }

    public void Update(ActionEvent event) {
    }

    public void AddNew(ActionEvent event) {

        examid.clear();
        date.getEditor().clear();
        time.getEditor().clear();
        venue.clear();

        btnSave.setText("Save");
        btnDelete.setDisable(true);

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
            }catch (AlreadyExistsInOrderException e){
                new Alert(Alert.AlertType.INFORMATION,e.getMessage()).show();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact DEPPO").show();
                Logger.getLogger("controller").log(Level.SEVERE, null,e);
            }
        }


    }




}

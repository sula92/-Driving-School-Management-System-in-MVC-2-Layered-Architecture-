package controller;

import business.BOFactory;
import business.BOTypes;
import business.custom.*;
import com.jfoenix.controls.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class StudFormController implements Initializable {
    public JFXButton btnSave;
    public ScrollPane StdForm;
    public FontAwesomeIconView home;
    public TableColumn colstdId;
    public TableColumn colnm;
    public TableColumn colnic;
    public TableColumn colCid;
    public TableColumn colbtranch;
    public TableColumn colDoj;
    public TableColumn colContact;
    public TableColumn coldel;
    public TableView<StudentTM> tblStd;

    public StudentBO studentBO= BOFactory.getInstance().getBO(BOTypes.STUDENT);
    public JFXTextField txtStdId;
    public JFXTextField txtnic;
    public JFXComboBox<String> comboGender;
    public JFXDatePicker dateDOB;
    public JFXTextField txtName;
    public JFXTextField txtAge;
    public JFXTextArea txtAdd;
    public JFXTextField txtmob;
    public JFXTextField txtPhine;
    public JFXTextField txtEmail;
    public JFXComboBox comboBranch;
    public JFXDatePicker dateDOJ;
    public JFXComboBox comboCid;
    public JFXComboBox<String> comboExId;
    public JFXComboBox comboTid;
    public JFXComboBox comboTrainingId;
    public JFXComboBox comboLecId;
    public ExamBO examBO=BOFactory.getInstance().getBO(BOTypes.EXAM);
    public TrialBO trialBO=BOFactory.getInstance().getBO(BOTypes.TRIAL);
    public LectureBO lectureBO=BOFactory.getInstance().getBO(BOTypes.LECTURE);
    public BranchBO branchBO=BOFactory.getInstance().getBO(BOTypes.BRANCH);
    public TrainingBO trainingBO=BOFactory.getInstance().getBO(BOTypes.TRAINING);
    public ImageView iv1;
    public JFXButton addNew;


    public void SaveAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getAllExams();
        getAllTrials();
        getAllTrainings();
        loadGenders();

        colstdId.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        colnm.setCellValueFactory(new PropertyValueFactory<>("name"));
        colnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colCid.setCellValueFactory(new PropertyValueFactory<>("branch"));
        colbtranch.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colDoj.setCellValueFactory(new PropertyValueFactory<>("doj"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        coldel.setCellValueFactory(new PropertyValueFactory<>("del"));

        ObservableList<StudentTM> studentTMS=tblStd.getItems();
        try {
            studentBO.findAllStudents().stream().forEach(stds -> {
                Button button=new Button("Delete");
                button.setStyle("-fx-background-color: red");
                studentTMS.add(new StudentTM(stds.getStdId(),stds.getName(),stds.getNic(),stds.getBranchId(),stds.getCourseId(),stds.getDateOfJoined(),stds.getPerson_contact().getPhone(),button));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblStd.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSave.setText("UPDATE");
            txtStdId.setText(newValue.getStdId());
            txtmob.setText(newValue.getContact());
            txtName.setText(newValue.getName());
            txtnic.setText(newValue.getNic());
            txtPhine.setText(newValue.getContact());
            comboBranch.setValue(newValue.getBranch());
            comboCid.setValue(newValue.getCourseId());
            try {
                StudentDTO studentDTO=studentBO.findStudent(newValue.getNic());
                dateDOB.setValue(LocalDate.parse(studentDTO.getDOB()));
                txtAge.setText(studentDTO.getAge());
                comboGender.setValue(studentDTO.getGender());
                txtAdd.setText(studentDTO.getPerson_contact().getAddress());
                txtEmail.setText(studentDTO.getPerson_contact().getEmail());
                comboBranch.setValue(studentDTO.getBranchId());
                comboCid.setValue(studentDTO.getCourseId());
                LocalDate date=LocalDate.parse(studentDTO.getDateOfJoined().toString());
                dateDOJ.setValue(date);
                comboExId.setValue(studentDTO.getExamId());
                comboTid.setValue(studentDTO.getTrialId());
                comboTrainingId.setValue(studentDTO.getTrainingId());
                comboLecId.setValue(studentDTO.getLecId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            String x="studentimages/";
            String y=newValue.getNic();
            String z=".jpg";
            String xyz=x.concat(y).concat(z);

            Image img=new Image(xyz);
            iv1.setImage(img);
            iv1.setFitHeight(200.0);
            iv1.setFitWidth(300.0);

        });

    }

    private void loadGenders() {
        comboGender.getItems().add("Male");
        comboGender.getItems().add("Female");

    }

    private void getAllTrainings() {
        try {
            trainingBO.findAllTrainings().stream().forEach(trainingDTO -> {
                comboTrainingId.getItems().add(trainingDTO.getTraining_ID());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllTrials() {
        try {
            trialBO.findAllTrials().stream().forEach(examDTO -> {
                comboTid.getItems().add(examDTO.getTrial_id());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GoToHome(MouseEvent mouseEvent) throws IOException {
        URL url=this.getClass().getResource("/view/MainForm.fxml");
        Parent parent= FXMLLoader.load(url);
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.StdForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Student");
        stage.setFullScreen(false);

    }

    public void getAllExams()  {
        try {
            examBO.findAllExams().stream().forEach(examDTO -> {
                comboExId.getItems().add(examDTO.getExam_ID());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save");
        try {
            int lid= Integer.parseInt(studentBO.getLastStudentID());
            if(lid<10){
                txtStdId.setText("00"+(lid+1)+"");
            }
            else if(lid>10 && lid<100){
                txtStdId.setText("0"+(lid+1)+"");
            }
            else {
                txtStdId.setText((lid+1)+"");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

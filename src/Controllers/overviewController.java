package Controllers;

        import Data.CandidateData;
        import Data.CategoryData;
        import Data.JudgeData;
        import ServerConnection.ServerConnection;
        import Tabulation.Main;
        import com.jfoenix.controls.JFXButton;
        import dbConnection.DbConnection;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;

        import java.net.URL;
        import java.sql.*;
        import java.util.ResourceBundle;

public class overviewController implements Initializable{

    @FXML private TableView<CategoryData> table_category;
    @FXML private TableColumn<CategoryData, String> column_catID;
    @FXML private TableColumn<CategoryData, String> column_catName;
    @FXML private TableColumn<CategoryData, String> column_catsStat;
    @FXML private TableView<CandidateData> table_candidate;
    @FXML private TableColumn<CandidateData, String> column_candNum;
    @FXML private TableColumn<CandidateData, String> column_candGend;
    @FXML private TableColumn<CandidateData, String> column_candName;
    @FXML private TableColumn<CandidateData, String> column_candStat;
    @FXML private TableColumn<CandidateData, String> column_candLock;
    @FXML private TableView<JudgeData> table_judge;
    @FXML private TableColumn<JudgeData, String> column_judgeNum;
    @FXML private TableColumn<JudgeData, String> column_judgeConn;
    @FXML private TableColumn<JudgeData, String> column_judgeStatus;
    @FXML private JFXButton btn_starCategory;
    @FXML private JFXButton btn_completeCategory;
    @FXML private JFXButton btn_currentCandidate;
    @FXML private JFXButton btn_startVoting;
    @FXML private JFXButton btn_standby;
    @FXML private JFXButton btn_resume;

    private ObservableList<CategoryData> categorydata,selectedCategory;
    private ObservableList<CandidateData> candidateData,selectedCandidate;
    private ObservableList<JudgeData> judgeData,selectedJudge;
    private static ObservableList<JudgeData> judgeData2;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCatTable();
        loadCandTable();
        loadJudgeTable();


        table_category.setOnMouseClicked(event -> {
            if(!table_category.getSelectionModel().getSelectedItems().isEmpty()){
                selectedCategory = table_category.getSelectionModel().getSelectedItems();
                btn_starCategory.setDisable(false);
            }

        });

        btn_starCategory.setOnAction(event -> {
            table_category.toBack();
       //     btn_starCategory.setDisable(true);
            btn_standby.setDisable(true);
            Main.getConnection().sendMessage("this is a test");

        });
    }

    private void loadCatTable(){
        try{
            String sql = "SELECT * FROM TBLCategoryList ORDER BY catID ASC";
            Connection connection = DbConnection.getConnection();
            this.categorydata = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                this.categorydata.add(new CategoryData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.column_catID.setCellValueFactory((new PropertyValueFactory<CategoryData,String >("catID")));
        this.column_catName.setCellValueFactory((new PropertyValueFactory<CategoryData,String >("catName")));
        this.column_catsStat.setCellValueFactory((new PropertyValueFactory<CategoryData,String >("catStatus")));
        this.table_category.setItems(null);
        this.table_category.setItems(this.categorydata);
    }

    private void loadCandTable(){
        try{
            String sql = "SELECT * FROM TBLCandidateInfo ORDER BY CandNO,CandGender ASC";
            Connection connection = DbConnection.getConnection();
            this.candidateData = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                this.candidateData.add(new CandidateData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.column_candNum.setCellValueFactory((new PropertyValueFactory<CandidateData,String >("num")));
        this.column_candGend.setCellValueFactory((new PropertyValueFactory<CandidateData,String >("gend")));
        this.column_candName.setCellValueFactory((new PropertyValueFactory<CandidateData,String >("name")));
        this.column_candStat.setCellValueFactory((new PropertyValueFactory<CandidateData,String >("stats")));
        this.column_candLock.setCellValueFactory((new PropertyValueFactory<CandidateData,String >("lock")));
        this.table_candidate.setItems(null);
        this.table_candidate.setItems(this.candidateData);
    }

    private void loadJudgeTable(){
        try{
            String sql = "SELECT * FROM TBLJudgeInfo ORDER BY JudgeNO ASC";
            Connection connection = DbConnection.getConnection();
            this.judgeData = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                this.judgeData.add(new JudgeData(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.column_judgeNum.setCellValueFactory((new PropertyValueFactory<JudgeData,String >("judgeNum")));
        this.column_judgeConn.setCellValueFactory((new PropertyValueFactory<JudgeData,String >("judgeConn")));
        this.column_judgeStatus.setCellValueFactory((new PropertyValueFactory<JudgeData,String >("judgeStatus")));
        this.table_judge.setItems(null);
        this.table_judge.setItems(this.judgeData);
    }

   /* public static void updateConnection(String msg){
       String SQL = "UPDATE TBLJudgeInfo SET JudgeConnection = 'connected' WHERE JudgeNO = ?";
       try {
           Connection connection = DbConnection.getConnection();
           judgeData2 = FXCollections.observableArrayList();
           PreparedStatement statement   = connection.prepareStatement(SQL);
           statement.setString(1,msg);
           statement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }

    }*/
}


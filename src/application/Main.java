package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;


public class Main extends Application {	// 1. Application 상속받아서
	@Override							// 3. Override 실행
	public void start(Stage primaryStage) {	//Stage 객ㅊㅔ : 윈도우 창
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));	//FXMLLoader : Main.fxml 화면을 객체화
			SplitPane root = (SplitPane)loader.load();		//loader.load 요소 제어 가능
			Scene scene = new Scene(root,770,400);		//FXMLLoader 에서 읽어 온 root 정보를 scene 에 넣는다.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	//화면꾸미기는 css 스타일 문법으로 하겠다.
			primaryStage.setScene(scene); 	//(scene)을 매개변수로 넣어 
			
			primaryStage.setTitle("BoardApp");	//윈도우창의 타이틀은 BoardApp
			primaryStage.show();	// 화면에 보여줘라!
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {// 2. launch 실행하면
		launch(args);
	}
}

/*
 * Main.fxml
 * fx: controller
 *  수정 가능한 부분
 *  controller 지정
 * 
*/

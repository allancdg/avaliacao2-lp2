module ProjectJavaFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens br.ufrn.imd.lp2.javafx to javafx.graphics, javafx.fxml;
	opens br.ufrn.imd.lp2.javafx.controller to javafx.fxml;
}

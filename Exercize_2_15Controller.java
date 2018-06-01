import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;


public class Exercize_2_15Controller {

	@FXML
	private Button start_Button;

	@FXML
	private TextField number1_Text_Field;

	@FXML
	private TextField number2_Text_FIeld;

	@FXML
	private TextField text_Field_Sum;

	@FXML
	private TextField text_Field_Product;

	@FXML
	private TextField text_Field_Difference;

	@FXML
	private TextField text_Field_Quotient;

	@FXML
	private Label incorrect_Input_Label;

	@FXML
	private ImageView load_Image;

	@FXML
	void start_Button_Pressed(ActionEvent event) {
		if (!check_Input((number1_Text_Field.getText()), (number2_Text_FIeld.getText()))) {
			incorrect_Input_Label.setVisible(true);
		}
		else {
			incorrect_Input_Label.setVisible(false);
			Integer sum = Integer.valueOf(number1_Text_Field.getText()) + Integer.valueOf(number2_Text_FIeld.getText());
			text_Field_Sum.setText(sum.toString());
			Integer difference = Integer.valueOf(number1_Text_Field.getText()) - Integer.valueOf(number2_Text_FIeld.getText());
			text_Field_Difference.setText(difference.toString());
			Integer product = Integer.valueOf(number1_Text_Field.getText()) * Integer.valueOf(number2_Text_FIeld.getText());
			text_Field_Product.setText(product.toString());
			try {
				Integer quotient = Integer.valueOf(number1_Text_Field.getText()) / Integer.valueOf(number2_Text_FIeld.getText());
				text_Field_Quotient.setText(quotient.toString());
			}catch (ArithmeticException ex) {
				text_Field_Quotient.setText("NaN");
			}
			new Thread() {
				public void run() {
					//----------------------------------
					load_Image.setVisible(true);
					//----------------------------------
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					//----------------------------------
					load_Image.setVisible(false);

				}

			}.start();
		}
	}

	boolean check_Input(String text_Field1, String text_Field2)
	{
		if((text_Field1.length() > 2) || (0 == text_Field1.length())) return false;
		if((text_Field2.length() > 2) || (0 == text_Field2.length())) return false;
		if((!(Character.isDigit(text_Field1.charAt(0)))) && !(Character.isDigit(text_Field1.charAt(1)))) return false;
		if((!(Character.isDigit(text_Field2.charAt(0)))) && !(Character.isDigit(text_Field2.charAt(1)))) return false;
		return true;
	}

}

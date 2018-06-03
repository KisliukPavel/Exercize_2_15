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
		//----------------------------------clean & disable fields
		text_Field_Sum.setDisable(true);
		text_Field_Sum.setText("");
		text_Field_Difference.setDisable(true);
		text_Field_Difference.setText("");
		text_Field_Product.setDisable(true);
		text_Field_Product.setText("");
		text_Field_Quotient.setDisable(true);
		text_Field_Quotient.setText("");
		//----------------------------------
		//----------------------------------check input (only integers)
		if (!check_Input((number1_Text_Field.getText()), (number2_Text_FIeld.getText()))) {
			incorrect_Input_Label.setVisible(true);
		}
		//----------------------------------
		else {
			incorrect_Input_Label.setVisible(false);
			new Thread() {
				public void run() {
					//----------------------------------
					load_Image.setVisible(true);
					number1_Text_Field.setDisable(true);
					number2_Text_FIeld.setDisable(true);
					start_Button.setDisable(true);
					//----------------------------------loading imitation
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					//----------------------------------
					load_Image.setVisible(false);
					number1_Text_Field.setDisable(false);
					number2_Text_FIeld.setDisable(false);
					start_Button.setDisable(false);
					//----------------------------------
					//------------------------------------------------compute & output yilds
					Integer sum = Integer.valueOf(number1_Text_Field.getText()) + Integer.valueOf(number2_Text_FIeld.getText());
					text_Field_Sum.setText(sum.toString());
					//------------------------------------------------
					Integer difference = Integer.valueOf(number1_Text_Field.getText()) - Integer.valueOf(number2_Text_FIeld.getText());
					text_Field_Difference.setText(difference.toString());
					//------------------------------------------------
					Integer product = Integer.valueOf(number1_Text_Field.getText()) * Integer.valueOf(number2_Text_FIeld.getText());
					text_Field_Product.setText(product.toString());
					//------------------------------------------------check division by 0
					if(0 == Double.valueOf(number2_Text_FIeld.getText())){
						text_Field_Quotient.setText("I");
					}
					else{
						Double quotient = Double.valueOf(number1_Text_Field.getText()) / Double.valueOf(number2_Text_FIeld.getText());
						String S = new String();
						S = quotient.toString();
						String S2 = new String();
						S2 = S.substring(0, S.length());
						text_Field_Quotient.setText(S2);
					}
					//------------------------------------------------
					text_Field_Sum.setDisable(false);
					text_Field_Difference.setDisable(false);
					text_Field_Product.setDisable(false);
					text_Field_Quotient.setDisable(false);
				}

			}.start();
		}
	}


	boolean check_Input(String text_Field1, String text_Field2)
	{
		if((text_Field1.length() > 2) || (0 == text_Field1.length())) return false;
		if((text_Field2.length() > 2) || (0 == text_Field2.length())) return false;
		for(int i = 0; i < text_Field1.length(); i++) {
			if(!(Character.isDigit(text_Field1.charAt(i)))) {
				return false;
			}
		}
		for(int i = 0; i < text_Field2.length(); i++) {
			if(!(Character.isDigit(text_Field2.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

}

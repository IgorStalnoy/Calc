import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    private String value1;
    private String value2;
    private String expectedOperation;
    Calculator calculator = new Calculator();
    @FXML
    TextArea inputField;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button7;
    @FXML
    Button button8;
    @FXML
    Button button9;
    @FXML
    Button button0;
    @FXML
    Button buttonDot;
    @FXML
    Button buttonSum;
    @FXML
    Button buttonSubtraction;
    @FXML
    Button buttonDivision;
    @FXML
    Button buttonMultiplication;
    @FXML
    Button resetButton;
    @FXML
    Button resultButton;
    @FXML
    Button backspaceButton;

    public void addDigit1(ActionEvent actionEvent) {inputField.setText(inputField.getText().concat("1"));}

    public void addDigit2(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("2"));
    }

    public void addDigit3(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("3"));
    }

    public void addDigit4(ActionEvent actionEvent) {inputField.setText(inputField.getText().concat("4"));}

    public void addDigit5(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("5"));
    }

    public void addDigit6(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("6"));
    }

    public void addDigit7(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("7"));
    }

    public void addDigit8(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("8"));
    }

    public void addDigit9(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("9"));
    }

    public void addDigit0(ActionEvent actionEvent) {
        inputField.setText(inputField.getText().concat("0"));
    }

    public void addDot(ActionEvent actionEvent) {
        if (isInputFieldEmpty() && inputField.getText().charAt(inputField.getText().length() - 1) != 46) {
            inputField.setText(inputField.getText().concat("."));
        }
    }

    public void sum(ActionEvent actionEvent) {
        if (value1 == null && isInputFieldEmpty()) {
            value1 = inputField.getText();
            expectedOperation = "+";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        } else if (value1 != null && isSecondValueInputted()) {
            expectedOperation = "+";
            value2 = inputField.getText().substring(inputField.getText().lastIndexOf("\n"));
            double result = calculator.sum(Double.parseDouble(value1), Double.parseDouble(value2));
            inputField.setText(String.valueOf(result));
            value1 = null;
            value2 = null;
        } else if (value1 != null && !isSecondValueInputted()) {
            expectedOperation = "+";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        }
    }

    public void subtraction(ActionEvent actionEvent) {
        if (value1 == null && isInputFieldEmpty()) {
            value1 = inputField.getText();
            expectedOperation = "-";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        } else if (value1 != null && isSecondValueInputted()) {
            expectedOperation = "-";
            value2 = inputField.getText().substring(inputField.getText().lastIndexOf("\n"));
            double result = calculator.subtraction(Double.parseDouble(value1), Double.parseDouble(value2));
            inputField.setText(String.valueOf(result));
            value1 = null;
            value2 = null;
        } else if (value1 != null && !isSecondValueInputted()) {
            expectedOperation = "-";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        }
    }

    public void division(ActionEvent actionEvent) {
        if (value1 == null && isInputFieldEmpty()) {
            value1 = inputField.getText();
            expectedOperation = "/";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        } else if (value1 != null && isSecondValueInputted()) {
            expectedOperation = "/";
            value2 = inputField.getText().substring(inputField.getText().lastIndexOf("\n"));
            double result = calculator.division(Double.parseDouble(value1), Double.parseDouble(value2));
            inputField.setText(String.valueOf(result));
            value1 = null;
            value2 = null;
        } else if (value1 != null && !isSecondValueInputted()) {
            expectedOperation = "/";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        }
    }

    public void multiplication(ActionEvent actionEvent) {
        if (value1 == null && isInputFieldEmpty()) {
            value1 = inputField.getText();
            expectedOperation = "*";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        } else if (value1 != null && isSecondValueInputted()) {
            expectedOperation = "*";
            value2 = inputField.getText().substring(inputField.getText().lastIndexOf("\n"));
            double result = calculator.multiplication(Double.parseDouble(value1), Double.parseDouble(value2));
            inputField.setText(String.valueOf(result));
            value1 = null;
            value2 = null;
        } else if (value1 != null && !isSecondValueInputted()) {
            expectedOperation = "*";
            inputField.setText(value1 + "\n" + expectedOperation + "\n");
        }

    }

    public void reset(ActionEvent actionEvent) {
        value1 = null;
        value2 = null;
        expectedOperation = null;
        inputField.setText("");
    }

    public void deleteLastDigit(ActionEvent actionEvent) {
        Pattern digits = Pattern.compile("[\\d.]");
        if (isInputFieldEmpty()) {
            Matcher isLastSymbolDigit = digits.matcher(inputField.getText().substring(inputField.getText().length() - 1));
            if (isLastSymbolDigit.matches()) {
                inputField.setText(inputField.getText().substring(0, inputField.getText().length() - 1));
            }
        }
    }

    public void result(ActionEvent actionEvent) {
        if (isInputFieldEmpty() && expectedOperation != null && value1 != null && isSecondValueInputted()) {
            value2 = inputField.getText().substring(inputField.getText().lastIndexOf("\n"));
            double result;
            switch (expectedOperation) {
                case "+" -> {
                    result = calculator.sum(Double.parseDouble(value1), Double.parseDouble(value2));
                    expectedOperation = null;
                    value1 = null;
                    value2 = null;
                    inputField.setText(String.valueOf(result));
                }
                case "-" -> {
                    result = calculator.subtraction(Double.parseDouble(value1), Double.parseDouble(value2));
                    expectedOperation = null;
                    value1 = null;
                    value2 = null;
                    inputField.setText(String.valueOf(result));
                }
                case "/" -> {
                    result = calculator.division(Double.parseDouble(value1), Double.parseDouble(value2));
                    expectedOperation = null;
                    value1 = null;
                    value2 = null;
                    inputField.setText(String.valueOf(result));
                }
                case "*" -> {
                    result = calculator.multiplication(Double.parseDouble(value1), Double.parseDouble(value2));
                    expectedOperation = null;
                    value1 = null;
                    value2 = null;
                    inputField.setText(String.valueOf(result));
                }
            }
        }
    }

    private boolean isInputFieldEmpty() {
        return inputField.getText().length() != 0;
    }

    private boolean isSecondValueInputted() {
        return inputField.getText().substring(inputField.getText().lastIndexOf("\n")).length() > 1;
    }
}




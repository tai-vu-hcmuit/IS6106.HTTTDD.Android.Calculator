package taivu.uit.htttdd.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

/*
* This Calculator is under construction
* Only work well with these cases:
* - Case 1: [Number] + [operator] + [Number] + [=]
*
* Note: Do not start with an [operator]
* */

class MainActivity : AppCompatActivity() {
    private lateinit var operation: String;
    private lateinit var operator: String;
    private lateinit var firstNum: String;
    private lateinit var secondNum: String;
    private var isFirstNum: Boolean = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.operation = "";
        this.isFirstNum = true;
        this.firstNum = "";
        this.secondNum = "";
        this.operator = "";
    }

    private fun addOperationForView(operation: String, ele: String): String {
        this.isFirstNum = false;
        this.operator = ele;

        val lastEle = operation.lastOrNull();
        if(lastEle == ele.lastOrNull()){
            return operation;
        }

        return operation + ele;
    }

    private fun addNumberForCalculate(operation: String, number: String): String {
        if(this.isFirstNum) {
            this.firstNum += number;
        }
        else{
            this.secondNum += number;
        }

        return operation + number;
    }

    /*1*/
    fun onClickButtonAC(view: View) {
        val txtOperation = findViewById<TextView>(R.id.txt_operation);
        val txtResult = findViewById<TextView>(R.id.txt_result);

        this.operation = "";
        this.firstNum = "";
        this.secondNum = "";
        this.isFirstNum = true;
        txtOperation.text = this.operation;
        txtResult.text = "0";
    }

    fun onClickButtonDelete(view: View) {
        val txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.operation.dropLast(1);
        txtOperation.text = this.operation;
    }
    fun onClickButtonModulo(view: View) {
        val txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addOperationForView(this.operation, "%")
        txtOperation.text = this.operation;
    }
    fun onClickButtonDivide(view: View) {
        val txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addOperationForView(this.operation, "/")
        txtOperation.text = this.operation;
    }

    /*2*/
    fun onClickButton7(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "7")
        txtOperation.text = this.operation;
    }

    fun onClickButton8(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "8")
        txtOperation.text = this.operation;
    }
    fun onClickButton9(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "9")
        txtOperation.text = this.operation;
    }
    fun onClickButtonMultiply(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addOperationForView(this.operation, "x")
        txtOperation.text = this.operation;
    }

    /*3*/
    fun onClickButton4(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "4")
        txtOperation.text = this.operation;
    }

    fun onClickButton5(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "5")
        txtOperation.text = this.operation;
    }
    fun onClickButton6(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "6")
        txtOperation.text = this.operation;
    }
    fun onClickButtonMinus(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addOperationForView(this.operation, "-")
        txtOperation.text = this.operation;
    }

    /*4*/
    fun onClickButton1(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "1")
        txtOperation.text = this.operation;
    }

    fun onClickButton2(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "2")
        txtOperation.text = this.operation;
    }
    fun onClickButton3(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "3")
        txtOperation.text = this.operation;
    }
    fun onClickButtonPlus(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addOperationForView(this.operation, "+")
        txtOperation.text = this.operation;
    }

    /*5*/
    fun onClickButtonChangeSign(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

//        this.operation = this.addNumberForCalculate(this.operation, "7")
//        txtOperation.text = this.operation;
    }

    fun onClickButton0(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addNumberForCalculate(this.operation, "0")
        txtOperation.text = this.operation;
    }
    fun onClickButtonDot(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_operation);

        this.operation = this.addOperationForView(this.operation, ".")
        txtOperation.text = this.operation;
    }
    fun onClickButtonCalculate(view: View) {
        var txtOperation = findViewById<TextView>(R.id.txt_result);

        var result: Float = 0F;
        var firstNum = this.firstNum.toFloat();
        var secondNum = this.secondNum.toFloat();

        when(this.operator) {
            "+" -> result = firstNum + secondNum;
            "-" -> result = firstNum - secondNum;
            "x" -> result = firstNum * secondNum;
            "/" -> result = firstNum / secondNum;
            "%" -> result = firstNum % secondNum;
            else -> result = 0F;
        }

        this.firstNum = "";
        this.secondNum = "";
        this.operator = "";
        this.operation = "";
        this.isFirstNum = true;

        txtOperation.text = result.toString();
    }
}


/*
* Ref: https://data-flair.training/blogs/build-simple-calculator-app-android-studio/
* */
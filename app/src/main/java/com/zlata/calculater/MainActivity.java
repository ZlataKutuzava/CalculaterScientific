package com.zlata.calculater;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {

    private static final String INPUT_VALUE= "input";
    private static final String OUTPUT_VALUE = "expression";
    Boolean dot = false;

    EditText output;
    TextView input;

    Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;

    Button plusButton, minusButton, starButton, divButton, equslsButton, dotButton, leftBraceButton, rightBraceButton, factorialButton, powerButton, sqrtButton;

    Button sinButton, cosButton, tgButton, exponentaButton, lnButton, logButton, piButton;

    Button eraseButton, clearAllButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        input = (TextView) findViewById(R.id.input_field);
        input.setText("");

     output = (EditText) findViewById(R.id.output_field);
        output.setText("");
        output.setEnabled(false);

        if (savedInstanceState != null) {
            String expression = savedInstanceState.getString(OUTPUT_VALUE);
            setExpression(expression);
            String input = savedInstanceState.getString(INPUT_VALUE);
            setInput(input);
        }

        zeroButton = (Button) findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("0");
            }
        });


        oneButton = (Button) findViewById(R.id.one_button);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("1");
            }
        });

        twoButton = (Button) findViewById(R.id.two_button);
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("2");
            }
        });

        threeButton = (Button) findViewById(R.id.three_button);
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("3");
            }
        });

        fiveButton = (Button) findViewById(R.id.five_button);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("5");
            }
        });

        sixButton = (Button) findViewById(R.id.six_button);
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("6");
            }
        });

        eightButton = (Button) findViewById(R.id.eight_button);
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("8");
            }
        });

        nineButton = (Button) findViewById(R.id.nine_button);
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("9");
            }
        });



        sinButton = (Button) findViewById(R.id.sin_button);
        sinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("sin(");
            }
        });

        cosButton = (Button) findViewById(R.id.cos_button);
        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("cos(");
            }
        });

        tgButton = (Button) findViewById(R.id.tan_button);
        tgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("tg(");
            }
        });

        lnButton = (Button) findViewById(R.id.ln_button);
        lnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("ln(");
            }
        });

        logButton = (Button) findViewById(R.id.ctg_button);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("ctg(");
            }
        });

        exponentaButton = (Button) findViewById(R.id.exponenta_button);
        exponentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation(String.valueOf(Math.E));
            }
        });

        piButton = (Button) findViewById(R.id.pi_button);
        piButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation(String.valueOf(Math.PI));
            }
        });

        factorialButton = (Button) findViewById(R.id.factorial_button);
        factorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = getInput();
                if (currentInput.length() > 0) {
                    appendExpression(currentInput);
                    addSimpleOperation("!");
                }
            }
        });

        powerButton = (Button) findViewById(R.id.power_button);
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = getInput();
                if (currentInput.length() > 0) {
                    appendExpression(currentInput);
                    addSimpleOperation("^");
                }
            }
        });

        sqrtButton = (Button) findViewById(R.id.sqrt_button);
        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("sqrt(");
            }
        });

        leftBraceButton = (Button) findViewById(R.id.left_brace_button);
        leftBraceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBracket("(");
            }
        });

        rightBraceButton = (Button) findViewById(R.id.right_brace_button);
        rightBraceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBracket(")");
            }
        });


        eraseButton = (Button) findViewById(R.id.erase_button);
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = getInput();
                String newInput;
                if (currentInput.length() <= 1) {
                    newInput = "";
                } else {
                    newInput = currentInput.substring(0, currentInput.length() - 1);
                }
                setInput(newInput);


            }
        });

        clearAllButton = (Button) findViewById(R.id.clear_all_button);
        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInput("");
                setExpression("");
                Calculator.resetCalculated();
            }
        });

        sevenButton = (Button) findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("7");
            }
        });

        equslsButton= (Button) findViewById(R.id.equals_button);
        equslsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Calculator.isCalculated()) {
                    getInput();
                    String expression = getInput();
                    appendInput("=");
                    String result = Calculator.calculate(expression);
                    setInput(result);}
            }
        });

        dotButton = (Button) findViewById(R.id.dot_button);
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(".");
                }

        });


        fourButton = (Button) findViewById(R.id.four_button);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appendInput("4");
            }
        });

        plusButton = (Button) findViewById(R.id.plus_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("+");

            }
        });

        minusButton = (Button) findViewById(R.id.minus_button);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("-");
            }
        });
        starButton = (Button) findViewById(R.id.star_button);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 addSimpleOperation("*");
            }
        });
        divButton = (Button) findViewById(R.id.div_button);
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation("/");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(OUTPUT_VALUE, getExpression());
        outState.putString(INPUT_VALUE, getInput());
        super.onSaveInstanceState(outState);
    }

    public String getInput()
    {
        return input.getText().toString();
    }

    public void setInput(String text) {
        input.setText(text);
    }

   public String getExpression() {   //считывает то, что находится  в выводе
        return output.getText().toString();
    }

    public void setExpression(String text) {  //устанавливает определённое значение в вывод
        output.setText(text);
    }

    public void appendInput(String str) {
        if (getInput().equals("Error")) return;
        if (Calculator.isCalculated()) {
            setExpression("");
            setInput(str);
            Calculator.resetCalculated();
            return;
        }
        String currentInput = getInput();
        String newInput;

        if (str.equals(".")){
            char chars[]=currentInput.toCharArray();
            for (int i = currentInput.length()-2; i >0 ; i--) {
                if(Character.isDigit(chars[i]))
                    continue;
                else if(chars[i]=='.'){
                    dot=true;
                }else break;
            }
        }

        if(dot) {
            dot = false;
            return;
        }

        if (currentInput.length() >= 500) {
            input.setEnabled(false);
            return;
        }

        String s = currentInput;


        boolean isInputEnndingPlus = s.endsWith("+");
        if (isInputEnndingPlus && str.equals("+")){
           return;
        }
        if (isInputEnndingPlus && str.equals("-"))
        {
            return;
        }

        if (currentInput.toString().matches("") && str.equals(".")) {
            return;
        }

        if (currentInput.matches("") && str.equals(".")) {
            return;
        }
        if (isInputEnndingPlus && str.equals("*"))
        {return;}
        if (isInputEnndingPlus && str.equals("/"))
        {return;}
        if (isInputEnndingPlus && str.equals("^"))
        {return;}
        if (isInputEnndingPlus && str.equals("!"))
        {return;}
        if (isInputEnndingPlus && str.equals("."))
        {return;}

        boolean isInputEnndingMInus = s.endsWith("-");
        if (isInputEnndingMInus && str.equals("+"))
        {return;}
        if (isInputEnndingMInus && str.equals("-"))
        {return;}
        if (isInputEnndingMInus && str.equals("*"))
        {return;}
        if (isInputEnndingMInus && str.equals("/"))
        {return;}
        if (isInputEnndingMInus && str.equals("^"))
        {return;}
        if (isInputEnndingMInus && str.equals("!"))
        {return;}
        if (isInputEnndingMInus && str.equals("."))
        {return;}

        boolean isInputEndingStar = s.endsWith("*");
        if (isInputEndingStar && str.equals("+"))
        {return;}
        if (isInputEndingStar && str.equals("-"))
        {return;}
        if (isInputEndingStar && str.equals("*"))
        {return;}
        if (isInputEndingStar && str.equals("/"))
        {return;}
        if (isInputEndingStar && str.equals("^"))
        {return;}
        if (isInputEndingStar && str.equals("!"))
        {return;}
        if (isInputEndingStar && str.equals("."))
        {return;}

        boolean isInputEndingSlash = s.endsWith("/");
        if (isInputEndingSlash && str.equals("+"))
        {return;}
        if (isInputEndingSlash && str.equals("-"))
        {return;}
        if (isInputEndingSlash && str.equals("*"))
        {return;}
        if (isInputEndingSlash && str.equals("/"))
        {return;}
        if (isInputEndingSlash && str.equals("^"))
        {return;}
        if (isInputEndingSlash && str.equals("!"))
        {return;}
        if (isInputEndingSlash && str.equals("."))
        {return;}


        boolean isInputEndingUp = s.endsWith("^");
        if (isInputEndingUp && str.equals("+"))
        {return;}
        if (isInputEndingUp && str.equals("-"))
        {return;}
        if (isInputEndingUp && str.equals("*"))
        {return;}
        if (isInputEndingUp && str.equals("/"))
        {return;}
        if (isInputEndingUp && str.equals("^"))
        {return;}
        if (isInputEndingUp && str.equals("!"))
        {return;}
        if (isInputEndingUp && str.equals("."))
        {return;}
        boolean isInputEndingVoskl = s.endsWith("!");
        if (isInputEndingVoskl && str.equals("!"))
        {return;}



        boolean isInputEndingLeftBrace = s.endsWith("(");
        if (isInputEndingLeftBrace && str.equals(")"))  {return;}


        boolean isInputEndingRightBrace = s.endsWith(")");
        if (isInputEndingRightBrace && str.equals("("))
        {return;}

        boolean isInputEndingDot = s.endsWith(".");
        if (isInputEndingDot && str.equals("."))
        {return;}

        if (currentInput.equals("0") && !str.equals(".")) {
            newInput = str;
            setInput(newInput);
            return;
        }

      if (currentInput.equals("") && str.equals(".")) {
            return;
        }

        if (currentInput.equals("+") && str.equals("-")) {
            return;
        }

        if (currentInput.equals("") && str.equals("+")) {
            return;
        }

        if (currentInput.equals("") && str.equals("*")) {
            return;
        }

        if (currentInput.equals("") && str.equals("/")) {
            return;
        }

        newInput = currentInput + str;
        setInput(newInput);
    }



    public void appendExpression(String str) {
        if (getInput().equals("Error")) return;
        String currentExpression = getExpression();
        String newExpression = currentExpression + str;
        setInput(newExpression);
    }

    public void addSimpleOperation(String str) {
            if (getInput().equals("Error")) return;
            if (Calculator.isCalculated()) {
                setInput(getInput());
                Calculator.resetCalculated();
            } else {
                appendExpression(getInput());
            }
            appendInput(str);
    }

    public void addBracket(String bracket) {
        if (getInput().equals("Error")) return;
        if (Calculator.isCalculated()) {
            appendInput(bracket);
            Calculator.resetCalculated();
            return;
        }
        if (getInput().length() > 0) {
            appendExpression(getInput());
        }
        appendInput(bracket);
    }
}

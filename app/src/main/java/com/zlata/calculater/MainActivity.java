package com.zlata.calculater;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String INPUT_VALUE= "input";
    private static final String OUTPUT_VALUE = "expression";

    EditText output;
    TextView input;

    Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;

    Button plusButton, minusButton, starButton, divButton, changeSignButton, dotButton, leftBraceButton, rightBraceButton, factorialButton, powerButton, sqrtButton;

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
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Counter.isCounted()) {
                    appendExpression(getInput());
                    String expression = getOutput();
                    appendExpression("=");
                    String result = Counter.calculate(expression);
                    setInput(result);
                }
            }
        });

        output = (EditText) findViewById(R.id.output_field);
        output.setText("");
        output.setEnabled(false);

        if (savedInstanceState != null) {
            String expression = savedInstanceState.getString(OUTPUT_VALUE);
            setOutput(expression);
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

        fourButton = (Button) findViewById(R.id.four_button);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("4");
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

        sevenButton = (Button) findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput("7");
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

        dotButton = (Button) findViewById(R.id.dot_button);
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(".");
            }
        });

        changeSignButton= (Button) findViewById(R.id.change_sign_button);
        changeSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSign();
            }
        });

        plusButton = (Button) findViewById(R.id.plus_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAriphmetic("+");
            }
        });
        minusButton = (Button) findViewById(R.id.minus_button);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAriphmetic("-");
            }
        });
        starButton = (Button) findViewById(R.id.star_button);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAriphmetic("*");
            }
        });
        divButton = (Button) findViewById(R.id.div_button);
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAriphmetic("/");
            }
        });

        divButton = (Button) findViewById(R.id.div_button);
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAriphmetic("/");
            }
        });

        sinButton = (Button) findViewById(R.id.sin_button);
        sinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScientific("sin");
            }
        });

        cosButton = (Button) findViewById(R.id.cos_button);
        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScientific("cos");
            }
        });

        tgButton = (Button) findViewById(R.id.tan_button);
        tgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScientific("tg");
            }
        });

        lnButton = (Button) findViewById(R.id.ln_button);
        lnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScientific("ln");
            }
        });

        logButton = (Button) findViewById(R.id.log_button);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScientific("lg");
            }
        });

        exponentaButton = (Button) findViewById(R.id.exponenta_button);
        exponentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInput(String.valueOf(Math.E));
            }
        });

        piButton = (Button) findViewById(R.id.pi_button);
        piButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInput(String.valueOf(Math.PI));
            }
        });

        factorialButton = (Button) findViewById(R.id.factorial_button);
        factorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = getInput();
                if (currentInput.length() >= 0) {
                    appendExpression(currentInput);
                }
                appendExpression("!");
                setInput("");
            }
        });

        powerButton = (Button) findViewById(R.id.power_button);
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = getInput();
                if (currentInput.length() >= 0) {
                    appendExpression(currentInput);
                }
                appendExpression("^");
                setInput("");
            }
        });

        sqrtButton = (Button) findViewById(R.id.sqrt_button);
        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScientific("sqrt");
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
                setOutput("");
                Counter.resetCount();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(OUTPUT_VALUE, getOutput());
        outState.putString(INPUT_VALUE, getInput());
        super.onSaveInstanceState(outState);
    }
    public String getInput() {
        return input.getText().toString();
    }

    public void setInput(String text) {
        if (text.length() >= 12) {
            text = String.format("%.12s", Float.valueOf(text));
        }
        input.setText(text);
    }

    public String getOutput() {
        return output.getText().toString();
    }

    public void setOutput(String text) {
        output.setText(text);
    }

    public void appendInput(String str) {
        if (getInput().equals("Error")) return;
        if (Counter.isCounted()) {
            setOutput("");
            setInput(str);
            Counter.resetCount();
            return;
        }
        String currentInput = getInput();
        String newInput;

        if (currentInput.length() >= 11) {
            return;
        }

        if (currentInput.equals("0") && !str.equals(".")) {
            newInput = str;
            setInput(newInput);
            return;
        }
        if (currentInput.indexOf(".") >= 0 && str.equals(".")) {
            return;
        }

        newInput = currentInput + str;
        setInput(newInput);
    }

    public void appendExpression(String str) {
        if (getInput().equals("Error")) return;
        String currentExpression = getOutput();
        String newExpression = currentExpression + str;
        setOutput(newExpression);
    }

    public void changeSign() {
        if (getInput().equals("Error")) return;
        String currentInput = getInput();
        String newInput;
        if (currentInput.indexOf("-") == 0) {
            newInput = currentInput.substring(1);
        } else {
            newInput = "-" + currentInput;
        }
        setInput(newInput);
    }

    public void addAriphmetic(String str) {
        if (getInput().equals("Error")) return;
        if (Counter.isCounted()) {
            setOutput(getInput());
            Counter.resetCount();
        } else {
            appendExpression(getInput());
        }
        appendExpression(str);
        setInput("");
    }

    public void addBracket(String bracket) {
        if (getInput().equals("Error")) return;
        if (Counter.isCounted()) {
            setInput("");
            setOutput(bracket);
            Counter.resetCount();
            return;
        }
        if (getInput().length() > 0) {
            appendExpression(getInput());
        }
        appendExpression(bracket);
        setInput("");
    }

    public void addScientific(String operation) {
        if (getInput().equals("Error")) return;
        if (Counter.isCounted()) {
            setOutput(operation);
            Counter.resetCount();
        } else {
            appendExpression(operation);
        }
        appendExpression("(");
        setInput("");

    }
}

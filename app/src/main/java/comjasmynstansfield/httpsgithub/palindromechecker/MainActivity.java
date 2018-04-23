/**
 * Name: Jasmyn Stansfield
 * Course: CS30S
 * Teacher: Mr. Hardman
 * Lab #4, Program #1
 * Date last modified: April 23, 2018
 */

package comjasmynstansfield.httpsgithub.palindromechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mWordInput;

    private TextView mErrorMessage;
    private TextView mResult;

    @Override
    /**
     * onCreate is the method that is run when the activity begins
     *
     * @param savedInstanceState is a bundle of data used to restor the activity from a
     *                           previous instance
     * @return Nothing will be returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordInput = (EditText) findViewById(R.id.et_word_input);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
        mResult = (TextView) findViewById(R.id.tv_result);

        mWordInput.addTextChangedListener(wordInputWatcher);


    }

    private final TextWatcher wordInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        /**
         * afterTextChanged is the method that is run when the user enters text
         * into the editable object
         *
         * @param editable is the editable object the user typed input into
         * @return "" Nothing will be returned
         */
        public void afterTextChanged(Editable editable) {
            String userInput = mWordInput.getText().toString();
            boolean result;

            if (editable.length() == 0) {
                mResult.setText("");
                mErrorMessage.setText("You must enter a word to check whether is is a palindrome or not.");
            }
            else
            {
                mResult.getText().toString().toUpperCase();

                result = checkPalindrome( mWordInput.getText().toString(), 0 );

                if( result == true )
                {
                    mErrorMessage.setText("");
                    mResult.setText( "Your word is a palindrome!");
                }
                else
                {
                    mErrorMessage.setText("");
                    mResult.setText( "Your word is not a palindrome :(");
                }

            }
        };

        /**
         * checkPalindrome will check whether the word entered by the user is spelled the same
         * backwards as it is forwards
         * @param userInput is the word entered by the user
         * @param i is the current index
         * @return a boolean stating whether the word is a palindrome or not
         */
        private boolean checkPalindrome(String userInput, int i)
        {
            boolean result;

            int indexFromEnd = mWordInput.length() - i - 1;

            if( userInput.charAt(i) == userInput.charAt(indexFromEnd))
            {
                if( i == indexFromEnd || i == indexFromEnd - 1)
                {
                    result = true;
                }
                else
                {
                    result = checkPalindrome( userInput, i + 1);
                }
            }
            else
            {
                result = false;
            }
            return result;
        }
    };
}

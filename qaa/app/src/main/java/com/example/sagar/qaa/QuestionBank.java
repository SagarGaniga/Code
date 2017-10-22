package com.example.sagar.qaa;

/**
 * Created by Sagar on 21-Oct-17.
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    // declare list of Question objects
    List <Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("How do crazy people gro through the forest?",
                    new String[]{"Take Normal Path", "Use Car", "Use Bike", "Take Psycho Path"}, "Take Psycho Path"));
            myDataBaseHelper.addInitialQuestion(new Question("What happend to the guy who lost his left hand and leg in car crash?",
                    new String[]{"He Dyed", "He's all right now", "Injured", "Recovering"}, "He's all right now"));
            myDataBaseHelper.addInitialQuestion(new Question("What do fish say when they hit a concrete wall?",
                    new String[]{"Dam", "Sorry", "Sync", "Repo"}, "Dam"));
            myDataBaseHelper.addInitialQuestion(new Question("What do you call a boomerang that doesn't work?",
                    new String[]{"stick", "BOOM", "RANG", "Not so Boomerang"}, "stick"));
            myDataBaseHelper.addInitialQuestion(new Question("Where do you find a dog with no legs?",
                    new String[]{"Mumbai", "Zoo", "Studio", "Right where you left him"}, "Right where you left him"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}
package com.example.haldir.rtquiz;

/**
 * Created by Haldir on 25.01.2018.
 */

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    // deklaracja listy pytan
    List <Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    // zwracanie ilosci pytan
    public int getLength(){
        return list.size();
    }

    // zwracanie pytan po indexie
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // odpowiedzi z listy po indexie - 1, 2, 3 or 4
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  zwracanie poprawnej odp
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//pobieranie pytan, wyborow i odpowiedzi z DB

        if (list.isEmpty()) {//jezeli lista pytan jest pusta, generuj
            myDataBaseHelper.addInitialQuestion(new Question("W którym roku powstał język programowania Java?",
                    new String[]{"1995", "1996", "1992", "2000"}, "1995"));
            myDataBaseHelper.addInitialQuestion(new Question("Jakiego typu gry jest Call Of Duty?",
                    new String[]{"RPG", "RTS", "FPS", "Point and Click"}, "FPS"));
            myDataBaseHelper.addInitialQuestion(new Question("Jakie miasto jest siedzibą firmy Microsoft?",
                    new String[]{"Chicago", "Los Angeles", "Redmont", "Ohio"}, "Redmont"));
            myDataBaseHelper.addInitialQuestion(new Question("Jakiego studia gier komputerowych jest produkcja \"Wiedźmin 3 Dziki Gon\"?",
                    new String[]{"CDProject RED", "Ubisoft", "EA", "Piranha Bytes"}, "CDProject RED"));
            myDataBaseHelper.addInitialQuestion(new Question("Do gier studia Blizzard Entertainment nie należy...",
                    new String[]{"World of Warcraft", "Overwatch", "Diablo", "DOTA"}, "DOTA"));
            myDataBaseHelper.addInitialQuestion(new Question("Która z firm wyprodukowała silnik graficzny Frostbite?",
                    new String[]{"Crytek", "EA DICE", "Epic Games", "Ubisoft"}, "EA DICE"));

            list = myDataBaseHelper.getAllQuestionsList();//pobierz liste z bazy

        }
    }

}
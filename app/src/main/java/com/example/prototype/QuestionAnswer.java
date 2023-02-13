package com.example.prototype;

public class QuestionAnswer {

    private static String[] questions = {
            "What colour was princess Rose's hair at the start of the story?",
            "Who turned princess Rose's hair black?",
            "What advice did the golden bird give princess rose?",
            "Who gave princess Rose the rose petals?"
    };

    private static String[][] answers = {
            {"black","red","blue","green"},
            {"the golden bird","the prince","the witch","the king"},
            {"black hair in rose water","to ask the prince for help","to paint her hair red","to say sorry to the witch"},
            {"the witch","the golden bird","the king","the prince"}
    };

    private static String[] correctAnswers = {
            "red",
            "the witch",
            "black hair in rose water",
            "the prince"
    };

    private static String[] RedRidingHoodQuestions = {
            "Who gave little red riding hood her little riding hood of red velvet?",
            "Who did little red riding hood meet in the woods?",
            "How many people did the wolf swallow?",
            "Who saved little red riding hood and her grandmother?"
    };

    private static String[][] RedRidingHoodAnswers = {
            {"her mother","her grandmother","the huntsman","the wolf"},
            {"the huntsman","her mother","the wolf","her grandmother"},
            {"one","two","three","four"},
            {"the huntsman","her mother","the wolf","her grandmother"}
    };

    private static String[] RedRidingHoodCorrectAnswers = {
            "her grandmother",
            "the wolf",
            "two",
            "the huntsman"
    };

    public static String[] questionsDecider(String quizName){
        String [] selectedQuestions = {};
        if (quizName.equals("Princess Rose And The Golden Bird")){
            selectedQuestions = questions.clone();
        } else if (quizName.equals("Little Red Riding Hood")){
            selectedQuestions = RedRidingHoodQuestions.clone();
        }
        return selectedQuestions;
    }

    public static String[][] answerDecider(String quizName){
        String [][] selectedAnswers = {};
        if (quizName.equals("Princess Rose And The Golden Bird")){
            selectedAnswers = answers.clone();
        } else if (quizName.equals("Little Red Riding Hood")){
            selectedAnswers = RedRidingHoodAnswers.clone();
        }
        return selectedAnswers;
    }

    public static String[] correctAnswerDecider(String quizName){
        String [] selectedCorrectAnswers = {};
        if (quizName.equals("Princess Rose And The Golden Bird")){
            selectedCorrectAnswers = correctAnswers.clone();
        } else if (quizName.equals("Little Red Riding Hood")){
            selectedCorrectAnswers = RedRidingHoodCorrectAnswers.clone();
        }
        return selectedCorrectAnswers;
    }


}

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

    private static String[] CinderellaQuestions = {
            "How many sisters did Cinderella have?",
            "How many times did Cinderella go to the ball?",
            "When did Cinderella have to leave the ball?",
            "How could Prince find Cinderella?"
    };
    private static String[][] Cinderellaanswers = {
            {"One","Three","Two","Ten"},
            {"Fifteen Times","One Time","Three","Seven Times"},
            {"Midnight","Morning Time","Evening Time","Midday"},
            {"He was looking for a dress, which will approach the lost flap","He was looking for a second one","He gave trying on a shoe, which Cinderella lost","He was looking Money on the Floor"}
    };
    private static String[] CinderellaCorrectAnswers = {
            "Two",
            "Two Times",
            "Midnight",
            "He gave trying on a shoe, which Cinderella lost"
    };
    private static String[] GoldilocksQuestions = {
            "What hair colour Goldilocks have?",
            "How many bowls were on the table?",
            "What did Goldilocks do when she saw the three bears?",
            "Who did live in the house?"
    };
    private static String[][] GoldilocksAnswers = {
            {"Black","Green","Gold","Brown"},
            {"Three","Ten","Five","Seven"},
            {"She danced with the bears.","She ran into the forest.","She ate more porridge.","She kept sleeping"},
            {"The three bears","The three pigs","The three lions","The three cats"}
    };
    private static String[] GoldilocksCorrectAnswers = {
            "Gold",
            "Three",
            "She ran into the forest",
            "he three bears"
    };
    private static String[] The_Fox_and_theCrowQuestions = {
            "What animal does the Fox see on the limb of a tree??",
            "What was the setting?",
            "What is the problem",
            "What did the Crow say?"
    };
    private static String[][] The_Fox_and_theCrowAnswers = {
            {"Eagle","Pigeon","Crow","Cow"},
            {"Forest","Mountain","Village","Sahara"},
            {"The crow was stuck in the tree","The fox was hungry and wanted crow's food","Crow was afraid of the fox","There was no problem"},
            {"Caw","wow","Boo","Moo"}
    };
    private static String[] The_Fox_and_theCrowCorrectAnswers = {
            "Crow",
            "Forest",
            "The fox was hungry and wanted crow's food",
            "Caw"
    };
    private static String[] androclesAndTheLionQuestions = {
            "Where did Androcles take shelter?",
            "What was Androcles' first reaction when he saw a lion?",
            "What had pierced one of the lion's toes?",
            "Who ordered that Androcles should be set free?"
    };
    private static String[][] androclesAndTheLionAnswers = {
            {"Garden","Forest","ship","Orchard"},
            {"Stand Still","Turn and Flee","Kill","Clim a Tree"},
            {"A small needle","A big thorn","Stone","pin"},
            {"The Police Man","the king","emperor ","The old lady"}
    };
    private static String[] androclesAndTheLionCorrectAnswers = {
            "Forest",
            "Turn and Flee",
            "A big thorn",
            "emperor"
    };

    private static String[] The_Rat_and_the_ElephantQuestions = {
            "How did the rat describe himself?",
            "How does the rat describe the elephant?",
            "Who is the narrator of the story?",
            "Why did the rat approach the royal master and his suite?"
    };
    private static String[][] The_Rat_and_the_ElephantAnswers = {
            {"pretty and scary","Cute and beautiful","Ugly","Scary"},
            {"Beastly looking, polite and cute","Huge, scary and pretty","Fat and cute","Big, fat and ugly"},
            {"An unknown narrator","The Rat","the Elephant","bird"},
            {"Because the rat saw the elephant and got jealous","because he was sad","Because he wanted to be a royal rat","Because of the loud noise"}
    };
    private static String[] The_Rat_and_the_ElephantCorrectAnswers = {
            "Cute and beautiful",
            "Big, fat and ugly",
            "The Rat",
            "Because of the loud noise"
    };
    private static String[] The_Three_Little_PigsQuestions = {
            "What kind of house did the FIRST little pig make?",
            "What did the big bad wolf like to do?",
            "What kind of house did the SECOND little pig make? ",
            "What less did the FIRST and SECOND little pig learn from their brother?"
    };
    private static String[][] The_Three_Little_PigsAnswers = {
            {"brick","woods","mood","Straw"},
            {"Sing","work","eat little pigs","Play with pigs"},
            {"Sleep","Run Around","Dance and play","Cried"},
            {"its fun to play","Don't Work hard","Dance and play","Hard Work pays off"}
    };
    private static String[] The_Three_Little_PigsCorrectAnswers = {
            "Straw",
            "eat little pigs",
            "Dance and play",
            "Hard Work pays off"
    };









    public static String[] questionsDecider(String quizName){
        String [] selectedQuestions = {};
        if (quizName.equals("Princess Rose And The Golden Bird")){
            selectedQuestions = questions.clone();
        } else if (quizName.equals("Little Red Riding Hood")){
            selectedQuestions = RedRidingHoodQuestions.clone();
        }else if (quizName.equals("The Three Little Pigs")){
            selectedQuestions = The_Three_Little_PigsQuestions.clone();
        }
        else if (quizName.equals("Cinderella")) {
            selectedQuestions = CinderellaQuestions.clone();
        }
        else if (quizName.equals("Goldilocks")) {
            selectedQuestions = GoldilocksQuestions.clone();
        }
        else if (quizName.equals("The Fox And The Crow")) {
            selectedQuestions = The_Fox_and_theCrowQuestions.clone();
        }
        else if (quizName.equals("Androcles And The Lion")) {
            selectedQuestions = androclesAndTheLionQuestions.clone();
        }
        else if (quizName.equals("The Rat And The Elephant")) {
            selectedQuestions = The_Rat_and_the_ElephantQuestions.clone();
        }
        return selectedQuestions;
    }

    public static String[][] answerDecider(String quizName){
        String [][] selectedAnswers = {};
        if (quizName.equals("Princess Rose And The Golden Bird")){
            selectedAnswers = answers.clone();
        } else if (quizName.equals("Little Red Riding Hood")){
            selectedAnswers = RedRidingHoodAnswers.clone();
        }else if (quizName.equals("The Three Little Pigs")){
            selectedAnswers = The_Three_Little_PigsAnswers.clone();
        }
        else if (quizName.equals("Cinderella")){
            selectedAnswers = Cinderellaanswers.clone();
        }
        else if (quizName.equals("Goldilocks")){
            selectedAnswers = GoldilocksAnswers.clone();
        }
        else if (quizName.equals("The Fox And The Crow")){
            selectedAnswers = The_Fox_and_theCrowAnswers.clone();
        }
        else if (quizName.equals("Androcles And The Lion")){
            selectedAnswers = androclesAndTheLionAnswers.clone();
        }
        else if (quizName.equals("The Rat And The Elephant")){
            selectedAnswers = The_Rat_and_the_ElephantAnswers.clone();
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
        else if (quizName.equals("The Three Little Pigs")){
            selectedCorrectAnswers = The_Three_Little_PigsCorrectAnswers.clone();
        }
        else if (quizName.equals("Cinderella")){
            selectedCorrectAnswers = CinderellaCorrectAnswers.clone();
        }
        else if (quizName.equals("Goldilocks")){
            selectedCorrectAnswers = GoldilocksCorrectAnswers.clone();
        }
        else if (quizName.equals("The Fox And The Crow")){
            selectedCorrectAnswers = The_Fox_and_theCrowCorrectAnswers.clone();
        }
        else if (quizName.equals("Androcles And The Lion")){
            selectedCorrectAnswers = androclesAndTheLionCorrectAnswers.clone();
        }
        else if (quizName.equals("The Rat And The Elephant")){
            selectedCorrectAnswers = The_Rat_and_the_ElephantCorrectAnswers.clone();
        }
        return selectedCorrectAnswers;
    }


}

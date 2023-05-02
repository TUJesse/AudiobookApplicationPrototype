package com.example.prototype;

public class QuestionAnswer {

    private static String[] questions = {
            "What colour was the princesses hair",
            "What did the princess and the golden bird do every evening",
            "What did princess rose dip her head into",
            "What did the witch do after she cast the spell",
            "What was inside the box the prince had"
    };

    private static String[][] answers = {
            {"Black","Red","Blue","Gold"},
            {"Sing","Play","Read","Swim"},
            {"Rose Water","Hot Water","Warm Water","Wold Water"},
            {"Made the spell permanent","Put a spell on her legs","Picked up all of the rose blooms","Put a spell on her hands"},
            {"A magic potion", "A single red hair", "Some magic dust", "A mysterious glass"}
    };

    private static String[] correctAnswers = {
            "Red",
            "Sing",
            "Rose Water",
            "Picked up all of the rose blooms",
            "A single red hair"
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
            "what were the young ladies invited too?",
            "where was cinderella sitting by?",
            "What colour was the coach that took cinderella?",
            "When did the prince find the slipper?",
            "Who found cinderella by the fire place?",
            "What was cinderella dressed in for the palace?",
            "When did cinderella wed the prince?"
    };
    private static String[][] Cinderellaanswers = {
            {"One","Three","Two","Ten"},
            {"A party","A Royal ball","A Movie","A Concert"},
            {"Bedroom","Sitting room","Fireplace","Outside"},
            {"Red","Blue","Golden","Green"},
            {"Evening","Afternoon","Night","Morning"},
            {"The mother","The royal servant","The sister","The prince"},
            {"Pyjamas","Dress","Tracksuit","Rags"},
            {"Next Year","Next Day","Next Month","Next Week"}
    };
    private static String[] CinderellaCorrectAnswers = {
            "Two",
            "A Royal ball",
            "Fireplace",
            "Golden",
            "Morning",
            "The royal servant",
            "Rags",
            "Next Day"
    };
    private static String[] GoldilocksQuestions = {
            "What colour was Goldilocks' hair?",
            "Which bowl of porridge did Goldilocks say was just right?",
            "What did the bears say when they returned home to eat their porridge?",
            "Who's bed was Goldilocks sleeping in?",
            "Who's house did Goldilocks run off to when she was found by the three bears?"
    };
    private static String[][] GoldilocksAnswers = {
            {"Black","Green","Gold","Brown"},
            {"The great huge bear's bowl","The middle bear's bowl","The small bear's bowl","No bowl was just right"},
            {"Who ate my porridge","Let us eat","Where is my porridge","Somebody has been at my porridge"},
            {"The big bear's bed","The small bear's bed","The middle bear's bed","Her bed"},
            {"Her Grandmama's house","Her Mother's house","Her Grandpapa's house","Her father's house"}
    };
    private static String[] GoldilocksCorrectAnswers = {
            "Gold",
            "The small bear's bowl",
            "Somebody has been at my porridge",
            "The small bear's bed",
            "Her Grandmama's house"
    };
    private static String[] The_Fox_and_theCrowQuestions = {
            "What was the setting?",
            "What animal does the Fox see on the limb of a tree??",
            "What is the problem",
            "What did the Crow say?",
            "How did Fox get Crow to drop the cheese?"
    };
    private static String[][] The_Fox_and_theCrowAnswers = {
            {"Forest","Mountain","Village","Sahara"},
            {"Eagle","Pigeon","Crow","Cow"},
            {"The crow was stuck in the tree","The fox was hungry and wanted crow's food","Crow was afraid of the fox","There was no problem"},
            {"Caw","wow","Boo","Moo"},
            {"The Crow feels bad for the Fox after he tells her a sob story "," because the crow started crying after sob story","The Crow is flattered by the Fox's compliments, so much so that she drops her food","The Crow isn't hungry and would rather sing than eat"}
    };
    private static String[] The_Fox_and_theCrowCorrectAnswers = {
            "Forest",
            "Crow",
            "The fox was hungry and wanted crow's food",
            "Caw",
            "The Crow is flattered by the Fox's compliments, so much so that she drops her food"
    };
    private static String[] androclesAndTheLionQuestions = {
            "Where did Androcles flee to, to escape from his master?",
            "What did Androcles do when he saw the lion in pain?",
            "Who ordered that Androcles should be set free?"
    };
    private static String[][] androclesAndTheLionAnswers = {
            {"Garden","Forest","ship","Orchard"},
            {"Stand Still","Turn and Flee","He drew the thorn out of the Lion's paw","Clim a Tree"},
            {"his master","the king","emperor","The old lady"}
    };
    private static String[] androclesAndTheLionCorrectAnswers = {
            "Forest",
            "He drew the thorn out of the Lion's paw",
            "emperor"
    };

    private static String[] The_Rat_and_the_ElephantQuestions = {
            "How did the rat describe himself?",
            "How does the rat describe the elephant?",
            "Why did the rat approach the royal master and his suite?"
    };
    private static String[][] The_Rat_and_the_ElephantAnswers = {
            {"pretty and scary","Cute and beautiful","Ugly","Scary"},
            {"Beastly looking, polite and cute","Huge, scary and pretty","Fat and cute","Big, fat and ugly"},
            {"Because the rat saw the elephant and got jealous","because he was sad","Because he wanted to be a royal rat","Because of the loud noise"}
    };
    private static String[] The_Rat_and_the_ElephantCorrectAnswers = {
            "Cute and beautiful",
            "Big, fat and ugly",
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

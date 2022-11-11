package com.hfad.quizzo;

import java.util.ArrayList;

public class Database {

    private static ArrayList<Question> questions;

    public ArrayList<Question> getQuestions()
    {
        if(questions == null)
        {
            questions = new ArrayList<Question>();
            loadQuestions();
        }return questions;
    }
    public static void addQuestion(Question q)
    {
        questions.add(q);
    }

    public static ArrayList<Question> retrieveQuestionsWithGenre(String genre)
    {
        if(questions == null)
        {
            questions = new ArrayList<Question>();
            loadQuestions();
        }

        if (genre.equals("All"))
        {
            return questions;
        }

        ArrayList<Question> quesGenre = new ArrayList<Question>();

        for (int i = 0; i < questions.size(); i++)
        {
            if (genre.equals(questions.get(i).getGenre()))
            {
                quesGenre.add(questions.get(i));
            }
        }
            return quesGenre;

    }

    private static void loadQuestions()
    {
        ArrayList<String> questionChoices1 = new ArrayList<String>();
        questionChoices1.add("Pacific");
        questionChoices1.add("Atlantic");
        questionChoices1.add("Arctic");
        questionChoices1.add("Indian");
        questions.add(new Question("Geography", "Which ocean is the largest?", questionChoices1, "Pacific", "The Pacific Ocean stretches to an astonishing 63.8 million square miles!"));

        ArrayList<String> questionChoices2 = new ArrayList<String>();
        questionChoices2.add("192");
        questionChoices2.add("195");
        questionChoices2.add("193");
        questionChoices2.add("197");
        questions.add(new Question("Geography", "How many countries are in the world?", questionChoices2, "195", "Africa has the most countries of any continent with 54."));

        ArrayList<String> questionChoices3 = new ArrayList<String>();
        questionChoices3.add("Mississippi");
        questionChoices3.add("Nile");
        questionChoices3.add("Congo");
        questionChoices3.add("Amazon");
        questions.add(new Question("Geography", "What is the name of the longest river in the world?", questionChoices3, "Nile", "Explorer John Hanning Speke discovered the source of the Nile on August 3rd, 1858."));

        ArrayList<String> questionChoices4 = new ArrayList<String>();
        questionChoices4.add("United States");
        questionChoices4.add("China");
        questionChoices4.add("Japan");
        questionChoices4.add("India");
        questions.add(new Question("Geography", "Which country has the largest population?", questionChoices4, "China", "Shanghai is the most populated city in China with a population of 24,870,895."));

        ArrayList<String> questionChoices5 = new ArrayList<String>();
        questionChoices5.add("Mars");
        questionChoices5.add("Mercury");
        questionChoices5.add("Venus");
        questionChoices5.add("Jupiter");
        questions.add(new Question("Geography", "Which planet is closest to Earth?", questionChoices5, "Venus", "Even though Venus is the closest, the planet it still ~38 million miles from Earth!"));

        ArrayList<String> questionChoices6 = new ArrayList<String>();
        questionChoices6.add("Sega");
        questionChoices6.add("Nintendo");
        questionChoices6.add("Sony");
        questionChoices6.add("Atari");
        questions.add(new Question("Video Games", "Which company created the famous plumber Mario?", questionChoices6, "Nintendo", "Nintendo created Mario in 1981 for the arcade game Donkey Kong."));

        ArrayList<String> questionChoices7 = new ArrayList<String>();
        questionChoices7.add("Sonic");
        questionChoices7.add("Tails");
        questionChoices7.add("Knuckles");
        questionChoices7.add("Amy");
        questions.add(new Question("Video Games", "What is the name of the famous video character who is a blue hedgehog?", questionChoices7, "Sonic", "In some official concept art, Sonic was originally meant to be a rabbit."));


        ArrayList<String> questionChoices8 = new ArrayList<String>();
        questionChoices8.add("Wii Sports");
        questionChoices8.add("Grand Theft Auto V");
        questionChoices8.add("Tetris");
        questionChoices8.add("Minecraft");
        Question videoGamesQuestion3 = new Question("Video Games", "As of 2022, which of the following is the best selling video game of all time?", questionChoices8, "Minecraft", "As of 2022, Minecraft has sold over 238 million units.");
        questions.add(videoGamesQuestion3);

        ArrayList<String> questionChoices9 = new ArrayList<String>();
        questionChoices9.add("Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.");
        questionChoices9.add("Place 2 milk, 3 sugar, 2 eggs, and 3 wheat in the 3x3 crafting grid.");
        questionChoices9.add("Place 3 milk, 5 sugar, 6 eggs, and 3 wheat in the 3x6 crafting grid.");
        questionChoices9.add("Place 1 milk, 1 sugar, 1 egg, and 1 wheat in the 1x1 crafting grid.");
        Question videoGamesQuestion4 = new Question("Video Games", "How do you craft a cake in Minecraft?", questionChoices9, "Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.", "Cake is the only food that has to be placed for players to eat it.");
        questions.add(videoGamesQuestion4);

        ArrayList<String> questionChoices10 = new ArrayList<String>();
        questionChoices10.add("Diddy Kong");
        questionChoices10.add("Donkey Kong Jr.");
        questionChoices10.add("Dixie Kong");
        questionChoices10.add("Papa Kong");
        Question videoGamesQuestion5 = new Question("Video Games", "Who is Donkey Kong’s son?", questionChoices10, "Donkey Kong Jr", "Donkey Kong Jr. has appeared only in the game Super Mario Kart for Super Nintendo Entertainment System as a playable character celebrating the 10th anniversary of his arcade game and his shared history with Mario.");
        questions.add(videoGamesQuestion5);

        ArrayList<String> questionChoices11 = new ArrayList<String>();
        questionChoices11.add("1");
        questionChoices11.add("5");
        questionChoices11.add("4");
        questionChoices11.add("10");
        Question videoGamesQuestion6 = new Question("Video Games", "How many Xenoblade Chronicles have been created?", questionChoices11, "5", "Xenoblade Chronicles was originally going to be titled Monado: Beginning of the World and was not intended as an entry into the Xeno series.");
        questions.add(videoGamesQuestion6);

        ArrayList<String> questionChoices12 = new ArrayList<String>();
        questionChoices12.add("Black");
        questionChoices12.add("White");
        questionChoices12.add("Pink");
        questionChoices12.add("Brown");
        Question animalsQuestion1 = new Question("Animals", "What colour is a polar bear’s skin?", questionChoices12, "Black", "Polar bear fur is actually hollow and transparent!");
        questions.add(animalsQuestion1);

        ArrayList<String> questionChoices13 = new ArrayList<String>();
        questionChoices13.add("Man-o-war");
        questionChoices13.add("Box jellyfish");
        questionChoices13.add("Irukandji Jellyfish");
        questionChoices13.add("Sea Nettle");
        Question animalsQuestion2 = new Question("Animals", "Which jellyfish has the deadliest sting?", questionChoices13, "Irukandji Jellyfish", "Some jellyfish species are functionally immortal.");
        questions.add(animalsQuestion2);


        ArrayList<String> questionChoices14 = new ArrayList<String>();
        questionChoices14.add("True");
        questionChoices14.add("False");
        Question animalsQuestion3 = new Question("Animals", "Hyenas scavenge more than lions do.", questionChoices14, "False", "Lions actually scavenge for food more than they hunt it.");
        questions.add(animalsQuestion3);

        ArrayList<String> questionChoices15 = new ArrayList<String>();
        questionChoices15.add("Grizzly bear");
        questionChoices15.add("Polar bear");
        questionChoices15.add("Raccoon");
        questionChoices15.add("Cat");
        questionChoices15.add("Spectacled bear");
        Question animalsQuestion4 = new Question("Animals", "What is the giant panda’s closest relative?", questionChoices15, "Spectacled bear", "Despite common belief, molecular studies show that pandas are in fact closer to bears than raccoons.");
        questions.add(animalsQuestion4);

        ArrayList<String> questionChoices16 = new ArrayList<String>();
        questionChoices16.add("Hippo");
        questionChoices16.add("Sloth");
        questionChoices16.add("Bats");
        questionChoices16.add("Elk");
        questionChoices16.add("Fish");
        Question animalsQuestion5 = new Question("Animals", "Which one of these animals cannot swim?", questionChoices16, "Hippo", "Hippos are the world’s most dangerous land mammal.");
        questions.add(animalsQuestion5);

        ArrayList<String> questionChoices17 = new ArrayList<String>();
        questionChoices17.add("Eagles");
        questionChoices17.add("Packers");
        questionChoices17.add("Cowboys");
        questionChoices17.add("76ers");
        questionChoices17.add("Ravens");
        Question sportsQuestion1 = new Question("Sports", "Who won the first superbowl in NFL history?", questionChoices17, "Packers", "The Packers have won the NFL championship 4 times.");
        questions.add(sportsQuestion1);


        ArrayList<String> questionChoices18 = new ArrayList<String>();
        questionChoices18.add("1");
        questionChoices18.add("2");
        questionChoices18.add("Infinite");
        questionChoices18.add("7");
        questionChoices18.add("3");
        Question sportsQuestion2 = new Question("Sports", "How many NFL teams play in New Jersey and New York?", questionChoices18, "3", "The Giants and Jets both play in New Jersey, but are New York based. The Buffalo Bills are the only team that actually plays in New York.");
        questions.add(sportsQuestion2);

        ArrayList<String> questionChoices19 = new ArrayList<String>();
        questionChoices19.add("50");
        questionChoices19.add("100");
        questionChoices19.add("75");
        questionChoices19.add("60");
        Question sportsQuestion3 = new Question("Sports", "How many points did Kobe Bryant score in his last NBA game?", questionChoices19, "60", "Kobe scored over 60 five times during his career.");
        questions.add(sportsQuestion3);

        ArrayList<String> questionChoices20 = new ArrayList<String>();
        questionChoices20.add("28");
        questionChoices20.add("7");
        questionChoices20.add("23");
        questionChoices20.add("13");
        Question sportsQuestion4 = new Question("Sports", "How many gold medals has Michael Phelps been awarded in his olympic career?", questionChoices20, "23", "Michael Phelps is the most successful olympian for owning the most medals and most gold medals of any athlete.");
        questions.add(sportsQuestion4);

        ArrayList<String> questionChoices21 = new ArrayList<String>();
        questionChoices21.add("Michael Jordan");
        questionChoices21.add("Magic Johnson");
        questionChoices21.add("Bill Russell");
        questionChoices21.add("LeBron James");
        Question sportsQuestion5 = new Question("Sports", "What player has the most NBA Championships in NBA History?", questionChoices21, "Bill Russell", "Bill Russell won the NBA championship 11 times in his career!");
        questions.add(sportsQuestion5);


        ArrayList<String> questionChoices22 = new ArrayList<String>();
        questionChoices22.add("Venus Williams");
        questionChoices22.add("Roger Federer");
        questionChoices22.add("Rafael Nadal");
        questionChoices22.add("Serena Williams");
        questionChoices22.add("Novak Djokovic");
        Question sportsQuestion6 = new Question("Sports", "Who has earned more Grand Slam single titles during the open era in tennis.", questionChoices22, "Serena Williams", "Serena and Her Sister Venus won 14 Grand Slam Doubles titles and three doubles gold medals at the Olympics.");
        questions.add(sportsQuestion6);

    }
}





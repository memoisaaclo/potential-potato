package com.company;
/*
 * Isaac Lo - iilo
 * 202102 CIS171 22832
 * 3/8/21
 */

import java.util.Scanner;

public class TextQuestLo {
    /*
     *  This is a text-based fighting game where the user faces randomly generated enemies.
     */

    public static int battle(int health, int battlesCompleted, int fireBoost, int waterBoost, int airBoost){
        Scanner in = new Scanner(System.in);
        /*
         * This method is called for every battle, it outputs the players health after the battle
         * It also contains logic that pseudo randomly draws one of five enemies. These enemies vary in power.
         * This variance in power is amplified as battles are completed.
         */
        // Initialize the name, health, and power of enemies
        String enemyName;
        int enemyDamage;
        int enemyHealth;
        // These boosts will lesson or strengthen an enemies card power per element. 1 = fire, 2 = water, 3 = air
        int enemy_element_boost1;
        int enemy_element_boost2;
        int enemy_element_boost3;

        // Enemy power and health variance is calculated as a function of 1 out of 3 randomness and battles completed
        int enemyDamageVariance = (int) ((Math.random() / 3) * battlesCompleted);
        int enemyHealthVariance = (int) ((Math.random() / 3) * battlesCompleted);

        // Enemy ID is then randomly selected out of five enemies which chooses the enemy stats
        int enemyID = (int) ((Math.random() * 5) + 1);
        // Enemy stat switch
        switch (enemyID) {
            case 1 -> {
                enemyName = "Slug";
                enemyDamage = 13;
                enemyHealth = 120;
                enemy_element_boost1 = -3;
                enemy_element_boost2 = 3;
                enemy_element_boost3 = -3;
            }
            case 2 -> {
                enemyName = "Jester";
                enemyDamage = 23;
                enemyHealth = 101;
                enemy_element_boost1 = 1;
                enemy_element_boost2 = -2;
                enemy_element_boost3 = 1;
            }
            case 3 -> {
                enemyName = "Nighthawk";
                enemyDamage = 45;
                enemyHealth = 55;
                enemy_element_boost1 = -1;
                enemy_element_boost2 = -4;
                enemy_element_boost3 = 4;
            }
            case 4 -> {
                enemyName = "Warrior";
                enemyDamage = 32;
                enemyHealth = 150;
                enemy_element_boost1 = 1;
                enemy_element_boost2 = 1;
                enemy_element_boost3 = 0;
            }
            case 5 -> {
                enemyName = "Dragon";
                enemyDamage = 99;
                enemyHealth = 200;
                enemy_element_boost1 = 5;
                enemy_element_boost2 = -7;
                enemy_element_boost3 = 1;
            }
            default -> {
                enemyName = "Bacon";
                enemyDamage = 99;
                enemyHealth = 1;
                enemy_element_boost1 = 3;
                enemy_element_boost2 = 3;
                enemy_element_boost3 = 3;
            }
        }

        // Display enemy identification and battle initiation text
        System.out.printf("A %s with %s health and %s power appears!%n%n", enemyName, enemyHealth, enemyDamage);

        // Allow user to catch up
        System.out.print("Enter any key to continue... ");
        in.nextLine();

        // Change the power variance if applicable
        if (enemyHealthVariance > 0){
            enemyHealth += enemyHealthVariance;
            System.out.printf("Rats! The %s's health has been powered up by %s units!%n", enemyName, enemyHealthVariance);
        }
        if (enemyDamageVariance > 0){
            enemyDamage += enemyDamageVariance;
            System.out.printf("Barnacles! The %s's power has been amplified up by %s units!%n", enemyName, enemyDamageVariance);
        }

        // Main battle loop
        while ((health > 0) && (enemyHealth > 0)){
            // Display player and enemy stats
            System.out.printf("You have %s hp.%n", health);
            System.out.printf("The %s has %s hp.%n%n", enemyName,enemyHealth);

            // Randomly generate enemy and player element power between 1 and 10;
            int enemy_power_1 = (int) (Math.random() * 10) + 1;
            int enemy_power_2 = (int) (Math.random() * 10) + 1;
            int enemy_power_3 = (int) (Math.random() * 10) + 1;
            int player_power_1 = (int) (Math.random() * 10) + 1;
            int player_power_2 = (int) (Math.random() * 10) + 1;
            int player_power_3 = (int) (Math.random() * 10) + 1;
            // Add attribute boosts also (enemies get experience boosts too)
            enemy_power_1 += enemy_element_boost1 + (battlesCompleted / 7);
            enemy_power_2 += enemy_element_boost2 + (battlesCompleted / 7);
            enemy_power_3 += enemy_element_boost3 + (battlesCompleted / 7);
            player_power_1 += fireBoost;
            player_power_2 += waterBoost;
            player_power_3 += airBoost;
            // reset enemy cards to be greater than or equal to one
            if (enemy_power_1 < 0) enemy_power_1 = 0;
            if (enemy_power_2 < 0) enemy_power_2 = 0;
            if (enemy_power_3 < 0) enemy_power_3 = 0;

            // Display enemy choices
            System.out.println("Here are the enemies cards!");
            System.out.println("Card 1: ");
            drawCard(enemy_power_1, 1);
            System.out.println("Card 2: ");
            drawCard(enemy_power_2, 2);
            System.out.println("Card 3: ");
            drawCard(enemy_power_3, 3);

            // Allow user to catch up
            System.out.print("Enter any key to continue... ");
            in.nextLine();

            // Display player choices
            System.out.println("Here are your cards!");
            System.out.println("Card 1: ");
            drawCard(player_power_1, 1);
            System.out.println("Card 2: ");
            drawCard(player_power_2, 2);
            System.out.println("Card 3: ");
            drawCard(player_power_3, 3);

            // Player choice loop
            boolean validMove = false;
            int playerChoice = 0;
            do {
                System.out.print("Pick your card ('1', '2', or '3'): ");
                try{
                    playerChoice = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e){
                    continue;
                }
                if(playerChoice == 1 || playerChoice == 2 || playerChoice == 3) validMove = true;
            } while (!validMove);

            // Enemy choice random generation between 1 and 3
            int enemyChoice = (int) (Math.random() * 3) + 1;
            
            // get user and enemy card powers to display
            int player_cardPower;
            if (playerChoice == 1) player_cardPower = player_power_1;
            else if (playerChoice == 2) player_cardPower = player_power_2;
            else player_cardPower = player_power_3;
            
            int enemy_cardPower;
            if (enemyChoice == 1) enemy_cardPower = enemy_power_1;
            else if (enemyChoice == 2) enemy_cardPower = enemy_power_2;
            else enemy_cardPower = enemy_power_3;

            // Display player and enemy choices
            System.out.printf("You pick a %s card with a power of %s.%n", intToElement(playerChoice), player_cardPower);
            System.out.printf("%s picks a %s card with a power of %s.%n%n", enemyName, intToElement(enemyChoice), enemy_cardPower);

            // Main turn logic,
            // elementWinner int is set: 2, indicates a draw, 1 indicates a user turn win, 0 the enemy wins that turn
            int elementWinner = 1; // player is default elementWinner this saves time in 'if' tree

            // choice 1 represents fire, 2 indicates water, 3 indicates air
            if (playerChoice == 1) {
                if (enemyChoice == 2) elementWinner = 0; // if you choose fire and they choose water, they win
                else if (enemyChoice == 1) elementWinner = 2; // Draw
            }
            else if (playerChoice == 2) {
                if (enemyChoice == 3) elementWinner = 0; // if you choose water and they choose air, they win
                else if (enemyChoice == 2) elementWinner = 2; // Draw
            }
            else {
                if (enemyChoice == 1) elementWinner = 0; // if you choose air and they choose fire, they win
                else if (enemyChoice == 3) elementWinner = 2; // Draw
            }

            // element winner is assigned advantage, and display final card powers
            if (elementWinner == 1) {
                player_cardPower += 6;
                System.out.printf("You win the element advantage and boosting your card power to %s.%n%n", player_cardPower);
            }
            else if (elementWinner == 0) {
                enemy_cardPower += 6;
                System.out.printf("%s wins the element advantage and boosting his card power to %s.%n%n", enemyName, enemy_cardPower);
            } else {
                System.out.println("No element advantage this turn.");
            }

            // winner is decided by whose card power with element advantage is greater. 1 = player, 0 = enemy
            int winner = 1; // default is player
            if (player_cardPower < enemy_cardPower) winner = 0;

            // Display final card powers
            System.out.printf("Your final card power: %s%n", player_cardPower);
            System.out.printf("%s final card power: %s%n%n", enemyName, enemy_cardPower);

            if (winner == 1) {
                // damage is calculated through a base 50 plus randomly generated values affected by the num enemies faced
                //                                  this means it will be more likely to get a boost as you win more
                int damage = (int) (50 + ((Math.random() * (1 - (1 / battlesCompleted)))) * battlesCompleted);
                enemyHealth -= damage;
                if (enemyHealth < 0) enemyHealth = 0;  // get rid of negative health values if applicable

                System.out.printf("You win the round and inflict %s damage!%n", damage);
                System.out.printf("Enemy has %s health left!%n%n", enemyHealth);
            } else {
                health -= enemyDamage;
                if (health < 0) health = 0;  // get rid of negative health values if applicable

                System.out.printf("%s wins the round and inflicts %s damage!%n", enemyName, enemyDamage);
                System.out.printf("You have %s health left!%n%n", health);
            }
            // Allow user to catch up
            System.out.print("Enter any key to continue... ");
            in.nextLine();
        }

        if (health > 0) System.out.printf("You defeated the %s!!!%n%n", enemyName); //Win message
        return health;
    }
    
    public static void drawCard(int cardPower, int elementNum){
        // pick element string based on element num
        String element = intToElement(elementNum);
        
        // This method creates a card graphic with given stats
        for(int i = 0; i < 16; i++) System.out.print('_');
        System.out.println();
        System.out.printf("| %5s  %5s |%n", element, cardPower );
        for(int i = 0; i < 16; i++) System.out.print('¯');
        System.out.println();
    }

    public static String returnQuote(int quoteInt) {
        return switch (quoteInt) {
            case 1 -> "Understandable, have a nice day.";
            case 2 -> "You win some and you lose a lot.";
            case 3 -> "At least you tried! Next time don't lose.";
            case 4 -> "Everyone has lost once! Don't let it keep you down";
            case 5 -> "Uyuh chico, trabaja mas duro proxima tiempo.";
            default -> "Bacon get you again? It is pretty good.";
        };
    }

    public static String intToElement(int elementNum){
        /*
         * this method takes a int (1-3) and outputs a element name
         */
        String element;
        switch (elementNum){ // Save the player decision as a string
            case 1 -> element = "FIRE";
            case 2 -> element = "WATER";
            case 3 -> element = "AIR";
            default -> element = "BACON";
        }
        return element;
    }
    
    public static void main(String[] args){
        // Create scanner to receive input
        Scanner in = new Scanner(System.in);

        // Create and initialize player stats
        int MAX_HEALTH = 100;
        final int STARTING_NUM_HEALTH_POTIONS = 3;

        int playerHealth = MAX_HEALTH;
        int healthPotions = STARTING_NUM_HEALTH_POTIONS;
        int enemiesFaced = 0;

        int fireBoost = 0;
        int waterBoost = 0;
        int airBoost = 0;

        // Initiate welcome.
        System.out.println();
        System.out.println("Welcome to Text Quest!");
        System.out.println("In this game you will be able to choose from three attack card elements.");
        System.out.println("The cards will always be either water, fire, or air, but their power will vary.");
        System.out.println("Larger power wins over lower, the element advantage adds 6 card power to an attack. (Player always wins power draws.)");
        System.out.println("Fire beats air, air beats water, and water beats fire.");
        System.out.println("You may use full heal potions outside of the battle. You start with three.");
        System.out.println();

        // Allow user to slow down
        System.out.print("Understand: ");
        in.nextLine();

        System.out.println("Nevertheless, we continue on!");
        System.out.println();
        System.out.println();

        // Main game loop
        do{
            enemiesFaced++;
            playerHealth = battle(playerHealth, enemiesFaced, fireBoost, waterBoost, airBoost);


            // After battle rewards if you survive the battle
            if (playerHealth > 0){
                // Allow user to boost certain elements, if they defeated 3, 7, 12, 17, 23, 32 enemies or a multiple of 10. (and if alive)
                if (enemiesFaced == 3 || enemiesFaced == 7 || enemiesFaced == 17 || enemiesFaced == 32 || enemiesFaced % 10 == 0){
                    System.out.println();
                    System.out.println("---ATTRIBUTE BOOST ACQUIRED---");

                    // do while loop to force the user to input valid data
                    boolean valid = false;
                    do {
                        System.out.printf("Add to Fire (lvl %s), Water (lvl %s), or Air (lvl %s) ('1', '2', or '3'): ", fireBoost, waterBoost, airBoost);
                        int element;
                        try{
                            element = Integer.parseInt(in.nextLine());
                            if (element == 1) fireBoost++;
                            else if (element == 2) waterBoost++;
                            else airBoost++;
                        } catch (NumberFormatException e) {
                            continue;
                        }
                        if (element == 1 || element == 2 || element == 3) valid = true;
                    } while(!valid);
                    System.out.printf("Splendid, Fire Boost: %s, Water Boost: %s, Air Boost: %s%n%n", fireBoost, waterBoost, airBoost);
                }
                // Add to max health per 3 battles and if alive
                if (enemiesFaced % 3 == 0) {
                    MAX_HEALTH += 10;
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Fantastic! You are granted a max health boost!");
                    System.out.printf("Max health: %shp; Current health: %s%n", MAX_HEALTH, playerHealth);
                    System.out.println("--------------------------------------------------------");
                    System.out.println();
                }
                if (enemiesFaced % 5 == 0) {
                    // if faced enemies is a factor of five and has health give them an extra health potion
                    healthPotions++;
                    System.out.println("------------------------------------");
                    System.out.println("Bravo! You receive a health potion!");
                    System.out.println("------------------------------------");
                    System.out.println();
                }
                // If applicable run potion prompt. If wanted, will full heal player
                if ((healthPotions > 0) && (playerHealth < MAX_HEALTH)) {
                    System.out.printf("You have %s health. Would you like to use a health potion? %nYou have %s health potions.%n", playerHealth, healthPotions);
                    System.out.print("Y/N: ");
                    if (in.nextLine().toLowerCase().equals("y")) {
                        playerHealth = MAX_HEALTH;
                        healthPotions--;

                        System.out.println("Health full.");
                        System.out.println();
                    }
                }
            }

        } while (playerHealth > 0);

        // Death script
        System.out.println();
        System.out.println("GAME OVER...");
        // Allow user to catch up
        System.out.print("Enter any key to continue... ");
        in.nextLine();

        // print random quote
        int quoteInt = (int) (Math.random() * 5) + 1;
        System.out.println("--------------------------------------------");
        System.out.printf("\"%s\"%n", returnQuote(quoteInt));
        System.out.println("--------------------------------------------");
        System.out.println("You have been defeated!");
        System.out.printf("Enemies faced: %s", enemiesFaced);
        System.out.println();

        // Retry script
        System.out.print("Want to try again? Y/N: ");
        if (in.nextLine().toLowerCase().equals("y")) main(new String[0]);
    }
}

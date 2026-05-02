package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for Homework 10 — The Adventurers' Guild: Iterator + Mediator.
 *
 * The scaffold prints the banner only; students fill in the guild demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");

        // 1. Create at least 2 heroes.
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Arthur", 150, 25, 15));
        heroes.add(new Hero("Merlin", 90, 200, 10, 5, 100));

        // 2. Build a QuestLog with at least 5 quests of mixed priority.
        QuestLog questLog = new QuestLog();
        questLog.add(new Quest("Goblin Camp", QuestPriority.NORMAL, 100, false));
        questLog.add(new Quest("Dragon Hoard", QuestPriority.URGENT, 5000, true));
        questLog.add(new Quest("Lost Kitten", QuestPriority.LOW, 10, false));
        questLog.add(new Quest("Bandit Raid", QuestPriority.HIGH, 300, true));
        questLog.add(new Quest("Deliver Letter", QuestPriority.LOW, 5, false));

        // 3. Register at least 4 GuildMembers (Quartermaster, Scout, Healer, Captain) on the GuildHall.
        GuildHall hall = new GuildHall();
        Quartermaster quartermaster = new Quartermaster("Gimli", hall);
        Scout scout = new Scout("Legolas", hall);
        Healer healer = new Healer("Elrond", hall);
        Captain captain = new Captain("Aragorn", hall);

        hall.register(quartermaster);
        hall.register(scout);
        hall.register(healer);
        hall.register(captain);

        // 4. Iterate the quest log with at least 2 different QuestIterator implementations.
        // 5. Dispatch coordinating messages through the mediator during quest planning.
        // 6. Run the CouncilEngine and print a final CouncilRunResult.
    }
}
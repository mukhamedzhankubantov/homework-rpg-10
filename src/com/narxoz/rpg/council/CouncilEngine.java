package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;
import java.util.List;

/**
 * Orchestrates a planning session that uses both Iterator and Mediator.
 */
public class CouncilEngine {

    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildMediator hall) {
        // TODO: walk questLog with at least 2 different iterators,
        //       dispatch coordinating messages through hall for each quest,
        //       and return counters (questsTraversed, messagesRouted, membersNotified).
        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 0;

        QuestIterator orderedIter = questLog.ordered();
        while (orderedIter.hasNext()) {
            Quest quest = orderedIter.next();
            questsTraversed++;
            hall.dispatch("scouting", null, quest.getTitle());
            messagesRouted++;
        }

        QuestIterator highPriorityIter = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (highPriorityIter.hasNext()) {
            Quest quest = highPriorityIter.next();
            questsTraversed++;
            hall.dispatch("urgent", null, quest.getTitle());
            messagesRouted++;
        }

        return new CouncilRunResult(questsTraversed, messagesRouted, membersNotified);
    }
}
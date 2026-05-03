package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class RewardSortedQuestIterator implements QuestIterator {

    private final List<Quest> snapshot;
    private int cursor;

    public RewardSortedQuestIterator(QuestLog questLog) {
        this.snapshot = new ArrayList<>();
        for (Quest q : questLog.snapshot()) {
            this.snapshot.add(q);
        }
        this.snapshot.sort((q1, q2) -> Integer.compare(q2.getRewardGold(), q1.getRewardGold()));
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) return null;
        return snapshot.get(cursor++);
    }
}
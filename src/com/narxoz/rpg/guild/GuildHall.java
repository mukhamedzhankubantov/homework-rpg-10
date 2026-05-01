package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Topic-based mediator for the Adventurers' Guild war council.
 */
public class GuildHall implements GuildMediator {

    private final Map<String, List<GuildMember>> membersByTopic = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        // TODO: add the member to the topic lists it should receive.
        if (member instanceof Captain) {
            addSubscriber("orders", member);
            addSubscriber("urgent", member);
        } else if (member instanceof Scout) {
            addSubscriber("scouting", member);
            addSubscriber("orders", member);
        } else if (member instanceof Healer) {
            addSubscriber("healing", member);
            addSubscriber("urgent", member);
        } else if (member instanceof Quartermaster) {
            addSubscriber("supplies", member);
            addSubscriber("rewards", member);
        }
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        // TODO: notify registered members for the topic without direct colleague calls.
        List<GuildMember> subscribers = subscribersFor(topic);
        for (GuildMember member : subscribers) {
            if (member != from) {
                member.receive(topic, from, payload);
            }
        }
    }

    protected void addSubscriber(String topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, key -> new ArrayList<>()).add(member);
    }

    protected List<GuildMember> subscribersFor(String topic) {
        return membersByTopic.getOrDefault(topic, List.of());
    }
}

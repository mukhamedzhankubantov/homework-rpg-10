package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for wounds, potions, and recovery plans.
 */
public class Healer extends GuildMember {

    public Healer(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void prepareAid(String topic, String payload) {
        // TODO: send a healing message through the mediator.
        System.out.println("[Healer " + getName() + "] Sending recovery plan for: " + topic);
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        // TODO: react to a guild-hall message without calling another colleague directly.
        String sender = (from != null) ? from.getName() : "The Council";
        System.out.println("[Healer " + getName() + "] Preparing supplies for " + sender + "'s request: " + payload);
    }
}
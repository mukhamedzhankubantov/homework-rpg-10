package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for ancient history, curses, and magical lore.
 */
public class Loremaster extends GuildMember {

    public Loremaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void shareLore(String topic, String payload) {
        System.out.println("[Loremaster " + getName() + "] Sharing ancient knowledge on: " + topic);
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Loremaster " + getName() + "] Recording lore from " + from.getName() + " on " + topic + ": " + payload);
    }
}
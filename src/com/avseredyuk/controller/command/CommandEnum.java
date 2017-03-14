package com.avseredyuk.controller.command;

/**
 * Created by Anton_Serediuk on 3/14/2017.
 */
public enum CommandEnum {
    LIST_PRODUCTS(new String[] {"l", "list"}),
    SELECT_PRODUCT(new String[] {"s", "select"});

    private String[] commandsMap;

    CommandEnum(String[] commandsMap) {
        this.commandsMap = commandsMap;
    }

    public String[] getCommandsMap() {
        return this.commandsMap;
    }
}

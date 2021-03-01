package nl.roboticsmilan.project2020.Data;

public enum Achievement {

    HANS("Welkom in Hans zijn DeveloperHuis", "Je hebt hans zijn developers huis bezocht", "HUISHANS", 10),
    VISBOERHENK("Wil jij een lekker visje kopen?", "Je hebt Visboer henk bezocht", "VISBOERHENK", 20);


    String name;
    String description;
    String id;
    int coins;

    private Achievement(String name, String description, String id, int coins) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCoins() {
        return coins;
    }

    public String getId() {
        return id;
    }
}

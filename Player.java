public class Player {
    private String name;
    private String position;
    private int jerseyNumber;

    public Player(String name, String position, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + name + '\'' +
                ", Position='" + position + '\'' +
                ", Jersey Number=" + jerseyNumber +
                '}';
    }
}

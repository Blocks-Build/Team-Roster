import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;

    public Team() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(int jerseyNumber) {
        players.removeIf(player -> player.getJerseyNumber() == jerseyNumber);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}

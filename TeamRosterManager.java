import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamRosterManager {
    private Team team = new Team();
    private JTextArea rosterDisplay;

    public static void main(String[] args) {
        // Create the application frame
        SwingUtilities.invokeLater(() -> {
            new TeamRosterManager().createAndShowGUI();
        });
    }

    // Create the GUI
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Team Roster Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // UI Components
        JLabel nameLabel = new JLabel("Player Name:");
        JTextField nameInput = new JTextField(15);
        JLabel positionLabel = new JLabel("Position:");
        JTextField positionInput = new JTextField(15);
        JLabel jerseyLabel = new JLabel("Jersey Number:");
        JTextField jerseyInput = new JTextField(5);
        
        JButton addButton = new JButton("Add Player");
        JButton removeButton = new JButton("Remove Player");
        JButton viewRosterButton = new JButton("View Roster");

        rosterDisplay = new JTextArea(10, 30);
        rosterDisplay.setEditable(false);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPlayer(nameInput, positionInput, jerseyInput);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePlayer(jerseyInput);
            }
        });

        viewRosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRoster();
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.add(nameLabel);
        panel.add(nameInput);
        panel.add(positionLabel);
        panel.add(positionInput);
        panel.add(jerseyLabel);
        panel.add(jerseyInput);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(viewRosterButton);
        
        // Add the panel and text area to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(new JScrollPane(rosterDisplay), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Methods to handle player actions
    private void addPlayer(JTextField nameInput, JTextField positionInput, JTextField jerseyInput) {
        String name = nameInput.getText();
        String position = positionInput.getText();
        int jerseyNumber;

        try {
            jerseyNumber = Integer.parseInt(jerseyInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid jersey number.");
            return;
        }

        Player player = new Player(name, position, jerseyNumber);
        team.addPlayer(player);

        nameInput.setText("");
        positionInput.setText("");
        jerseyInput.setText("");

        viewRoster(); // Refresh roster display
    }

    private void removePlayer(JTextField jerseyInput) {
        int jerseyNumber;

        try {
            jerseyNumber = Integer.parseInt(jerseyInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid jersey number.");
            return;
        }

        team.removePlayer(jerseyNumber);
        jerseyInput.setText("");

        viewRoster(); // Refresh roster display
    }

    private void viewRoster() {
        rosterDisplay.setText("");
        if (team.getPlayers().isEmpty()) {
            rosterDisplay.append("No players in the team.\n");
        } else {
            for (Player player : team.getPlayers()) {
                rosterDisplay.append(player.toString() + "\n");
            }
        }
    }
}

package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerStatsScreen extends JPanel
{
    int playerHP = 100, playerDMG = 25, playerPotion = 10, enemyHP = 50, enemyDMG = 15;
    String playerWeapon = "Fist of the North Star +2";
    String playerName = "Great Arshad";
    String enemyName = "Wild Boar";
    String enemyWeapon = "Horn Wrath";
    String enemyType = "Forest Beast";

    private JPanel playerStatsImagePanel, playerStatsSizePanel, enemyStatsSizePanel;
    private JLabel playerStatsImageLabel, playerHPLabel, playerWeaponLabel, playerDMGLabel, playerHPNumberLabel, playerPotionLabel, playerDMGNumberLabel,
                    playerWeaponNameLabel, playerPotionNumberLabel, playerNameLabel, playerDisplayNameLabel, enemyNameLabel, enemyDisplayNameLabel,
                    enemyHPLabel, enemyHPNumberLabel, enemyDMGLabel, enemyDMGNumberLabel, enemyWeaponLabel, enemyWeaponNameLabel, enemyTypeLabel, enemyTypeNameLabel;

    private ImageIcon playerStatsAreaImage;
    private Font playerStatsFont = new Font("Times New Roman", Font.PLAIN, 18);

    public PlayerStatsScreen()
    {
        //This adds the player stat's field to the screen
        playerStatsImagePanel = new JPanel();
        playerStatsImagePanel.setBounds(480, 480, 480, 480);
        playerStatsImagePanel.setLayout(new BorderLayout());
        add(playerStatsImagePanel);

        //This adds a background to the player stats field.
        playerStatsImageLabel = new JLabel();
        playerStatsAreaImage = new ImageIcon(".//res//playerStatsPanel.png");
        playerStatsImageLabel.setIcon(playerStatsAreaImage);
        playerStatsImageLabel.setLayout(new GridLayout(1,2));
        playerStatsImagePanel.add(playerStatsImageLabel);

        //This is creating a new Panel for custom size layouts rather than using the image label panel
        playerStatsSizePanel = new JPanel();
        playerStatsSizePanel.setBorder(new EmptyBorder(10,20,10,10));
        playerStatsSizePanel.setOpaque(false);
        playerStatsSizePanel.setLayout(new GridLayout(5,2));

        playerStatsImageLabel.add(playerStatsSizePanel);

        //This is setting up the stats area for the game

        //Add Player Name
        playerNameLabel = new JLabel("Player Name: ");
        playerNameLabel.setFont(playerStatsFont);
        playerNameLabel.setForeground(Color.LIGHT_GRAY);
        playerStatsSizePanel.add(playerNameLabel);

        playerDisplayNameLabel = new JLabel(playerName);
        playerDisplayNameLabel.setFont(playerStatsFont);
        playerDisplayNameLabel.setForeground(Color.DARK_GRAY);
        playerStatsSizePanel.add(playerDisplayNameLabel);

        //Add Player HP
        playerHPLabel = new JLabel("Player Vitality: ");
        playerHPLabel.setFont(playerStatsFont);
        playerHPLabel.setForeground(Color.lightGray);
        playerStatsSizePanel.add(playerHPLabel);

        playerHPNumberLabel = new JLabel("" + playerHP);
        playerHPNumberLabel.setFont(playerStatsFont);
        playerHPNumberLabel.setForeground(Color.DARK_GRAY);
        playerStatsSizePanel.add(playerHPNumberLabel);

        //Add player Damage
        playerDMGLabel = new JLabel("Player Damage: ");
        playerDMGLabel.setFont(playerStatsFont);
        playerDMGLabel.setForeground(Color.LIGHT_GRAY);
        playerStatsSizePanel.add(playerDMGLabel);

        playerDMGNumberLabel = new JLabel("" + playerDMG);
        playerDMGNumberLabel.setFont(playerStatsFont);
        playerDMGNumberLabel.setForeground(Color.DARK_GRAY);
        playerStatsSizePanel.add(playerDMGNumberLabel);

        //Add Player Weapon
        playerWeaponLabel = new JLabel("Player Weapon: ");
        playerWeaponLabel.setFont(playerStatsFont);
        playerWeaponLabel.setForeground(Color.LIGHT_GRAY);
        playerStatsSizePanel.add(playerWeaponLabel);

        playerWeaponNameLabel = new JLabel("" + playerWeapon);
        playerWeaponNameLabel.setFont(playerStatsFont);
        playerWeaponNameLabel.setForeground(Color.DARK_GRAY);
        playerStatsSizePanel.add(playerWeaponNameLabel);

        //Add Player Potion count
        playerPotionLabel = new JLabel("Player's Potions: ");
        playerPotionLabel.setFont(playerStatsFont);
        playerPotionLabel.setForeground(Color.LIGHT_GRAY);
        playerStatsSizePanel.add(playerPotionLabel);

        playerPotionNumberLabel = new JLabel("" + playerPotion);
        playerPotionNumberLabel.setFont(playerStatsFont);
        playerPotionNumberLabel.setForeground(Color.DARK_GRAY);
        playerStatsSizePanel.add(playerPotionNumberLabel);

        //This is for the Enemy Stats
        enemyStatsSizePanel = new JPanel();
        enemyStatsSizePanel.setLayout(new GridLayout(5,2));
        enemyStatsSizePanel.setBorder(new EmptyBorder(10,20,10,10));
        enemyStatsSizePanel.setOpaque(false);
        playerStatsImageLabel.add(enemyStatsSizePanel);

        //Add Player Name
        enemyNameLabel = new JLabel("Enemy Name: ");

        enemyNameLabel.setFont(playerStatsFont);
        enemyNameLabel.setForeground(Color.LIGHT_GRAY);
        enemyStatsSizePanel.add(enemyNameLabel);

        enemyDisplayNameLabel = new JLabel(enemyName);
        enemyDisplayNameLabel.setFont(playerStatsFont);
        enemyDisplayNameLabel.setForeground(Color.DARK_GRAY);
        enemyStatsSizePanel.add(enemyDisplayNameLabel);

        //Add Player HP
        enemyHPLabel = new JLabel("Enemy Vitality: ");
        enemyHPLabel.setFont(playerStatsFont);
        enemyHPLabel.setForeground(Color.lightGray);
        enemyStatsSizePanel.add(enemyHPLabel);

        enemyHPNumberLabel = new JLabel("" + enemyHP);
        enemyHPNumberLabel.setFont(playerStatsFont);
        enemyHPNumberLabel.setForeground(Color.DARK_GRAY);
        enemyStatsSizePanel.add(enemyHPNumberLabel);

        //Add player Damage
        enemyDMGLabel = new JLabel("Enemy Damage: ");
        enemyDMGLabel.setFont(playerStatsFont);
        enemyDMGLabel.setForeground(Color.LIGHT_GRAY);
        enemyStatsSizePanel.add(enemyDMGLabel);

        enemyDMGNumberLabel = new JLabel("" + enemyDMG);
        enemyDMGNumberLabel.setFont(playerStatsFont);
        enemyDMGNumberLabel.setForeground(Color.DARK_GRAY);
        enemyStatsSizePanel.add(enemyDMGNumberLabel);

        enemyWeaponLabel = new JLabel("Enemy Weapon: ");
        enemyWeaponLabel.setFont(playerStatsFont);
        enemyWeaponLabel.setForeground(Color.LIGHT_GRAY);
        enemyStatsSizePanel.add(enemyWeaponLabel);

        enemyWeaponNameLabel = new JLabel(enemyWeapon);
        enemyWeaponNameLabel.setFont(playerStatsFont);
        enemyWeaponNameLabel.setForeground(Color.DARK_GRAY);
        enemyStatsSizePanel.add(enemyWeaponNameLabel);

        enemyTypeLabel = new JLabel("Enemy Type: ");
        enemyTypeLabel.setFont(playerStatsFont);
        enemyTypeLabel.setForeground(Color.LIGHT_GRAY);
        enemyStatsSizePanel.add(enemyTypeLabel);

        enemyTypeNameLabel = new JLabel(enemyType);
        enemyTypeNameLabel.setFont(playerStatsFont);
        enemyTypeNameLabel.setForeground(Color.DARK_GRAY);
        enemyStatsSizePanel.add(enemyTypeNameLabel);
    }
}

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChangeLevel implements ItemListener {
    private GameState gameState;
    private Manager manager;

    public ChangeLevel(GameState gameState, Manager manager)
    {
        this.gameState=gameState;
        this.manager=manager;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        manager.resetBoard(gameState);
        manager.setLevelFromComboBox(gameState);
    }
}

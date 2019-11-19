package control.command;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.GameController;

public class GameFluxInvoker {
	
	private Map<String, Class<? extends Command>> commands = new HashMap<>();
	
	private List<Command> imediatos = new ArrayList<>();
	private List<Command> all = new ArrayList<>();
	
	public static GameFluxInvoker instance;

	private GameFluxInvoker() {
		super();
		commands.put("selectCard", SelectCardCommand.class);
		commands.put("selectDice", SelectDiceCommand.class);
	}

	public synchronized static GameFluxInvoker getInstance() {
		if(instance == null) {
			instance = new GameFluxInvoker();
			return instance;
		}else {
			return instance; 
		}
	}
	
	public void add(Command com) {
		imediatos.add(com);
	}
	
	public void execute() {
		for (Command com:imediatos) {
			com.execute();
			all.add(com);
		}
		imediatos.clear();
	}
	
	public void undo() {
		Command comm = all.remove(all.size()-1);
		comm.undo();
		
	}
	
	public Class<? extends Command> getCommand(String key) {
		return commands.get(key);
		
	}
	
	
	public void execute(String keyCommand, GameController classParameter, int index) {
		Class<? extends Command> commandCard = getCommand(keyCommand);
		Constructor<? extends Command> constr;
		try {
			constr = commandCard.getConstructor(GameController.class, int.class);
			Command c = constr.newInstance(classParameter, index);
			
			add(c);
			
//			c.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public void undo(String keyCommand, GameController classParameter, int index) {
		Class<? extends Command> commandCard = getCommand(keyCommand);
		Constructor<? extends Command> constr;
		try {
			constr = commandCard.getConstructor(GameController.class, int.class);
			Command c = constr.newInstance(classParameter, index);
			c.undo();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}

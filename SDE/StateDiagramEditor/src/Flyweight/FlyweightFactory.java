package Flyweight;

import java.util.HashMap;

import Strategy.DrawStrategy;
import Strategy.StateDrawStrategy;
import Strategy.StateDrawStrategy2;
import Strategy.TransitionDrawStrategy;

public class FlyweightFactory {
	
	static FlyweightFactory instance = new FlyweightFactory();
	static final HashMap<String , DrawStrategy> flyweightPool= new HashMap<String, DrawStrategy>();
	//singleton
	public static FlyweightFactory getInstance() {
		return instance;
	}
	
	public static DrawStrategy getStrategy(String name) {	
		if(flyweightPool.containsKey(name)) {
			return (DrawStrategy) flyweightPool.get(name);
		}else{
			if(name.equals("state")) {
				StateDrawStrategy s = new StateDrawStrategy();
				flyweightPool.put(name, s);
				System.out.println("fly1");
				return (StateDrawStrategy) s;
			}else if(name.equals("state2")){
				StateDrawStrategy2 s = new StateDrawStrategy2();
				flyweightPool.put(name, s);
				System.out.println("fly1");
				return (StateDrawStrategy2) s;
			}else{
				TransitionDrawStrategy t = new TransitionDrawStrategy();
				flyweightPool.put(name, t);
				System.out.println("fly2");
				return (TransitionDrawStrategy) t;
			}
		}
	} 
}

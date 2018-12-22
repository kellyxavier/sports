import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Sports
{
	public static void changeJOP()
	{
		UIManager.put("Label.font", new FontUIResource 
				(new Font("Tempus Sans ITC", Font.BOLD, 18)));
		UIManager.put("OptionPane.messageForeground",Color.green);
		UIManager.put("TextField.background", Color.black);
		UIManager.put("TextField.font", new FontUIResource
				(new Font("Dialog", Font.ITALIC, 18)));
		UIManager.put("TextField.foreground", Color.green);
		UIManager.put("Panel.background",Color.black);
		UIManager.put("OptionPane.background", Color.black);
		UIManager.put("Button.background",new Color(0,0,255));
		UIManager.put("Button.foreground", new Color(255,255,255));
		UIManager.put("Button.font", new FontUIResource	
				(new Font("Tempus Sans ITC", Font.BOLD, 14)));
	}
	public static int menu1()
	{
		String [] options = { "Football", "Basketball", "Baseball", 
				"Hockey", "Quit"};
		int response = JOptionPane.showOptionDialog(null,
				"Choose a sport", null, 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null,
				options, "Add");
		return response;
	}
	public static int menu2()
	{
		String [] options = { "Print", "Search", "Exit"};
		int response = JOptionPane.showOptionDialog(null,
				"What would you like to do?", null, 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null,
				options, "Add");
		return response;
	}
	public static int menuAN()
	{
		String [] options = { "American League", "National League"};
		int response = JOptionPane.showOptionDialog(null,
				"Choose a league", null, 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null,
				options, "Add");
		return response;
	}
	public static void fillTreeMap(Map<String, String> map, String sport)
	{
		try
		{ 
			Scanner inFile = new Scanner(new File(sport+".txt"));
			while (inFile.hasNext()) 
			{
				String city = inFile.nextLine();
				String mascot = inFile.nextLine();
				map.put(city, mascot);
			}
			inFile.close();
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
	}
	public static int menu3()
	{
		String [] options = { "City", "Mascot"};
		int response = JOptionPane.showOptionDialog(null,
				"Is that a city or mascot?", null, 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null,
				options, "Add");
		return response;
	}
	public static int menu4()
	{
		String [] options = { "Continue Searching", "Exit"};
		int response = JOptionPane.showOptionDialog(null,
				"Wuold you like to continue searching or exit?", null, 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.PLAIN_MESSAGE, null,
				options, "Add");
		return response;
	}
	public static void searchTreeMap(Map<String, String> map, String sport,
			String league){
		do{
			String data = JOptionPane.showInputDialog("What would you like to search for?");
			int choice3 = menu3();
			if(choice3==0){
				if(map.containsKey(data))
					JOptionPane.showMessageDialog(null, "The " + league + " " + sport.toLowerCase() 
							+ " team mascot for " + data + " is the " + map.get(data) + ".");
				else
					JOptionPane.showMessageDialog(null,data + " does not have a " + sport.toLowerCase() 
							+ " team in the " + league + ".");
			}
			else{
				Iterator <String> itr = map.keySet().iterator();
				String temp;
				String city=null;
				while(itr.hasNext()){
					temp = itr.next();
					if(map.get(temp).equals(data))
						city=temp;
				}
				if(city!=null)
					JOptionPane.showMessageDialog(null,"The home of the " + league + " " 
				+ sport.toLowerCase() + " team the "+ data + " is " + city + ".");
				else
					JOptionPane.showMessageDialog(null,"Sorry, the " + data + " is not a " 
				+ sport.toLowerCase() + " team mascott in the " + league + ".");
			}
		}
		while(menu4()!=1);
	}
	public static void main (String[] args)
	{
		changeJOP();
		Map <String, String> footballMap = new TreeMap <String, String>();
		Map <String, String> basketballMap = new TreeMap <String, String>();
		Map <String, String> baseballALMap = new TreeMap <String, String>();
		Map <String, String> baseballNLMap = new TreeMap <String, String>();
		Map <String, String> hockeyMap = new TreeMap <String, String>();
		int choice1 = menu1();
		while(choice1!=4){
			if(choice1==0){
				fillTreeMap(footballMap, "Football");
				int choice2 = menu2();
				while(choice2!=2){
					if(choice2==0)
						JOptionPane.showMessageDialog(null, 
								footballMap.toString().replace("," , "\n"));
					else
						searchTreeMap(footballMap, "Football", "NFL");
					choice2=menu2();
				}
				choice1=menu1();
			}
			else if(choice1==1){
				fillTreeMap(basketballMap, "Basketball");
				int choice2 = menu2();
				while(choice2!=2){
					if(choice2==0)
						JOptionPane.showMessageDialog(null, 
								basketballMap.toString().replace("," , "\n"));
					else
						searchTreeMap(basketballMap, "Basketball", "NBA");
					choice2=menu2();
				}
				choice1=menu1();
			}
			else if(choice1==2){
				int choiceAN=menuAN();
				if(choiceAN==0){
					fillTreeMap(baseballALMap, "BaseballAL");
					int choice2=menu2();
					while(choice2!=2){
						if(choice2==0)
							JOptionPane.showMessageDialog(null, 
									baseballALMap.toString().replace("," , "\n"));
						else
							searchTreeMap(baseballALMap,"Baseball", "American League");
						choice2=menu2();
					}
				}
				else{
					fillTreeMap(baseballNLMap, "BaseballNL");
					int choice2=menu2();
					while(choice2!=2){
						if(choice2==0)
							JOptionPane.showMessageDialog(null, 
									baseballNLMap.toString().replace("," , "\n"));
						else
							searchTreeMap(baseballNLMap,"Baseball", "National League");
						choice2=menu2();
					}
				}
				choice1=menu1();
			}
			else{
				fillTreeMap(hockeyMap, "Hockey");
				int choice2 = menu2();
				while(choice2!=2){
					if(choice2==0)
						JOptionPane.showMessageDialog(null, 
								hockeyMap.toString().replace("," , "\n"));
					else
						searchTreeMap(hockeyMap,"Hockey","NHL");
					choice2=menu2();
				}
				choice1=menu1();
			}
		}
		System.exit(0);
	}
}
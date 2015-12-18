package JsonClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;

import javax.swing.plaf.SliderUI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFiles {
	public static String HanSolo = "Han Solo";
	public static String LukeSkywaler = "Luke Skywaler";
	public static String LeiaOrgana = "Leia Organa";
	public static String KyloRen = "Kylo Ren";
	public static String Rey = "Rey";
	public static String Finn = "Finn";
	public static String PoeDameron = "Poe Dameron";
	
	public static void main(String[] args) {
		BufferedReader br = null;
		int cont;

		try {
			cont=0;
			String CurrentLine;
			br = new BufferedReader(new FileReader("\\Python27\\trabalhoRedesSociais\\data\\stream_starwars.json"));
			
			while ((CurrentLine = br.readLine().toString()) != null) {
				if(cont==0) {
					JSONParser parser = new JSONParser();
					Object obj = parser.parse(CurrentLine.toString());
					JSONObject jsonObject = (JSONObject) obj;
					
					String txt = (String)jsonObject.get("text");
					System.out.println(txt);
					cont++;
					
				} else if(cont==1) {
					cont = 0;
				}
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void encontraLigacao(String twitter) {
		
	}

}

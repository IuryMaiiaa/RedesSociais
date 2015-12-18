package JsonClass;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFiles {
	public String HanSolo = "Han Solo";
	public String LukeSkywalker = "Luke Skywalker";
	public String Leia = "Leia";
	public String KyloRen = "Kylo Ren";
	public String Rey = "Rey";
	public String Finn = "Finn";
	public String PoeDameron = "Poe Dameron";
	
	public ArrayList<String> palavras = new ArrayList<String>();
	public ArrayList<String> coluna1 = new ArrayList<String> ();
	public ArrayList<String> coluna2 = new ArrayList<String> ();
	
	public void popula(){
	this.palavras.add(this.HanSolo);
	this.palavras.add(this.LukeSkywalker);
	this.palavras.add(this.Finn);
	this.palavras.add(this.KyloRen);
	this.palavras.add(this.Leia);
	this.palavras.add(this.PoeDameron);
	this.palavras.add(this.Rey);
	}
	
	public void encontraLigacao(String twitter) {
		ArrayList <String> mencoes = new ArrayList <String>();
		mencoes = (ArrayList<String>) palavras.clone();
		for(int i=0; i<palavras.size(); i++){
			if (twitter.contains(palavras.get(i))){
				mencoes.remove(palavras.get(i));
				for (int j = 0; j < mencoes.size(); j++) {
					if (twitter.contains(mencoes.get(j))){
						coluna1.add(palavras.get(i).toString());
						coluna2.add(mencoes.get(j).toString());
						 
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BufferedReader br = null;
		ReadFiles rf = new ReadFiles();
		int cont;
		rf.popula();
		

		try {
			cont=0;
			String CurrentLine;
			br = new BufferedReader(new FileReader("C:\\Users\\Lie\\Dropbox\\stream_starwars.json"));
			
			while ((CurrentLine = br.readLine()) != null) {
				if(cont==0) {
					JSONParser parser = new JSONParser();
					Object obj = parser.parse(CurrentLine.toString());
					JSONObject jsonObject = (JSONObject) obj;
					
					String txt = (String)jsonObject.get("text");
					if (txt != null) {
						rf.encontraLigacao(txt);
					} else {
						break;
					}
					
					
					cont++;
					
				} else if(cont==1) {
					cont = 0;
				}
			}
			System.out.println(rf.coluna1.toString());
			System.out.println(rf.coluna2.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}

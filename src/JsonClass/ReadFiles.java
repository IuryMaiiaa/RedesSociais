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
	public String Chewbacca = "Chewbacca";
	public String R2d2 = "R2-D2";
	public String C3po = "C3-PO";
	public String Phasma = "Phasma";
	public String Maz = "Maz Kanata";
	public String Snoke = "Snoke";
	public String Hux = "Hux";
	
	public ArrayList<String> palavras = new ArrayList<String>();
	public ArrayList<String> coluna1 = new ArrayList<String> ();
	public ArrayList<String> coluna2 = new ArrayList<String> ();
	public ArrayList<Peso> relacoes = new ArrayList<Peso> ();
	
	public void popula(){
	this.palavras.add(this.HanSolo);
	this.palavras.add(this.LukeSkywalker);
	this.palavras.add(this.Finn);
	this.palavras.add(this.KyloRen);
	this.palavras.add(this.Leia);
	this.palavras.add(this.PoeDameron);
	this.palavras.add(this.Rey);
	this.palavras.add(this.Chewbacca);
	this.palavras.add(this.R2d2);
	this.palavras.add(this.C3po);
	this.palavras.add(this.Phasma);
	this.palavras.add(this.Maz);
	this.palavras.add(this.Snoke);
	this.palavras.add(this.Hux);
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
	
	public void calculaPeso(ArrayList<String> coluna1, ArrayList<String> coluna2){
		Peso aux = new Peso();
		for (int i=0; i<coluna1.size(); i++){
			for (int j=0; j<this.relacoes.size(); j++){
				aux = this.relacoes.get(j);
				if (coluna1.get(i).equals(aux.coluna1)){
					if (coluna2.get(i).equals(aux.coluna2)){
						aux.weight++;
					}
				}
				else if (coluna1.get(i).equals(aux.coluna2)){
					if (coluna2.get(i).equals(aux.coluna1)){
						aux.weight++;
					}
				}
				else {
					aux.coluna1 = coluna1.get(i);
					aux.coluna2 = coluna2.get(i);
					aux.weight = 1;
					}
			}
			relacoes.add(aux);
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = null;
		ReadFiles rf = new ReadFiles();
		int cont;

		
		writingCSVFile wfile = new writingCSVFile();
		

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
			wfile .writeCsvFile(rf.coluna1, rf.coluna2,rf.palavras);

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

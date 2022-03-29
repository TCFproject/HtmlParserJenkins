package fr.epsi.jenkins;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

	public static String cheminDeBase = "C:\\xampp\\htdocs\\equipements\\";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String cheminBureau = "C:\\Users\\THIERRY\\Desktop\\";
		String[] nomFichier;
		File f = new File(cheminDeBase);
		nomFichier = f.list();
		
		TxtRecuperateur txtRecup = new TxtRecuperateur(cheminDeBase+"staff.txt");
		TxtRecuperateur outilRecup = new TxtRecuperateur(cheminDeBase+"list.txt");
		ArrayList<HtmlPerser> listParser = new ArrayList<>();
		try {
			listParser.add(new HtmlIndexPerser(txtRecup.getWords()));
			for (String fichier :nomFichier) {
				if (!fichier.equals("staff.txt") &&
						!fichier.equals("list.txt") &&
						fichier.contains(".txt") || fichier.contains(".jpg")) {
					TxtRecuperateur identitesAgents = new TxtRecuperateur(cheminDeBase+fichier);
					listParser.add(new HtmlAgentPerser(fichier,identitesAgents.getWords(), 
							outilRecup.getWords()));
				}
			}
			for (HtmlPerser htmlPerser : listParser) {
				try {
					htmlPerser.createFile();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

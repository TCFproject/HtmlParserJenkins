package fr.epsi.jenkins;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtRecuperateur {
	private File txtFile;
	
	public TxtRecuperateur(String txtFile) {
		// TODO Auto-generated constructor stub
		this.txtFile = new File(txtFile);
	}
	
	public void getTable() {
		try {
			for (String iterable_element : getWords()) {
				System.out.println(iterable_element);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getWords() throws FileNotFoundException {
		Scanner myReader = new Scanner(this.txtFile);
		ArrayList<String> insertWord = new ArrayList<>();
		while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        insertWord.add(data);
	    }
	    myReader.close();
	    return insertWord;
	}
}

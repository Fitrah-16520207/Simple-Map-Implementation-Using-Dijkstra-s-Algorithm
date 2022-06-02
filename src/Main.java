import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
public class Main {
	
	public static String chooseFile() {										// fungsi untuk memilih file yang ingin diselesaikan
		SimpanPilihFile fc = new SimpanPilihFile();
		String lastSelectedFileDirectory =  System.getProperty("user.dir");
		fc.setDialogTitle("Pilih File");
		fc.setCurrentDirectory(new File(lastSelectedFileDirectory));
		
		int response = fc.showOpenDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {						// Jika file yang di klik sesuai
			String path = fc.getSelectedFile().getPath();					// akan mendapatkan path dari file tersebut untuk dibuka
			lastSelectedFileDirectory = path;
			return path;
		} else {
			return "";
		}
	}
	public static int getInput(int startMenuNumber, int endMenuNumber, String message) { // fungsi untuk menerima input
		System.out.print(message);
		
		Scanner scanner = new Scanner(System.in);						
		int command = scanner.nextInt();
		while(command < startMenuNumber || command > endMenuNumber) {		// selama input tidak sesuai dengan angka yang diinginkan
			System.out.println("Masukan Tidak Valid! Coba lagi");			// print pesan kesalahan
			System.out.print(message);
			command = scanner.nextInt();
		}
		System.out.println();
		scanner.close();
		return command;
	}
	public static Vector<Point>[] readGraf(String path){
		File sourceFile = new File(path);
		Vector<Point> vector[] = new Vector[100];
		for (int i=0;i<100;i++) vector[i] = new Vector<Point>();
		Scanner scanner;
		try {
			scanner = new Scanner(sourceFile);
			String baris;
			int x = 0;
			while(scanner.hasNextLine()) {								// Selama belum terbaca enter 
				baris = scanner.nextLine();
				List<Integer> row = new ArrayList<Integer>();
				String[] barisArr = baris.split(" ");
				for (int j = 0; j < barisArr.length; j++) {
					row.add(Integer.parseInt(barisArr[j]));				// Ubah hasil input dari string ke integer
					
					//P.setValue((4*x)+j,row.get(j));						// Masukkan integer tersebut ke dalam objek puzzle
				}
				vector[row.get(0)].add(new Point(row.get(2),row.get(1)));
				System.out.print(row.get(0) + " " + vector[row.get(0)].lastElement().getV()+ " " + vector[row.get(0)].lastElement().getDist()+ "\n");
				x++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {								//exception jika file yang dipilih tidak ada
			e.printStackTrace();
		}
		return vector;
		
	}
	public static void main(String[] args) {/*
		Vector<Point> vector[] = new Vector[10];
		vector[0] = new Vector<Point>();
		vector[0].add(new Point(8,1));
		vector[0].add(new Point(2,3));
		vector[0].add(new Point(11,4));
		vector[1] = new Vector<Point>();
		vector[1].add(new Point(8,0));
		vector[1].add(new Point(3,4));
		vector[1].add(new Point(10,3));
		vector[1].add(new Point(1,2));
		vector[2] = new Vector<Point>();
		vector[2].add(new Point(1,1));
		vector[2].add(new Point(3,3));
		vector[3] = new Vector<Point>();
		vector[3].add(new Point(2,0));
		vector[3].add(new Point(10,1));
		vector[3].add(new Point(3,2));
		vector[3].add(new Point(1,4));
		vector[4] = new Vector<Point>();
		vector[4].add(new Point(11,0));
		vector[4].add(new Point(3,1));
		vector[4].add(new Point(1,3));
		System.out.println("test");
		Djikstra.dijkstra(3,4,vector);*/
		//System.out.printf("Pencet Enter untuk memasukkan teks yang berisi graf");
		
		String filePath;
		Vector<Point> vector[] =new Vector[100];;//Jika input adalah dua maka akan memanggil fungsi chooseFile()
		try {
			filePath = chooseFile();
			if(filePath.isEmpty()) {								//Jika file path kosong akan mengeluarkan pesan error
				System.out.println("Tidak ada file yang dipilih");
			}
			vector = readGraf(filePath);							//Memanggil fungsi readPuzzle sesuai dengan path file yang dipilih
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Graf yang dihasilkan: ");
		int countGraf=0;
		for(int i = 0; i< 100;i++) {
			if(!vector[i].isEmpty()) {
				Vector<Point> v = vector[i];
				for(int j=0;j<v.size();j++) {
					System.out.print("Simpul "+ i +" ke simpul " + v.get(j).getV()+ " biaya: "+ v.get(j).getDist() + "\n");
				}
				countGraf++;
			}
		}
		int awal = -1,akhir=-1;
		System.out.println("Masukkan simpul awal: ");
		String masukkan = "Masukkan: ";
		awal = getInput(0,countGraf,masukkan);								//Memanggil fungsi getInput untuk memasukkan input yang diberikan
		System.out.println("Masukkan simpul akhir: ");
		masukkan = "Masukkan: ";
		akhir = getInput(0,countGraf,masukkan);
		Djikstra.dijkstra(awal,akhir,vector);
	}
}
class SimpanPilihFile extends JFileChooser {			//Fungsi untuk memunculkan ui dari pilih file
    protected JDialog createDialog(Component parent) throws HeadlessException {
        JDialog dialog = super.createDialog(parent);
        dialog.setAlwaysOnTop(true);
        return dialog;
    }
}

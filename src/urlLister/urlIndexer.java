package urlLister;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Label;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import java.util.Scanner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class urlIndexer {
	
	

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					urlIndexer window = new urlIndexer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public urlIndexer() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1475, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(73, 40, 494, 22);
		frame.getContentPane().add(textField);
		
		Label label = new Label("URL Path");
		label.setBounds(5, 40, 62, 22);
		frame.getContentPane().add(label);
		
		JLabel Label_1 = new JLabel("Created");
		Label_1.setBounds(221, 127, 208, 14);
		frame.getContentPane().add(Label_1);
		
		JLabel Label_2 = new JLabel("Last Accessed");
		Label_2.setBounds(221, 152, 208, 14);
		frame.getContentPane().add(Label_2);
		
		JLabel Label_3 = new JLabel("Last Modified");
		Label_3.setBounds(221, 177, 208, 14);
		frame.getContentPane().add(Label_3);
		
		List list = new List();
		list.setBounds(547, 372, 440, 244);
		frame.getContentPane().add(list);
		
		List list_2 = new List();
		list_2.setBounds(993, 84, 456, 532);
		frame.getContentPane().add(list_2);		
		
		List list_1 = new List();
		list_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				File filePath=new File(list_1.getSelectedItem());
				String dir="";
				if (filePath.isDirectory())
				{
				    dir=filePath.getAbsolutePath();
				    list_2.add(dir);
				    System.out.println(dir);
				   
				}
				else
				{
				   dir=filePath.getAbsolutePath().replaceAll(filePath.getName(), "");
				   list_2.add(dir);
			       System.out.println(dir);
				
				}
				
				
				String path = list_1.getSelectedItem();		
				Object[] values = list_1.getSelectedObjects();				
				Path file = Paths.get(path);					
				BasicFileAttributes attr = null;
				try {
					attr = Files.readAttributes(file, BasicFileAttributes.class);
					
					
					System.out.println("creationTime     = " + attr.creationTime());
			        System.out.println("lastAccessTime   = " + attr.lastAccessTime());
			        System.out.println("lastModifiedTime = " + attr.lastModifiedTime());
			 
			        System.out.println("isDirectory      = " + attr.isDirectory());
			        System.out.println("isOther          = " + attr.isOther());
			        System.out.println("isRegularFile    = " + attr.isRegularFile());
			        System.out.println("isSymbolicLink   = " + attr.isSymbolicLink());
			        System.out.println("size             = " + attr.size());	
			        
			        Label_1.setText(String.valueOf(attr.creationTime()));
			        Label_2.setText(String.valueOf(attr.lastAccessTime()));
			        Label_3.setText(String.valueOf(attr.lastModifiedTime()));
			        
			        
			        
			        
			        
				} catch (IOException e1) {
					
					e1.printStackTrace();
				
				    }	
				
				for(Object s: values){
					list_2.add(s.toString());
					
				}
				
			}	
				
		});
		
		
		list_1.setBounds(10, 372, 419, 244);
		frame.getContentPane().add(list_1);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Conal_Curran\\Pictures\\Veritas.png"));
		lblNewLabel.setBounds(1238, 11, 211, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnScan = new JButton("Scan");
		btnScan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				File folder = new File("C:\\Users\\Conal_Curran\\workspace\\URLLister\\sandbox");
				
				
				ArrayList<File> files = new ArrayList<File>(Arrays.asList(folder.listFiles()));
				
				for (File s : files)
				{
				  list.add(s.toString());
				  
				}
				
				String URLlist = " ";
				for (File s : files)
				{
				    URLlist += s + " " + "\n";
				    
				}
				System.out.println(URLlist);
				
				
				for (File fileEntry : folder.listFiles()) {
			        if (fileEntry.isDirectory()) {			        	
			            System.out.println(fileEntry);
			           
			            
			        } else {
			            System.out.println(fileEntry.getName());
			        }
				
				}
				
			}
				
	
		});
		btnScan.setBounds(73, 68, 89, 23);
		frame.getContentPane().add(btnScan);
		
		
		
		JButton btnImageFiles = new JButton("Image Files");
		btnImageFiles.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				list_1.removeAll();
				
				String[] model = list.getItems();
                
				for(String F: model){
					if( F.endsWith("png")){
						
						System.out.println(F);
					
					     list_1.add(F.toString());
					}
				
				}
				
			}
		});
		
		
		
		btnImageFiles.setBounds(435, 398, 106, 23);
		frame.getContentPane().add(btnImageFiles);
		
		JButton btnDocFiles = new JButton("Doc Files");
		btnDocFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list_1.removeAll();
                
                String[] model2 = list.getItems();
                
				for(String F: model2){
					if( F.endsWith("doc")){
						
						System.out.println(F);
					
					     list_1.add(F.toString());
					}
				
				}
				
			}
		});
		
		btnDocFiles.setBounds(435, 432, 106, 23);
		frame.getContentPane().add(btnDocFiles);
		
		JButton btnNewButton = new JButton("PDF Files");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list_1.removeAll();
				
                String[] model3 = list.getItems();
                
				for(String F: model3){
					if( F.endsWith("pdf")){
						
						System.out.println(F);
					
					     list_1.add(F.toString());
					}
				
				}
				
			}
			
		});
		
		btnNewButton.setBounds(435, 473, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HTML Files");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list_1.removeAll();
				
                String[] model4 = list.getItems();
                
				for(String F: model4){
					if( F.endsWith("html")){
						
						System.out.println(F);
					
					     list_1.add(F.toString());
					}
				
				}
				
			}
			
		});
		btnNewButton_1.setBounds(435, 514, 106, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel Lb1 = new JLabel("Created:");
		Lb1.setBounds(106, 127, 56, 14);
		frame.getContentPane().add(Lb1);
		
		JLabel Lb2 = new JLabel("Last Accessed:");
		Lb2.setBounds(106, 152, 105, 14);
		frame.getContentPane().add(Lb2);
		
		JLabel Lb3 = new JLabel("Last Modified:");
		Lb3.setBounds(106, 177, 80, 14);
		frame.getContentPane().add(Lb3);
		
		JLabel lblFolder = new JLabel("Folder:");
		lblFolder.setBounds(993, 64, 46, 14);
		frame.getContentPane().add(lblFolder);
		
		JButton btnPrintDirectory = new JButton("Print Selected File Paths");
		btnPrintDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String [] model5 = list_1.getItems();	
				
				
				FileWriter writer;
				try {
					writer = new FileWriter("C:\\Users\\Conal_Curran\\workspace\\URLLister\\sandbox\\Selected File Paths.txt");		
					
					for(String str: model5) {
						  writer.write(str + " " + "\r\n" );
						}
						writer.close();
						
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} 
				
			}				
		});
		
		btnPrintDirectory.setBounds(73, 343, 323, 23);
		frame.getContentPane().add(btnPrintDirectory);
		
		JButton btnPrintFilePath = new JButton("Print File Path");
		btnPrintFilePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String [] model6 = list.getItems();	
				
				
				FileWriter writer;
				try {
					writer = new FileWriter("C:\\Users\\Conal_Curran\\workspace\\URLLister\\sandbox\\File Paths.txt");		
					
					for(String str: model6) {
						  writer.write(str + " " + "\r\n" );
						}
						writer.close();
						
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} 
			}
		});
		btnPrintFilePath.setBounds(608, 343, 295, 23);
		frame.getContentPane().add(btnPrintFilePath);
		
		JLabel lblSelected = new JLabel("Selected:");
		lblSelected.setBounds(10, 347, 46, 14);
		frame.getContentPane().add(lblSelected);
		
		JLabel lblFilePaths = new JLabel("File Paths:");
		lblFilePaths.setBounds(547, 352, 80, 14);
		frame.getContentPane().add(lblFilePaths);
		
	}
}


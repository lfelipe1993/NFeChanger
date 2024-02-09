package changer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import changer.model.entities.ValoresModificados;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Program {

	public static String cCNPJ = "01336140000521";
	public static String xNome = "BRAVIUM S.A";

	// enderEmit
	public static String xFant = "BRAVIUM SA COT";
	public static String xLgr = "Rua RUA PHILIP LEINER";
	public static String nNro = "100";
	public static String xCpl = "ANEXO UNIDADES 12 E 13";
	public static String xBairro = "PARQUE ALEXANDRE";
	public static String cMun = "3513009";
	public static String xMun = "Cotia";
	public static String uUF = "SP";
	public static String cCEP = "06714285";
	public static String cPais = "1058";
	public static String xPais = "Brasil";
	public static String fFone = "1136270400";

	public static String iIE = "278606033118";
	public static String cCRT = "3";
	
	
	
	//----------PRODUTO----------------------------
	
	public static String nomeProduto = "";
	public static String valorProduto = "";
	public static String ncmProduto = "";
	public static String taxProduto = "";

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		
		
		List<ValoresModificados> novosValores = new ArrayList<>();
		List<String> params = Arrays.asList(args);

		params.forEach(p -> {
			if (p != null) {
				String[] teste = p.split("=");

				if (teste[0].equalsIgnoreCase("produto")) {
					nomeProduto = teste[1];
				} 
				
				if (teste[0].equalsIgnoreCase("valor")) {
					valorProduto = moneyConvert(teste[1]);
					taxProduto = taxCalc(teste[1]);
				} 
				
				if (teste[0].equalsIgnoreCase("NCM")) {
					ncmProduto = teste[1];
				} 
			}
		});
		

		System.out.println("--- VARIAVEIS DE ENTRADA ---");
		System.out.println(nomeProduto);
		System.out.println(valorProduto);
		System.out.println(ncmProduto);
		System.out.println("----------------------------");
		
		if(nomeProduto == "" || valorProduto == "" || valorProduto == ""|| taxProduto == "") {
			System.out.println("parametros estao zerados e por isso o programa sera encerrado.");
			System.exit(1);
		}
		
		
		//------------------------------ABRINDO O XML---------------------------------------

		File file = new File("nf.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document document = db.parse(file);

		document.getDocumentElement().normalize();
		//System.out.println("Root Element :" + document.getDocumentElement().getNodeName());

		
		System.out.println("");
		System.out.println("--- VARIAVEIS ATUAIS DO XML ---");
		Element raiz = document.getDocumentElement();
		
		//---------------------------------------------------------------------------------
		
		//-------------------------------EDITAR A EMPRESA----------------------------------
		
		NodeList elementEmitente = raiz.getElementsByTagName("emit");
		
		for (int i = 0; i < elementEmitente.getLength(); i++) {
			
			Node node = elementEmitente.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element tElement = (Element) node;

				changeContextNode(tElement,"CNPJ",cCNPJ);
				changeContextNode(tElement,"xNome",xNome);
				changeContextNode(tElement,"xFant",xFant);
				changeContextNode(tElement,"xLgr",xLgr);
				changeContextNode(tElement,"nro",nNro);
				changeContextNode(tElement,"xCpl",xCpl);
				changeContextNode(tElement,"xBairro",xBairro);
				changeContextNode(tElement,"cMun",cMun);
				changeContextNode(tElement,"xMun",xMun);
				changeContextNode(tElement,"UF",uUF);
				changeContextNode(tElement,"CEP",cCEP);
				changeContextNode(tElement,"cPais",cPais);
				changeContextNode(tElement,"xPais",xPais);
				changeContextNode(tElement,"IE",iIE);
				changeContextNode(tElement,"CRT",cCRT);

			}
			
		}
		
		//---------------------------------------------------------------------------------
		
		//-------------------------------DADOS DO PRODUTO----------------------------------
		
		NodeList elementosNFe = raiz.getElementsByTagName("det");

		for (int i = 0; i < elementosNFe.getLength(); i++) {

			Node node = elementosNFe.item(i);
			//System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element tElement = (Element) node;
				
				System.out.println("xProd: " + tElement.getElementsByTagName("xProd").item(0).getTextContent());
				changeContextNode(tElement,"xProd",nomeProduto);
				novosValores.add(new ValoresModificados("xProd",nomeProduto));
				
				System.out.println("NCM: " + tElement.getElementsByTagName("NCM").item(0).getTextContent());
				changeContextNode(tElement,"NCM",ncmProduto);
				novosValores.add(new ValoresModificados("NCM",ncmProduto));
				
				System.out.println("vUnCom: " + tElement.getElementsByTagName("vUnCom").item(0).getTextContent());
				changeContextNode(tElement,"vUnCom",valorProduto);
				novosValores.add(new ValoresModificados("vUnCom",valorProduto));
				
				System.out.println("vProd: " + tElement.getElementsByTagName("vProd").item(0).getTextContent());
				changeContextNode(tElement,"vProd",valorProduto);
				novosValores.add(new ValoresModificados("vProd",valorProduto));
				
				System.out.println("vUnTrib: " + tElement.getElementsByTagName("vUnTrib").item(0).getTextContent());
				changeContextNode(tElement,"vUnTrib",valorProduto);
				novosValores.add(new ValoresModificados("vUnTrib",valorProduto));
				
				System.out.println("vTotTrib: " + tElement.getElementsByTagName("vTotTrib").item(0).getTextContent());
				changeContextNode(tElement,"vTotTrib",taxProduto);
				novosValores.add(new ValoresModificados("vTotTrib",taxProduto));
				
				System.out.println("vBC: " + tElement.getElementsByTagName("vBC").item(0).getTextContent());
				changeContextNode(tElement,"vBC",valorProduto);
				novosValores.add(new ValoresModificados("vBC",valorProduto));
				
				System.out.println("vBC2: " + tElement.getElementsByTagName("vBC").item(1).getTextContent());
				changeContextNode(tElement,"vBC",valorProduto,1);
				

				
				//changeContextNode(tElement,"xProd",nomeProduto);

				//System.out.println("xProd: " + tElement.getElementsByTagName("xProd").item(0).getTextContent());

			}

		}
		
		//-----------------------------<total>/<ICMSTot>--------------------------------------------
		NodeList elementosImpostTotal = raiz.getElementsByTagName("ICMSTot");

		for (int i = 0; i < elementosImpostTotal.getLength(); i++) {

			Node node = elementosImpostTotal.item(i);
			//System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element tElement = (Element) node;
				
				System.out.println("vProd: " + tElement.getElementsByTagName("vProd").item(0).getTextContent());
				changeContextNode(tElement,"vProd",valorProduto);
				System.out.println("vNF: " + tElement.getElementsByTagName("vNF").item(0).getTextContent());
				changeContextNode(tElement,"vNF",valorProduto);
				System.out.println("vTotTrib: " + tElement.getElementsByTagName("vTotTrib").item(0).getTextContent());
				changeContextNode(tElement,"vTotTrib",taxProduto);

			}

		}
		
		//-----------------------------<total>/<ICMSTot>--------------------------------------------
		NodeList infAdic = raiz.getElementsByTagName("infAdic");

		for (int i = 0; i < infAdic.getLength(); i++) {

			Node node = infAdic.item(i);
			//System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element tElement = (Element) node;
				
				System.out.println("infAdic: " + tElement.getElementsByTagName("infCpl").item(0).getTextContent());
				changeContextNode(tElement,"infCpl","Reservado ao Fisco.");
				novosValores.add(new ValoresModificados("infCpl","Reservado ao Fisco."));
			}

		}
		
		
		//----------------------------------<detPag>--------------------------------------------
		NodeList detPag = raiz.getElementsByTagName("detPag");

		for (int i = 0; i < detPag.getLength(); i++) {

			Node node = detPag.item(i);
			//System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element tElement = (Element) node;
				
				System.out.println("vPag: " + tElement.getElementsByTagName("vPag").item(0).getTextContent());
				changeContextNode(tElement,"vPag","Reservado ao Fisco.");
				novosValores.add(new ValoresModificados("vPag",valorProduto));
			}

		}
		
		
		System.out.println("");
		System.out.println("--- VARIAVEIS FINAIS DO XML ---");
		
		novosValores.forEach(p -> {
			
			System.out.println(p.getNome() +": "+ p.getValor());
			
		});
		
		
		
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new FileOutputStream("nf_atualizada.xml"));
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transFactory.newTransformer();
			
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static String moneyConvert(String valor1) {
	    
	    BigDecimal v1 = new BigDecimal(valor1.replaceAll("\\.", "").replace(",","."));        
	    
	    DecimalFormat df = new DecimalFormat("#####0.00");
	    
	    return df.format(v1);
	}

	private static void changeContextNode(Element tElement, String tagName, String newValue) {
		
		changeContextNode(tElement, tagName, newValue,0);
	}
	
	private static void changeContextNode(Element tElement, String tagName, String newValue,int item) {
		
		if(tElement.getElementsByTagName(tagName).item(item) != null) {
			tElement.getElementsByTagName(tagName).item(item).setTextContent(newValue);
		}
	}
	
	public static String taxCalc(String valor1) {
	    
	    BigDecimal v1 = new BigDecimal(valor1.replaceAll("\\.", "").replace(",","."));  
	    BigDecimal tax = new BigDecimal("33.79");
	    BigDecimal hound = new BigDecimal("100");
	    
	    v1 = v1.divide(hound).multiply(tax);
	    
	    DecimalFormat df = new DecimalFormat("#####0.00");
	    
	    return df.format(v1);
	}

}

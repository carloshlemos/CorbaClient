import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import DoubleLinkedListApp.DoubleLinkedList;
import DoubleLinkedListApp.DoubleLinkedListHelper;
import DoubleLinkedListApp.Pessoa;

public class StartClient {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			DoubleLinkedList doubleLinkedListObj = (DoubleLinkedList) DoubleLinkedListHelper.narrow(ncRef.resolve_str("ABC"));

			System.out.println("Bem-vindo ao Sistema de Lista Duplamente Encadeada:");
			Pessoa carlos = new Pessoa();
			carlos.nome = "Carlos Henrique Lemos";
			carlos.idade = 35;

			Pessoa adriane = new Pessoa();
			adriane.nome = "Adriane Guimarães de Siqueira Lemos";
			adriane.idade = 35;

			System.out.println("Enviando os objetos para o Servidor.");
			doubleLinkedListObj.addPosition(0, carlos);
			doubleLinkedListObj.addPosition(1, adriane);
			System.out.println("-----------------------------------");

			System.out.println("Buscando a Pessoa na posição 1: " + doubleLinkedListObj.get(1).nome);
			System.out.println("-----------------------------------");
			System.out.println("Removendo a Pessoa na posição 0: " + doubleLinkedListObj.remove(0));
			System.out.println("-----------------------------------");
			System.out.println("Buscando a Pessoa na posição 0: " + doubleLinkedListObj.get(0).nome);
			System.out.println("-----------------------------------");
		} catch (Exception e) {
			System.out.println("Hello Client exception: " + e);
			e.printStackTrace();
		}

	}
}
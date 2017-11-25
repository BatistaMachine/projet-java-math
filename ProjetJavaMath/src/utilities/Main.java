package utilities;

import Core.Matrice;
import Core.Simplexe;
import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;
import Erreur.ObjectNullException;

public class Main {

	public static void main(String[] args) throws NumberUnderLimitException, NegatifNumberException, ObjectNullException {
		Matrice m=null;
		try{
			m=new Matrice(2,2);
			m.setVariable(0, 0, 2.);
			m.setVariable(0, 1, 1.);
			m.setVariable(1, 0, 0.);
			m.setVariable(1, 1, -2.);
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice m\n"+m);
		}
		System.out.println("nombre de variable "+m.getNbVariables());
		System.out.println("Nombre de contraintes "+m.getNbContraintes());
		Matrice m2=m;
		System.out.println("Matrice m equals Matrice m2 is "+m.equals(m2));
		Matrice m3=null;
		try{
			m3=new Matrice(2,2);
			m3.setVariable(0, 0, 1.);
			m3.setVariable(0, 1, 1.);
			m3.setVariable(1, 0, 0.);
			m3.setVariable(1, 1, -2.);
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice m3\n"+m3);
		}
		/*Pour le equals les test on �t� fait si la matrice est cloner et si on change les dimension mais pas les valeurs �galement. Donc une matrice est �agale � une autre si et seulement si elle 
		ont les m�mes dimensions et les m�mes valeurs au m�me position.*/
		System.out.println("Matrice m equals Matrice m3 is "+m.equals(m3));
		Matrice m4=null;
		try{
			m4=new Matrice(2,2);
			m4.setVariable(0, 0, -1.);
			m4.setVariable(0, 1, -1.);
			m4.setVariable(1, 0, -1.);
			m4.setVariable(1, 1, -1.);
			m3=m3.sommeMatrice(m4);
			/*la somme avec une matrice null donne la matrice, la somme avec des valeur postives ou n�gative modifie la valeur qui se trouve � la m�me postion dans la matrice r�sultat.*/
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		catch(ObjectNullException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice m4\n"+m4);
			System.out.println("Modification de m3 par m3=m3+m4\n"+m3);
		}
		System.out.println("Transpotision de m\n"+m.transposition());
		Matrice identite=null;
		try{
			identite=new Matrice(2,2);
			identite.setVariable(0, 0, 1.);
			identite.setVariable(0, 1, 0.);
			identite.setVariable(1, 0, 0.);
			identite.setVariable(1, 1, 1.);
			m2.produitMatrice(identite);
			//erreur dans la multiplication
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		catch(ObjectNullException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice identit�\n"+identite);
			System.out.println("Matrice m3 multipli� par la matrice identit�\n"+m);
		}	
		//la classe matrice fonctionne jusqu'� la m�thode transposition(). La suite n'a pas �t� tester
	}

}

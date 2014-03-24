package jena;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class Ontology {

	public static void main(String[] args) {
		OntModel om = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);
		
		final String NS = "http://www.example.org/";
		OntClass human = om.createClass( NS + "Human" );
		OntClass man   = om.createClass( NS + "Man"   );
		OntClass woman = om.createClass( NS + "WoMan" );
		
		Individual m1 = om.createIndividual( NS + "m1", man );
		Individual m2 = om.createIndividual( NS + "m2", man );
		Individual w1 = om.createIndividual( NS + "w1", man );
		
		human.addSubClass(man);
		human.addSubClass(woman);
		
		RDFList arg = om.createList(new RDFNode[]{man, woman});
		OntClass manOrWoman = om.createUnionClass( NS + "manOrWoman", arg);
		human.addEquivalentClass(manOrWoman);
		
		for ( ExtendedIterator<? extends OntClass> i = human.listEquivalentClasses(); i.hasNext(); ) {
			System.out.println(i.next());
		}
		
		for ( ExtendedIterator<? extends OntResource> i = human.listInstances(); i.hasNext(); ) {
			System.out.println(i.next());
		}
		
		Property has = om.createProperty( NS + "has" );
		OntClass hand = om.createClass( NS + "Hand" );
		//Individual m1LeftHand = om.createIndividual( NS + "left-hand@m1", hand);
		//Individual m1RightHand = om.createIndividual( NS + "right-hand@m1", hand);
		OntResource m1LeftHand = om.createOntResource( NS + "left-hand@m1" );
		OntResource m1RightHand = om.createOntResource( NS + "right-hand@m2" );
		//OntClass forall = om.createAllValuesFromRestriction( NS + "A:", has, hand );
		OntClass forall = om.createSomeValuesFromRestriction( NS + "E", has, hand);
		m1.addProperty(has, m1LeftHand);
		m1.addProperty(has, m1RightHand);
		m1.addOntClass(forall);
		
		final String INDENT = "   ";
		System.out.println(">> implict instance of hand");
		for ( final OntResource i : hand.listInstances().toSet() ) {
			System.out.println( INDENT + i );
		}

		System.out.println(">> implict instance of A:has.Hand");
		for ( final OntResource i : forall.listInstances().toSet() ) {
			System.out.println( INDENT + i );
		}
		
		System.out.println(">> all individual");
		for ( final OntResource i : om.listIndividuals().toSet() ) {
			System.out.println( INDENT + i );
		}
		
		System.out.println(">> all class");
		for ( final OntResource i : om.listClasses().toSet() ) {
			//System.out.println( INDENT + i );
		}
	}
}
